package dao;

import java.sql.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import controller.PlayerController;

public class UserMenu {

	public static void usermenu(int id) {

		PlayerController controller = new PlayerController();
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		int k = 1;
		try {
			while (k == 1) {

				System.out.println(
						"\t1.Update Name\n\t2.Update dates(yyyy-MM-dd)\n\t3.Update no. of rooms\n\t4.Update type of room\n\t5.Exit");
				int n = scanner.nextInt();
				scanner.nextLine();
				String f[];
				switch (n) {
				case 1:
					System.out.println("Enter NAME for UPDATE:");
					String f1 = scanner.nextLine();
							
					System.out.println(controller.updateGuestName(id, f1));
					break;
				case 2:
					System.out.println("Enter Check-In to Check-Out(yyyy-MM-dd)UPDATE:");
					f = scanner.nextLine().split(",");
					System.out.println(controller.updateGuestDates(id, Date.valueOf(f[0]),
							Date.valueOf(f[1])));
					break;
				case 3:
					System.out.println("Enter no. of rooms UPDATE:");
					int f2 = scanner.nextInt();
					System.out.println(controller.updateGuestRooms(id,f2));
					break;
				case 4:
					//System.out.println("Enter type of room UPDATE:");
					
					System.out.println("Enter type of room UPDATE:");
					String p=scanner.nextLine();
					System.out.println(controller.updateGuestTyperoom(id, p));
					break;
					
				case 5:
					System.out.println("Thank you for choosing Trident!");
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
