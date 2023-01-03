package util;

public class Query {

	// guest table queries
	public static final String ADD_GUEST = "insert into Trident(cname,cstart,cend,cnosroom,ctyperoom) values(?,?,?,?,?)";
	public static final String DELETE_GUEST = "delete from Trident where cid=?";
	public static final String UPDATE_GUEST_NAME = "update Trident set cname=? where cid=?";
	public static final String UPDATE_GUEST_DATES = "update Trident set cstart=? , cend=? where cid=?";
	public static final String UPDATE_GUEST_NOSROOM = "update Trident set cnosroom=? where cid=?";
	
	public static final String UPDATE_GUEST_TYPEROOM = "update Trident set ctyperoom=? where cid=?";

	public static final String VIEW_ALL_PLAYERS = "select * from Trident";
	public static final String VIEW_SPECIFIC_GUEST = "select * from Trident where cid=?";
	public static final String PAID_ONLINE = "update Trident set Paid_online=? where cid=?";

	// user table queries
	public static final String CHECK_CREDENTIAL = "select * from Users where email=? and password=?";
	public static final String ADD_USER = "insert into Users(name,mobile,email,password) values(?,?,?,?)";
	public static final String VIEW_ALL_USERS_DETAILS = "select name,mobile,email,InDtTm from Users ";

}
