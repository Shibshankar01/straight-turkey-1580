package com.CIMS.DTO;

import java.sql.Date;

public class CrimeDTO {

	private Date dateofCrime;
	private String description;
	private String detailDesc;
	private String status;
	private String policeStationName;
	
	public CrimeDTO(Date dateofCrime, String description, String detailDesc, String status, String policeStationName) {
		super();
		this.dateofCrime = dateofCrime;
		this.description = description;
		this.detailDesc = detailDesc;
		this.status = status;
		this.policeStationName = policeStationName;
	}
	public Date getDateofCrime() {
		return dateofCrime;
	}
	public void setDateofCrime(Date dateofCrime) {
		this.dateofCrime = dateofCrime;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getDetailDesc() {
		return detailDesc;
	}
	public void setDetailDesc(String detailDesc) {
		this.detailDesc = detailDesc;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPoliceStationName() {
		return policeStationName;
	}
	public void setPoliceStationName(String policeStationName) {
		this.policeStationName = policeStationName;
	}
	@Override
	public String toString() {
		return "CrimeDTO [dateofCrime=" + dateofCrime + ", description=" + description + ", detailDesc=" + detailDesc
				+ ", status=" + status + ", policeStationName=" + policeStationName + "]";
	}

	
}
