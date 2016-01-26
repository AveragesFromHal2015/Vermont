<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="jp.ac.hal.Beans.Product"%>
<% request.setCharacterEncoding("UTF-8"); %>

<%

	ArrayList<Product> list;
	list = (ArrayList)request.getAttribute("list");

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
<a href="ProductDetail?Productid=<%= p.getProductid()%>">
<article id= <%= p.getProductid() %>>
<img src="img/<%= p.getProductid()%>.jpg" alt="写真：帳薄ファイル" width="150" height="150"/>
<h1><%out.println(p.getProductname());%></h1></a>
</br>
<%out.println(p.getPrice());%>
</br>
<p><%out.println(p.getDescription());%></p>
</article>
<%}%>
  <!-- ↑↑商品情報1ここまで↑↑ -->



  <!-- ↓↓商品情報6ここから↓↓ -->
  <article id="productName6">
  <img src="img/products06.jpg" alt="写真：プリンタ" width="150" height="150">
  <h1>プリンタ </h1>
  <p>ビジネス向けインクジェット複合機で、Wi-Fi/有線LANに対応。外出先や会議室にいても文書やメールのプリント指示ができます。</p>
  </article>
  <!-- ↑↑商品情報6ここまで↑↑ -->

  <!-- ↓↓商品情報7ここから↓↓ -->
  <article id="productName7">
  <img src="img/products07.jpg" alt="写真：マウス" width="150" height="150">
  <h1>マウス</h1>
  <p>最高峰の読み取り性能で、ほとんどの素材に対応！あらゆる場面で優れた操作性を誇るプロ仕様のマウスです。</p>
  </article>
  <!-- ↑↑商品情報7ここまで↑↑ -->

  <!-- ↓↓商品情報8ここから↓↓ -->
  <article id="productName8">
  <img src="img/products08.jpg" alt="写真：記録媒体" width="150" height="150">
  <h1>記録媒体</h1>
  <p>2倍速の繰り返し録画用なブルーレイメディア、8倍速記録対応のDVD-Rディスクなど国産品多数！ </p>
  </article>
  <!-- ↑↑商品情報8ここまで↑↑ -->

<!-- ↑カテゴリ2ここまで↑ -->

<!-- ↓ページのはじめに戻るリンク↓ -->
<p><a href="#top">↑このページのはじめに戻る</a></p>

<!-- ↓カテゴリ3ここから↓ -->
  <!-- ↓↓カテゴリー3の見出し↓↓ -->
  <h2 id="category3">デスク・チェア・他</h2>

  <!-- ↓↓商品情報9ここから↓↓ -->
  <article id="productName9">
  <img src="img/products09.jpg" alt="写真：肘付椅子" width="150" height="150">
  <h1>肘付椅子</h1>
  <p>高級感のあるファブリックを張地に使用したオフィスチェアです。</p>
  </article>
  <!-- ↑↑商品情報9ここまで↑↑ -->

  <!-- ↓↓商品情報10ここから↓↓ -->
  <article id="productName10">
  <img src="img/products10.jpg" alt="写真：パイプ椅子" width="150" height="150">
  <h1>パイプ椅子</h1>
  <p>しっかりとした作りのスチールパイプは、マットシルバーで光沢抑え目の上品な印象を与えます。カラーは、定番のブラック色。</p>
  </article>
  <!-- ↑↑商品情報10ここまで↑↑ -->

  <!-- ↓↓商品情報11ここから↓↓ -->
  <article id="productName11">
  <img src="img/products11.jpg" alt="写真：ミーティングテーブル" width="150" height="150">
  <h1>ミーティングテーブル</h1>
  <p>シンプルなデザインで、高級な環境にふさわしいテーブルセットです。</p>
  </article>
  <!-- ↑↑商品情報11ここまで↑↑ -->

  <!-- ↓↓商品情報12ここから↓↓ -->
  <article id="productName12">
  <img src="img/products12.jpg" alt="写真：スケジュールボード" width="150" height="150">
  <h1>スケジュールボード</h1>
  <p>軽くて丈夫なアルミフレームで持運びも簡単なスケジュールボード(行動予定表)です。</p>
  </article>
  <!-- ↑↑商品情報12ここまで↑↑ -->

<!-- ↑カテゴリ3ここまで↑ -->

<!-- ↓ページのはじめに戻るリンク↓ -->
<p><a href="#top">↑このページのはじめに戻る</a></p>

</section>
</div>

<jsp:include page="navigation.jsp"></jsp:include>
<jsp:include page="footer.jsp">
	<jsp:param name="title" value="管理者画面"/>
</jsp:include>