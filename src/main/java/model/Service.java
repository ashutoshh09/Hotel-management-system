package model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Service {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String servicename;
	private String servicedesc;
	private long contact;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getServicename() {
		return servicename;
	}
	public void setServicename(String servicename) {
		this.servicename = servicename;
	}
	public String getServicedesc() {
		return servicedesc;
	}
	public void setServicedesc(String servicedesc) {
		this.servicedesc = servicedesc;
	}
	public long getContact() {
		return contact;
	}
	public void setContact(long contact) {
		this.contact = contact;
	}
	
	
	
}
