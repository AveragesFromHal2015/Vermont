package jp.ac.hal.Servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.startup.UserConfig;

import jp.ac.hal.Beans.User;
import jp.ac.hal.Cmn.CmnFnc;
import jp.ac.hal.Cmn.CmnVal;
import jp.ac.hal.Dao.Dao;
import jp.ac.hal.Dao.LoginDao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String errURL = "error.jsp";

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//変数の宣言
		String name = "";
		String pass = "";
		String url = "index.jsp";
		int status = 0;
		ArrayList<User> list = new ArrayList<User>();
		LoginDao d;	
		User u = new User();
		
		request.setCharacterEncoding("UTF-8");	

		try{
			d = new LoginDao();
			//セッション取得
			name = request.getParameter("user_name");
			pass = request.getParameter("password");
			
			//ユーザ名、パスワードが空欄、nullでない
			if((name != null && !name.isEmpty()) && (pass != null && !pass.isEmpty())){
				list = d.loginSQL(name, pass);
				//ログイン可能なら
				if (list != null){
					HttpSession session = request.getSession(true);
					
					//セッションの削除
//					session.removeAttribute("mailAddress");
//					session.removeAttribute("id");
					session.removeAttribute("name");
					
					//セッションの保存
//					session.setAttribute("mailAddress", mailAddress);
					session.setAttribute("name", u.getUser_name());
//					session.setAttribute("id", d.getUserName());
					
					if(request.getParameter("option") != null){
						
						//cookieの保存
						Cookie optionCookie = new Cookie("option","0");
						Cookie userCookie = new Cookie("name",name);
						Cookie passCookie = new Cookie("pass",pass);
						
						//クッキーの有効時間設定(有効期間1週間)
						optionCookie.setMaxAge(7*24*60*60);//optionCookieオブジェクトの有効時間設定
						userCookie.setMaxAge(7*24*60*60);//userCookieオブジェクトの有効時間設定
						passCookie.setMaxAge(7*24*60*60);//passCookieオブジェクトの有効時間設定
						
						//クッキーをクライアントに作成する
						response.addCookie(optionCookie);//optionCookieオブジェクトのクッキーをクライアントに作成
						response.addCookie(userCookie);//userCookieオブジェクトのクッキーをクライアントに作成
						response.addCookie(passCookie);//passCookieオブジェクトのクッキーをクライアントに作成


					}else{
						//cookieの削除
						Cookie optionCookie = new Cookie("option","");
						Cookie userCookie = new Cookie("user","");
						Cookie passCookie = new Cookie("pass","");
						
						//クッキーの有効時間設定(有効期間1週間)
						optionCookie.setMaxAge(0);//optionCookieオブジェクトの有効時間設定
						userCookie.setMaxAge(0);//userCookieオブジェクトの有効時間設定
						passCookie.setMaxAge(0);//passCookieオブジェクトの有効時間設定
						
						//クッキーをクライアントに作成する
						response.addCookie(optionCookie);//optionCookieオブジェクトのクッキーをクライアントに作成
						response.addCookie(userCookie);//userCookieオブジェクトのクッキーをクライアントに作成
						response.addCookie(passCookie);//passCookieオブジェクトのクッキーをクライアントに作成

					}
					
					//ログイン処理
					url = "user.jsp";	//送り先は仮
					request.setAttribute("list", list);
					
				}else {//ID、パスワードがDBに無かった
					status = CmnVal.errCodeLoginFalse;
					url = CmnVal.errURL;	//送り先は仮
				}
			}else{
				//名前、パスワードがどちらとも無し、またはnull
				if((name == null || name.isEmpty()) && (pass == null || pass.isEmpty())){
					status = CmnVal.errCodeLoginFalse;
				}
				//名前が無し、またはnull
				else if(name == null || name.isEmpty()){
					status = CmnVal.errCodeLoginNullMail;
				}
				
				//パスワードが無し、またはnull
				else if(pass == null || pass.isEmpty()){
					status = CmnVal.errCodeLoginNullPass;
				}
				
				url = CmnVal.errURL;	//送り先は仮
			}
			
		}/*catch(SQLException e){

			//SQLエラーの場合
			url = CmnVal.errURL;
			
			//転送するMessage
			message = "データベースエラーが発生しました。"+ e;
			
		}*/catch(Exception e){
			status = CmnVal.errCode;
			url = CmnVal.errURL;
				//Messageをセット
//				request.setAttribute("message","エラー");
		}finally{
			CmnFnc.cmnForward(response, request, status, url);	//送る処理
		}
	}

}
