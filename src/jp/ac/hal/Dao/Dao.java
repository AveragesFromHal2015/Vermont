package jp.ac.hal.Dao;

//データべース関連パッケージのインポート
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import jp.ac.hal.Beans.Product;

/**
 * データアクセスオブジェクトクラス(DAO)
 * @author hirairi
 *
 */

public class Dao {
	/** 接続先サーバ名 */
	private String serverName;
	/** 接続先インスタンス名 */
	private String instanceName;
	/** 接続先ユーザ名 */
	private String userName;
	/** 接続先パスワード */
	private String password;

	//エラープロパティ
	boolean err = false;
	//メッセージプロパティ
	String Msg = "";

	public Dao() {

	}

	private static Dao instance;


	public static Dao getInstance() {
		if (instance == null) {
			instance = new Dao();
		}
		return instance;
	}

	/**
	 * コンストラクタ
	 * (newしたときに呼ばれる処理)
	 * @throws ClassNotFoundException
	 */
	public Dao(String serverName, String instanceName, String userName, String password)
			throws ClassNotFoundException {
		this.serverName = serverName;
		this.instanceName = instanceName;
		this.userName = userName;
		this.password = password;

		// ドライバクラスのロード
		Class.forName("oracle.jdbc.driver.OracleDriver");
	}

	/**
	 * コネクションの取得
	 * @return コネクション
	 * @throws SQLException
	 */
	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:oracle:thin:@" + serverName + ":1521:" + instanceName, userName,
				password);
	}

	/**
	 * Employeesテーブルからデータを取得する
	 * @return Employeesオブジェクトのリスト
	 */
	public ArrayList<Product> getProductData(String Product_Id)
	{

		ArrayList<Product> ProductData = new ArrayList<Product>();

		//SQL
		String sql = "";

		if (Product_Id == null)
		{
			//全件取得
			sql = "select * from Products_table;";
		}
		else
		{
			//指定された商品IDの商品情報を取得
			sql = "select * from Products_table where product_id=" + Product_Id + ";";
		}

		try (
				// 接続クラスの取得
				Connection con = getConnection();
				// SQL実行クラスの取得
				PreparedStatement ps = con.prepareStatement(
						"select * from product_table");) {

			// SQLを実行し結果セットを取得
			ResultSet rs = ps.executeQuery();

			while (rs.next())
			{
				int productid = rs.getInt("product_id");
				String productname = rs.getString("product_name");
				int price = rs.getInt("price");
				ProductData.add(new Product(productid, productname, price));
			}

			//データが取得できているかチェック
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ProductData;
	}
}