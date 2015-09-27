<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>    
<jsp:include page="header.jsp">
	<jsp:param name="title" value="ログイン"/>
	<jsp:param name="filename" value="login"/>
</jsp:include>

<div id="contents">
<section>
	<h1>ログイン</h1>

	<form action="LoginServlet" method="post">
		<table border="0" align="center" cellspacing="20">
			<tr>
				<th>ユーザID:</th>
				<td><input type="text" name="id" /></td>
			</tr>
			<tr>
				<th>Password:</th>
				<td><input type="password" name="password" /></td>
			</tr>
			<tr>
				<th>
					<input type="submit" name="login" value="ログイン" />
				</th>
			</tr>
		</table>
	</form>

</section>
</div>

<jsp:include page="navigation.jsp"></jsp:include>
<jsp:include page="footer.jsp">
	<jsp:param name="title" value="管理者画面"/>
</jsp:include>