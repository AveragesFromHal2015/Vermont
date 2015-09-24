<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name = request.getAttribute("name");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>管理者画面</title>
</head>
<body>

	<h1> <%=name %>さんようこそ</h1>
	
	<a href="">法人アカウント管理ページへ</a>
	<a href="">商品管理ページへ</a>
	<a href="">見積もり・管理ページへ</a>
	<a href="">受注データ管理・閲覧ページへ</a>
	
	<a href="">ログアウト</a>

</body>
</html>
