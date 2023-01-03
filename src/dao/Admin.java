package dao;

import java.sql.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import controller.PlayerController;
import controller.UserController;
import model.Guest;
import model.User;

public class Admin {
	
	public static void menu() {
		String s[];
		@SuppressWarnings("resource")
		Scanner scanner=new Scanner(System.in);
		System.out.println("\n\nLocation:\033[3mHyderabad\033[0m");
		PlayerController controller = new PlayerController();
		UserController controller2=new UserController();
		try {

			System.out.println();
			int k = 1;
			while (k == 1) {

				System.out.println(
						"\n\t\t\t\t\tMENU : \n\t\t\t\t\t1.Add Guest\n\t\t\t\t\t2.View Guest\n\t\t\t\t\t3.Update Guest details\n\t\t\t\t\t4.Delete Guest\n\t\t\t\t\t5.View all users\n\t\t\t\t\t6.Exit");

				int option = scanner.nextInt();
				scanner.nextLine();

				switch (option) {
				case 1:
					System.out.println(
							"Enter id,Guest Name,Check-in,Check-out(yyyy-MM-dd),no. of rooms, type(Heera/Presedential/Neelam/Firoza/Manik)ADD:");
					s = scanner.nextLine().split(",");
					System.out.println(controller.addGuest(Integer.parseInt(s[0]), s[1], Date.valueOf(s[2]),
							Date.valueOf(s[3]), Integer.parseInt(s[4]), s[5]));
					break;
				case 2:
					System.out.format("%-20s%-20s%-20s%-20s%-20s%-20s%-20s\n", "Guest_id", "Guest_Name", "Check-In",
							"Check-Out", "No. of Rooms", "Suite","Online_Paid");
					for (Guest p : controller.view()) {
						System.out.println(p);
					}
					break;
				case 3:
					// scanner.nextLine();
					System.out.println(
							"\t1.Update Name\n\t2.Update dates\n\t3.Update no. of rooms\n\t4.Update type of room");
					int n = scanner.nextInt();
					scanner.nextLine();
					String f[];
					switch (n) {
					case 1:
						System.out.println("Enter Player ID, NAME for UPDATE:");
						f = scanner.nextLine().split(",");
						System.out.println(controller.updateGuestName(Integer.parseInt(f[0]), f[1]));
						break;
					case 2:
						System.out.println("Enter Player ID, From Check-In to Check-Out UPDATE:");
						f = scanner.nextLine().split(",");
						System.out.println(controller.updateGuestDates(Integer.parseInt(f[0]), Date.valueOf(f[1]),
								Date.valueOf(f[2])));
						break;
					case 3:
						System.out.println("Enter Player ID, no. of rooms UPDATE:");
						f = scanner.nextLine().split(",");
						System.out.println(controller.updateGuestRooms(Integer.parseInt(f[0]), Integer.parseInt(f[1])));
						break;

					}

					break;
				case 4:
					System.out.println("Enter Player ID for Delete:");
					Integer id = scanner.nextInt();
					System.out.println(controller.deleteGuest(id));
					scanner.nextLine();
					break;
				case 5:
					System.out.format("%-20s%-20s%-20s%-20s\n", "User_name", "User_Mobile", "User_email","User_Time_Stamp");
					for (User p1 : controller2.viewUser()) {
						System.out.println(p1);
					}
					break;
				case 6:
					System.exit(0);
					break;

				}
				System.out.println("For continue press 1:");
				k = scanner.nextInt();
			}

		} catch (InputMismatchException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		//scanner.close();
	}

}
