package model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import java.sql.Date;

@Entity
public class Guest {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	private String name;
	private String check_in;
	private String check_out;
	public void setCheck_in(String check_in) {
		this.check_in = check_in;
	}

	public String getCheck_in() {
		return check_in;
	}

	public String getCheck_out() {
		return check_out;
	}

	public void setCheck_out(String check_out) {
		this.check_out = check_out;
	}

	private int room;
	private int nosguest;

//	public Date getCheck_in() {
//		return check_in;
//	}

//	public void setCheck_in(Date check_in) {
//		this.check_in = check_in;
//	}
//
//	public Date getCheck_out() {
//		return check_out;
//	}
//
//	public void setCheck_out(Date check_out) {
//		this.check_out = check_out;
//	}

	public int getRoom() {
		return room;
	}

	public void setRoom(int room) {
		this.room = room;
	}

	public int getNosguest() {
		return nosguest;
	}

	public void setNosguest(int nosguest) {
		this.nosguest = nosguest;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
