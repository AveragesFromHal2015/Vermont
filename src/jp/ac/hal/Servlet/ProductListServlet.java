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
		//ページ数
		int pageNo = 0;
		//全件数
		int pageDisp = 0;
		try {
			ArrayList<Product> list = new ArrayList<Product>();
			try (
					// Oracleコネクション
					Connection conn = getConnection();
					// SQLクラス(全件データ取得)
					PreparedStatement ps1 = conn.prepareStatement("select * from product_table ORDER BY product_id");
					// SQLを実行し結果をセット
					ResultSet rs1 = ps1.executeQuery();
					//SQLクラス(件数取得)
					PreparedStatement ps2 = conn.prepareStatement("select count(*) from product_table order by product_id");
					//SQL実行結果をセット
					ResultSet rs2 = ps2.executeQuery();
				){
					//全件数取得
					if(rs2.next()){
						pageDisp = rs2.getInt("count(*)");
						//全件から表示件数で割ってページ数を求める
						for (pageDisp.size() ; pageDisp>=-30; 30--){
							pageNo++;
						}
					}
					// 結果セットからデータを取り出す
					while (rs1.next()) {
						productid = rs1.getInt("product_id");
						productname = rs1.getString("product_name");
						price = rs1.getInt("price");
						stock = rs1.getInt("stock");
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
