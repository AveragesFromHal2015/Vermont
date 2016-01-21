<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="jp.ac.hal.Beans.*"%>
<%
	ArrayList<User> list = (ArrayList<User>)request.getAttribute("list");
	String msg = (String)request.getAttribute("msg");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>法人アカウント編集画面</h2>
	
<%	if(msg != null){ %>

	<h3><%=msg %></h3>

<% 	}%>
	<form action="AdminComAccountEdit" method="post">
		<table border="1px">
<%
	for(User user : list){
%>
				<tr>
					<td>ユーザID</td><td><input type="text" value="<%=user.getUserid() %>" name="user_id" /></td>
				</tr>
				<tr>
					<td>ユーザ名</td><td><input type="text" value="<%=user.getUser_name() %>" name="user_name" /></td>
				</tr>
				<tr>
					<td>パスワード</td><td><input type="text" value="<%=user.getUser_pass() %>" name="user_pass" /></td>
				</tr>
				<tr>
					<td>会社名</td><td><input type="text" value="<%=user.getCom_name() %>" name="com_name" /></td>
				</tr>
				<tr>
					<td>部署名</td><td><input type="text" value="<%=user.getCom_department() %>" name="com_department" /></td>
				</tr>
				<tr>
					<td>電話番号</td><td><input type="text" value="<%=user.getUser_tel() %>" name="user_tel" /></td>
				</tr>
				<tr>
					<td>FAX</td><td><input type="text" value="<%=user.getUser_fax() %>" name="user_fax" /></td>
				</tr>
				<tr>
					<td>住所</td><td><input type="text" value="<%=user.getUser_address() %>" name="user_address" /></td>
				</tr>
				<tr>
					<td>銀行</td><td><input type="text" value="<%=user.getUser_bank() %>" name="user_bank" /></td>
				</tr>
				<tr>
					<td>締日</td><td><input type="text" value="<%=user.getEnd_day() %>" name="end_day" /></td>
				</tr>
				<tr>
					<td>与信限度額</td><td><input type="text" value="<%=user.getCredit_limit() %>" name="credit_limit" /></td>
				</tr>
				<tr>
					<td>社員ID</td><td><input type="text" value="<%=user.getEmployee_id() %>" name="employee_id" /></td>
				</tr>
<%
	}
%>
		</table>
	<input type="submit" value="完了" />
	</form>
	<p><a href="AdminComAccountServlet">戻る</a></p>

</body>
</html>