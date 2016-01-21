<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE HTML>
<html lang="ja">
<head>
	<meta charset="UTF-8">
	<!-- ↓ページタイトル↓ -->
	<title><%= request.getParameter("title") %> | すぐくる</title>
	<link rel="stylesheet" href="common/css/common.css" type="text/css">
	<link rel="stylesheet" href="common/css/<%= request.getParameter("filename") %>.css" type="text/css">
	<script type="text/javascript" src="common/js/jquery.min.js"></script>
	<script type="text/javascript" src="common/js/jquery.flatheights.js"></script>
	<script>
	jQuery(function() {
	$('#pickUp article').flatHeights();
	});
	</script>
	<!--[if lt IE 9]>
	<script src="common/js/html5shiv.js"></script>
	<![endif]-->
	<script src="http://code.jquery.com/jquery-2.1.3.min.js"></script>
	<!--<![endif]-->
	<script src="common/js/signUp.js"></script>
	<script src="https://ajaxzip3.googlecode.com/svn/trunk/ajaxzip3/ajaxzip3-https.js" charset="UTF-8"></script>
	<link href="common/css/styles.css" rel="stylesheet">
	
</head>
<body id="top">
	<noscript><p id="noscript">このWebサイトはJavaScriptを使用しています。<!--[if lt IE 9]><br>
	Internet Explorer 7／8をお使いの方はJavaScriptをオンにしてご覧ください。<![endif]-->
	</p></noscript>
	<header>
	<!-- ↓ロゴ画像↓ -->
	<h1><a href="index.jsp"><img src="img/logo.gif" alt="SUGUKURU" width="378" height="79"></a></h1>
	<!-- ↓ログイン・新規会員登録↓ -->
	<p><a href="login.jsp">ログイン</a> <a href="SignUp.jsp">新規会員登録</a></p>
	</header>
