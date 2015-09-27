package jp.ac.hal.Cmn;

import java.io.IOException;
import java.rmi.ServerException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.ac.hal.Beans.Cart;
import jp.ac.hal.Beans.Product;

/**
 * 共通の関数
 * @author kazu
 *
 */
public class CmnFnc {
	
	//　====================================	
	//　エラーチェック系共通処理
	//　====================================	
	public static boolean isPrmErr(String str) {
		return str == null || str.isEmpty();
	}

	public static boolean isPrmErr(int num) {
		return num == 0 ;
	}
	
	public static boolean isForward(int statusCode) {
		return statusCode < CmnVal.errCode;
	}

	
	//　====================================	
	//　セッション系共通処理
	//　====================================
	public static String getStrFromSession(HttpServletRequest request ,String str) {
		HttpSession session = request.getSession(true);
		return (String)session.getAttribute(str);
	}
	
	public static Product getProduct(HttpServletRequest request) {
		return (Product)request.getAttribute(CmnVal.FormValProduct);
	}
	
	public static Cart getSessionCart(HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		Cart cart = (Cart)session.getAttribute(CmnVal.SessionValCart);
		if(cart == null){
			cart = new Cart();
		}
		return cart;
	}
	
	public static void setStrFromSession(HttpServletRequest request ,String name , String value) {
		HttpSession session = request.getSession(true);
		session.setAttribute(name, value);
	}
	
	public static void deleteAllSession(HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		session.removeAttribute(CmnVal.FormValMail);
		session.removeAttribute(CmnVal.FormValId);
		session.removeAttribute(CmnVal.FormValName);
	}
	

	//　====================================	
	//　エラーメッセージ系共通処理
	//　====================================
	
	//エラー番号によってメッセージを返すメソッド
	public static String errMsg(int errNum) {
		HashMap<Integer,String> mapErrMsg = new HashMap<>();
		mapErrMsg.put(CmnVal.errCode, CmnVal.errMsg);
		mapErrMsg.put(CmnVal.errCodeLoginFalse, CmnVal.errMsgLoginFalse);
		mapErrMsg.put(CmnVal.errCodeLoginNullMail, CmnVal.errMsgLoginNullMail);
		mapErrMsg.put(CmnVal.errCodeLoginNullId, CmnVal.errMsgLoginNullId);
		mapErrMsg.put(CmnVal.errCodeLoginNullPass, CmnVal.errMsgLoginNullPass);
		mapErrMsg.put(CmnVal.errCodeAccsessFalse, CmnVal.errMsgAccsessFalse);
		mapErrMsg.put(CmnVal.errCodeCartFalse, CmnVal.errMsgCartFalse);
		mapErrMsg.put(CmnVal.errCodeCartDel, CmnVal.errMsgCartDel);

		return mapErrMsg.get(errNum);
	}

	//　====================================	
	//　遷移・ログイン・ログアウト系共通処理
	//　====================================
	public static void cmnForward(HttpServletResponse response ,HttpServletRequest request,int status,String URL) throws IOException,ServletException{
		if(isForward(status)){//エラー無し
			response.sendRedirect(URL);
		}else{//エラーあり
			//Messageをセット
			request.setAttribute(CmnVal.attributeMass,errMsg(status));
			//ディスパッチオブジェクト作成
			RequestDispatcher rd = request.getRequestDispatcher(CmnVal.errURL);
			//リクエストを転送
			rd.forward(request,response);
		}
	}
	
	public static void cmnLogOut(HttpServletRequest request,HttpServletResponse response) throws IOException{
		deleteAllSession(request);
		response.sendRedirect(CmnVal.TopURL);
	}
	
	

//	private static void createCookie(HttpServletResponse response,String name,Object value) {
//		//cookieの保存
//		Cookie cookie = new Cookie(name,value);		
//		//クッキーの有効時間設定(有効期間1週間)
//		cookie.setMaxAge(7*24*60*60);//Cookieオブジェクトの有効時間設定
//		//クッキーをクライアントに作成する
//		response.addCookie(cookie);//optionCookieオブジェクトのクッキーをクライアントに作成
//	}
	
}
