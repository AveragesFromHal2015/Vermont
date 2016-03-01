<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("UTF-8");
%>
<jsp:include page="header.jsp">
	<jsp:param name="title" value="新規会員登録" />
	<jsp:param name="filename" value="SignUp" />
</jsp:include>

<div id="contents">
	<div>
		<form method="post" action="SignUpServlet" id="SignUpServlet">
			<table>
				<tr>
					<th><label for="user_name">名前 <span class="ind">必須</span><br>
							<span>（全角）</span></label></th>
					<td><input type="text" name="user_name" id="user_name"
						placeholder="名前"></td>
				</tr>
				<tr>
					<th><label for="user_pass">パスワード <span class="ind">必須</span><br>
							<span>（半角英数字）</span></label></th>
					<td><input type="password" name="user_pass" id="user_pass"
						placeholder="パスワード"></td>
				</tr>
				<tr>
					<th><label for="com_name">会社名 <span class="ind">必須</span></label></th>
					<td><input type="text" name="com_name" id="com_name"
						placeholder="会社名"></td>
				</tr>
				<tr>
					<th><label for="com_department">部署名 <span class="ind">必須</span></label></th>
					<td><input type="text" name="com_department"
						id="com_department" placeholder="部署名"></td>
				</tr>
				<tr>
					<th><label for="user_tel">電話番号 <span class="ind">必須</span><br>
							<span>（半角数字・ハイフンなし）</span></label></th>
					<td><input type="text" name="user_tel" id="user_tel"
						placeholder="電話番号" maxlength="11"></td>
				</tr>
				<tr>
					<th><label for="user_fax">FAX <span class="ind">必須</span><br>
							<span>（半角数字・ハイフンなし）</span></label></th>
					<td><input type="text" name="user_fax" id="user_fax"
						placeholder="FAX" maxlength="11"></td>
				</tr>
				<tr>
					<th><label for="userPostalCode">郵便番号<br> <span>（半角数字・ハイフンあり）</span></label></th>
					<td><input type="text" name="userPostalCode" size="10"
						maxlength="8"
						onKeyUp="AjaxZip3.zip2addr(this,'','user_address','user_address');"
						id="user_address" placeholder="郵便番号"></td>
				</tr>

				<tr>
					<th><label for="user_address">住所 <span class="ind">必須</span></label></th>
					<td><input type="text" name="user_address" id="user_address"
						placeholder="住所"></td>
				</tr>
				<tr>
					<th><label for="formMail">メールアドレス<br />(今後のユーザIDとなります)
							<span class="ind">必須</span><br> <span>（半角英数字）</span></label></th>
					<td><input type="text" name="formMail" id="formMail"
						placeholder="メールアドレス"></td>
				</tr>
			</table>
			<p>
				<input type="submit" name="signUp" value="登録">
			</p>
		</form>
	</div>
</div>
<jsp:include page="navigation.jsp"></jsp:include>
<jsp:include page="footer.jsp">
	<jsp:param name="title" value="管理者画面" />
</jsp:include>
