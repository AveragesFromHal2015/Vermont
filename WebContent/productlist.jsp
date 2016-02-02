<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="jp.ac.hal.Beans.Product" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>商品一覧</title>
</head>
<body>

	<table>
		<tr style="border:solid 1px black;">
			<th>商品ID</th>
			<th>商品名</th>
			<th>価格</th>
		</tr>
	<%
		ArrayList<Product> list = (ArrayList<Product>)request.getAttribute("productlist");
	
		
		for(Product p : list){
	%>
		
		<tr style="border:solid 1px black;">
			<th style="border:solid 1px black;"><%=p.getProductid()%></th>
			<td style="border:solid 1px black;"><%=p.getProductname()%></td>
			<td style="border:solid 1px black;"><%=p.getPrice()%></td>
		</tr>
	<%	
		}
	%>
	</table>


</body>
</html>