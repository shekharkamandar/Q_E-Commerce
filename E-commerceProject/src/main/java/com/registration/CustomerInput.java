package com.registration;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.admin.ValidityOfMobileNumber;

public class CustomerInput {

	public static Session getSession() {
		Configuration cfg = new Configuration();
		cfg = cfg.configure("hibernate.cfg.xml");

		SessionFactory factory = cfg.buildSessionFactory();
		Session session = factory.openSession();

		return session;
	}

	public static void customerInfo() {
		Scanner scn = new Scanner(System.in);
		Registration reg = new Registration();

		System.out.println("Enter full name :");
		String name = scn.nextLine();

		System.out.println("Enter mobile no :");
		String mobileNo = scn.next();

		System.out.println("Enter mail id :");
		String mailId = scn.next();

		System.out.println("Enter password :");
		String password = scn.next();

		reg.setName(name);
		if (ValidityOfMobileNumber.isValidMobileNo(mobileNo))
			reg.setMobileNumber(mobileNo);
		else {
			System.out.println("Entered mobile number is invalid.");
			CustomerInput.customerInfo();
		}

		reg.setMailId(mailId);
		reg.setPassword(password);

		Session session = getSession();
		Transaction transaction = session.beginTransaction();

		session.save(reg);
		transaction.commit();
		session.close();
	}
}
