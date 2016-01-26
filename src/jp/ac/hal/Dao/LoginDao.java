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
		// TODO 自動生成されたコンストラクター・スタブ
	}

	public ArrayList<User> loginSQL(String user_name, String user_pass) {

		ArrayList<User> list = new ArrayList<User>();
		Connection conn = null;
		
		conn = getConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from company_table where user_name = ? AND user_pass = ?");

				ps.setString(1,user_name);
				ps.setString(2,user_pass);
			ResultSet rs = ps.executeQuery();
			//結果セットからデータを取り出す
			while(rs.next()){
				//リストに追加
				list.add(new User(rs.getInt("user_id"), rs.getString("user_name"), rs.getString("user_pass")
						, rs.getString("com_name"), rs.getString("com_department"), rs.getInt("employee_id")
						, rs.getInt("user_tel"), rs.getInt("user_fax"), rs.getString("user_address")
						, rs.getInt("user_bank"), rs.getString("end_day"), rs.getInt("credit_limit")));
			}
			
			close(null,ps,conn);
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

}
