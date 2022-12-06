package com.admin;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.registration.CustomerInput;

public class GetPurchaseHistory {

	public static void getPurchasehistory() {
		Session session = CustomerInput.getSession();

		Query query = session.createQuery("from PurchaseFields");
		List<PurchaseFields> purchase = query.list();
		System.out.println("----------------------------------------------------------------------------------------");
		System.out.println("     Name\t\tproductId\tproductname\tquantity\tprice\ttotal");
		System.out.println("----------------------------------------------------------------------------------------");
		for (PurchaseFields pf : purchase) {
			String name = pf.getName();
			int pId = pf.getProductId();
			String pName = pf.getProductName();
			int quant = pf.getQuantity();
			int price = pf.getPrice();
			int total = pf.getTotal();

			System.out.println(name+"\t"+"\t"+pId+"\t"+"\t"+pName+"\t"+"  "+quant+"\t"+"\t"+price+"\t"+total);
		}

	}

}
