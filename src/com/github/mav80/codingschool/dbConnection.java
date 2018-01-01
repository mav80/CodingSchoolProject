package com.github.mav80.codingschool;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConnection {
	
	Connection dbConnection = null;
	
	
	//metoda na nawiązanie połączenia
	public Connection getConnection() {
		try {
			this.dbConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/CodingSchool?useSSL=false&characterEncoding=utf-8",
					"root",
					"coderslab"
					);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return this.dbConnection;
	}
	
	
	
	//metoda na zamknięcie polączenia
	public void closeConnection() {
		if(this.dbConnection != null) {
			try {
				this.dbConnection.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	

}
