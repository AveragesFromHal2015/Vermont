/**
 * @author okudera.tatsuya
 */
package jp.ac.hal.Servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.ac.hal.Beans.User;
import jp.ac.hal.Dao.AdminDao;

/**
 * Servlet implementation class AdminComAccountServlet
 */
@WebServlet("/AdminComAccountServlet")
public class AdminComAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminComAccountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "AdminComAccount.jsp";
		
		//DB接続情報
		String serverName = "tstdsv03";
		String instanceName = "orcl1";
		String userName = "ora131";
		String password = "ora131";

		try{
			AdminDao adao = new AdminDao(serverName, instanceName, userName, password);
			
			ArrayList<User> list = new ArrayList<User>();
			list = adao.ComAccountList();
			
			request.setAttribute("list", list);
		}catch(Exception e){
			e.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "AdminComAccount.jsp";
		
		//DB接続情報
		String serverName = "tstdsv03";
		String instanceName = "orcl1";
		String userName = "ora131";
		String password = "ora131";

		try{
			AdminDao adao = new AdminDao(serverName, instanceName, userName, password);
			
			ArrayList<User> list = new ArrayList<User>();
			list = adao.ComAccountList();
			
			request.setAttribute("list", list);
		}catch(Exception e){
			e.printStackTrace();
		}
		request.getRequestDispatcher(url).forward(request, response);
		

	}

}
