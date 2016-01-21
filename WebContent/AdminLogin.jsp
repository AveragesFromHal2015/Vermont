<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="jp.ac.hal.Cmn.CmnVal"%>
<%
	String msg = (String)request.getAttribute("msg");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理者ログイン</title>
</head>
<body>
	<h1>管理者ログイン</h1>
	<%if(msg!=null){ %>
		<h2><%=msg %></h2>
	<%} %>
	<form action="AdminLoginServlet" method="post">
		<table border="0" align="center" cellspacing="20">
			<tr>
				<th>社員ID:</th>
				<td><input type="text" name="employee_id" size="8" pattern="^[0-9A-Za-z]+$" /></td>
			</tr>
			<tr>
				<th>Password:</th>
				<td><input type="password" name="pass" /></td>
			</tr>
			<tr>
				<th>
					<input type="submit" name="login" value="ログイン" />
				</th>
			</tr>
		</table>
	</form>
</body>
</html>