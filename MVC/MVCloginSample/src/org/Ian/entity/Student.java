package org.Ian.entity;

public class Student {
	private String id;
	private String Name;
	private int times;
	private String date;

	public Student() {
	}
	
	public Student(String id, String Name, int times) {
		this.id = id;
		this.Name = Name;
		this.times = times;
	}

	public String getId() {
		return id;
	}

	public void setId(String Id) {
		this.id = Id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String Name) {
		this.Name = Name;
	}

	public void setTimes(int i) {
		this.times = i;
	}

	public int getTimes() {
		return this.times;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
}
