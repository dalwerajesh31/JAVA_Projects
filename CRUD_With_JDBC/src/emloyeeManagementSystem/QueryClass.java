package emloyeeManagementSystem;



public class QueryClass {

	private static String create = "insert into Employee (eid, ename, dept, salary) values (?,?,?,?)";
	private static String read = "select * from employee;";
	private static String readByName = "select * from employee where ename = ?";
	private static String update = " update employee set salary = ? where ename = ?";
	private static String delete = "delete from employee where eid = ?";
	
	public static String getDelete() {
		return delete;
	}

	public static String getReadByName() {
		return readByName;
	}

	public static String getUpdate() {
		return update;
	}

	public static String getRead() {
		return read;
	}

	public static String getCreate() {
		return create;
	}

}
