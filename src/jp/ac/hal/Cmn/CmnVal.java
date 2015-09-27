package jp.ac.hal.Cmn;

import java.util.HashMap;

import com.sun.javafx.collections.MappingChange.Map;

/**
 * 共通の定数
 * @author kazu
 *
 */
public class CmnVal {
	
	//エラー時のジャンプ先URL
	public static final String errURL = "error.jsp";
	public static final String LoginURL = "login.jsp";
	public static final String TopURL = "index.jsp";
	
	//エラーステータスコード
	/*
	 * 800 ログイン時エラーメッセージ 
	 * 810 アクセスエラー
	 */
	public static final int errCode = 800;
	public static final int errCodeLoginFalse = 801;
	public static final int errCodeLoginNullMail = 802;
	public static final int errCodeLoginNullId = 803;
	public static final int errCodeLoginNullPass = 804;
	public static final int errCodeAccsessFalse = 810;

	//エラーメッセージ
	public static final String errMsgLoginFalse = "メールアドレス、もしくはパスワードが間違っています。";
	public static final String errMsgLoginNullMail = "メールアドレスを入力してください。";
	public static final String errMsgLoginNullId = "IDを入力してください。";
	public static final String errMsgLoginNullPass = "パスワードを入力してください。";
	public static final String errMsgAccsessFalse = "不正なアクセスです。";
	
	public static final String attributeMass = "message";	
	//間違えないために定数化
	public static final String FormValPassword = "password";
	public static final String FormValMail = "mailAddress";
	public static final String FormValId = "user_id";
	public static final String FormValName = "name";
	public static final String FormValProduct = "pruduct";
	
	public static final String SessionValCart = "cart";
		
}
