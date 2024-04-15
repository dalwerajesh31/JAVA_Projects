package emloyeeManagementSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DaoEmployeeLayer {

	public static void create(Employee emp) {
		
		Connection connection = DoConnection.connect();
		
		String query = QueryClass.getCreate();
		
		try {
			PreparedStatement pstm = connection.prepareStatement(query);
			
			pstm.setInt(1, emp.getEid());
			pstm.setString(2, emp.getEname());
			pstm.setString(3, emp.getDept());
			pstm.setDouble(4, emp.getSalary());

			pstm.execute();
			
			System.out.println("Employee details added successfully as follows : \n" + emp);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public static List<Employee> listAllEmployee() {
		
		List<Employee> empList = new ArrayList<>();		
		
	try(	Connection connection = DoConnection.connect();
			Statement stm = connection.createStatement();
			ResultSet rst =  stm.executeQuery(QueryClass.getRead());	) {
			
			while(rst.next()) {
				empList.add(new Employee(rst.getInt(1), rst.getString(2), rst.getString(3), rst.getDouble(4)));
			}			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return empList;
	}

	public static void updateEmp(String name, double newSalary) {

		try {
		    Connection connection = DoConnection.connect();
		    PreparedStatement psts = connection.prepareStatement(QueryClass.getUpdate());
		    
		    psts.setDouble(1, newSalary);
		    psts.setString(2, name);
		    
		     if(psts.executeUpdate() > 0)		    
		    System.out.println("Employee Updated Successfully ....  " );
		    
		    psts.close(); // Close PreparedStatement
		    connection.close(); // Close Connection
		    
		} catch (SQLException e) {
		    e.printStackTrace(); // Print stack trace for debugging
		    // Handle specific SQLExceptions here if needed
		} catch (Exception e) {
		    e.printStackTrace(); // Print stack trace for debugging
		    // Handle other exceptions here if needed
		}
		
	}

	public static void deleteEmp(int eid) {
		
		
		
		try( Connection connection = DoConnection.connect();
			 PreparedStatement pstm = connection.prepareStatement(QueryClass.getDelete());
				) {
				pstm.setInt(1, eid);
				if(pstm.executeUpdate() > 0) {
					System.out.println("Employee details deleted successfully...");
				}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
