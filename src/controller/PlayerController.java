package controller;

import java.sql.Date;
import java.util.List;

import dao.GuestImpl;
import model.Guest;

public class PlayerController {
	Guest guest;
	GuestImpl impl=new GuestImpl();
	
	
	public String addGuest1(String name,Date from,Date to, int rooms,String type) {
		guest=new Guest(name,from,to,rooms,type);
		return impl.addGuest(guest);
	}
	
	
	public String addGuest(int id,String name,Date from,Date to, int rooms,String type) {
		guest=new Guest(id,name,from,to,rooms,type);
		return impl.addGuest(guest);
	}
	
	public List<Guest> view() {
		
		return impl.view();
		
	}
	
	
	public List<Guest> viewSpecific(Integer id) {
		guest=new Guest(id);
		guest.setId(id);
		//impl.viewSpecific(guest).
		return impl.viewSpecific(guest);
	}
	public String updateGuestName(Integer id,String name) {
		guest=new Guest(id,name);
		return impl.updateGuestName(guest);
	}
	
	
	public String updateGuestDates(Integer id,Date from,Date to) {
		
		guest=new Guest(id,from,to);
		return impl.updateGuestDates(guest);
		
		
	}
	
	public String updateGuestRooms(Integer id,Integer rooms) {
		
	
		guest=new Guest(id,rooms);
		return impl.updateGuestRooms(guest);
		
		
	}
	
	public String updateGuestTyperoom(Integer id,String type) {
		guest=new Guest(type,id);
		return impl.updateGuestTyperoom(guest);
		
	}
	
	public String deleteGuest(Integer id) {
		guest=new Guest(id);
		guest.setId(id);
		return impl.deleteGuest(guest);
	}
}
