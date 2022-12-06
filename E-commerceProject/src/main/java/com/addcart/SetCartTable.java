package com.addcart;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.registration.CustomerInput;

public class SetCartTable {
       
	public static void setCartTable() {
		Session session = CustomerInput.getSession();
		
		CartTable table= new CartTable();
	    table.setProductId(Cart.id);
		table.setName(Cart.name);
		table.setQuantity(Cart.quantity);
		table.setPrice(Cart.price);
		table.setTotal(Cart.total);
		
		Transaction tr=session.beginTransaction();
		session.save(table);
		tr.commit();
		session.close();
	}
}
