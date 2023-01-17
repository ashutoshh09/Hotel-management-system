package dao;

import java.util.List;

import model.Guest;
import model.User;

public interface IGuest {
	
	public List<Guest> viewGuests();
	public String delete(int id);
	
	public String update(Guest guest);
	public String add(Guest guest);
	public List<Guest> getGuestById(int id);
	public List<Guest> getGuestByUsername(String name);

}
