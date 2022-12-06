package com.admin;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.addcart.Cart;
import com.addcart.CartTable;
import com.registration.CustomerInput;
import com.registration.Registration;

import demo.ecommerce.Products;

public class PurchaseHistory {
	static String name;
	static int id;
	static String pName;
	static int quantity;
	static int price;
	static int total;

	public static void pHistory() {

		Session session = CustomerInput.getSession();
		Query query = session.createQuery("from Registration");
		List<Registration> registration = query.list();
		Query query1 = session.createQuery("from CartTable");
		List<CartTable> carttable = query1.list();

		for (Registration reg : registration) {
			name = reg.getName();

			for (CartTable cart : carttable) {
				id = cart.getProductId();
				pName = cart.getName();
				quantity = cart.getQuantity();
				price = cart.getPrice();
				total = cart.getTotal();
			}

		}

		setPurchase();
		
	}

	public static void setPurchase() {
		Session session = CustomerInput.getSession();

		PurchaseFields purchase = new PurchaseFields();
		purchase.setName(name);
		purchase.setProductId(id);
		purchase.setProductName(pName);
		purchase.setQuantity(quantity);
		purchase.setPrice(price);
		purchase.setTotal(total);

		Transaction tr = session.beginTransaction();
		session.save(purchase);
		tr.commit();
		session.close();
	}

}