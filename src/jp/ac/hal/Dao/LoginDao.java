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

	public int loginSQL(String user_name, String user_pass) {

		int id = -1;
		Connection conn = null;

		conn = getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("select user_id from company_table where user_name = ? AND user_pass = ?");

				ps.setString(1,user_name);
				ps.setString(2,user_pass);
			ResultSet rs = ps.executeQuery();
			//結果セットからデータを取り出す
			while(rs.next()){
				id = rs.getInt("user_id");
			}
			
			close(null,ps,conn);
		}
		catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs, ps, conn);
		}
		if(id > -1){
			return id;
		} else{
			return -1;
		}
	}
}
