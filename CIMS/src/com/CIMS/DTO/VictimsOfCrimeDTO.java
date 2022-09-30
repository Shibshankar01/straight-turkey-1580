package com.CIMS.DTO;

public class VictimsOfCrimeDTO {
	
	private String name;
	private int age;
	private String gender;
	private String address;
	private String description;
	
	public VictimsOfCrimeDTO() {
		// TODO Auto-generated constructor stub
	}

	public VictimsOfCrimeDTO(String name, int age, String gender, String address, String description) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.description = description;
	}

	@Override
	public String toString() {
		return "VictimsOfCrimeDTO [name=" + name + ", age=" + age + ", gender=" + gender + ", address=" + address
				+ ", description=" + description + "]";
	}
	
	
}
