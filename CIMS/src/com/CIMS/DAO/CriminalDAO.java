package com.CIMS.DAO;

import java.util.List;

import com.CIMS.DTO.CriminalArrestedBeforeDTO;
import com.CIMS.DTO.CriminalsOfCrimeDTO;
import com.CIMS.Exception.CriminalException;
import com.CIMS.bean.Criminal;

public interface CriminalDAO {
	
	public List<Criminal> getAllCriminals() throws CriminalException;
	
	public List<CriminalArrestedBeforeDTO> getCriminalsArrestedBefore() throws CriminalException;
	
	public List<CriminalsOfCrimeDTO> getCriminalsForCrime(int crimeId) throws CriminalException;
	
	public int addACriminal(Criminal criminal) throws CriminalException;
}
