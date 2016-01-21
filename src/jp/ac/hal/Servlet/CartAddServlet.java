package jp.ac.hal.Servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.ac.hal.Beans.Product;
import jp.ac.hal.Dao.Dao;

/**
 * Servlet implementation class CartAddServlet
 */
@WebServlet("/CartAddServlet")
public class CartAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException,
			IOException {

		int product_id;

		product_id = Integer.parseInt(request.getParameter("productid"));
		request.setAttribute("product_id", product_id);

		//ログ取得
		final Logger logger = Logger.getLogger("Cart");

		//カート処理サーブレット
		//Daoオブジェクト生成
		Dao dao = new Dao();

		//ShohinDataBean ArrayList生成

		//Cart用 shohindata ArrayList生成
		ArrayList<Product> cart = new ArrayList<Product>();

		//セッションを取得
		HttpSession session = request.getSession();

		//転送ページ
		String disPage = "msg.jsp";

		//リクエストからカートに入れる商品ID取得
		String Product_Id = request.getParameter("product_id");

		//ログ表示
		logger.info("product_Id=" + Product_Id);

		//カート登録処理
		//登録ボタン cartAddを押下処理
		if (request.getParameter("cartAdd") != null) {

			//商品情報取得
			ArrayList<Product> ProductData = dao.getProductData(Product_Id);


				if (session.getAttribute("cart") != null) {
					//セッションから商品情報を取得(セッションにカートがあったら)
					cart = (ArrayList<Product>) session.getAttribute("cart");
				}
				//カートに商品情報を追加

				for (int i = 0; i < ProductData.length; i++) {
					cart.add(ProductData.get(i));
				}

				//セッションに商品情報を書き込む（セッション内のパラメータ名：cart）
				session.setAttribute("cart", cart);
				//商品一覧画面へ転送
				disPage = "msg.jsp";
			}
		}
	}
