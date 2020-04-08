package it.polito.tdp.anagrammi.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDB {

	static private final String jdbcURL= "jdbc:mysql://localhost/dizionario?user=root&password=********";
	
	public static Connection getConnection() {
		
		try {
			Connection connection = DriverManager.getConnection(jdbcURL);
			return connection;					
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Cannot get a connection " + jdbcURL, e);
		}
	}
}
