package dao;

import java.util.List;


import model.Service;

public interface IService {
	
	
	public List<Service> viewService();
	public String delete(int id);
	
	public String update(Service service);
	public String add(Service service); 

}
