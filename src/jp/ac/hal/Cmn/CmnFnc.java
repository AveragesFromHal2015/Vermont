package jp.ac.hal.Cmn;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 共通の関数
 * @author kazu
 *
 */
public class CmnFnc {
	
	/*
	 * 毎回のチェックが面倒なので作りました。by hirosawa
	 * 
	 */
	public static boolean isPrmErr(String str) {
		return str == null || str.isEmpty();
	}

	public static boolean isPrmErr(int num) {
		return num == 0 ;
	}
	
	public static boolean isForward(int statusCode) {
		return statusCode < 900;
	}
	
	//エラー番号によってメッセージを返すメソッド
	public static String errMsg(int errNum) {
		return "";
	}
	
	
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

//	private static void createCookie(HttpServletResponse response,String name,Object value) {
//		//cookieの保存
//		Cookie cookie = new Cookie(name,value);		
//		//クッキーの有効時間設定(有効期間1週間)
//		cookie.setMaxAge(7*24*60*60);//Cookieオブジェクトの有効時間設定
//		//クッキーをクライアントに作成する
//		response.addCookie(cookie);//optionCookieオブジェクトのクッキーをクライアントに作成
//	}
	
}
