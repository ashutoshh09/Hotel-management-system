package dao;

import java.util.List;

import model.Guest;

public interface IGuest {

	public String addGuest(Guest guest);
	
	

	public List<Guest> view();
	public List<Guest> viewSpecific(Guest guest);

	public String updateGuestName(Guest guest);
	public String updateGuestDates(Guest guest);
	public String updateGuestRooms(Guest guest);
	public String updateGuestTyperoom(Guest guest);


	public String deleteGuest(Guest guest);
	
}
