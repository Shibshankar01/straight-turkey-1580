package com.CIMS.DTO;

import java.sql.Date;

public class CrimesOfCriminalDTO {

	private String criminalName;
	private Date dateOfCrime;
	private String description;
	private String detailDescription;
	
	public CrimesOfCriminalDTO() {
		// TODO Auto-generated constructor stub
	}

	public CrimesOfCriminalDTO(String criminalName, Date dateOfCrime, String description, String detailDescription) {
		super();
		this.criminalName = criminalName;
		this.dateOfCrime = dateOfCrime;
		this.description = description;
		this.detailDescription = detailDescription;
	}

	@Override
	public String toString() {
		return "CrimesOfCriminalDTO [criminalName=" + criminalName + ", dateOfCrime=" + dateOfCrime + ", description="
				+ description + ", detailDescription=" + detailDescription + "]";
	}
	
	
}
