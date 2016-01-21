<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<jsp:include page="header.jsp">
	<jsp:param name="title" value="すぐくるTOP"/>
	<jsp:param name="filename" value="index"/>
</jsp:include>
<div id="contents">

<section id="search">
  <!-- ↓↓新商品リリースの見出し↓↓ -->
 <h1>SEARCH
  <!-- ↓↓新商品リリースの説明↓↓ -->
 <small>STATIONERYのオススメ商品をご紹介します。</small>
 </h1>
     <form class="" action="ProductListServlet.java" method="post">
       <input type="text" name="name">
       <input type="button" name="name" value="search">
     </form>
</section>



<!-- ↓メイン画像↓ -->
<img src="img/index01.jpg" alt="メインイメージ" width="680" height="300">

<!-- ↓新商品リリースここから↓ -->
<section id="release">
   <!-- ↓↓新商品リリースの見出し↓↓ -->
  <h1>新商品リリース
   <!-- ↓↓新商品リリースの説明↓↓ -->
  <small>STATIONERYのオススメ商品をご紹介します。</small>
  </h1>

  <!-- ↓↓新商品1ここから↓↓ -->
  <a href="products.html#productName1">
  <article>
  <img src="img/index02.jpg" alt="写真：帳薄ファイル" width="150" height="150">
  <h2>帳薄ファイル</h2>
  <p>高級感あふれるスタイリッシュで便利な帳簿用ファイル。丈夫で長持ちです。</p>
  </article>
  </a>
  <!-- ↑↑新商品1ここまで↑↑ -->

  <!-- ↓↓新商品2ここから↓↓ -->
  <a href="products.html#productName9">
  <article>
  <img src="img/index03.jpg" alt="写真：肘付椅子" width="150" height="150">
  <h2>肘付椅子 </h2>
  <p>高級感のあるファブリックを張地に使用したオフィスチェアです。</p>
  </article>
  </a>
  <!-- ↑↑新商品2ここまで↑↑ -->

  <!-- ↓↓新商品3ここから↓↓ -->
  <a href="products.html#productName2">
  <article>
  <img src="img/index04.jpg" alt="写真：ナンバリング" width="150" height="150">
  <h2>ナンバリング</h2>
  <p>高性能ポリグレ樹脂製グリップの5桁ナンバリング(スタンプ)です。樹脂グリップが手にかかる衝撃を吸収します。</p>
  </article>
  </a>
  <!-- ↑↑新商品3ここまで↑↑ -->

  <!-- ↓↓新商品4ここから↓↓ -->
  <a href="products.html#productName3">
  <article>
  <img src="img/index05.jpg" alt="写真：電話" width="150" height="150">
  <h2>電話</h2>
  <p>使いやすさを追求した電話機と多彩な機能で業務の効率化をサポート。オススメナンバー1！</p>
  </article>
  </a>
  <!-- ↑↑新商品4ここまで↑↑ -->

</section>
<!-- ↑新商品リリースここまで↑ -->

<!-- ↓ニュースここから↓ -->
<section id="news">
   <!-- ↓↓ニュースの見出し↓↓ -->
  <h1>ニュース
   <!-- ↓↓ニュースの説明↓↓ -->
  <small>STATIONERYからのニュースです</small>

  </h1>
  <!-- ↓↓ニュース1ここから↓↓ -->
  <a href="news.html#news130712">
  <article>
  <h2>7月22日(月)臨時閉店のお知らせ</h2>
  <p>7月22日(月)、18時に臨時閉店となります。</p>
  <time>2013.07.12</time>
  </article>
  </a>
  <!-- ↑↑ニュース1ここまで↑↑ -->

  <!-- ↓↓ニュース2ここから↓↓ -->
  <a href="news.html#news130612"><article>
  <h2>カ​タ​ロ​グ​表​記​訂​正​の​お​詫​び​と​お​知​ら​せ</h2>
  <p>STATIONERYカタログvol,6におきまして、表記に誤りのある部分がございました。</p>
  <time>2013.06.12</time>
  </article>
  </a>
  <!-- ↑↑ニュース2ここまで↑↑ -->

  <!-- ↓↓ニュース3ここから↓↓ -->
  <a href="news.html#news130513">
  <article>
  <h2>サーバメンテナンスのお知らせ</h2>
  <p>2013年5月16日13:00〜14:00　サーバーメンテナンスに伴い、一部のサービスが停止致します。</p>
  <time>2013.05.13</time>
  </article>
  </a>
  <!-- ↑↑ニュース3ここまで↑↑ -->

  <p><a href="news.html">ニュース一覧へ</a>
</section>
<!-- ↑ニュースここまで↑ -->
</div>
<jsp:include page="navigation.jsp"></jsp:include>
<jsp:include page="footer.jsp">
	<jsp:param name="title" value="管理者画面"/>
</jsp:include>
