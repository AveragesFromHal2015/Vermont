package jp.ac.hal.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.NamingException;

public class LoginDao extends Dao {

	private Connection conn = null;
	private PreparedStatement ps = null;
	private ResultSet rs = null;

	public LoginDao() throws ClassNotFoundException, NamingException {
		super();
	}

<<<<<<< HEAD
	public boolean loginSQL(String user_name, String user_pass) {

		String name = null;
		Connection conn = null;

		conn = getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("select user_name from company_table where user_name = ? AND user_pass = ?");

				ps.setString(1,user_name);
				ps.setString(2,user_pass);
			ResultSet rs = ps.executeQuery();
			//結果セットからデータを取り出す
			while(rs.next()){
				name = rs.getString("user_name");
			}
			
			close(null,ps,conn);
		}
		catch (SQLException e) {
=======
	// ログイン処理
	public int loginSQL(String mail_address, String user_pass) {
		int i = 0;

		String sql = "select count(*) from company_table where mailaddress = ? and password = ?";

		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql);

			ps.setString(1, mail_address);
			ps.setString(2, user_pass);

			rs = ps.executeQuery();

			i = rs.getInt("count(*)");

		} catch (SQLException e) {
>>>>>>> 1d7c38ce0c0e9725edeb0d470e175163ac6cacba
			e.printStackTrace();
		} finally {
			close(rs, ps, conn);
		}
<<<<<<< HEAD
		if(name != null){
			return true;
		} else{
			return false;
		}
=======
		return i;
>>>>>>> 1d7c38ce0c0e9725edeb0d470e175163ac6cacba
	}
}
