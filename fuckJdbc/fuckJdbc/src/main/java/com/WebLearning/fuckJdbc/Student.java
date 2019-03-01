package com.WebLearning.fuckJdbc;


public class Student {

	private String ID;
	private String name;
	private int age;
	private String addressString;
	
	public Student(String ID, String name, int age, String address) {
		this.ID = ID;
		this.name = name;
		this.age = age;
		this.addressString = address;
	}
	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddressString() {
		return addressString;
	}
	public void setAddressString(String addressString) {
		this.addressString = addressString;
	}
	 
	 
}
