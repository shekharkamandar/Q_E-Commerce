package com.menu;

import java.util.Scanner;

import com.addcart.Cart;
import com.addcart.SetCartTable;
import com.admin.AdminCheckQuantity;
import com.admin.AdminLogIn;
import com.admin.AdminMenu;
import com.admin.AdminSetInfo;
import com.admin.GetPurchaseHistory;
import com.admin.GetRegistration;
import com.admin.PurchaseHistory;
import com.productlist.ProductList;
import com.registration.CustomerInput;
import com.registration.LogIn;

public class MenuBar {

	public static void menu() {

		System.out.println("********************************************************************************");
		System.out.println("Welcome to Shopping cart :");
		System.out.println();

		System.out.println("1) Registration");
		System.out.println("2) LogIn");
		System.out.println("3) Admin");
		System.out.println("4) Exit");
		System.out.println("********************************************************************************");
		System.out.println();

		Scanner sc = new Scanner(System.in);

		System.out.println("Select Your choice : ");
		int choice = sc.nextInt();
		System.out.println();
		switch (choice) {

		case 1:
			CustomerInput.customerInfo();
			System.out.println();
			System.out.println("Sign In:");
			LogIn.login();
			break;

		case 2:
			LogIn.login();
			break;

		case 3:
			AdminMenu.adminMenu();
			break;

		case 0:
			System.out.println("You are exit...");
			System.exit(0);

		default:
			break;
		}

	}

}
