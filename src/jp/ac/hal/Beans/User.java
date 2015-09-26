package jp.ac.hal.Beans;

public class User {
	private int userid;
	private String user_name;
	private String user_pass; //パスワード
	private String com_name; //会社名
	private String com_department; //部署名
	private int employee_id; //社員番号
	private int user_tel;
	private int user_fax;
	private String user_address; //住所
	private int user_bank; //銀行No
	private String end_day; //締日
	private int credit_limit; //与信限度額
	
	public int getUserid() {
		return userid;
	}
	public String getUser_name() {
		return user_name;
	}
	public String getUser_pass() {
		return user_pass;
	}
	public String getCom_name() {
		return com_name;
	}
	public String getCom_department() {
		return com_department;
	}
	public int getEmployee_id() {
		return employee_id;
	}
	public int getUser_tel() {
		return user_tel;
	}
	public int getUser_fax() {
		return user_fax;
	}
	public String getUser_address() {
		return user_address;
	}
	public int getUser_bank() {
		return user_bank;
	}
	public String getEnd_day() {
		return end_day;
	}
	public int getCredit_limit() {
		return credit_limit;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public void setUser_pass(String user_pass) {
		this.user_pass = user_pass;
	}
	public void setCom_name(String com_name) {
		this.com_name = com_name;
	}
	public void setCom_department(String com_department) {
		this.com_department = com_department;
	}
	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	public void setUser_tel(int user_tel) {
		this.user_tel = user_tel;
	}
	public void setUser_fax(int user_fax) {
		this.user_fax = user_fax;
	}
	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}
	public void setUser_bank(int user_bank) {
		this.user_bank = user_bank;
	}
	public void setEnd_day(String end_day) {
		this.end_day = end_day;
	}
	public void setCredit_limit(int credit_limit) {
		this.credit_limit = credit_limit;
	}
	

}
