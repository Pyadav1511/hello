package bean;

import java.util.Date;

public class Patientbean {
	public Patientbean(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	private int id;
	private String name;
	private Date date2;
	public Patientbean(){
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
	public Date getDate2() {
		return date2;
	}
	public void setDate(Date date2) {
		this.date2 = date2;
	}

	@Override
	public String toString() {
		return "Patientbean [id=" + id + ", name=" + name + ", date2=" + date2
				+ "]";
	}

	
	
	
}
