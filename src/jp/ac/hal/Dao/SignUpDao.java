package jp.ac.hal.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.NamingException;

import jp.ac.hal.Beans.User;

public class SignUpDao extends Dao{

	public SignUpDao() throws ClassNotFoundException, NamingException {
		super();
		// TODO 自動生成されたコンストラクター・スタブ
	}

	
	public boolean regist(ArrayList<Object> user) {

		ArrayList<Object> list = new ArrayList<Object>();
		Connection conn = null;
		PreparedStatement ps = null;
		int rows = 0;
		//重複検索
		//取り出し
		try {

			conn = getConnection();
			ps = conn.prepareStatement("select user_name from company_table");
			
			//SQLを実行し結果セットを取得
			ResultSet rs = ps.executeQuery();
			//結果セットからデータを取り出す
			while(rs.next()){
				//リストに追加
				list.add(rs.getString("user_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		//エラー検知
		for(int i=0;i < list.size();i++){
			if(list.get(i).equals(user.get(0))){
				rows = -1;
			}
		}
		

		//insert処理
		if(rows == 0){
			//SQL文
			String sql = "insert into company_table(user_id,user_name,user_pass,com_name,"
					+ "com_department,user_tel,user_fax,user_address) values(atinseq.NEXTVAL,?,?,?,?,?,?,?)";
			try {
				ps = conn.prepareStatement(sql);
				for (int i = 0; i < user.size(); i++) {
					ps.setObject(i+1, user.get(i));
				}
				rows=ps.executeUpdate();
			}
			catch (SQLException e) {
				e.printStackTrace();
			}
//			ExcuteSql(sql,user);
			close(null,ps,conn);
			
			if(rows > 0){
				return false;
			}
			else{
				return true;
			}
		}
		else
		
		return true;
		}
}
