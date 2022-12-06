package com.addcart;

import java.util.Scanner;

import org.hibernate.Session;

import com.admin.PurchaseHistory;
import com.menu.MenuBar;
import com.productlist.ProductList;
import com.registration.CustomerInput;

import demo.ecommerce.Products;

public class Cart {
	static int id;
	static String name;
	static int quantity;
	static int price;
	static int total;
	static int choice;
	static int a;
	static int b;

	public static void choice() {
		Scanner sc = new Scanner(System.in);
		System.out.println();
		System.out.println("Enter the product Id:");
		choice = sc.nextInt();
		System.out.println();
		System.out.println("cart Details:");
		System.out.println();
		cart(choice);
		
	}

	public static void cart(int choice) {

		Session session = CustomerInput.getSession();
		Products p = (Products) session.get(Products.class, choice);

		System.out.println("----------------------------------------------------------------------------------------");
		System.out.println("Id\t Name\t\t  Quantity\tPrice \t Total");
		System.out.println("----------------------------------------------------------------------------------------");
		id = p.getProductId();
		name = p.getProductName();

		if (quantity <= 1) {
			a = p.getQuantity();
			if (b == 1) {
				a = b + 1;

			} else {
				a = 1;
				b = a;

			}
			quantity++;
		}
		price = p.getPrice();

		total = a * p.getPrice();

		System.out.println(id + "\t" + name + "\t   " + Cart.a + "\t\t " + price + "\t " + Cart.total);
		System.out.println("----------------------------------------------------------------------------------------");
		SetCartTable.setCartTable();
		PurchaseHistory.pHistory();
		getOption();
	}

	public static void getOption() {
		Scanner sc = new Scanner(System.in);

		System.out.println();
		System.out.println("1) Productlist");
		System.out.println("2) Exit");

		System.out.println();
		System.out.println("Select Choice:");
		int choice = sc.nextInt();

		switch (choice) {

		case 1:
			ProductList.productList();
			break;

		case 2:
			System.out.println("log out successfully.......");
			System.out.println("*********************************Thank You**********************************************");
			MenuBar.menu();
			System.exit(0);
			break;

		}

	}
}
