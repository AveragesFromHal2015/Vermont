<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% request.setCharacterEncoding("UTF-8"); %>
	<div id="navigation">
	<!-- ↓ナビゲーションここから↓ -->
	<nav>
	<ul>
	  <li><a href="index.jsp">ホーム</a></li>
	  <li><a href="ProductListServlet">取り扱い商品</a>
	    <!-- ↓↓サブカテゴリー↓↓ -->
	    <ul>
	      <li><a href="products.jsp#category1">事務用品</a></li>
	      <li><a href="products.jsp#category2">パソコン周辺機器</a></li>
	      <li><a href="products.jsp#category3">デスク・チェア、他</a></li>
	    </ul>
	  </li>
	  <li><a href="shops.jsp">取り扱い店舗</a>
	    <!-- ↓↓サブカテゴリー↓↓ -->
	    <ul>
	      <li><a href="shops.jsp#aomori">青森</a></li>
	      <li><a href="shops.jsp#saitama">埼玉</a></li>
	      <li><a href="shops.jsp#tokyo">東京</a></li>
	    </ul>
	  </li>
	  <li><a href="news.jsp">ニュース一覧</a></li>
	  <li><a href="company.jsp">会社概要</a></li>
	</ul>
	</nav>
	<!-- ↑ナビゲーションここまで↑ -->
	</div>
