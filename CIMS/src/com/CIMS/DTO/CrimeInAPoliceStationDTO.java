package com.CIMS.DTO;

import java.sql.Date;

public class CrimeInAPoliceStationDTO {
	private String policeStationName;
	private Date dateOfCrime;
	private String desc;
	private String detailDesc;
	private String status;
	public CrimeInAPoliceStationDTO(String policeStationName, Date dateOfCrime, String desc, String detailDesc,
			String status) {
		super();
		this.policeStationName = policeStationName;
		this.dateOfCrime = dateOfCrime;
		this.desc = desc;
		this.detailDesc = detailDesc;
		this.status = status;
	}
	public String getPoliceStationName() {
		return policeStationName;
	}
	public void setPoliceStationName(String policeStationName) {
		this.policeStationName = policeStationName;
	}
	public Date getDateOfCrime() {
		return dateOfCrime;
	}
	public void setDateOfCrime(Date dateOfCrime) {
		this.dateOfCrime = dateOfCrime;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
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
	@Override
	public String toString() {
		return "CrimeInAPoliceStationDTO [policeStationName=" + policeStationName + ", dateOfCrime=" + dateOfCrime
				+ ", desc=" + desc + ", detailDesc=" + detailDesc + ", status=" + status + "]";
	}
	
	
}
