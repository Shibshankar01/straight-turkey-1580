package com.CIMS.DAO;

import java.util.List;

import com.CIMS.DTO.CrimesOfCriminalDTO;
import com.CIMS.DTO.CriminalsOfCrimeDTO;
import com.CIMS.Exception.CrimeException;
import com.CIMS.bean.Crime;

public interface CrimeDAO {
	public List<Crime> getAllCrimes() throws CrimeException;
	
	public List<CrimesOfCriminalDTO> getCrimesOfACriminal(int criminalId) throws CrimeException;
}
