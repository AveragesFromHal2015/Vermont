<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String name = (String)request.getAttribute("name");
%>
<jsp:include page="header.jsp">
	<jsp:param value="title" name="管理者画面"/>
</jsp:include>
	<h1> <%=name %>さんようこそ</h1>
	
	<a href="">法人アカウント管理ページへ</a>
	<a href="">商品管理ページへ</a>
	<a href="">見積もり・管理ページへ</a>
	<a href="">受注データ管理・閲覧ページへ</a>
	
	<a href="">ログアウト</a>
<jsp:include page="footer.jsp">
	<jsp:param value="title" name="管理者画面"/>
</jsp:include>
