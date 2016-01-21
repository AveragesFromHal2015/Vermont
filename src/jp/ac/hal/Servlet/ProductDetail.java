package jp.ac.hal.Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.ac.hal.Beans.Product;
import jp.ac.hal.Dao.ProductDAO;

/**
 * Servlet implementation class ProductDetail
 */
@WebServlet("/ProductDetail")
public class ProductDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub


		ArrayList<Product> list = new ArrayList<Product>();
		String productid = request.getParameter("Productid");
		System.out.println("プロダクトID" + productid);
		int Productid2 = Integer.parseInt(productid);
		try{
			ProductDAO dao = new ProductDAO("tstdsv03","orcl1","ora131","ora131");
			list = dao.Detail(Productid2);
			request.setAttribute("list", list);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
		//products.jspへフォワード
		request.getRequestDispatcher("/WEB-INF/products_detail.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
