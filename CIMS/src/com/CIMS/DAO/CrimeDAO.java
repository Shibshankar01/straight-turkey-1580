package com.CIMS.DAO;

import java.util.List;

import com.CIMS.DTO.CrimeDTO;
import com.CIMS.DTO.CrimeInAPoliceStationDTO;
import com.CIMS.DTO.CrimesOfCriminalDTO;
import com.CIMS.Exception.CrimeException;
import com.CIMS.bean.Crime;

public interface CrimeDAO {
	public List<CrimeDTO> getAllCrimes() throws CrimeException;
	
	public List<CrimeInAPoliceStationDTO> getAllCrimesForAPoliceStation(String psName) throws CrimeException;
	
	public List<CrimesOfCriminalDTO> getCrimesOfACriminal(String criminalName) throws CrimeException;
	
	public List<CrimeDTO> getAllCrimesOnStatus(String status) throws CrimeException;
	
	public List<CrimeDTO> getAllCrimesForCurrentMonth() throws CrimeException;
	
	public int addACrime(Crime crime) throws CrimeException;
	
	public int updateACrimeStatus(int crimeid, String status) throws CrimeException;
	
	public int assignCrimeToCriminal(String criminalName, int crimeId) throws CrimeException;
	
	public int assignCrimeToVictim(String victimName, int crimeId) throws CrimeException;
}
