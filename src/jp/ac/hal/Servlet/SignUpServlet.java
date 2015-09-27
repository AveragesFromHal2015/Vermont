package jp.ac.hal.Servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.ac.hal.Cmn.CmnFnc;
import jp.ac.hal.Cmn.CmnVal;
import jp.ac.hal.Dao.Dao;

/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//変数の宣言
		String mailAddress = "";
		String pass = "";
		String url = "";
		String message = "";
		boolean errFlg = false;
		
		String user_name;
		String user_pass; //パスワード
		String com_name; //会社名
		String com_department; //部署名
		int user_tel;
		String s_user_tel;
		int user_fax;
		String s_user_fax;
		String user_address; //住所*/

		//データ・アクセスクラスを作る
		Dao d ;	
		CmnFnc c;
		ArrayList<Object> user = new ArrayList<>();
		
		try{
			user_name = request.getParameter("user_name");
			user_pass = request.getParameter("user_pass");
			com_name = request.getParameter("com_name");
			com_department = request.getParameter("com_department");
			s_user_tel = request.getParameter("user_tel");
			s_user_fax = request.getParameter("user_fax");
			user_address = request.getParameter("user_address");
			
			//エラーチェック
			//null、空白
			errFlg = CmnFnc.isPrmErr(user_name);
			errFlg = CmnFnc.isPrmErr(user_pass);
			errFlg = CmnFnc.isPrmErr(com_name);
			errFlg = CmnFnc.isPrmErr(com_department);
			errFlg = CmnFnc.isPrmErr(s_user_tel);
			errFlg = CmnFnc.isPrmErr(s_user_fax);
			errFlg = CmnFnc.isPrmErr(user_address);
			
			if(errFlg){
				message = "未入力の欄があります。";
				url = CmnVal.errURL;
			}
			else{
				
				//文字数
				errFlg = user_name.length() > 200;
				errFlg = user_pass.length() > 40;
				errFlg = com_name.length() > 30;
				errFlg = com_department.length() > 30;
				errFlg = s_user_tel.length() > 11;
				errFlg = s_user_fax.length() > 11;
				errFlg = user_address.length() > 200;
				
				if(errFlg){
					message = "文字数の上限を超えている欄があります。";
					url = CmnVal.errURL;
				}
				else{
					//文字から数値へ
					user_tel = Integer.parseInt(s_user_tel);
					user_fax = Integer.parseInt(s_user_fax);
					
					user.add(user_name);
					user.add(user_pass);
					user.add(com_department);
					user.add(com_name);
					user.add(user_tel);
					user.add(user_fax);
					user.add(user_address);
					
					d.regist(user);//DBへ追加処理
				}
			}
			
			
		}catch(SQLException e){

			//SQLエラーの場合
			errFlg = true;
			url = CmnVal.errURL;
			
			//転送するMessage
			message = "データベースエラーが発生しました。"+ e;
			
		}catch(Exception e){

			//エラーの場合
			errFlg = true;
			url = CmnVal.errURL;

			//転送するMessage
			message = "エラーが発生しました。"+ e;

		}finally{

			if(errFlg == false){//エラー無し
				
				response.sendRedirect(url);

			}else{//エラーあり
				//Messageをセット
				request.setAttribute("errorMessage",message);
				//ディスパッチオブジェクト作成
				RequestDispatcher rd = request.getRequestDispatcher(url);
				//リクエストを転送
				rd.forward(request,response);
			}
		}
	}

}