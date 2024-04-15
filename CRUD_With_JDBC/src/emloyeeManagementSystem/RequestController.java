package emloyeeManagementSystem;

import java.util.Scanner;

public class RequestController {

	public static void main(String[] args) {
		System.out.println("!!! Welcome to Employee Management App !!!\n Select following Options : ");
		System.out.println("1. Create Employee\n2. Read_All_Employe\n3. Update Employee\n4. Delete Employee\n0. To Exit");
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter your choice : ");		
		 int choice = sc.nextInt();
		
		 do {		
		
		switch (choice) {
				case 1: {
					System.out.println("To create Employee enter the following details : \n Eid, Ename, Department, Salary");
					int eid = sc.nextInt();
					sc.nextLine();
					String ename = sc.nextLine();
					String dept = sc.nextLine();
					double salary = sc.nextDouble();
					Employee emp = new Employee(eid, ename, dept, salary);
					DaoEmployeeLayer.create(emp);
				}
				break;
				
						// 2. Read_All_Employe
				case 2 : {
					System.out.println("Below is the list of all Employees : \n");
					DaoEmployeeLayer.listAllEmployee().forEach(emp -> System.out.println(emp+"\n"));;
				}
				break;
						// 3. Update Employee
				case 3 : {
					System.out.println("Enter the name of the employee whose salary is to update : ");
					sc.nextLine();
					String name = sc.nextLine();
					System.out.println("Enter new Salary of Emploee : ");
					double newSalary = sc.nextDouble();
					System.out.println("Name\t" + name + "\t"+newSalary);
					DaoEmployeeLayer.updateEmp(name, newSalary);
				}
				break;
						// 4. Delete Employee
				case 4:{
					System.out.println("!!!\t Alert : 'Delete Operation' \n Enter employee ID : ");
					int eid = sc.nextInt();
					DaoEmployeeLayer.deleteEmp(eid);
				}
				break;
				
				default:
					System.out.println("You have entered invalid choice..");
				}
				
				System.out.println("\n\nEnter your choice : ");		
				 choice = sc.nextInt();
				 
			}while(choice != 0);
		 
		 System.out.println("\n\n!!! Program Terminated Successfully... !!!");
	}
}
