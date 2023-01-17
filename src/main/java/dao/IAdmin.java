package dao;

import model.Admin;

public interface IAdmin {
	
	public String adminLoginValidate(Admin admin);
	public String changepassword(String pr_password,String new_password,String user);

}
