/**
 * @author okudera.tatsuya
 */
package jp.ac.hal.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.ac.hal.Beans.User;
import jp.ac.hal.Dao.AdminDao;

/**
 * Servlet implementation class AdminComAccountEdit
 */
@WebServlet("/AdminComAccountEdit")
public class AdminComAccountEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminComAccountEdit() {
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
		request.setCharacterEncoding("utf-8");
		
		String url = "AdminComAccountServlet";
		String msg = "";
		int user_id = Integer.parseInt(request.getParameter("user_id"));
		String user_name = request.getParameter("user_name");
		String user_pass = request.getParameter("user_pass");
		String com_name = request.getParameter("com_name");
		String com_department = request.getParameter("com_department");
		int user_tel = Integer.parseInt(request.getParameter("user_tel"));
		int user_fax = Integer.parseInt(request.getParameter("user_fax"));
		String user_address = request.getParameter("user_address");
		int user_bank = Integer.parseInt(request.getParameter("user_bank"));
		String end_day = request.getParameter("end_day");
		int credit_limit = Integer.parseInt(request.getParameter("credit_limit"));
		int employee_id = Integer.parseInt(request.getParameter("employee_id"));
		
		//DB接続情報
		String serverName = "tstdsv03";
		String instanceName = "orcl1";
		String userName = "ora131";
		String password = "ora131";
		
		AdminDao adao = new AdminDao(serverName, instanceName, userName, password);
		User user = new User(user_id, user_name, user_pass, com_name, com_department, employee_id, user_tel, user_fax, user_address, user_bank, end_day, credit_limit);
		
		adao.ComAccountEdit(user);
		msg = "変更しました";
		request.setAttribute("msg", msg);
		
		request.getRequestDispatcher(url).forward(request, response);
		
	}
}
