package src.jp.ac.hal.Servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import src.jp.ac.hal.Dao.Dao;
import src.jp.ac.hal.Beans.Product;

/**
 * Servlet implementation class ProductListServlet
 */
@WebServlet("/ProductListServlet")
public class ProductListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//商品ID
		int productid = 0;
		//商品名
		String productname = "";
		//価格
		int price = 0;
		//在庫数
		int stock = 0;
		try {
			ArrayList<Product> list = new ArrayList<Product>();
			try (
					// Oracleコネクション
					Connection conn = getConnection();
					// SQLクラスの取得
					PreparedStatement ps = conn.prepareStatement("select * from product_table ORDER BY product_id");
					// SQLを実行し結果をセット
					ResultSet rs = ps.executeQuery();
				){
					// 結果セットからデータを取り出す
					while (rs.next()) {
						productid = rs.getInt("product_id");
						productname = rs.getString("product_name");
						price = rs.getInt("price");
						stock = rs.getInt("stock");
						//リストに追加
						list.add(new Product(productid,productname,price,stock));
						request.setAttribute("productlist", list);
						//request.getRequestDispatcher("result.jsp").forward(request, response);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				return;
			} catch (ClassNotFoundException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			
			
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
