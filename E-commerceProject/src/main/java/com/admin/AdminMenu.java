package com.admin;

import java.util.Scanner;

public class AdminMenu {

	public static void adminMenu() {

		System.out.println("Welcome to admin log in : ");
		System.out.println();
		AdminLogIn.adminDetails();
		getAdminmenu();
		System.out.println();
	}
        public static void getAdminmenu() {
		System.out.println("1) Customer Details ");
		System.out.println("2) Product Quantity ");
		System.out.println("3) Purchase History");
		System.out.println("4) Exit ");
		System.out.println();

		Scanner sc = new Scanner(System.in);
		System.out.println("Please select choice :");
		int ac = sc.nextInt();
		System.out.println();

		switch (ac) {

		case 1:
			GetRegistration.getRegistration();
			System.out.println();
			getAdminmenu();
			break;

		case 2:
			AdminCheckQuantity.choice();
			System.out.println();
			getAdminmenu();
			break;

		case 3:

			System.out.println("Purchase History :");
			GetPurchaseHistory.getPurchasehistory();
			System.out.println();
			getAdminmenu();
			break;

		case 0:
			System.out.println();
			System.out.println("You are exit...");
			System.exit(0);

		default:
			System.out.println();
			System.out.println("Invalid input");
			System.exit(0);

		}

	}
}
