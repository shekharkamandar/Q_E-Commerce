package com.admin;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;

import com.registration.CustomerInput;

public class AdminLogIn {
	static String mobile;
	static String pass;

	static String mobileNumber;
	static String password;

	public static void adminDetails() {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter mobile number :");
		mobile = sc.next();
		
		System.out.println("Enter password :");
		pass = sc.next();
		System.out.println();
		
		if (ValidityOfMobileNumber.isValidMobileNo(mobile))  
			adminCheck();
			else  {
			System.out.println("Entered mobile number is invalid.");   
			adminDetails();
			}
		
	}

	public static void adminCheck() {

		Session session = CustomerInput.getSession();
		Query query = session.createQuery("from AdminInfo");

		List<AdminInfo> reg = query.list();
		for (AdminInfo admin : reg) {
			mobileNumber = admin.getMobileNumber();
			password = admin.getPassword();
		}
		check();
	}

	public static void check() {
		boolean flag = false;
		if ((mobile.equals(mobileNumber)) && (pass.equals(password))) {
			flag = true;
			System.out.println();
			System.out.println("log in successfully...");
			System.out.println();

		}
		if (!flag) {
			System.out.println("Invalid username and password...!");
			System.out.println();
			adminDetails();
		}
	}

}
