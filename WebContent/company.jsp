<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="header.jsp">
	<jsp:param value="title" name="会社概要"/>
	<jsp:param value="filename" name="company"/>
</jsp:include>
<div id="contents">
<section>
<!-- ↓ページの見出し↓ -->
<h1>会社概要
<!-- ↓ページの説明↓ -->
<small>STATIONERYでは皆様のご来店をスタッフ一同お待ちいたしております。</small>
</h1>

<!-- ↓会社概要ここから↓ -->
<article>

  <!-- ↓↓画像↓↓ -->
  <img src="img/company01.jpg" alt="会社イメージ画像" width="210" height="255">

  <!-- ↓↓会社情報ここから↓↓ -->
  <table>
  <tr>
    <th scope="row">社名</th>
    <td>STATIONERY</td>
  </tr>
  <tr>
    <th scope="row">代表者</th>
    <td>山田B郎</td>
  </tr>
  <tr>
    <th scope="row">創業</th>
    <td>2000年</td>
  </tr>
  <tr>
    <th scope="row">事業内容</th>
    <td>文具 オフィス家具 OA機器販売</td>
  </tr>
  <tr>
    <th scope="row">従業員数</th>
    <td>120名</td>
  </tr>
  <tr>
    <th scope="row">資本金</th>
    <td>5,000万</td>
  </tr>
  </table>
  <!-- ↑↑会社情報ここまで↑↑ -->

</article>
<!-- ↑会社概要ここまで↑ -->
<!-- ↓↓アクセス情報ここから↓↓ -->
  <dl>
    <dt>TEL</dt>
    <dd>000-000-0000</dd>
    <dt>FAX</dt>
    <dd>000-000-0000</dd>
    <dt>E-Mail</dt>
    <dd><a href="mailto:info@******">info@******</a></dd>
    <!-- ▼▼改行▼▼ -->
    <dt class="newLine">住所</dt>
    <dd>〒000-0000<br>
    東京都○○町1-2-3　△△△10階</dd>
  </dl>

  <!-- ↓↓アクセス情報ここから↓↓ -->
  <dl>
    <dt>TEL</dt>
    <dd>000-000-0000</dd>
    <dt>FAX</dt>
    <dd>000-000-0000</dd>
    <dt>E-Mail</dt>
    <dd><a href="mailto:info@******">info@******</a></dd>
    <!-- ▼▼改行▼▼ -->
    <dt class="newLine">住所</dt>
    <dd>〒000-0000<br>
    東京都○○町1-2-3　△△△10階</dd>
  </dl>

  <!-- ↓↓補足説明↓↓ -->
  <p>お車でお越しの際の最寄高速道路出口は、都心環状線「神田橋出口」「霞ヶ関出口」「丸の内出口（外回り出口専用）」などになります。</p>
  <!-- ↑↑アクセス情報ここまで↑↑ -->

</article>
<!-- ↑アクセスここまで↑ -->

</section>
</div>

<div id="navigation">
<!-- ↓ナビゲーションここから↓ -->
<nav>
<ul>
  <li><a href="index.html">ホーム</a></li>
  <li><a href="products.html">取り扱い商品</a>
    <!-- ↓↓サブカテゴリー↓↓ -->
    <ul>
      <li><a href="products.html#category1">事務用品</a></li>
      <li><a href="products.html#category2">パソコン周辺機器</a></li>
      <li><a href="products.html#category3">デスク・チェア、他</a></li>
    </ul>
  </li>
  <li><a href="shops.html">取り扱い店舗</a>
    <!-- ↓↓サブカテゴリー↓↓ -->
    <ul>
      <li><a href="shops.html#aomori">青森</a></li>
      <li><a href="shops.html#saitama">埼玉</a></li>
      <li><a href="shops.html#tokyo">東京</a></li>
    </ul>
  </li>
  <li><a href="news.html">ニュース一覧</a></li>
  <li><a href="company.html">会社概要</a></li>
</ul>
</nav>
<!-- ↑ナビゲーションここまで↑ -->
</div>

<jsp:include page="footer.jsp">
	<jsp:param value="title" name="管理者画面"/>
</jsp:include>