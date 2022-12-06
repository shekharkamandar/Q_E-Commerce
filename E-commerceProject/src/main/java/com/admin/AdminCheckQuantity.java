package com.admin;

import java.util.Scanner;

import org.hibernate.Session;

import com.registration.CustomerInput;

import demo.ecommerce.Products;

public class AdminCheckQuantity {
	static int choice;
    static int quantity;
    static int productId;
    
	public static void choice() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the product Id:");
		choice = sc.nextInt();
		checkQuantity(choice);
	}

	public static void checkQuantity(int choice) {

		Session session = CustomerInput.getSession();
		
		Products product=(Products) session.get(Products.class, choice);
		productId=product.getProductId();
		quantity=product.getQuantity();
		System.out.println("--------------------------------------------");
		System.out.println("productId \t Quantity");
		System.out.println("--------------------------------------------");
		System.out.println("  "+productId+"\t\t"+"   "+quantity);
		
		
	}

}
