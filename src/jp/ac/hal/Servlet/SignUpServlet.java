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

import jp.ac.hal.Beans.User;
import jp.ac.hal.Cmn.CmnFnc;
import jp.ac.hal.Cmn.CmnVal;
import jp.ac.hal.Dao.Dao;

/**
 * Servlet implementation class SignUpServlet
 */
@WebServlet("/SignUpServlet")
public class SignUpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//変数の宣言
		String url = "";
		String message = "";
		boolean errFlg = false;

		//データ・アクセスクラスを作る
		Dao d ;	
		CmnFnc c;
		User u = new User();
		ArrayList<Object> user = new ArrayList<>();
		int[] lengthcheck ={200, 40, 30, 30, 11, 11, 200};
		
		try{
			
			//Userbeanへ追加
			u.setUser_name(request.getParameter("user_name"));	//DBにユーザネームが無いのでDBに追加しないとダメかも
			u.setUser_pass(request.getParameter("user_pass"));
			u.setCom_name(request.getParameter("com_name"));
			u.setCom_department(request.getParameter("com_department"));
			u.setUser_tel(Integer.parseInt(request.getParameter("user_tel")));
			u.setUser_fax(Integer.parseInt(request.getParameter("user_fax")));
			u.setUser_address(request.getParameter("user_address"));
			
			//arraylistへ格納
			user.add(u.getUser_name());
			user.add(u.getUser_pass());
			user.add(u.getCom_name());
			user.add(u.getCom_department());
			user.add(u.getUser_tel());
			user.add(u.getUser_fax());
			user.add(u.getUser_address());
			
			
			//エラーチェック
			//null、空白
			for(int i=0; i < user.size() && errFlg == false; i++){
				errFlg = CmnFnc.isPrmErr(user.get(i).toString());
				
			}
			if(errFlg){
				message = "未入力の欄があります。";
				url = CmnVal.errURL;
			}
			else{
				//文字数
				for(int i=0; i < user.size() && errFlg == false; i++){
					errFlg = user.get(i).toString().length() > lengthcheck[i];
				}
				if(errFlg){
					message = "文字数の上限を超えている欄があります。";
					url = CmnVal.errURL;
				}
				else{
					//d.regist(user);//DBへ追加処理
				}
			}
			
		}catch(NumberFormatException e){
			
			//数値エラー
			errFlg = true;
			url = CmnVal.errURL;

			//転送するMessage
			message = "電話番号、FAXは数値を入力して下さい"+ e;
			
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
