package dao;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Service;

public interface IService  extends JpaRepository<Service, Integer>{
	
	

}
