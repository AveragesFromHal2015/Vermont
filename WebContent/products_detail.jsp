<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="jp.ac.hal.Beans.Product"%>
<% request.setCharacterEncoding("UTF-8"); %>

<%

	ArrayList<Product> list;
	list = (ArrayList)request.getAttribute("list");
	request.setAttribute("list", list);

%>
<!DOCTYPE HTML>
<html lang="ja">
<head>
<meta charset="UTF-8">

<!-- ↓ページタイトル↓ -->
<title>取り扱い商品｜STATIONERY</title>

<!-- ↓検索エンジン用ここから↓ -->
<meta name="Description" content="検索用文言">
<meta name="Keywords" content="検索用キーワードカンマ（,）区切り">
<!-- ↑検索エンジン用ここまで↑-->
<link rel="stylesheet" href="common/css/common.css" type="text/css">
<link rel="stylesheet" href="common/css/products.css" type="text/css">

<script src="common/js/jquery.min.js"></script>
<script src="common/js/common.js"></script>
<!--[if lt IE 9]>
<script src="common/js/html5shiv.js"></script>
<![endif]-->
</head>

<body id="top">
<noscript><p id="noscript">このWebサイトはJavaScriptを使用しています。<!--[if lt IE 9]><br>
Internet Explorer 7／8をお使いの方はJavaScriptをオンにしてご覧ください。<![endif]-->
</p></noscript>

<header>
<!-- ↓ロゴ画像↓ -->
<h1><a href="index.jsp"><img src="img/logo.gif" alt="STATIONERY" width="378" height="79"></a></h1>

<!-- ↓キャッチコピー↓ -->
<p>毎日快適！オフィス用品を揃えるならSTATIONERY！</p>
</header>




<div id="contents">
<section>
<!-- ↓ページの見出し↓ -->
<h1>取り扱い商品
<!-- ↓ページの説明↓ -->
<small>STATIONERYのラインナップ</small>
</h1>

<!-- ↓カテゴリ1ここから↓ -->
  <!-- ↓↓カテゴリー1の見出し↓↓ -->
  <h2 id="category1">事務用品</h2>


  <!-- ↓↓商品情報1ここから↓↓ -->
<%for(Product p:list){%>
<input type="hidden" name="Productid" value="<%= p.getProductid() %>">
<article id= <%= p.getProductid() %>>
<img src="img/<%= p.getProductid()%>.jpg" alt="写真：帳薄ファイル" width="150" height="150"/>
<h1><%out.println(p.getProductname());%></h1>
</br>
<%out.println(p.getPrice());%>
</br>
<p><%out.println(p.getDescription());%></p>
</br>
<p><%out.println(p.getStock());%></p>
</br>
<p><%out.println(p.getCategoryname());%></p>
<FORM method="POST" action="OrderServlet">
<input type="hidden" name= "product" value= <%= p.getProductid() %>>
<input type="hidden" name= "productname" value= <%= p.getProductname() %>>
<input type="hidden" name= "price" value= <%= p.getPrice() %>>
<INPUT TYPE="submit" name="pagename" value="購入する">
</form>
</article>
<%}%>

  <!-- ↑↑商品情報1ここまで↑↑ -->


<!-- ↓ページのはじめに戻るリンク↓ -->
<p><a href="#top">↑このページのはじめに戻る</a></p>

</section>
</div>

<jsp:include page="navigation.jsp"></jsp:include>
<jsp:include page="footer.jsp">
	<jsp:param name="title" value="管理者画面"/>
</jsp:include>