package com.CIMS.DAO;

import java.util.List;

import com.CIMS.DTO.VictimsOfCrimeDTO;
import com.CIMS.Exception.VictimException;
import com.CIMS.bean.Victim;

public interface VictimDAO {
	
	public List<VictimsOfCrimeDTO> getVictimsOfCrime(int crimeId) throws VictimException;
	
	public int addAVictim(Victim victim) throws VictimException;
	
}
