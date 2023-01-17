package dao;

import java.util.List;

import javax.servlet.http.HttpSession;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import model.Admin;

public class AdminImpl implements IAdmin {

	@Override
	public String adminLoginValidate(Admin admin) {
		// TODO Auto-generated method stub

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("hcl");
		EntityManager manager = factory.createEntityManager();
		
		@SuppressWarnings("unchecked")
		List<Admin> list=manager.createQuery("from Admin a where a.username='"+admin.getUsername()+"' and a.password='"+admin.getPassword()+"'").getResultList();
		if(list.size()>0) {
			return "success";
		}
		return "failure";
	}

	@Override
	public String changepassword(String pr_password, String new_password,String user) {
		// TODO Auto-generated method stub
		;
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("hcl");
		EntityManager manager = factory.createEntityManager();
		//String message=(String)session.getAttribute("current-user");
		manager.getTransaction().begin();
		@SuppressWarnings("unchecked")
		Query query=manager.createQuery("update Admin a set a.password='"+new_password+"' where a.password='"+pr_password+"' and a.username='"+user+"'");
		query.executeUpdate();
		manager.getTransaction().commit();
		return "updated";
		
	}
	
	

}
