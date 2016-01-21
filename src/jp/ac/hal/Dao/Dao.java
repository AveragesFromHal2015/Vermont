package jp.ac.hal.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
public class Dao{
	
	private static Dao instance;
	private DataSource ds;

	private Dao() throws NamingException{
		Context context = new InitialContext();
		ds = (DataSource)context.lookup("java:comp/env/Oracle_JDBC");
	}

	static public Dao getInstance() throws NamingException{
		if(instance == null){
			instance = new Dao();
		}
		return instance;
	}

	private Connection getConnection(){
		Connection conn=null;
		try {
			conn = ds.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	public int ExcuteSql(String sql,Object...obj){
		Connection conn = getConnection();
		PreparedStatement ps=null;
		int rows=0;
		try {
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < obj.length; i++) {
				ps.setObject(i+1, obj[i]);
			}
			rows=ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(null,ps,conn);
		return rows;	
	}
	
	private void close(ResultSet rs, PreparedStatement ps, Connection conn) {
		if(rs!=null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				if(ps!=null){
					try {
						ps.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}finally{
						if(conn!=null){
							try {
								conn.close();
							} catch (SQLException e) {
								e.printStackTrace();
							}
						}
					}
				}
			}
		}
	}

}