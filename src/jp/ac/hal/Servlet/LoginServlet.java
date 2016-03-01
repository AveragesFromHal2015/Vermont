/**
 * @author okudera.tatsuya
 */
package jp.ac.hal.Servlet;

import java.io.IOException;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.ac.hal.Cmn.CmnFnc;
import jp.ac.hal.Cmn.CmnVal;
import jp.ac.hal.Dao.LoginDao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
<<<<<<< HEAD

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
		boolean lc = false;
		ArrayList<User> list = new ArrayList<User>();
		LoginDao d;

		request.setCharacterEncoding("UTF-8");

		
		try {
			d = new LoginDao();
			// セッション取得
			name = request.getParameter("user_name");
			pass = request.getParameter("password");

			// ユーザ名、パスワードが空欄、nullでない
			if (CmnFnc.isPrmErr(name) == false && CmnFnc.isPrmErr(pass) == false) {
				lc = d.loginSQL(name, pass);
				// ログイン可能なら
				if (lc == true) {
					HttpSession session = request.getSession(true);

					// セッションの削除
					// session.removeAttribute("mailAddress");
					// session.removeAttribute("id");
					session.removeAttribute("name");

					// セッションの保存
					// session.setAttribute("mailAddress", mailAddress);
					session.setAttribute("name", name);
					// session.setAttribute("id", d.getUserName());

						// cookieの保存
						Cookie userCookie = new Cookie("name", name);
						Cookie passCookie = new Cookie("pass", pass);

						// クッキーの有効時間設定(有効期間1週間)
						userCookie.setMaxAge(7 * 24 * 60 * 60);// userCookieオブジェクトの有効時間設定
						passCookie.setMaxAge(7 * 24 * 60 * 60);// passCookieオブジェクトの有効時間設定

						// クッキーをクライアントに作成する
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
=======

	private String errMsg = "";
	private String sendURL = "";

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response, HttpSession session)
			throws ServletException, IOException {

		// ユーザID（メールアドレス）、パスワード login.jsp から取得
		String mailaddress = request.getParameter("mail_address");
		String password = request.getParameter("user_pass");

		try {
			if (CmnFnc.isPrmErr(mailaddress)) {
				// 空ならエラーメッセージ
				errMsg = CmnVal.errMsgLoginNullMail;
			}
			if (CmnFnc.isPrmErr(password)) {
				// 空ならエラーメッセージ
				errMsg = errMsg + CmnVal.errMsgLoginNullPass;
			} else {
				LoginDao dao;
				dao = new LoginDao();
				int res = dao.loginSQL(mailaddress, password);

				if (res == 1) {
					//ログイン成功
					//クッキーかセッションにユーザ情報保存
					session.setAttribute("", mailaddress);
					sendURL = "index.jsp";
				}
				
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			sendURL = "SignUp.jsp";
		} catch (NamingException e) {
			e.printStackTrace();
			sendURL = "SignUp.jsp";
		} finally {
			request.setAttribute("errMsg", errMsg);
>>>>>>> 1d7c38ce0c0e9725edeb0d470e175163ac6cacba
		}

		request.getRequestDispatcher(sendURL).forward(request, response);
	}

}
