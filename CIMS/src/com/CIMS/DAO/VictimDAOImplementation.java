package com.CIMS.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.CIMS.DTO.VictimsOfCrimeDTO;
import com.CIMS.Exception.VictimException;
import com.CIMS.bean.Victim;
import com.CIMS.util.ConnectionClass;

public class VictimDAOImplementation implements VictimDAO{

	@Override
	public List<VictimsOfCrimeDTO> getVictimsOfCrime(int crimeId) throws VictimException {
		// TODO Auto-generated method stub
		List<VictimsOfCrimeDTO> victims = new ArrayList<>();
		
		try(Connection conn = ConnectionClass.getConnection()){
			
			PreparedStatement ps =  conn.prepareStatement("select v.name, v.age, v.gender, v.address, c.description from victimsofcrime vc inner join crime c inner join victim v on vc.victimid = v.victimid and c.crimeid = vc.crimeid where c.crimeid = ?;");
			ps.setInt(1, crimeId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String name = rs.getString("name");
				int age = rs.getInt("age");
				String gender = rs.getString("gender");
				String address = rs.getString("address");
				String description = rs.getString("description");
				victims.add(new VictimsOfCrimeDTO(name, age, gender, address, description));
			}
			if(victims.size()==0)
				throw new VictimException("No victims found");
		}catch(SQLException e) {
			throw new VictimException(e.getMessage());
		}
		return victims;
	}

	@Override
	public int addAVictim(Victim victim) throws VictimException {
		int x = 0;
		
		try(Connection conn = ConnectionClass.getConnection()){
			PreparedStatement ps = conn.prepareStatement("insert into victim(name, age, gender, address) values(?, ?, ?, ?);");
			ps.setString(1, victim.getName());
			ps.setInt(2, victim.getAge());
			ps.setString(3, victim.getGender());
			ps.setString(4, victim.getAddress());
			x = ps.executeUpdate();
			if(x==0)
				throw new VictimException("Victim not added..");
		}
		catch(SQLException e) {
			throw new VictimException(e.getMessage());
		}
		return x;
	}
	
}
