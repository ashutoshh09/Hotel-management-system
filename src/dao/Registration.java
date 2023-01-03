package dao;

import java.util.Scanner;

import controller.UserController;

public class Registration {

	public static void userResigtration() {
		UserController controller = new UserController();
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your Name: ");
		String name = sc.nextLine();
		long mobile;
		do {
			System.out.println("Enter Mobile Number:");
			mobile = sc.nextLong();
			if (!(Long.toString(mobile).length() == 10)) {
				System.out.println("Invalid number");
			}
		} while (!(Long.toString(mobile).length() == 10));

		String email;
		do {
			sc.nextLine();
			System.out.println("Enter email:");
			email = sc.nextLine();
			if (!EmailValidation.isValid(email)) {
				System.out.println("Invalid mail");
			}
		} while (!EmailValidation.isValid(email));
		String password;
		do {
			System.out.println("Enter Password:");
			password = sc.nextLine();
			if (!PasswordValidation.isValid(password)) {
				System.out.println("Invalid Password");
			}

		} while (!PasswordValidation.isValid(password));

		// s = sc.nextLine().split(",");
		System.out.println(controller.addUser(name, mobile, email, password));
		//sc.close();

	}

}
