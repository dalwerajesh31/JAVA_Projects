package emloyeeManagementSystem;

public class Employee {
	
			private int eid;
			private String ename;
			private String dept;
			@Override
			public String toString() {
				return "Employee [\n eid=" + eid + ", \n ename=" + ename + ", \n dept=" + dept + ", \n salary=" + salary + "\n]";
			}

			private double salary;
			
		public Employee(int eid2, String ename2, String dept2, double salary2) {
			eid = eid2;
			ename = ename2;
			dept = dept2;
			salary = salary2;
		}
		
		public int getEid() {
				return eid;
			}

			public String getEname() {
				return ename;
			}

			public String getDept() {
				return dept;
			}

			public double getSalary() {
				return salary;
			}

		
		
}
