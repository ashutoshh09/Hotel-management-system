package dao;

import org.springframework.data.jpa.repository.JpaRepository;


import model.Guest;

public interface IGuest extends JpaRepository<Guest, Integer> {
	
	Guest findByName(String name);

}
