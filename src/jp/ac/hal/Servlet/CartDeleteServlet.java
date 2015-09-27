package jp.ac.hal.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.ac.hal.Beans.Cart;
import jp.ac.hal.Beans.Product;
import jp.ac.hal.Cmn.CmnFnc;
import jp.ac.hal.Cmn.CmnVal;

/**
 * Servlet implementation class CartDeleteServlet
 */
@WebServlet("/CartDeleteServlet")
public class CartDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cart cart = CmnFnc.getSessionCart(request);
		Product product = CmnFnc.getProduct(request);		
		int status = 0;
		
		if(product != null){
			cart.deleteProduct(product);
		}else{
			status = CmnVal.errCodeCartDel;
		}
		
		CmnFnc.cmnForward(response, request, status, CmnVal.MessegeURL);
	}

}
