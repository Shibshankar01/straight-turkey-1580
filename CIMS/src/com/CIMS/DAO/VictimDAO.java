package com.CIMS.DAO;

import java.util.List;

import com.CIMS.DTO.VictimsOfCrimeDTO;
import com.CIMS.Exception.VictimException;

public interface VictimDAO {
	
	public List<VictimsOfCrimeDTO> getVictimsOfCrime(int crimeId) throws VictimException;
}
