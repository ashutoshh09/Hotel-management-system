package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Guest;
import util.Db;
import util.Query;

public class GuestImpl implements IGuest {
	Scanner sc = new Scanner(System.in);

	PreparedStatement statement;
	String result;

	@Override
	public String addGuest(Guest guest) {
		// TODO Auto-generated method stub
		long ptype;
		try {
			statement = Db.getObject().getConnection().prepareStatement(Query.ADD_GUEST);
			// statement.setInt(1, guest.getId());
			statement.setString(1, guest.getName());
			statement.setDate(2, guest.getFrom());
			statement.setDate(3, guest.getTo());
			statement.setInt(4, guest.getCrooms());
			statement.setString(5, guest.getType());

			if (guest.getType().contains("Heera")) {
				ptype = 100;
			} else if (guest.getType().contains("Neelam")) {
				ptype = 200;
			} else if (guest.getType().contains("Manik")) {
				ptype = 300;
			} else if (guest.getType().contains("Firoza")) {
				ptype = 400;
			} else {
				ptype = 500;
			}

			statement.executeUpdate();
			long n = (guest.getTo().getTime() - guest.getFrom().getTime()) / (1000 * 60 * 60 * 24) % 365 * ptype
					* guest.getCrooms();
			System.out.println("Cost of stay:" + n);
			guest.setPrice(n);
			System.out.println("paid?");
			char d = sc.next().charAt(0);

			if (!(d == 'y' || d == 'Y')) {
				System.out.println("Kindly pay!");
				System.exit(0);
			} else {
				statement = Db.getObject().getConnection().prepareStatement(Query.PAID_ONLINE);
				System.out.println("Please enter your guest_id(check your mail):");
				int gid = sc.nextInt();
				guest.setId(gid);
				statement.setLong(1, guest.getPrice());
				statement.setInt(2, guest.getId());
				statement.executeUpdate();
				System.out.println("Payment Successful");
			}

			result = "Booking Successfully";
			UserMenu.usermenu(guest.getId());
		} catch (SQLException ex) {
			result = "Duplicate Exists";
		}
		return result;
	}

	@Override
	public List<Guest> view() {
		// TODO Auto-generated method stub
		List<Guest> list = new ArrayList<Guest>();
		try {
			statement = Db.getObject().getConnection().prepareStatement(Query.VIEW_ALL_PLAYERS);
			ResultSet set = statement.executeQuery();
			while (set.next()) {
				Guest guest = new Guest(set.getInt(1), set.getString(2), set.getDate(3), set.getDate(4), set.getInt(5),
						set.getString(6), set.getInt(7));
				list.add(guest);

			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return list;
	}

	@Override
	public String updateGuestName(Guest guest) {
		// TODO Auto-generated method stub
		try {
			statement = Db.getObject().getConnection().prepareStatement(Query.UPDATE_GUEST_NAME);
			statement.setInt(2, guest.getId());
			statement.setString(1, guest.getName());
			int status = statement.executeUpdate();
			if (status > 0) {
				result = "Updated Successfully";
			} else {
				result = "Record Not found";
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return result;
	}

	@Override
	public String updateGuestDates(Guest guest) {
		try {
			statement = Db.getObject().getConnection().prepareStatement(Query.UPDATE_GUEST_DATES);
			statement.setInt(3, guest.getId());
			statement.setDate(2, guest.getTo());
			statement.setDate(1, guest.getFrom());
			int status = statement.executeUpdate();
			if (status > 0) {
				result = "Updated Successfully";
			} else {
				result = "Record Not found";
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return result;

	}

	@Override
	public String updateGuestRooms(Guest guest) {

		try {
			statement = Db.getObject().getConnection().prepareStatement(Query.UPDATE_GUEST_NOSROOM);
			// System.out.println(guest.getId()+" "+guest.getCrooms());
			statement.setInt(2, guest.getId());
			// statement.setDate(2, player.getTo());
			statement.setInt(1, guest.getCrooms());
			int status = statement.executeUpdate();
			if (status > 0) {
				result = "Updated Successfully";
			} else {
				result = "Record Not found";
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return result;

	}

	@Override
	public String updateGuestTyperoom(Guest guest) {

		try {
			statement = Db.getObject().getConnection().prepareStatement(Query.UPDATE_GUEST_TYPEROOM);
			// System.out.println(guest.getId()+" "+guest.getCrooms());
			statement.setInt(2, guest.getId());
			// statement.setDate(2, player.getTo());
			statement.setString(1, guest.getType());
			int status = statement.executeUpdate();
			if (status > 0) {
				result = "Updated Successfully";
			} else {
				result = "Record Not found";
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return result;

	}

	@Override
	public String deleteGuest(Guest guest) {
		// TODO Auto-generated method stub
		try {
			statement = Db.getObject().getConnection().prepareStatement(Query.DELETE_GUEST);
			statement.setInt(1, guest.getId());
			// statement.setString(1, player.getName());
			int status = statement.executeUpdate();
			if (status > 0) {
				result = "Deleted Successfully";
			} else {
				result = "Record Not found";
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return result;
	}

	@Override
	public List<Guest> viewSpecific(Guest guest) {
		long n = 0;
		int ptype = 0;
		List<Guest> list = new ArrayList<Guest>();
		try {
			statement = Db.getObject().getConnection().prepareStatement(Query.VIEW_SPECIFIC_GUEST);
			statement.setInt(1, guest.getId());

			ResultSet set = statement.executeQuery();
			while (set.next()) {
				guest = new Guest(set.getInt(1), set.getString(2), set.getDate(3), set.getDate(4), set.getInt(5),
						set.getString(6));
				list.add(guest);

				if (set.getString(6).contains("Heera")) {
					ptype = 1000;
				}
				n = (long) (set.getDate(4).getTime() - set.getDate(3).getTime());

			}
			if (guest.getType().contains("Heera")) {
				ptype = 100;
			} else if (guest.getType().contains("Neelam")) {
				ptype = 200;
			} else if (guest.getType().contains("Manik")) {
				ptype = 300;
			} else if (guest.getType().contains("Firoza")) {
				ptype = 400;
			} else {
				ptype = 500;
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			System.out.println("Cost of Stay: " + (n / (1000 * 60 * 60 * 24)) % 365 * ptype);
		}

		return list;
	}

}
