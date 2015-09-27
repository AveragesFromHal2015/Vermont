package jp.ac.hal.Cmn;

/**
 * 共通の定数
 * @author kazu
 *
 */
public class CmnVal {
	
	//エラー時のジャンプ先URL
	public static final String errURL = "error.jsp";
	public static final String LoginURL = "login.jsp";

	//エラーメッセージ
	public static final String errMsgLoginFalse = "メールアドレス、もしくはパスワードが間違っています。";
	public static final String errMsgLoginNullMail = "メールアドレスを入力してください。";
	public static final String errMsgLoginNullId = "IDを入力してください。";
	public static final String errMsgLoginNullPass = "パスワードを入力してください。";

	public static final String attributeMass = "message";
	
	//間違えないために定数化
	public static final String FormValPassword = "password";
	public static final String FormValMail = "mailAddress";
	public static final String FormValId = "user_id";
	public static final String FormValName = "name";
	
	
}
