package com.CIMS.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.CIMS.DTO.CrimesOfCriminalDTO;
import com.CIMS.Exception.CrimeException;
import com.CIMS.bean.Crime;
import com.CIMS.util.ConnectionClass;

public class CrimeDAOImplementation implements CrimeDAO{
	
	public List<Crime> getAllCrimes()throws CrimeException{
		List<Crime> crimes = new ArrayList<>();
		
		try(Connection conn = ConnectionClass.getConnection()){
			PreparedStatement st = conn.prepareStatement("select * from crime");
			ResultSet rs =  st.executeQuery();
			while(rs.next()) {
				int crimeId = rs.getInt("crimeid");
				Date date = rs.getDate("dateofcrime");
				String desc = rs.getString("description");
				String detailDesc = rs.getString("detail_desc");
				int areaId = rs.getInt("areaid");
				int policeStationId = rs.getInt("policestationid");
				String status = rs.getString("status");
				crimes.add(new Crime(date, desc, detailDesc, areaId, policeStationId, status));
			}
			if(crimes.size()==0)
				throw new CrimeException("No records present");
		}catch(SQLException e) {
			throw new CrimeException(e.getMessage());
		}
		return crimes;
	}

	@Override
	public List<CrimesOfCriminalDTO> getCrimesOfACriminal(int criminalId) throws CrimeException {
		// TODO Auto-generated method stub
		List<CrimesOfCriminalDTO> crimes = new ArrayList<>();
		
		try(Connection conn = ConnectionClass.getConnection()){
			PreparedStatement ps =  conn.prepareStatement("select cr.name, c.dateofcrime, c.description, c.detail_desc from criminalsofcrime coc inner join criminal cr inner join crime c on coc.criminalid = cr.criminalid and coc.crimeid = c.crimeid where cr.criminalid=?;");
			ps.setInt(1, criminalId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String name = rs.getString("name");
				Date dateOfCrime = rs.getDate("dateofcrime");
				String description = rs.getString("description");
				String detailDesc = rs.getString("detail_desc");
				crimes.add(new CrimesOfCriminalDTO(name, dateOfCrime, description, detailDesc));
			}
			if(crimes.size()==0) {
				throw new CrimeException("No crimes found");
			}
		}catch(SQLException e) {
			throw new CrimeException(e.getMessage());
		}
		return crimes;
	}
}
