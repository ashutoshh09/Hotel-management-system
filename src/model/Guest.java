package model;

import java.sql.Date;
//import java.time.LocalDate;

public class Guest {
	private int id;
	private String name;
	private Date from;
	private Date to;
	private int crooms;
	private String type;
	private long price;

	

	public Guest(int id, String name, Date from, Date to, int crooms, String type, long price) {
		super();
		this.id = id;
		this.name = name;
		this.from = from;
		this.to = to;
		this.crooms = crooms;
		this.type = type;
		this.price = price;
	}

	public Guest(String type,int id) {
		// TODO Auto-generated constructor stub
		this.type=type;
		this.id=id;
	}
	public Guest(String name, Date from, Date to, int crooms, String type) {
		super();
		this.name = name;
		this.from = from;
		this.to = to;
		this.crooms = crooms;
		this.type = type;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public Guest(int id) {
		this.id = id;
	}

	public Guest(int id, int crooms) {
		this.id = id;
		this.crooms = crooms;
	}

	public Guest(int id, Date from, Date to) {
		this.id = id;
		this.from = from;
		this.to = to;

	}

	public Guest(int id, String name, Date from, Date to, int crooms, String type) {
		super();
		this.id = id;
		this.name = name;
		this.from = from;
		this.to = to;
		this.crooms = crooms;
		this.type = type;
	}

	public Guest(int id,String name) {
		this.id = id;
		this.name = name;
		// TODO Auto-generated constructor stub
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

	public Date getFrom() {
		return from;
	}

	public void setFrom(Date from) {
		this.from = from;
	}

	public Date getTo() {
		return to;
	}

	public void setTo(Date to) {
		this.to = to;
	}

	public int getCrooms() {
		return crooms;
	}

	public void setCrooms(int crooms) {
		this.crooms = crooms;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return String.format("%-20s%-20s%-20s%-20s%-20s%-20s%-20s", id, name, from, to, crooms, type,price);
	}


}
