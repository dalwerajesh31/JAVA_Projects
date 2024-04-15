package emloyeeManagementSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DoConnection {

	public static Connection connect() {
		
		 String url = "jdbc:mysql://localhost:3306/jdbcoperations";
		 String username = "root";
		 String password = "843084";
		 Connection connection = null;
		 
		 try {
			 connection = DriverManager.getConnection(url, username, password);
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return connection;
	}

}
