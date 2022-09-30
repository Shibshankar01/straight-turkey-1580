package com.CIMS.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionClass {
	
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/sb101proj", "root", "8369766605");
	}
}
