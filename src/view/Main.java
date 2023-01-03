package view;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import controller.UserController;
import dao.Admin;
import dao.Registration;
import dao.UserPage;

public class Main {
	static String s[];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(
				"***************************************TRIDENT HOTELS*****************************************");
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		DateTimeFormatter dtf=DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now=LocalDateTime.now();
		System.out.println("\t\t\t\t\t\t\t\t\t" + dtf.format(now));

		UserController controller = new UserController();
		System.out.println("\n\t\t\t\tProject Topic: Hotel Reservation System\n");
		System.out.println("1.Admin\n2.User\nEnter your choice:");
		int n = scanner.nextInt();
		scanner.nextLine();
		switch (n) {
		case 1:
			System.out.println("Enter email:");
			String type = null;
			String name = scanner.nextLine();
			System.out.println("Enter Password:");
			String password = scanner.nextLine();
			if (!password.contains("admin")) {
				System.out.println("Kindly Enter valid Admin Login");
				System.exit(0);
			}
			if (controller.login(type, name, password) == 1) {

				System.out.println("\n\n******************Admin Home Page****************");
				Admin.menu();

			} else {
				System.out.println("Check Email,Password");
			}
			break;
		case 2:
			System.out.println("****************************Registration Page*****************************");
			System.out.println("Have you registerd already(Y/N)");
			char t = scanner.next().charAt(0);
			scanner.nextLine();
			if (t == 'y' || t == 'Y') {
				String type1 = null;

				System.out.println("Enter email:");
				String name1 = scanner.nextLine();

				System.out.println("Enter Password:");
				String password1 = scanner.nextLine();
				if (controller.login(type1, name1, password1) == 1) {

					System.out.println("\n\n******************User Home Page****************");
					UserPage.view();

				} else {
					System.out.println("Check Email,Password");
				}
				break;
			} else {
				Registration.userResigtration();
			}
			UserPage.view();
			break;

		}
		//scanner.close();

	}
}
