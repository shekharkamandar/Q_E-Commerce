package com.admin;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.registration.CustomerInput;

public class AdminSetInfo {

	public static void setInfo() {
		Session session = CustomerInput.getSession();

		AdminInfo adm = new AdminInfo();
		adm.setName("Coder");
		adm.setMobileNumber("9503062654");
		adm.setPassword("admin@123");

		Transaction tr = session.beginTransaction();
		session.save(adm);
		tr.commit();
		session.close();

	}

}
