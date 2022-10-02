package com.CIMS.DTO;

import java.sql.Date;

public class CrimesOfCriminalDTO {

	private String criminalName;
	private Date dateOfCrime;
	private String description;
	private String detailDescription;
	private String status;
	
	public CrimesOfCriminalDTO() {
		// TODO Auto-generated constructor stub
	}

	public CrimesOfCriminalDTO(String criminalName, Date dateOfCrime, String description, String detailDescription, String status) {
		super();
		this.criminalName = criminalName;
		this.dateOfCrime = dateOfCrime;
		this.description = description;
		this.detailDescription = detailDescription;
		this.status = status;
	}

	
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCriminalName() {
		return criminalName;
	}

	public void setCriminalName(String criminalName) {
		this.criminalName = criminalName;
	}

	public Date getDateOfCrime() {
		return dateOfCrime;
	}

	public void setDateOfCrime(Date dateOfCrime) {
		this.dateOfCrime = dateOfCrime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDetailDescription() {
		return detailDescription;
	}

	public void setDetailDescription(String detailDescription) {
		this.detailDescription = detailDescription;
	}

	@Override
	public String toString() {
		return "CrimesOfCriminalDTO [criminalName=" + criminalName + ", dateOfCrime=" + dateOfCrime + ", description="
				+ description + ", detailDescription=" + detailDescription + "]";
	}
	
	
}
