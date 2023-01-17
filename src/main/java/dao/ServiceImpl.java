package dao;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import model.Service;
import util.Query;

public class ServiceImpl implements IService{

	@Override
	public List<Service> viewService() {
		// TODO Auto-generated method stub
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("hcl");
		EntityManager manager = factory.createEntityManager();

		manager.getTransaction().begin();
		@SuppressWarnings("unchecked")
		List<Service> list = manager.createQuery(Query.VIEW_SERVICE).getResultList();

		return list;
	}

	@Override
	public String delete(int id) {
		// TODO Auto-generated method stub
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("hcl");
		EntityManager manager = factory.createEntityManager();

		manager.getTransaction().begin();
		Service b = manager.getReference(Service.class, id);
		manager.remove(b);
		manager.getTransaction().commit();
		return id + " Removed From Book List";
	}

	@Override
	public String update(Service service) {
		// TODO Auto-generated method stub
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("hcl");
		EntityManager manager = factory.createEntityManager();

		manager.getTransaction().begin();
		manager.merge(service);
		manager.getTransaction().commit();
		return service.getId() + " Updated";
	}

	@Override
	public String add(Service service) {
		// TODO Auto-generated method stub
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("hcl");
		EntityManager manager = factory.createEntityManager();

		manager.getTransaction().begin();
		manager.persist(service);
		manager.getTransaction().commit();
		return service.getId() + " Added";
	}

}
