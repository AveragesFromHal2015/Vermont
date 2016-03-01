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
		}

		request.getRequestDispatcher(sendURL).forward(request, response);
	}

}
