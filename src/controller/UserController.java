package controller;

import java.util.List;

import dao.UserImpl;
import model.User;

public class UserController {
	
	User user;
	UserImpl impl=new UserImpl();
	
	
	public String addUser(String name, long mobile, String email, String password) {
		user=new User(name,mobile,email,password);
		return impl.addUser(user);
		
		
		
		
	}
	
	public int login(String type,String mail,String password) {
		user=new User(type,mail,password);
		return impl.login(user);
		
	}
	
	public List<User> viewUser() {
		return impl.viewUser();
	}
	
	
	
	

}
