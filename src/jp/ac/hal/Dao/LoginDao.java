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
			e.printStackTrace();
		} finally {
			close(rs, ps, conn);
		}
		return i;
	}
}
