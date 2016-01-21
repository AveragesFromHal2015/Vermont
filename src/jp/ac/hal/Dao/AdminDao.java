/**
 * @author okudera.tatsuya
 */
package jp.ac.hal.Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jp.ac.hal.Beans.Admin;
import jp.ac.hal.Beans.User;

public class AdminDao {
	//サーバ名
	private String serverName;
	//インスタンス名、DBユーザ名、DBパスワード
	private String instanceName;
	private String userName;
	private String password;
	/**
	 * @param serverName
	 * @param instanceName 
	 * @param userName
	 * @param password
	 */
	public AdminDao(String serverName,String instanceName,String userName,
			String password) {
		super();
		this.serverName = serverName;
		this.instanceName = instanceName;
		this.userName = userName;
		this.password = password;
		//ドライバクラスのロード
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			//ドライバのロードに失敗したときreturnを返す
			return;
		}	
	}
	/**
	 * 2015年11月 着手 2015年11月 完了
	 * コネクション作成
	 * @return
	 * @throws SQLException
	 */
	private Connection getConnection() throws SQLException{
		return DriverManager.getConnection("jdbc:oracle:thin:@"+ serverName +":1521:"+ instanceName,userName,password);
	}
	/**
	 * 2015年11月着手 2015年11月30日(月)完了
	 * ログイン処理
	 * @param admin
	 * @return
	 */
	public int login(Admin admin){
		int ret = 0;
		String sql = "SELECT count(*) FROM Employee_table where employee_id=? and password=?";
		try(
			//接続クラスの取得
			Connection con = getConnection();
		){
			//SQL実行クラスの取得
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, admin.getEmployee_id());
			ps.setString(2, admin.getPass());
			ResultSet rs = ps.executeQuery();
			
			rs.next();
			
			ret = rs.getInt("count(*)");
			
		}catch(SQLException e){
			e.printStackTrace();
		}
		return ret;
	}
	/**
	 * 2015年12月3日(木) 着手 2015年12月3日(木) 完了
	 * 法人アカウント一覧
	 * @param user
	 */
	public ArrayList<User> ComAccountList(){
		ArrayList<User> list = new ArrayList<User>();
		String sql = "select * from company_table";
		try(
			//接続クラスの取得
			Connection con = getConnection();
		){
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				//ユーザID,ユーザ名,パスワード
				//会社名,部署名
				//社員ID
				//電話番号,FAX,住所,銀行番号
				//締日,クレジット限度額			計12件
				int user_id = rs.getInt("user_id");
				String user_name = rs.getString("user_name");
				String user_pass = rs.getString("user_pass");
				String com_name = rs.getString("com_name"); 
				String com_department = rs.getString("com_department"); 
				int employee_id = rs.getInt("employee_id");
				int user_tel = rs.getInt("user_tel");
				int user_fax = rs.getInt("user_fax");
				String user_address = rs.getString("user_address");
				int user_bank = rs.getInt("user_bank");
				String end_day = rs.getString("end_day");
				int credit_limit = rs.getInt("credit_limit");
				
				list.add(new User(
						user_id,
						user_name,
						user_pass,
						com_name,
						com_department,
						employee_id,
						user_tel,
						user_fax,
						user_address,
						user_bank,
						end_day,
						credit_limit
						));
			}
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * 2015年12月3日(木)着手 2015年12月3日(木)完了
	 * 法人アカウント削除
	 * @param user
	 */
	public void ComAccountDelete(User user){
		String sql = "delete from company_table where user_id = ?";
		try(
			Connection con = this.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			){
			ps.setInt(1, user.getUserid());
			ps.executeUpdate();
			
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	/**
	 * 2015年12月8日(火)着手 2015年12月10日(木)完了
	 * 法人アカウント詳細(1件)
	 * @param user
	 * @return
	 */
	public ArrayList<User> ComAccountDetail(User user){
		ArrayList<User> list = new ArrayList<User>();
		String sql = "select * from company_table where user_id = ?";
		try(
				Connection con = this.getConnection();
				PreparedStatement ps = con.prepareStatement(sql);
		){
			ps.setInt(1, user.getUserid());
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				//ユーザID,ユーザ名,パスワード
				//会社名,部署名
				//社員ID
				//電話番号,FAX,住所,銀行番号
				//締日,クレジット限度額			計12件
				int user_id = rs.getInt("user_id");
				String user_name = rs.getString("user_name");
				String user_pass = rs.getString("user_pass");
				String com_name = rs.getString("com_name"); 
				String com_department = rs.getString("com_department"); 
				int employee_id = rs.getInt("employee_id");
				int user_tel = rs.getInt("user_tel");
				int user_fax = rs.getInt("user_fax");
				String user_address = rs.getString("user_address");
				int user_bank = rs.getInt("user_bank");
				String end_day = rs.getString("end_day");
				int credit_limit = rs.getInt("credit_limit");
				
				list.add(new User(
						user_id,
						user_name,
						user_pass,
						com_name,
						com_department,
						employee_id,
						user_tel,
						user_fax,
						user_address,
						user_bank,
						end_day,
						credit_limit
						));
			}
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		return list;
	}
	/**
	 * 2015年12月8日(火)着手 2015年12月10日(木)完了
	 * 法人アカウント編集
	 * @param user
	 */
	public void ComAccountEdit(User user){
		//1.ユーザ名,2.パスワード
		//3.会社名,4.部署名
		//5.電話番号,6.FAX,7.住所,8.銀行番号
		//9.締日,10.クレジット限度額
		//11.社員ID
		//12.ユーザID
		String sql = "update company_table set"
				+ " user_name = ?,"
				+ " user_pass = ?,"
				+ " com_name = ?,"
				+ " com_department = ?,"
				+ " user_tel = ?,"
				+ " user_fax = ?,"
				+ " user_address = ?,"
				+ " user_bank = ?,"
				+ " end_day = ?,"
				+ " credit_limit = ?,"
				+ " employee_id = ?"
				+ " where user_id = ?";
		try(
				Connection conn = this.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
		){
			ps.setString(1, user.getUser_name());
			ps.setString(2, user.getUser_pass());
			ps.setString(3, user.getCom_name());
			ps.setString(4, user.getCom_department());
			ps.setInt(5, user.getUser_tel());
			ps.setInt(6, user.getUser_fax());
			ps.setString(7, user.getUser_address());
			ps.setInt(8, user.getUser_bank());
			ps.setString(9, user.getEnd_day());
			ps.setInt(10, user.getCredit_limit());
			ps.setInt(11, user.getEmployee_id());
			ps.setInt(12, user.getUserid());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		
	}
}
