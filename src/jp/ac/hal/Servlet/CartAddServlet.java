package jp.ac.hal.Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.ac.hal.Beans.Cart;
import jp.ac.hal.Beans.Product;
import jp.ac.hal.Cmn.CmnFnc;
import jp.ac.hal.Cmn.CmnVal;

/**
 * Servlet implementation class CartAddServlet
 */
@WebServlet("/CartAddServlet")
public class CartAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
<<<<<<< HEAD
		HttpSession session = request.getSession();
		String product_id = request.getParameter("product_id");
		request.setAttribute("product_id",product_id);
		Cart cart = CmnFnc.getSessionCart(request);
=======
		
		Cart cart = CmnFnc.getSessionCart(request);	
>>>>>>> 85d75586b7f24eed90ff1812965d9e131b86a10e
		Product product = CmnFnc.getProduct(request);
		int status = 0;
		if(product != null){
			cart.addCart(product);
		}else{
			status = CmnVal.errCodeCartFalse;
		}
		CmnFnc.cmnForward(response, request, status, CmnVal.MessegeURL);
	}
}
