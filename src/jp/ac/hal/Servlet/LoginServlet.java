package jp.ac.hal.Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import jp.ac.hal.Beans.*;
import jp.ac.hal.Cmn.CmnFnc;
import jp.ac.hal.Cmn.CmnVal;
import jp.ac.hal.Dao.Dao;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private String errURL = "error.jsp";

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//変数の宣言
		String mailAddress = "";
		String pass = "";
		String url = "index.jsp";
		String message = "";
		boolean errFlg = false;
		
		String sql = "select count(*) from company_table where user_id = ? and user_pass=?;";
		
		User user = new User();

		//データ・アクセスクラスを作る
		Dao d ;
		
		//ログインボタン
		if(request.getParameter("login") != null ){
			if(user.setUserid(Integer.parseInt(request.getParameter(arg0)))){
				
			}
		}
		
		d.ExcuteSql(sql, obj);
		
		
		CmnFnc.cmnForward(response, request, CmnVal.errCode, url);

//		try{
//			
//			mailAddress = request.getParameter("mailAddress");
//			pass = request.getParameter("password");
//			
//			if((mailAddress != null && !mailAddress.isEmpty()) && (pass != null && !pass.isEmpty())){
//
//				//ログインの結果のジャンプ
//				if (d.loginSQL(mailAddress, pass) == true){
//					HttpSession session = request.getSession(true);
//					
//					//セッションの削除
//					session.removeAttribute("mailAddress");
//					session.removeAttribute("id");
//					session.removeAttribute("name");
//					
//					//セッションの保存
//					session.setAttribute("mailAddress", mailAddress);
//					session.setAttribute("name", d.getUserName());
//					session.setAttribute("id", d.getUserId());
//					
//					if(request.getParameter("option") != null){
//						
//						//cookieの保存
//						Cookie optionCookie = new Cookie("option","0");
//						Cookie userCookie = new Cookie("mailAddress",mailAddress);
//						Cookie passCookie = new Cookie("pass",pass);
//						
//						//クッキーの有効時間設定(有効期間1週間)
//						optionCookie.setMaxAge(7*24*60*60);//optionCookieオブジェクトの有効時間設定
//						userCookie.setMaxAge(7*24*60*60);//userCookieオブジェクトの有効時間設定
//						passCookie.setMaxAge(7*24*60*60);//passCookieオブジェクトの有効時間設定
//						
//						//クッキーをクライアントに作成する
//						response.addCookie(optionCookie);//optionCookieオブジェクトのクッキーをクライアントに作成
//						response.addCookie(userCookie);//userCookieオブジェクトのクッキーをクライアントに作成
//						response.addCookie(passCookie);//passCookieオブジェクトのクッキーをクライアントに作成
//
//					}else{
//						//cookieの削除
//						Cookie optionCookie = new Cookie("option","");
//						Cookie userCookie = new Cookie("user","");
//						Cookie passCookie = new Cookie("pass","");
//						
//						//クッキーの有効時間設定(有効期間1週間)
//						optionCookie.setMaxAge(0);//optionCookieオブジェクトの有効時間設定
//						userCookie.setMaxAge(0);//userCookieオブジェクトの有効時間設定
//						passCookie.setMaxAge(0);//passCookieオブジェクトの有効時間設定
//						
//						//クッキーをクライアントに作成する
//						response.addCookie(optionCookie);//optionCookieオブジェクトのクッキーをクライアントに作成
//						response.addCookie(userCookie);//userCookieオブジェクトのクッキーをクライアントに作成
//						response.addCookie(passCookie);//passCookieオブジェクトのクッキーをクライアントに作成
//					}
//
//					
//					//ログイン処理
//					url = "user.jsp";
//				}else {
//					//転送するMessage
//					message = "メールアドレス、もしくはパスワードが間違っています。";
//					//エラー処理
//					errFlg = true;
//					url = "error.jsp";
//				}
//			}else{
//				//エラーあり
//				errFlg = true;
//
//				if(mailAddress == null || mailAddress.isEmpty()){
//					message = "メールアドレスを入力してください。";
//				}
//
//				if(pass == null || pass.isEmpty()){
//					message = message + "パスワードを入力してください。";
//				}
//				
//				//エラー処理
//				url = errURL;		
//			}
//
//			
//		}catch(SQLException e){
//
//			//SQLエラーの場合
//			errFlg = true;
//			url = errURL;
//			
//			//転送するMessage
//			message = "データベースエラーが発生しました。"+ e;
//			
//		}catch(Exception e){
//
//			//エラーの場合
//			errFlg = true;
//			url = errURL;
//
//			//転送するMessage
//			message = "エラーが発生しました。"+ e;
//
//		}finally{
//
//			if(errFlg == false){//エラー無し
//				
//				response.sendRedirect(url);
//
//			}else{//エラーあり
//				//Messageをセット
//				request.setAttribute("errorMessage",message);
//				//ディスパッチオブジェクト作成
//				RequestDispatcher rd = request.getRequestDispatcher(url);
//				//リクエストを転送
//				rd.forward(request,response);
//			}
//		}
	}

}
