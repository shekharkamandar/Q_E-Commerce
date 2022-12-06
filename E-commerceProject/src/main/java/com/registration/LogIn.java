package com.registration;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;

import com.addcart.Cart;
import com.admin.ValidityOfMobileNumber;
import com.productlist.ProductList;

public class LogIn {

	static String mobile;
	static String pass;

	static String mobileNo;
	static String password;
	static boolean flag = false;

	public static void login() {
		Scanner scn = new Scanner(System.in);
		System.out.println("Enter mobile no :");
		mobileNo = scn.next();

		System.out.println("Enter password :");
		password = scn.next();
		
		
		if (ValidityOfMobileNumber.isValidMobileNo(mobileNo))
			getLogin();
		else {
			System.out.println("Entered mobile number is invalid.");
			login();
		}
		
		
	}

	public static void getLogin() {

		Session session = CustomerInput.getSession();
		Query query = session.createQuery("from Registration");

		List<Registration> reg = query.list();
		for (Registration r : reg) {
			mobile = r.getMobileNumber();
			pass = r.getPassword();
			try {
				if ((mobileNo.equals(mobile)) && (password.equals(pass))) {
					flag = true;
					System.out.println();
					System.out.println("log in successfully...");
				}

				if (!flag) {
					throw new InvalidUserException("Invalid username and password...!");
				}
			} catch (InvalidUserException e) {
				e.printStackTrace();
			}

		}

		getCall();
	}

	public static void getCall() {
		System.out.println();
		System.out.println("Lists of Products:");
		System.out.println();
		ProductList.productList();
		
	}

}
