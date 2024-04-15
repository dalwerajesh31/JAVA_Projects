package MyCrudOperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class StudentEntity {
	
	public void createDatabase() {
//		load driver  --> (need not to do in latest version)		
		
		String url = "jdbc:mysql://localhost:3306/";
		String username = "root";
		String password = "843084";
		String query1 = "create database jdbcOperations;";
		
		try {
				//	create connection
			Connection connection = DriverManager.getConnection(url, username, password);
		
				//	prepare statement			
			Statement stm = connection.createStatement();
			
				//	execute statement
			stm.execute(query1);
			
			System.out.println("Connection established Successfully.");
			//	close connection
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}

	public void createTable() {
		
		String url = "jdbc:mysql://localhost:3306/jdbcOperations";
		String username = "root";
		String password = "843084";
		String query = "create table studentDetails (sid int(3), sname varchar(20), email varchar(50));";
		
		try {
			Connection connection = DriverManager.getConnection(url, username, password);
			Statement stm = connection.createStatement();
			stm.execute(query);
			System.out.println("Table created successfully.");
			connection.close();
		} 
		
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void addStudent() {
		
		String url = "jdbc:mysql://localhost:3306/jdbcoperations";
		String username = "root";
		String password = "843084";
		String query = "insert into studentDetails (sid, sname, email) values (?,?,?)";
		
		Connection connection;
		try {
			connection = DriverManager.getConnection(url, username, password);
			
			PreparedStatement pstm = connection.prepareStatement(query);
			
			pstm.setInt(1, 21);
			pstm.setString(2, "JobLaglaRe");
			pstm.setString(3, "JobLaglaRe@gmail.com");
			
			 int record = pstm.executeUpdate();
			
			System.out.println("Number of records inserted in the table is " + record);
			
			connection.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
}
