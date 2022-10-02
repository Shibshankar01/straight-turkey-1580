package com.CIMS.DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.CIMS.DTO.CrimeDTO;
import com.CIMS.DTO.CrimeInAPoliceStationDTO;
import com.CIMS.DTO.CrimesOfCriminalDTO;
import com.CIMS.Exception.CrimeException;
import com.CIMS.bean.Crime;
import com.CIMS.util.ConnectionClass;

public class CrimeDAOImplementation implements CrimeDAO{
	
	public List<CrimeDTO> getAllCrimes()throws CrimeException{
		List<CrimeDTO> crimes = new ArrayList<>();
		
		try(Connection conn = ConnectionClass.getConnection()){
			PreparedStatement st = conn.prepareStatement("select c.dateofcrime, c.description, c.detail_desc, c.status, p.policestationname from crime c inner join police_station p on c.policestationid = p.policestationid;");
			ResultSet rs =  st.executeQuery();
			while(rs.next()) {
				Date d = rs.getDate("dateofcrime");
				String desc = rs.getString("description");
				String detailDesc = rs.getString("detail_desc");
				String status = rs.getString("status");
				String policeStation = rs.getString("policestationname");
				crimes.add(new CrimeDTO(d, desc, detailDesc, status, policeStation));
			}
			if(crimes.size()==0)
				throw new CrimeException("No records present");
		}catch(SQLException e) {
			throw new CrimeException(e.getMessage());
		}
		return crimes;
	}

