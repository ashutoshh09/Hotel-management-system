//package dao;
//
//import java.util.List;
//
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.EntityManagerFactory;
//import jakarta.persistence.Persistence;
//import model.Guest;
//import model.User;
//import util.Query;
//
//public class UserImpl implements IUser{
//
//	@Override
//	public List<User> viewUsers() {
//		// TODO Auto-generated method stub
//		EntityManagerFactory factory = Persistence.createEntityManagerFactory("hcl");
//		EntityManager manager = factory.createEntityManager();
//
//		manager.getTransaction().begin();
//		@SuppressWarnings("unchecked")
//		List<User> list = manager.createQuery(Query.VIEW_USERS).getResultList();
//
//		return list;
//	}
//
//	@Override
//	public String delete(int id) {
//		EntityManagerFactory factory = Persistence.createEntityManagerFactory("hcl");
//		EntityManager manager = factory.createEntityManager();
//
//		manager.getTransaction().begin();
//		User b = manager.getReference(User.class, id);
//		manager.remove(b);
//		manager.getTransaction().commit();
//		return id + " Removed From User List";
//	}
//
//	@Override
//	public String update(User user) {
//		EntityManagerFactory factory = Persistence.createEntityManagerFactory("hcl");
//		EntityManager manager = factory.createEntityManager();
//
//		manager.getTransaction().begin();
//		manager.merge(user);
//		manager.getTransaction().commit();
//		return user.getId() + " Updated";
//	}
//
//
//	@Override
//	public String add(User user) {
//		EntityManagerFactory factory = Persistence.createEntityManagerFactory("hcl");
//		EntityManager manager = factory.createEntityManager();
//
//		manager.getTransaction().begin();
//		manager.persist(user);
//		manager.getTransaction().commit();
//		return user.getName() + " Added";
//	}
//	
//	
//
//}




package dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import model.User;
import util.Query;

public class UserImpl implements IUser{
	
	@Override
	public List<User> viewUsers() {
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("hcl");
		EntityManager manager=factory.createEntityManager();
		try {
		manager.getTransaction().begin();
		@SuppressWarnings("unchecked")
		List<User> users=manager.createQuery(Query.VIEW_USERS).getResultList();
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

	@Override
	public String add(User user) {
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("hcl");
		EntityManager manager=factory.createEntityManager();
		try {
		manager.getTransaction().begin();
		manager.persist(user);
		manager.getTransaction().commit();
		return user.getName()+" added successfully!";
		}
		catch (Exception e) {
			e.printStackTrace();
			return "false";
		}
		finally {
			manager.close();
			factory.close();
		}
	}

	@Override
	public String update(User user) {
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("hcl");
		EntityManager manager=factory.createEntityManager();
		try {
		manager.getTransaction().begin();
		manager.merge(user);
		manager.getTransaction().commit();
		return "success";
		}
		catch (Exception e) {
			e.printStackTrace();
			return "failure";
		}
		finally {
			manager.close();
			factory.close();
		}
	}

	@Override
	public String delete(int id) {
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("hcl");
		EntityManager manager=factory.createEntityManager();
		try {
		manager.getTransaction().begin();
		User user=manager.getReference(User.class, id);
		manager.remove(user);
		manager.getTransaction().commit();
		return "success";
		}
		catch (Exception e) {
			e.printStackTrace();
			return "failure";
		}
		finally {
			manager.close();
			factory.close();
		}
	}
	@Override
	public User getUserByname(String name) {
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("hcl");
		EntityManager manager=factory.createEntityManager();
		try {
		@SuppressWarnings("unchecked")
		List<User> users=manager.createQuery("select u from User u where u.name='"+name+"'").getResultList();
		if(users.size()==0) return null;
		User user = null;
		for(User user2:users) {
			user=user2;
		}
		return user;
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
	public User getUserByUsername(String email) {
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("hcl");
		EntityManager manager=factory.createEntityManager();
		try {
		@SuppressWarnings("unchecked")
		List<User> users=manager.createQuery("select u from User u where u.email='"+email+"'").getResultList();
		if(users.size()==0) return null;
		User user = null;
		for(User user2:users) {
			user=user2;
		}
		return user;
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
	public List<User> getUserByemail(String email){
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("hcl");
		EntityManager manager=factory.createEntityManager();
		try {
		@SuppressWarnings("unchecked")
		List<User> users=manager.createQuery("select u from User u where u.email='"+email+"'").getResultList();
		if(users.size()==0) return null;
		User user = null;
		for(User user2:users) {
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
		
		
	}}

	@Override
	public List<User> getUserById(int id) {
		
		EntityManagerFactory factory=Persistence.createEntityManagerFactory("hcl");
		EntityManager manager=factory.createEntityManager();
		try {
		@SuppressWarnings("unchecked")
		List<User> users=manager.createQuery("select u from User u where u.id='"+id+"'").getResultList();
		if(users.size()==0) return null;
		User user = null;
		for(User user2:users) {
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
	
	public String userchangepassword(String pr_password, String new_password,String user) {
		// TODO Auto-generated method stub
		;
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("hcl");
		EntityManager manager = factory.createEntityManager();
		//String message=(String)session.getAttribute("current-user");
		manager.getTransaction().begin();
		@SuppressWarnings({ "unused" })
		int a=manager.createQuery("update User a set a.password='"+new_password+"' where a.password='"+pr_password+"' and a.name='"+user+"'").executeUpdate();
		manager.getTransaction().commit();
		return "updated";
	
	
}}

