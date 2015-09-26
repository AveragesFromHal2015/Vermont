package jp.ac.hal.Cmn;

import javax.servlet.http.Cookie;
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
	public static boolean isErr(String str) {
		return str == null || str.isEmpty();
	}

	public static boolean isErr(int num) {
		return num == 0 ;
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
