package dao;

import java.util.List;

import model.User;

public interface IUser {
	
	
	public String addUser(User user);
	public int login(User user);
	public List<User> viewUser();
//
//	
	

}
