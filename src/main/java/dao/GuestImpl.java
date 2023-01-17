package dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.Guest;
import model.User;
import util.Query;

public class GuestImpl implements IGuest {

	@Override
	public List<Guest> viewGuests() {
		// TODO Auto-generated method stub

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("hcl");
		EntityManager manager = factory.createEntityManager();

		manager.getTransaction().begin();
		@SuppressWarnings("unchecked")
		List<Guest> list = manager.createQuery(Query.VIEW_GUESTS).getResultList();

		return list;
	}

	@Override
	public String delete(int id) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("hcl");
		EntityManager manager = factory.createEntityManager();

		manager.getTransaction().begin();
		Guest b = manager.getReference(Guest.class, id);
		manager.remove(b);
		manager.getTransaction().commit();
		return id + " Removed From Book List";

	}

	@Override
	public String update(Guest guest) {
		// TODO Auto-generated method stub
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("hcl");
		EntityManager manager = factory.createEntityManager();

		manager.getTransaction().begin();
		manager.merge(guest);
		manager.getTransaction().commit();
		return guest.getId() + " Updated";
		
	}

	@Override
	public String add(Guest guest) {
		// TODO Auto-generated method stub
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("hcl");
		EntityManager manager = factory.createEntityManager();

		manager.getTransaction().begin();
		manager.persist(guest);
		manager.getTransaction().commit();
		return guest.getId() + " Added";
	}
	
	@Override
	public List<Guest> getGuestById(int id) {
		
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("hcl");
		EntityManager manager=factory.createEntityManager();
		try {
		@SuppressWarnings("unchecked")
		List<Guest> guests=manager.createQuery("select u from Guest u where u.id='"+id+"'").getResultList();
		if(guests.size()==0) return null;
		Guest user = null;
		for(Guest user2:guests) {
			user=user2;
		}
		return guests;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		finally {
			manager.close();
			factory.close();
		}
	}
	
	@Override
	public List<Guest> getGuestByUsername(String name) {
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("hcl");
		EntityManager manager=factory.createEntityManager();
		try {
		@SuppressWarnings("unchecked")
		List<Guest> users=manager.createQuery("select u from Guest u where u.name='"+name+"'").getResultList();
		if(users.size()==0) return null;
		Guest user = null;
		for(Guest user2:users) {
			user=user2;
		}
		return users;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		finally {
			manager.close();
			factory.close();
		}
	}
	


}
