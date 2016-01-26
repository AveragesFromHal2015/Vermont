<%@page import="com.sun.corba.se.spi.legacy.connection.GetEndPointInfoAgainException"%>
    <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="jp.ac.hal.Beans.User"%>
<%@ page import= "java.util.ArrayList" %>
        <%
		request.setCharacterEncoding("UTF-8");
    	ArrayList<User> list = null;
    	list = (ArrayList)request.getAttribute("list");
        Cookie cookie[] = request.getCookies();
    %>
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
<h1><a href="index.html"><img src="img/logo.gif" alt="STATIONERY" width="378" height="79"></a></h1>

</header>

<div id="contents">
<section>
<!-- ↓ページの見出し↓ -->
	<%
	try{
		if(cookie != null){
	    for(int i = 0; i < cookie.length; i++){
	        if(cookie[i].getName().equals("name")){
	            out.println(cookie[i].getValue());
	        }
	        if(cookie[i].getName().equals("pass")){
	            out.println(cookie[i].getValue());
	        }
	    }
	}
		for(User u: list){
			out.println(u.getUserid() + ":" + u.getUser_name());
			%><br /><%
		}
	}
	catch(NullPointerException e){
		out.println("ぬるぽ");
	}

	%>

</section>
</div>

<jsp:include page="navigation.jsp"></jsp:include>
<jsp:include page="footer.jsp">
	<jsp:param name="title" value="管理者画面"/>
</jsp:include>