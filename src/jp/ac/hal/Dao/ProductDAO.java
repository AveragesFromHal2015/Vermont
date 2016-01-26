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

public class ProductDAO {
	/** 接続先サーバ名 */
	private String serverName;
	/** 接続先インスタンス名 */
	private String instanceName;
	/** 接続先ユーザ名 */
	private String userName;
	/** 接続先パスワード */
	private String password;

	private ProductDAO() {

	}

	private static ProductDAO instance;

	public static ProductDAO getInstance() {
		if (instance == null) {
			instance = new ProductDAO();
		}
		return instance;
	}

	/**
	 * コンストラクタ
	 * (newしたときに呼ばれる処理)
	 * @throws ClassNotFoundException
	 */
	public ProductDAO(String serverName, String instanceName, String userName, String password)
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
	public ArrayList<Product> select() {
		// Userオブジェクトを入れるリスト
		ArrayList<Product> list = new ArrayList<Product>();

		try (
				// 接続クラスの取得
				Connection con = getConnection();
				// SQL実行クラスの取得
				PreparedStatement ps = con.prepareStatement(
						"select * from product_table");) {

			// SQLを実行し結果セットを取得
			ResultSet rs = ps.executeQuery();

			// 結果セットからデータを取り出す
			while (rs.next()) {
				int productid = rs.getInt("product_id");
				String productname = rs.getString("product_name");
				int price = rs.getInt("price");
				int orderpoint = rs.getInt("order_point");
				String orderdate = rs.getString("order_date");
				int orderamount = rs.getInt("order_amount");
				int stock = rs.getInt("stock");
				String registration = rs.getString("registration");
				int category = rs.getInt("category_id");
				int maker = rs.getInt("maker_id");
				String description = rs.getString("description");
				// リストに追加
				list.add(new Product(productid, productname, price, orderpoint, orderdate, orderamount, stock,
						registration, category, maker, description));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	public ArrayList<Product> Detail(int productid2) {
		// Userオブジェクトを入れるリスト
		ArrayList<Product> list = new ArrayList<Product>();

		try (
				// 接続クラスの取得
				Connection con = getConnection();
				// SQL実行クラスの取得
				PreparedStatement ps = con.prepareStatement(
						"select P_t.product_id,P_t.product_name,P_t.price,P_t.stock,C_t.category " +
						"from product_table P_t,category_table C_t " +
						"where P_t.product_id = ? AND P_t.category_id = C_t.category_id");) {

			// SQLを実行し結果セットを取得

			ps.setInt(1, productid2);

			ResultSet rs = ps.executeQuery();

			// 結果セットからデータを取り出す
			while (rs.next()) {
				int productid = rs.getInt("product_id");
				String productname = rs.getString("product_name");
				int price = rs.getInt("price");
				//int orderpoint = rs.getInt("order_point");
				//String orderdate = rs.getString("order_date");
				//int orderamount = rs.getInt("order_amount");
				int stock = rs.getInt("stock");
				//String registration = rs.getString("registration");
				//int categoryid = rs.getInt("category_id");
				//int maker = rs.getInt("maker_id");
				//String description = rs.getString("description");
				String categoryname = rs.getString("category");
				// リストに追加
				//list.add(new Product(productid, productname, price, orderpoint, orderdate, orderamount, stock,
				//		registration, categoryid, maker, description, categoryname));
				list.add(new Product(productid, productname, price, stock, categoryname));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}
}