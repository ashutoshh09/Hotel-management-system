package dao;

import java.sql.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import controller.PlayerController;

public class UserPage {

	public static void view() {
		PlayerController controller = new PlayerController();
		String s[];
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("Have you booked already(Y/N)");
		char c = scanner.next().charAt(0);
		if (c == 'y' || c == 'Y') {
			System.out.println("Enter your Guest id:");
			int id = scanner.nextInt();

			System.out.format("%-20s%-20s%-20s%-20s%-20s%-20s\n", "Guest_id", "Guest_Name", "Check-In", "Check-Out",
					"No. of Rooms", "Suite");
			System.out.println(controller.viewSpecific(id));

			if (!controller.viewSpecific(id).isEmpty()) {

				try {
					UserMenu.usermenu(id);

				} catch (InputMismatchException e) {
					// TODO: handle exception
					e.printStackTrace();
				}

			}

		} else {
			scanner.nextLine();
			System.out.println(
					"Enter Guest Name,Check-in,Check-out(yyyy-MM-dd),no. of rooms, type(Heera/Presedential/Neelam/Firoza/Manik)ADD:");
			s = scanner.nextLine().split(",");
			System.out.println(
					controller.addGuest1(s[0], Date.valueOf(s[1]), Date.valueOf(s[2]), Integer.parseInt(s[3]), s[4]));

		}

	}
}
