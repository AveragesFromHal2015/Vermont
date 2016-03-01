package jp.ac.hal.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.ac.hal.Beans.User;
import jp.ac.hal.Dao.AdminDao;

/**
 * Servlet implementation class AdminComAccountDeleteServlet
 */
@WebServlet("/AdminComAccountDelete")
public class AdminComAccountDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminComAccountDelete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
			String url = "AdminComAccountServlet";
			String msg = "削除しました";
			int user_id = Integer.parseInt(request.getParameter("user_id"));
			
			//DB接続情報
			String serverName = "tstdsv03";
			String instanceName = "orcl1";
			String userName = "ora131";
			String password = "ora131";
			
			AdminDao adao = new AdminDao(serverName, instanceName, userName, password);
			User user = new User(user_id, null, null, null, null, 0, 0, 0, null, 0, null, 0, password);
			adao.ComAccountDelete(user);
			request.setAttribute("msg", msg);
			request.getRequestDispatcher(url).forward(request, response);
		
	}

}
