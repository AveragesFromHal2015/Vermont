package jp.ac.hal.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class Dao{

public class Dao {
	private String serverName;
	private String instanceName;
	private String userName;
	private String password;	
	private static Dao instance;
	private DataSource ds;

	protected Dao() throws ClassNotFoundException{
		this.serverName = "tstdsv03";
		this.instanceName = "orcl1";
		this.userName = "ora131";
		this.password = "ora131";
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
	}

	static public Dao getInstance() throws ClassNotFoundException{
		if(instance == null){
			instance = new Dao();
		}
		return instance;
	}

	protected Connection getConnection(){
		Connection conn=null;
		try {
			conn = DriverManager.getConnection("jdbc:oracle:thin:@"+ serverName + ":1521:"+instanceName,userName,password);
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
	
	protected void close(ResultSet rs, PreparedStatement ps, Connection conn) {
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
