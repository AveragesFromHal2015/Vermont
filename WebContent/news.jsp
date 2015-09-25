<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="header.jsp">
	<jsp:param value="title" name="ニュース一覧"/>
	<jsp:param value="filename" name="news"/>
</jsp:include>
	<div id="contents">
	<section>
	<!-- ↓ページの見出し↓ -->
	<h1>ニュース一覧
	<!-- ↓ページの説明↓ -->
	<small>STATIONERYからのお知らせです</small>
	</h1>
	
	<!-- ↓ニュースここから↓ -->
	<%
	/* 
	<article id="記事のID">
	  <h1>記事のタイトル</h1>
	  <time>時間</time>
	  <p>説明文</p>
	</article>
	*/
	
	%>
	<!-- ↓↓ニュース1ここから↓↓ -->
	<article id="news130712">
	  <h1>7月22日(月)臨時閉店のお知らせ</h1>
	  <time>2013.07.12</time>
	  <p>7月22日(月)、18時に臨時閉店となります。<br>
	  ご来店を予定されていたお客様には大変ご迷惑をおかけしますが、よろしくお願い致します。<br>
	  <a href="shops.html">取り扱い店舗ページへ</a>
	  </p>
	</article>
	<!-- ↑↑ニュース1ここまで↑↑ -->
	  
	<!-- ↓↓ニュース2ここから↓↓ -->
	<article id="news130612">
	  <h1>カ​タ​ロ​グ​表​記​訂​正​の​お​詫​び​と​お​知​ら​せ</h1>
	  <time>2013.06.12</time>
	  <p>いつもSTATIONERYをご利用いただきまして誠にありがとうございます。<br>
	  STATIONERYカタログvol,6におきまして、表記に誤りのある部分がございました。<br>
	  この度は、お客様にご迷惑をおかけいたしますことお詫び申し上げます。</p>
	</article>
	<!-- ↑↑ニュース2ここまで↑↑ -->
	  
	<!-- ↓↓ニュース3ここから↓↓ -->
	<article id="news130513">
	  <h1>サーバメンテナンスのお知らせ</h1>
	  <time>2013.05.13</time>
	  <p>サーバーメンテナンスに伴い、下記時間帯の間、一部のサービスが停止致します。<br>
	  ＜期間＞2013年5月16日13:00〜14:00 </p>
	</article>
	<!-- ↑↑ニュース3ここまで↑↑ -->
	
	<!-- ↑ニュースここまで↑ -->  
	</section>
	
	</div>
<jsp:include page="navigation.jsp"></jsp:include>
<jsp:include page="footer.jsp">
	<jsp:param value="title" name="管理者画面"/>
</jsp:include>
