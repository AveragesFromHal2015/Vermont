<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jp.ac.hal.Beans.*"%>
<%
	ArrayList<User> list = (ArrayList<User>)request.getAttribute("list");
	//件数
	int i = 0;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>法人アカウント</title>
<script type="text/javascript">

function check(){

	if(window.confirm('本当に削除しますか？')){ // 確認ダイアログを表示

		return true; // 「OK」時は送信を実行

	}
	else{ // 「キャンセル」時の処理

		window.alert('キャンセルされました'); // 警告ダイアログを表示
		return false; // 送信を中止

	}

}
</script>
</head>
<body>
	<h1>法人アカウント一覧</h1>
	<table border="1">
		<tr>
			<th>ユーザID</th>
			<th>ユーザ名</th>
			<th>パスワード</th>
			<th>会社名</th>
			<th>部署名</th>
			<th>社員ID</th>
			<th>電話番号</th>
			<th>FAX</th>
			<th>住所</th>
			<th>銀行番号</th>
			<th>締日</th>
			<th>与信限度額</th>
		</tr>
<%
		for(User user:list){
%>
		<tr>
			<td><%=user.getUserid() %></td>
			<td><%=user.getUser_name() %></td>
			<td><%=user.getUser_pass() %></td>
			<td><%=user.getCom_name() %></td>
			<td><%=user.getCom_department() %></td>
			<td><%=user.getEmployee_id() %></td>
			<td><%=user.getUser_tel() %></td>
			<td><%=user.getUser_fax() %></td>
			<td><%=user.getUser_address() %></td>
			<td><%=user.getUser_bank() %></td>
			<td><%=user.getEnd_day() %></td>
			<td><%=user.getCredit_limit() %></td>
			<td>
				<form action="AdminComAccountDetail" method="post">
					<input type="submit" name="edit" value="編集画面へ" />
					<input type="hidden" value="<%=user.getUserid()%>" name="user_id"/>
				</form>
			</td>
			<td>
				<form action="AdminComAccountDelete" method="post" onsubmit="check()">
					<input type="submit" name="delete" value="削除" />
					<input type="hidden" value="<%=user.getUserid()%>" name="user_id"/>
				</form>
			</td>
		</tr>
<%
			//件数カウント
			i = i+1;
		}
%>
	</table>
<p><%=i %>件表示</p>
	<p><a href="AdminTop.jsp">トップへ</a></p>
	
</body>
</html>