package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.User;
import util.Db;
import util.Query;

public class UserImpl implements IUser {
	PreparedStatement statement;
	int result;

	@Override
	public String addUser(User user) {
		String result;
		try {

			statement = Db.getObject().getConnection().prepareStatement(Query.ADD_USER);
			statement.setString(1, user.getName());
			statement.setLong(2, user.getMobile());
			statement.setString(3, user.getEmail());
			statement.setString(4, user.getPassword());

			statement.executeUpdate();

			result = "Registered Successfully";
		} catch (SQLException ex) {
			result = "Duplicate Exists";
		}
		return result;
	}

	@Override
	public int login(User user) {
		try {
			statement = Db.getObject().getConnection().prepareStatement(Query.CHECK_CREDENTIAL);
			statement.setString(2, user.getPassword());
			statement.setString(1, user.getEmail());
			ResultSet rs = statement.executeQuery();
			int temp = 0;
			while (rs.next()) {
				temp++;
			}
			if (temp > 0) {
				result = 1;
				// Admin.menu();
			} else {
				result = 0;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
			;
		}
		return result;

	}

	@Override
	public List<User> viewUser() {
		List<User> list = new ArrayList<User>();
		try {
			statement = Db.getObject().getConnection().prepareStatement(Query.VIEW_ALL_USERS_DETAILS);
			ResultSet set = statement.executeQuery();
			while (set.next()) {
				User user = new User(set.getString(1), set.getLong(2), set.getString(3), set.getString(4));
				list.add(user);

			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return list;
	}

}
