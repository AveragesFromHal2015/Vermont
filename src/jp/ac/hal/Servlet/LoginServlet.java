/**
 * @author okudera.tatsuya
 */
package jp.ac.hal.Servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.ac.hal.Beans.User;
import jp.ac.hal.Cmn.CmnFnc;
import jp.ac.hal.Cmn.CmnVal;
import jp.ac.hal.Dao.LoginDao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String errURL = "error.jsp";

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// CmnVal.FormValPassword = request.getParameter("pass");

		// 変数の宣言
		String name = "";
		String pass = "";
		String url = "index.jsp";
		int status = 0;
		int user_id = -1;
		ArrayList<User> list = new ArrayList<User>();
		LoginDao d;

		request.setCharacterEncoding("UTF-8");

		
		try {
			d = new LoginDao();
			// セッション取得
			name = request.getParameter("mail_address");
			pass = request.getParameter("user_pass");

			// ユーザ名、パスワードが空欄、nullでない
			if (CmnFnc.isPrmErr(name) == false && CmnFnc.isPrmErr(pass) == false) {
				user_id = d.loginSQL(name, pass);
				// ログイン可能なら
				if (user_id > -1) {
					HttpSession session = request.getSession(true);

					// セッションの削除
					// session.removeAttribute("mailAddress");
					session.removeAttribute("user_id");
					session.removeAttribute("name");

					// セッションの保存
					// session.setAttribute("mailAddress", mailAddress);
					session.setAttribute("user_id", user_id);
					session.setAttribute("name", name);

					// cookieの保存
					Cookie userIdCookie = new Cookie("user_id", String.valueOf(user_id));
					Cookie userCookie = new Cookie("name", name);
					Cookie passCookie = new Cookie("pass", pass);

					// クッキーの有効時間設定(有効期間1週間)
					userIdCookie.setMaxAge(7 * 24 * 60 * 60);
					userCookie.setMaxAge(7 * 24 * 60 * 60);// userCookieオブジェクトの有効時間設定
					passCookie.setMaxAge(7 * 24 * 60 * 60);// passCookieオブジェクトの有効時間設定

					// クッキーをクライアントに作成する
					response.addCookie(userIdCookie);
					response.addCookie(userCookie);// userCookieオブジェクトのクッキーをクライアントに作成
					response.addCookie(passCookie);// passCookieオブジェクトのクッキーをクライアントに作成


					// ログイン処理
					url = "user.jsp"; // 送り先は仮
					request.setAttribute("user_name", name);

				} else {// ID、パスワードがDBに無かった
					status = CmnVal.errCodeLoginFalse;
					url = CmnVal.errURL; // 送り先は仮
				}
			} else {
				// 名前、パスワードがどちらとも無し、またはnull
				if ((name == null || name.isEmpty())
						&& (pass == null || pass.isEmpty())) {
					status = CmnVal.errCodeLoginFalse;
				}
				// 名前が無し、またはnull
				else if (name == null || name.isEmpty()) {
					status = CmnVal.errCodeLoginNullMail;
				}

				// パスワードが無し、またはnull
				else if (pass == null || pass.isEmpty()) {
					status = CmnVal.errCodeLoginNullPass;
				}

				url = CmnVal.errURL; // 送り先は仮
			}

		}/*
		 * catch(SQLException e){
		 * 
		 * //SQLエラーの場合 url = CmnVal.errURL;
		 * 
		 * //転送するMessage message = "データベースエラーが発生しました。"+ e;
		 * 
		 * }
		 */catch (Exception e) {
			 e.printStackTrace();
			 System.out.println("エラー");
			status = CmnVal.errCode;
			url = CmnVal.errURL;
			// Messageをセット
			// request.setAttribute("message","エラー");
		} finally {
			CmnFnc.cmnForward(response, request, status, url); // 送る処理
		}

	}

}
