package jp.ac.hal.Servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

<<<<<<< HEAD
import org.apache.catalina.Session;

=======
>>>>>>> 1d7c38ce0c0e9725edeb0d470e175163ac6cacba
import jp.ac.hal.Beans.Admin;
import jp.ac.hal.Cmn.CmnFnc;
import jp.ac.hal.Dao.AdminDao;

/**
 * Servlet implementation class AdminLogin
 */
@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "";
		boolean errflg = false;
		String msg = "";
		int ret = 0;
		int employee_id = 0;
		String pass = null;

		// DB接続情報
		String serverName = "tstdsv03";
		String instanceName = "orcl1";
		String userName = "ora131";
		String password = "ora131";

		try {
			employee_id = Integer.parseInt(request.getParameter("employee_id"));
			pass = request.getParameter("pass");

			// 未入力チェック
			if (CmnFnc.isPrmErr(employee_id) || CmnFnc.isPrmErr(pass)) {
				url = "AdminLogin.jsp";
				errflg = true;
				msg = "IDまたはパスワードが未入力です";
			}

			Admin admin = new Admin(employee_id, null, null, null, pass);
			AdminDao dao = new AdminDao(serverName, instanceName, userName,
					password);
			ret = dao.login(admin);

			if (ret == 1) {
				url = "AdminTop.jsp";
			} else if (ret == 0) {
				url = "AdminLogin.jsp";
				msg = "IDまたはパスワードが間違っています。";
				errflg = true;
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
			errflg = true;
			request.setAttribute("errflg", errflg);
			url = "AdminLogin.jsp";
			msg = "数字を指定してください";
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if (!errflg) {
				// 管理者トップ画面
				url = "AdminTop.jsp";
			} else {
				// 管理者ログイン画面
				url = "AdminLogin.jsp";
			}
			request.setAttribute("msg", msg);
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
}
