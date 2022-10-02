package com.CIMS.UseCases;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;


import com.CIMS.DAO.CrimeDAO;
import com.CIMS.DAO.CrimeDAOImplementation;
import com.CIMS.DAO.CriminalDAO;
import com.CIMS.DAO.CriminalDAOImplementation;
import com.CIMS.DAO.VictimDAO;
import com.CIMS.DAO.VictimDAOImplementation;
import com.CIMS.DTO.CrimeDTO;
import com.CIMS.DTO.CrimeInAPoliceStationDTO;
import com.CIMS.DTO.CrimesOfCriminalDTO;
import com.CIMS.DTO.CriminalsOfCrimeDTO;
import com.CIMS.DTO.VictimsOfCrimeDTO;
import com.CIMS.Exception.CrimeException;
import com.CIMS.Exception.CriminalException;
import com.CIMS.Exception.VictimException;
import com.CIMS.bean.Crime;
import com.CIMS.bean.Criminal;
import com.CIMS.bean.Victim;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		boolean mainFlag = true;
		int mainChoice = 0;
		System.out.println("Welcome to Crime Information Management System");
		System.out.println("Enter your choice");
		while(mainFlag) {
			System.out.println("1. Insert a crime records");
			System.out.println("2. View all the crime and criminal records");
			System.out.println("3. Exit");
			mainChoice = Integer.parseInt(sc.nextLine());
			CrimeDAO crimeDao1 = new CrimeDAOImplementation();
			CriminalDAO criminalDao1 = new CriminalDAOImplementation();
			VictimDAO victimDao1 = new VictimDAOImplementation();
			switch (mainChoice) {
			case 1:
				boolean insertFlag = true;
				int insertChoice = 0;
				
				while(insertFlag) {
					System.out.println("1. Insert a new crime");
					System.out.println("2. Insert a new criminal");
					System.out.println("3. Insert a new Victim");
					System.out.println("4. Update the status of a crime");
					System.out.println("5. Assign criminals to a crime");
					System.out.println("6. Assign victims to a crime");
					System.out.println("7. Exit");
					
					insertChoice = Integer.parseInt(sc.nextLine());
					
					switch (insertChoice) {
					case 1:
						System.out.println("Enter the date in which the crime occured in.: ");
						Date date = Date.valueOf(sc.nextLine());
						System.out.println("Enter a short description.: ");
						String description = sc.nextLine();
						System.out.println("Enter a detailed description.: ");
						String detailDesc = sc.nextLine();
						System.out.println("Enter the Area Id.: ");
						int areaId = Integer.parseInt(sc.nextLine());
						System.out.println("Enter the Police Station Id.: ");
						int policeStationId = Integer.parseInt(sc.nextLine());
						System.out.println("Enter the status");
						String status = sc.nextLine();
						Crime crime = new Crime(date, description, detailDesc, areaId, policeStationId, status);
						try {
							crimeDao1.addACrime(crime);
							System.out.println("Crime inserted successfully");
						}catch(CrimeException e) {
							System.out.println(e.getMessage());
						}
						break;
						
					case 2:
						System.out.println("Enter the criminal name");
						String name = sc.nextLine();
						System.out.println("Enter the criminal Age");
						int age = Integer.parseInt(sc.nextLine());
						System.out.println("Enter the criminal gender");
						String gender = sc.nextLine();
						System.out.println("Enter the criminal address");
						String address = sc.nextLine();
						System.out.println("Enter an indentifying mark in the criminal's body");
						String mark = sc.nextLine();
						System.out.println("Enter the police station id in which the criminal was first arrested if no arrested before enter 0");
						int psid = Integer.parseInt(sc.nextLine());
						Criminal criminal = new Criminal(name, age, gender, address, mark, psid);
						try {
							if(criminalDao1.addACriminal(criminal)>0)
								System.out.println("Criminal Inserted Succesfully");
						}
						catch(CriminalException e) {
							System.out.println(e.getMessage());
						}
						break;
						
					case 3:
						System.out.println("Enter the victim name");
						String vname = sc.nextLine();
						System.out.println("Enter the victim age");
						int vage = Integer.parseInt(sc.nextLine());
						System.out.println("Enter the victim gender");
						String vgender = sc.nextLine();
						System.out.println("Enter the victim address");
						String vaddress = sc.nextLine();
						Victim victim = new Victim(vname, vage, vgender, vaddress);
						try {
							if(victimDao1.addAVictim(victim)>0)
									System.out.println("Victim added succesfully");
						}
						catch(VictimException e) {
							System.out.println(e.getMessage());
						}
						break;
					
					case 4:
						System.out.println("Enter the crime Id");	
						int crimeId = Integer.parseInt(sc.nextLine());
						System.out.println("Enter the updated crime status");
						String nstatus = sc.nextLine();
						try {
							if(crimeDao1.updateACrimeStatus(crimeId, nstatus)!=0)
								System.out.println("Crime Status Updated Succesfully");
						}
						catch(CrimeException e) {
							System.out.println(e.getMessage());
						}
						break;
					case 5: 
						System.out.println("Enter the criminal name");
						String cname = sc.nextLine();
						System.out.println("Enter the crime Id");
						int ncrimeId = Integer.parseInt(sc.nextLine());
						try {
							int x = crimeDao1.assignCrimeToCriminal(cname, ncrimeId);
							if(x>0)
								System.out.println("Criminal Assigned to the crime succesfully.");
						} catch (CrimeException e) {
							System.out.println(e.getMessage());
						}
						break;
					case 6:
						System.out.println("Enter the victim name");
						String vvname = sc.nextLine();
						System.out.println("Enter the crime Id");
						int vvcrimeId = Integer.parseInt(sc.nextLine());
						try {
							int xx = crimeDao1.assignCrimeToVictim(vvname, vvcrimeId);
							if(xx>0)
								System.out.println("Victim assigned to the crime succesfully. ");
						}
						catch(CrimeException e) {
							System.out.println(e.getMessage());
						}
						break;
					case 7:
						insertFlag=false;
						break;
					default:
						insertFlag=false;
						break;
					}
					
				}
				break;

			case 2:
				boolean flag = true;
				int choice =0;
				
				CrimeDAO crimeDao = new CrimeDAOImplementation();
				CriminalDAO criminalDao = new CriminalDAOImplementation();
				VictimDAO victimDao = new VictimDAOImplementation();
				while(flag) {
					System.out.println("1. Get all Crimes");
					System.out.println("2. Get all Crimes registered under particular Police station");
					System.out.println("3. Get all Crimes for a particular Criminal");
					System.out.println("4. Get all Criminals for a particular Crime");
					System.out.println("5. Get all Victims for a particular Crime");
					System.out.println("6. Get list of all Solved or Unsolved Crimes");
					System.out.println("7. Get list of all crimes recorded in the current month");
					System.out.println("8. Exit");
					choice = Integer.parseInt(sc.nextLine());
					switch (choice) {
					case 1:
						try {
							List<CrimeDTO> crimes = crimeDao.getAllCrimes();
							crimes.forEach(crime->{
								System.out.println("Date of Crime.: "+crime.getDateofCrime());
								System.out.println("Description.: "+crime.getDescription());
								System.out.println("Detail Description.: "+crime.getDetailDesc());
								System.out.println("Status.: "+crime.getStatus());
								System.out.println("Police Station at which crime registered.: "+crime.getPoliceStationName());
								System.out.println("====================");
							});
						} catch (CrimeException e) {
							// TODO Auto-generated catch block
							System.out.println(e.getMessage());
						}
						break;

					case 2:
						System.out.println("Enter Police Station Name");
						String psName = sc.nextLine();
						
						try {
							List<CrimeInAPoliceStationDTO> crimes = crimeDao.getAllCrimesForAPoliceStation(psName);
							System.out.println("Police Station Name.: "+crimes.get(0).getPoliceStationName());
							crimes.forEach(crime->{
								System.out.println("Date of Crime.: "+crime.getDateOfCrime());
								System.out.println("Description.: "+crime.getDesc());
								System.out.println("Detail Description.: "+crime.getDetailDesc());
								System.out.println("Status.: "+crime.getStatus());
								System.out.println("===================");
							});
						}catch(CrimeException e) {
							System.out.println(e.getMessage());
						}
						break;
					
					case 3:
						System.out.println("Enter the Criminal Name");
						String criminalName = sc.nextLine();
						
						try {
							List<CrimesOfCriminalDTO> crimes =  crimeDao.getCrimesOfACriminal(criminalName);
							System.out.println("Criminal Name.: "+crimes.get(0).getCriminalName());
							crimes.forEach(crime->{
								System.out.println("Date of Crime.: "+crime.getDateOfCrime());
								System.out.println("Description.: "+crime.getDescription());
								System.out.println("Detail Description.: "+crime.getDetailDescription());
								System.out.println("Status.: "+crime.getStatus());
								System.out.println("===========================");
							});
						}
						catch(CrimeException e) {
							System.out.println(e.getMessage());
						}
						break;
						
					case 4:
						System.out.println("Enter the Crime Id");
						int crimeId = Integer.parseInt(sc.nextLine());
						
						try {
							List<CriminalsOfCrimeDTO> criminals = criminalDao.getCriminalsForCrime(crimeId);
							System.out.println("Crime Description. "+criminals.get(0).getDescription());
							criminals.forEach(criminal->{
								System.out.println("Criminal Name.: "+criminal.getCriminalName());
								System.out.println("Criminal Age.: "+criminal.getAge());
								System.out.println("Criminal Gender.: "+criminal.getGender());
								System.out.println("Criminal Address.: "+criminal.getAddress());
								System.out.println("Identifying mark.: "+criminal.getMark());
								System.out.println("=======================");
							});
						}catch(CriminalException e) {
							System.out.println(e.getMessage());
						}
						
						break;
					
					case 5:
						System.out.println("Enter the Crime Id");
						int crimeId2 = Integer.parseInt(sc.nextLine());
						
						try {
							List<VictimsOfCrimeDTO> victims = victimDao.getVictimsOfCrime(crimeId2);
							System.out.println("Crime Description.: "+victims.get(0).getDescription());
							victims.forEach(victim->{
								System.out.println("Victim Name.: "+victim.getName());
								System.out.println("Victim Age.: "+victim.getAge());
								System.out.println("Victim Gender.: "+victim.getGender());
								System.out.println("Victim Address.: "+victim.getAddress());
								System.out.println("===================");
							});
						}
						catch(VictimException e) {
							System.out.println(e.getMessage());
						}
						
						break;
						
					case 6:
						
						System.out.println("Enter the status of the crime(SOLVED/UNSOLVED)");
						String status = sc.nextLine();
						
						try {
							List<CrimeDTO> crimes =  crimeDao.getAllCrimesOnStatus(status);
							System.out.println("Total number of "+status+" crimes.: "+crimes.size());
							crimes.forEach(crime->{
								System.out.println("Date of Crime.: "+crime.getDateofCrime());
								System.out.println("Description.: "+crime.getDescription());
								System.out.println("Detail description.: "+crime.getDetailDesc());
								System.out.println("Police Station at which crime registered.: "+crime.getPoliceStationName());
								System.out.println("Status.: "+crime.getStatus());
								System.out.println("===================");
							});
						}
						catch(CrimeException e) {
							System.out.println(e.getMessage());
						}
						break;
						
					
					case 7:
						
						try {
							List<CrimeDTO> crimes = crimeDao.getAllCrimesForCurrentMonth();
							System.out.println("All crimes for the current month");
							crimes.forEach(crime->{
								System.out.println("Date of Crime.: "+crime.getDateofCrime());
								System.out.println("Description.: "+crime.getDescription());
								System.out.println("Detail Description.: "+crime.getDetailDesc());
								System.out.println("Police station at which crime registered.: "+crime.getPoliceStationName());
								System.out.println("===================");
							});
						}
						catch(CrimeException e) {
							System.out.println(e.getMessage());
						}
						
						
						break;
						
					case 8:
						
						flag = false;
						
					break;
			
					default:
						flag = false;
						break;
					}
				}
				break;
			
				
			case 3:
				mainFlag=false;
				break;

			default:
				mainFlag = false;
				break;
			}
		}
		
		
		
	}

}

























