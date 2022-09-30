package com.CIMS.DTO;

public class CriminalArrestedBeforeDTO {
	private String name;
	private int age;
	private String gender;
	private String address;
	private String mark;
	private String psname;
	
	public CriminalArrestedBeforeDTO() {
		// TODO Auto-generated constructor stub
	}

	public CriminalArrestedBeforeDTO(String name, int age, String gender, String address, String mark, String psname) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.mark = mark;
		this.psname = psname;
	}

	@Override
	public String toString() {
		return "CriminalArrestedBeforeDTO [name=" + name + ", age=" + age + ", gender=" + gender + ", address="
				+ address + ", mark=" + mark + ", psname=" + psname + "]";
	}
	
	
	
}
