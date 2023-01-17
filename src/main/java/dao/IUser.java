package dao;

import java.util.List;

import model.Guest;
import model.User;

public interface IUser {
	

	public List<User> viewUsers();
	public String delete(int id);
	
	public String update(User user);
	public String add(User user);
	public User getUserByUsername(String username);
	public User getUserByname(String name);
	public List<User> getUserByemail(String email);


	public List<User> getUserById(int id) ;
	
	

}
