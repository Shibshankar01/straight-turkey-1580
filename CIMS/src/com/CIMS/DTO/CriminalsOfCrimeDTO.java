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
	@Override
	public String toString() {
		return "CriminalsOfCrimeDTO [criminalName=" + criminalName + ", age=" + age + ", gender=" + gender
				+ ", address=" + address + ", mark=" + mark + ", description=" + description + "]";
	}
	
	
	
}
