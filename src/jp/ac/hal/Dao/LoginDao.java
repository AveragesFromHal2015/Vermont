package jp.ac.hal.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;

import jp.ac.hal.Beans.User;

public class LoginDao extends Dao{

	public LoginDao() throws ClassNotFoundException, NamingException {
		super();
	}

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
			e.printStackTrace();
		}
		if(name != null){
			return true;
		} else{
			return false;
		}
	}

}
