package com.CIMS.UseCases;

import java.util.List;

import com.CIMS.DAO.CrimeDAO;
import com.CIMS.DAO.CrimeDAOImplementation;
import com.CIMS.DAO.CriminalDAO;
import com.CIMS.DAO.CriminalDAOImplementation;
import com.CIMS.DAO.VictimDAO;
import com.CIMS.DAO.VictimDAOImplementation;
import com.CIMS.DTO.CrimesOfCriminalDTO;
import com.CIMS.DTO.CriminalArrestedBeforeDTO;
import com.CIMS.DTO.CriminalsOfCrimeDTO;
import com.CIMS.DTO.VictimsOfCrimeDTO;
import com.CIMS.Exception.CrimeException;
import com.CIMS.Exception.CriminalException;
import com.CIMS.Exception.VictimException;
import com.CIMS.bean.Crime;
import com.CIMS.bean.Criminal;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CrimeDAO dao = new CrimeDAOImplementation();
		try {
			List<CrimesOfCriminalDTO> crimes =  dao.getCrimesOfACriminal(2);
			System.out.println(crimes);
		} catch (CrimeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CriminalDAO criminalDao = new CriminalDAOImplementation();
		try {
			List<CriminalsOfCrimeDTO> criminals = criminalDao.getCriminalsForCrime(2);
			System.out.println(criminals);
		} catch (CriminalException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		VictimDAO victimDao = new VictimDAOImplementation();
		try {
			List<VictimsOfCrimeDTO> victims =  victimDao.getVictimsOfCrime(2);
			System.out.println(victims);
		} catch (VictimException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
