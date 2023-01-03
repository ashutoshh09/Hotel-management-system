package model;

public class User {
	
	private String name;
	private long mobile;
	private String email;
	private String password;
	private String time;
	
	public String getTime() {
		return time;
	}


	public void setTime(String time) {
		this.time = time;
	}


	public User(String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
	}
	
	
	public User(String name, long mobile, String email, String password) {
		super();
		this.name = name;
		this.mobile = mobile;
		this.email = email;
		this.password = password;
	}
	
	


	


	public User(String name, long mobile, String email) {
		super();
		this.name = name;
		this.mobile = mobile;
		this.email = email;
	}
	
	




	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return String.format("%-20s%-20s%-20s%-20s",name,mobile,email,password);
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	
	
	
	

}
