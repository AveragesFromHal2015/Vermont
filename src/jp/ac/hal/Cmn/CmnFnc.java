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
	
	/**
	 * @param str
	 * @return strがnullまたは空欄ならtrue
	 */
	public static boolean isPrmErr(String str) {
		return str == null || str.isEmpty();
	}
	
	/**
	 * @param num
	 * @return 値が0ならtrue
	 */
	public static boolean isPrmErr(int num) {
		return num == 0 ;
	}
	
	/** エラー判定
	 * @param statusCode
	 * @return statusCodeが800より下ならtrue
	 */
	public static boolean isForward(int statusCode) {
		return statusCode < CmnVal.errCode;
	}

	
	//　====================================	
	//　セッション系共通処理
	//　====================================
	
	/**
	 * @param request
	 * @param str　受け取る値の名前
	 * @return 別Servletから送られてきた値
	 */
	public static String getStrFromSession(HttpServletRequest request ,String str) {
		HttpSession session = request.getSession(true);
		return (String)session.getAttribute(str);
	}
	
	/**
	 * @param request
	 * @return 別Servletから送られてきたProductの値
	 */
	public static Product getProduct(HttpServletRequest request) {
		return (Product)request.getAttribute(CmnVal.FormValProduct);
	}
	
	/**
	 * @param request
	 * @return セッションが無ければ作成あればセッションを作成
	 */
	public static Cart getSessionCart(HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		Cart cart = (Cart)session.getAttribute(CmnVal.SessionValCart);
		if(cart == null){
			cart = new Cart();
		}
		return cart;
	}
	
	/**
	 * @param request
	 * @param name セッションに入れる名前
	 * @param value セッションに入れる値
	 */
	public static void setStrFromSession(HttpServletRequest request ,String name , String value) {
		HttpSession session = request.getSession(true);
		session.setAttribute(name, value);
	}
	
	/**セッション削除
	 * @param request
	 */
	public static void deleteAllSession(HttpServletRequest request) {
		HttpSession session = request.getSession(true);
		session.removeAttribute(CmnVal.FormValMail);
		session.removeAttribute(CmnVal.FormValId);
		session.removeAttribute(CmnVal.FormValName);
	}
	

	//　====================================	
	//　エラーメッセージ系共通処理
	//　====================================
	
	
	/**
	 * @param errNum
	 * @return エラー番号によってメッセージを返す
	 */
	public static String errMsg(int errNum) {
		HashMap<Integer,String> mapErrMsg = new HashMap<>();
		mapErrMsg.put(CmnVal.errCodeLoginFalse, CmnVal.errMsgLoginFalse);
		mapErrMsg.put(CmnVal.errCodeLoginNullMail, CmnVal.errMsgLoginNullMail);
		mapErrMsg.put(CmnVal.errCodeLoginNullId, CmnVal.errMsgLoginNullId);
		mapErrMsg.put(CmnVal.errCodeLoginNullPass, CmnVal.errMsgLoginNullPass);
		mapErrMsg.put(CmnVal.errCodeAccsessFalse, CmnVal.errMsgAccsessFalse);
		mapErrMsg.put(CmnVal.errCodeCartFalse, CmnVal.errMsgCartFalse);

		return mapErrMsg.get(errNum);
	}

	//　====================================	
	//　遷移・ログイン・ログアウト系共通処理
	//　====================================
	
	/**
	 * @param response	レスポンス
	 * @param request	リクエスト
	 * @param status	エラーコード　CmnValから
	 * @param URL		送り先のURL
	 * @throws IOException
	 * @throws ServletException
	 */
	public static void cmnForward(HttpServletResponse response ,HttpServletRequest request,int status,String URL) throws IOException,ServletException{

		if(isForward(status)){//エラー無し（エラーコードより下の数値）
			//ディスパッチオブジェクト作成
			RequestDispatcher rd = request.getRequestDispatcher(URL);
			//リクエストを転送
			rd.forward(request,response);
		}else{//エラーあり
			//Messageをセット
			request.setAttribute(CmnVal.attributeMass,errMsg(status));
			//ディスパッチオブジェクト作成
			RequestDispatcher rd = request.getRequestDispatcher(URL);
			//リクエストを転送
			rd.forward(request,response);
		}
	}
	
	/** ログアウトするときTOPへ返す
	 * @param request
	 * @param response
	 * @throws IOException
	 */
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
