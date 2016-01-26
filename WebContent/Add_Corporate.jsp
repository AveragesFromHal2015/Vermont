<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>法人会員登録</title>
</head>
<body>

	<h1>法人会員登録</h1>

	<form action="Add_CorporateServlet" method="post">
		<table border="0" align="center" cellspacing="10">
			<tr>
				<th>ユーザID(メールアドレス):</th>
				<td><input type="text" name="id" /></td>
			</tr>
			<tr>
				<th>パスワード:</th>
				<td><input type="password" name="password" /></td>
			</tr>
			<tr>
				<th>会社名:</th>
				<td><input type="text" name="CompanyName" /></td>
			</tr>
			<tr>
				<th>部署名:</th>
				<td><input type="text" name="DepartmentName" /></td>
			</tr>
			<tr>
				<th>電話番号:</th>
				<td><input type="text" name="TelNo" /></td>
			</tr>
			<tr>
				<th>FAX:</th>
				<td><input type="text" name="FaxNo" /></td>
			</tr>
			<tr>
				<th>銀行ナンバー:</th>
				<td><input type="text" name="BunkNo" /></td>
			</tr>
			<tr>
				<th>
					<input type="submit" name="add" value="登録" />
				</th>
			</tr>
		</table>
	</form>

</body>
</html>