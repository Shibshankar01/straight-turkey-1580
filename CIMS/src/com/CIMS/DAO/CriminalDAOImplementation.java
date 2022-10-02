package com.CIMS.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.CIMS.DTO.CriminalArrestedBeforeDTO;
import com.CIMS.DTO.CriminalsOfCrimeDTO;
import com.CIMS.Exception.CriminalException;
import com.CIMS.bean.Criminal;
import com.CIMS.util.ConnectionClass;

public class CriminalDAOImplementation implements CriminalDAO{

	@Override
	public List<Criminal> getAllCriminals() throws CriminalException {
		// TODO Auto-generated method stub
		List<Criminal> criminals = new ArrayList<>();
		
		try(Connection conn = ConnectionClass.getConnection()){
			PreparedStatement ps =  conn.prepareStatement("select * from criminal");
			ResultSet rs =  ps.executeQuery();
			while(rs.next()) {
				int criminalId = rs.getInt("criminalid");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String gender = rs.getString("gender");
				String address = rs.getString("address");
				String mark = rs.getString("mark");
				int policeStationId = rs.getInt("policestationfirstarrestedid");
				criminals.add(new Criminal(name, age, gender, address, mark, policeStationId));
			}
			if(criminals.size()==0)
				throw new CriminalException("No criminals found");
		}catch(SQLException e) {
			throw new CriminalException(e.getMessage());
		}
		
		return criminals;
	}

	@Override
	public List<CriminalArrestedBeforeDTO> getCriminalsArrestedBefore() throws CriminalException {
		// TODO Auto-generated method stub
		List<CriminalArrestedBeforeDTO> criminals = new ArrayList<>();
		
		try(Connection conn = ConnectionClass.getConnection()){
			PreparedStatement ps =  conn.prepareStatement("select name, age, gender, address, mark, policestationname from criminal cr inner join police_station ps on cr.policestationfirstarrestedid = ps.policestationid;");
			ResultSet rs =  ps.executeQuery();
			while(rs.next()) {
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String gender = rs.getString("gender");
				String address = rs.getString("address");
				String mark = rs.getString("mark");
				String policeStationName = rs.getString("policestationname");
				criminals.add(new CriminalArrestedBeforeDTO(name, age, gender, address, mark, policeStationName));
			}
			if(criminals.size()==0)
				throw new CriminalException("No criminals found");
		}catch(SQLException e) {
			throw new CriminalException(e.getMessage());
		}
		
		return criminals;
	}

	@Override
	public List<CriminalsOfCrimeDTO> getCriminalsForCrime(int crimeId) throws CriminalException {
		// TODO Auto-generated method stub
		List<CriminalsOfCrimeDTO> criminals = new ArrayList<>();
		
		try(Connection conn = ConnectionClass.getConnection()){
			PreparedStatement ps = conn.prepareStatement("select cr.name, cr.age, cr.gender, cr.address, cr.mark, c.description from criminalsofcrime coc inner join criminal cr inner join crime c on coc.criminalid = cr.criminalid and coc.crimeid = c.crimeid where c.crimeid = ?;");
			ps.setInt(1, crimeId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String gender = rs.getString("gender");
				String address = rs.getString("address");
				String mark = rs.getString("mark");
				String description = rs.getString("description");
				criminals.add(new CriminalsOfCrimeDTO(name, age, gender, address, mark, description));
			}
			if(criminals.size()==0)
				throw new CriminalException("No criminals found");
		}catch(SQLException e) {
			throw new CriminalException(e.getMessage());
		}
		return criminals;
	}

	@Override
	public int addACriminal(Criminal criminal) throws CriminalException {
		int x = 0;
		
		try(Connection conn = ConnectionClass.getConnection()){
			PreparedStatement ps = null;
			if(criminal.getPoliceStationFirstArrested()!=0) {
				ps = conn.prepareStatement("insert into criminal(name, age, gender, address, mark, policestationfirstarrestedid) values(?, ?, ?, ?, ?, ?);");
				ps.setString(1, criminal.getName());
				ps.setInt(2, criminal.getAge());
				ps.setString(3, criminal.getGender());
				ps.setString(4, criminal.getAddress());
				ps.setString(5, criminal.getMark());
				ps.setInt(6, criminal.getPoliceStationFirstArrested());
			}
			else {
				ps = conn.prepareStatement("insert into criminal(name, age, gender, address, mark) values(?, ?, ?, ?, ?);");
				ps.setString(1, criminal.getName());
				ps.setInt(2, criminal.getAge());
				ps.setString(3, criminal.getGender());
				ps.setString(4, criminal.getAddress());
				ps.setString(5, criminal.getMark());
			}			
			x = ps.executeUpdate();
			if(x==0)
				throw new CriminalException("Criminal not inserted..");
		}catch(SQLException e) {
			throw new CriminalException(e.getMessage());
		}
		return x;
	}
	
	

}










