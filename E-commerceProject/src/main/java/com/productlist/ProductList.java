package com.productlist;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.addcart.Cart;
import com.registration.*;

import demo.ecommerce.Products;

public class ProductList {

	public static void productList() {
		Session session = CustomerInput.getSession();

		Query query = session.createQuery("from Products");
		List<Products> products = query.list();
		System.out.println("----------------------------------------------------------------------------------------");
		System.out.println("Product Id \tProduct Name \t  Description\t\tQuantity\tPrice ");
		System.out.println("----------------------------------------------------------------------------------------");
		for (Products p : products) {
			int id = p.getProductId();
			String name = p.getProductName();
			String description = p.getDescription();
			int quantity = p.getQuantity();
			int price = p.getPrice();
			//System.out.println(id+"\t"+name+"\t"+description+"\t"+quantity+"\t"+price);
			System.out.println(id+"\t\t" +name+ "\t"+"  "+description+ "\t\t"+"  "+quantity+"\t\t"+price);
			

		}
		System.out.println("----------------------------------------------------------------------------------------");
		Cart.choice();
	}
}