	@Override
	public List<CrimesOfCriminalDTO> getCrimesOfACriminal(String criminalName) throws CrimeException {
		// TODO Auto-generated method stub
		List<CrimesOfCriminalDTO> crimes = new ArrayList<>();
		
		try(Connection conn = ConnectionClass.getConnection()){
			PreparedStatement ps =  conn.prepareStatement(" select cr.name, c.dateofcrime, c.description, c.detail_desc, c.status from criminalsofcrime coc inner join criminal cr inner join crime c on coc.criminalid = cr.criminalid and coc.crimeid = c.crimeid where cr.name=?;");
			ps.setString(1, criminalName);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String name = rs.getString("name");
				Date dateOfCrime = rs.getDate("dateofcrime");
				String description = rs.getString("description");
				String detailDesc = rs.getString("detail_desc");
				String status = rs.getString("status");
				crimes.add(new CrimesOfCriminalDTO(name, dateOfCrime, description, detailDesc, status));
			}
			if(crimes.size()==0) {
				throw new CrimeException("No crimes found");
			}
		}catch(SQLException e) {
			throw new CrimeException(e.getMessage());
		}
		return crimes;
	}

	@Override
	public List<CrimeInAPoliceStationDTO> getAllCrimesForAPoliceStation(String psName) throws CrimeException {
		// TODO Auto-generated method stub
		List<CrimeInAPoliceStationDTO> crimes = new ArrayList<>();
		try(Connection conn = ConnectionClass.getConnection()){
			PreparedStatement ps = conn.prepareStatement("select p.policestationname, c.dateofcrime, c.description, c.detail_desc, c.status from crime c inner join police_station p on c.policestationid = p.policestationid where policestationname = ?;");
			ps.setString(1, psName);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				String p = rs.getString("policestationname");
				Date date = rs.getDate("dateofcrime");
				String description = rs.getString("description");
				String detailDesc = rs.getString("detail_desc");
				String status = rs.getString("status");
				crimes.add(new CrimeInAPoliceStationDTO(p, date, description, detailDesc, status));
			}
			if(crimes.size()==0)
				throw new CrimeException("No crimes found");
		}catch(SQLException e) {
			throw new CrimeException(e.getMessage());
		}
		return crimes;
	}

	@Override
	public List<CrimeDTO> getAllCrimesOnStatus(String status) throws CrimeException {
		// TODO Auto-generated method stub
		List<CrimeDTO> crimes = new ArrayList<>();
		try(Connection conn = ConnectionClass.getConnection()) {
			PreparedStatement ps = conn.prepareStatement("select c.dateofcrime, c.description, c.detail_desc, c.status, p.policestationname from crime c inner join police_station p on c.policestationid = p.policestationid where c.status=?;");
			ps.setString(1, status);
			ResultSet rs =  ps.executeQuery();
			while(rs.next()) {
				Date d = rs.getDate("dateofcrime");
				String desc = rs.getString("description");
				String detailDesc = rs.getString("detail_desc");
				String statu = rs.getString("status");
				String policeStation = rs.getString("policestationname");
				crimes.add(new CrimeDTO(d, desc, detailDesc, statu, policeStation));
			}
			if(crimes.size()==0)
				throw new CrimeException("No Crimes found");
		}
		catch(SQLException e) {
			throw new CrimeException(e.getMessage());
		}
		return crimes;
	}

	@Override
	public List<CrimeDTO> getAllCrimesForCurrentMonth() throws CrimeException {
		// TODO Auto-generated method stub
		List<CrimeDTO> crimes = new ArrayList<>();
		
		try(Connection conn= ConnectionClass.getConnection()){
			PreparedStatement ps = conn.prepareStatement("select c.dateofcrime, c.description, c.detail_desc, c.status, p.policestationname from crime c inner join police_station p on c.policestationid = p.policestationid where month(dateofcrime)=month(now());");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Date date = rs.getDate("dateofcrime");
				String description = rs.getString("description");
				String detailDesc = rs.getString("detail_desc");
				String status = rs.getString("status");
				String psName = rs.getString("policestationname");
				crimes.add(new CrimeDTO(date, description, detailDesc, status, psName));
			}
			if(crimes.size()==0)
				throw new CrimeException("No crimes found for the current month");
		}catch(SQLException e) {
			throw new CrimeException(e.getMessage());
		}
		return crimes;
	}

	@Override
	public int addACrime(Crime crime) throws CrimeException {
		int x = 0;
		try (Connection conn = ConnectionClass.getConnection()){
			
			PreparedStatement ps =  conn.prepareStatement(" insert into crime(dateofcrime, description, detail_desc, areaid, policestationid, status) values(?, ?, ?, ?, ?, ?);");
			ps.setDate(1, crime.getDate());
			ps.setString(2, crime.getDescription());
			ps.setString(3, crime.getDetailDescription());
			ps.setInt(4, crime.getAreaId());
			ps.setInt(5, crime.getPoliceStationId());
			ps.setString(6, crime.getStatus());
			x=ps.executeUpdate();
			if(x==0)
				throw new CrimeException("Record not inserted");
			
		}catch(SQLException e) {
			throw new CrimeException(e.getMessage());
		}
		return 0;
	}

	@Override
	public int updateACrimeStatus(int crimeid, String status) throws CrimeException {
		int x = 0;
		try(Connection conn = ConnectionClass.getConnection()){
			PreparedStatement ps = conn.prepareStatement("update crime set status = ? where crimeid = ?;");
			ps.setString(1, status);
			ps.setInt(2, crimeid);
			x = ps.executeUpdate();
			if(x==0)
				throw new CrimeException("Crime status not updated");			
		}
		catch(SQLException e) {
			throw new CrimeException(e.getMessage());
		}
		return x;
	}

	@Override
	public int assignCrimeToCriminal(String criminalName, int crimeId) throws CrimeException {
		int x = 0;
		
		try (Connection conn = ConnectionClass.getConnection()){
			int criminalId = getCriminalId(criminalName);
			PreparedStatement ps = conn.prepareStatement("insert into criminalsofcrime values (?, ?);");
			ps.setInt(1, criminalId);
			ps.setInt(2, crimeId);
			x = ps.executeUpdate();
			if(x==0)
				throw new CrimeException("Crime not assigned to the criminal");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return x;
	}
	
	private int getCriminalId(String name)throws CrimeException{
		int id = 0;
		
		try(Connection conn = ConnectionClass.getConnection()){
			PreparedStatement ps = conn.prepareStatement("select criminalId from criminal where name = ?;");
			ps.setString(1, name);
			ResultSet rs =  ps.executeQuery();
			if(rs.next()) {
				id = rs.getInt("criminalId");
			}
			else {
				throw new CrimeException("No criminal found with that name");
			}
		}
		catch(SQLException e) {
			throw new CrimeException(e.getMessage());
		}
		return id;
	}

	@Override
	public int assignCrimeToVictim(String victimName, int crimeId) throws CrimeException {
		int x = 0;
		try(Connection conn = ConnectionClass.getConnection()){
			int criminalId = getVictimId(victimName);
			PreparedStatement ps = conn.prepareStatement("insert into victimsofcrime values(?, ?);");
			ps.setInt(1, criminalId);
			ps.setInt(2, crimeId);
			x = ps.executeUpdate();
			if(x==0)
				throw new CrimeException("Victim not assigned");
			
		}
		catch(SQLException e) {
			throw new CrimeException(e.getMessage());
		}
		return x;
	}
	
	private int getVictimId(String name) throws CrimeException{
		int victimId = 0;
		
		try(Connection conn = ConnectionClass.getConnection()){
			PreparedStatement ps = conn.prepareStatement("select victimid from victim where name = ?");
			ps.setString(1, name);
			ResultSet rs =  ps.executeQuery();
			if(rs.next()) {
				victimId = rs.getInt("victimid");
			}
			else {
				throw new CrimeException("No victims found with that name");
			}
		}
		catch(SQLException e) {
			throw new CrimeException(e.getMessage());
		}
		return victimId;
	}
	
	
}






















