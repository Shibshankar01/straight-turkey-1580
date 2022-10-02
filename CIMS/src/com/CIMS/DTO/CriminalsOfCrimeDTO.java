package com.CIMS.DTO;

public class CriminalsOfCrimeDTO {

	private String criminalName;
	private int age;
	private String gender;
	private String address;
	private String mark;
	private String description;
	
	public CriminalsOfCrimeDTO(String criminalName, int age, String gender, String address, String mark,
			String description) {
		super();
		this.criminalName = criminalName;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.mark = mark;
		this.description = description;
	}
	
	
	
	public String getCriminalName() {
		return criminalName;
	}



	public void setCriminalName(String criminalName) {
		this.criminalName = criminalName;
	}



	public int getAge() {
		return age;
	}



	public void setAge(int age) {
		this.age = age;
	}



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getMark() {
		return mark;
	}



	public void setMark(String mark) {
		this.mark = mark;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	@Override
	public String toString() {
		return "CriminalsOfCrimeDTO [criminalName=" + criminalName + ", age=" + age + ", gender=" + gender
				+ ", address=" + address + ", mark=" + mark + ", description=" + description + "]";
	}
	
	
	
}
