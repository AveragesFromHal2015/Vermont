package jp.ac.hal.Beans;

public class Admin {
	//社員ID、社員名、役職、部署、パスワード
	private int employee_id;
	private String employee_name;
	private String position;
	private String emp_department;
	private String pass;
	/**
	 * @param employee_id
	 * @param employee_name
	 * @param position
	 * @param emp_department
	 * @param pass
	 */
	public Admin(int employee_id, String employee_name, String position,
			String emp_department, String pass) {
		super();
		this.employee_id = employee_id;
		this.employee_name = employee_name;
		this.position = position;
		this.emp_department = emp_department;
		this.pass = pass;
	}
	public int getEmployee_id() {
		return employee_id;
	}
	public String getEmployee_name() {
		return employee_name;
	}
	public String getPosition() {
		return position;
	}
	public String getEmp_department() {
		return emp_department;
	}
	public String getPass() {
		return pass;
	}
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}
	public void setPosition(String position) {
		this.position = position;
	}
	public void setEmp_department(String emp_department) {
		this.emp_department = emp_department;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
}
