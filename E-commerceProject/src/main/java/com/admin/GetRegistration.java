package com.admin;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.registration.CustomerInput;
import com.registration.Registration;

public class GetRegistration {

	public static void getRegistration() {
		Session session = CustomerInput.getSession();

		Query query = session.createQuery("from Registration");
		List<Registration> registration = query.list();
		System.out.println("----------------------------------------------------------------------------------------");
		System.out.println("Id\t\tName\t\t\tMailId\t\t\tMobileNumber\tPassword");
		System.out.println("----------------------------------------------------------------------------------------");
		for (Registration reg : registration) {
			int sr_No = reg.getSr_No();
			String name = reg.getName();
			String mail = reg.getMailId();
			String mob = reg.getMobileNumber();
			String pass = reg.getPassword();

			System.out.println(sr_No + "\t" + "    " + name+"\t" + "\t" + mail + "\t" + mob + "\t" + pass);
		}
	}

}
