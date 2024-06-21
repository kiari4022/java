<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>カフェサイト「いっぷく」TOP</title>

<link rel="stylesheet" type="text/css"
	href="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.css">
<link rel="stylesheet" type="text/css" href="CSS/Top1.css">
<link href="https://fonts.googleapis.com/earlyaccess/sawarabimincho.css"
	rel="stylesheet" />
<link rel="icon" href="IMG/logo.png" type="IMG/logo/png">
<style> body {
	background-image: url('IMG/CafeBack5.jpg');
	/* 背景となる画像のURLを指定します */
	background-size: cover;
	/* 画面全体に背景画像を広げます */
	background-position: center;
	/* 背景画像を中央に配置します */
	font-family: "Sawarabi Mincho";
	background-attachment: fixed;
	/* 背景画像を固定する */
}
</style>
</head>
<body>


	<header style="display: flex;">
		<nav>

			<img src="IMG/logo4.png" style="width: 85px; margin-left: 60px;">
			<img src="IMG/logomoji.png" alt="ロゴ"
				style="width: 200px; margin-bottom: 20px; margin-left: 10px;">
			<span class="welcome" style="margin-left: 30px;">ようこそ、 <c:out
					value="${sessionScope.session.name}" /> さん
			</span>
			<ul>
				<li><a href="TopServlet" style="text-decoration: none;">TOP</a></li>
				<li><a href="PostServlet" style="text-decoration: none;">投稿</a></li>
				<li><a href="ExplanasionServlet" style="text-decoration: none;">用語解説</a></li>
				<li><a href="MyPageServlet" style="text-decoration: none;">マイページ</a></li>
				<form action="LogoutCheckServlet" method="post">
					<input type="submit" value="ログアウト" class="logoutbutton"><br>
				</form>
			</ul>
		</nav>

	</header>


	<main>
		<ul class="slider" style="margin-right:56px;">
			<li><img src="IMG/cafe1.jpg" alt=""></li>
			<li><img src="IMG/cafe2.jpg" alt=""></li>
			<li><img src="IMG/cafe3.jpg" alt=""></li>
			<li><img src="IMG/cafe4.jpg" alt=""></li>
			<li><img src="IMG/cafe5.jpg" alt=""></li>
			<!--/slider-->
		</ul>


		<ul>
			<section id="posts"  style="margin-right:90px;">
				<br> <br><br><br>
				<h1 style="text-align: center;">～ 当サイトをご利用される方へ ～</h1>
				<p style="text-align: center; margin-top:50px;   margin-top: 50px; line-height: 2.3;">
				当サイトは高齢者向けのカフェ投稿サイトです。<br>
				大きな文字やわかりやすいデザインで、ストレスなく情報を閲覧できます。<br>
				地域のカフェ情報やバリアフリー設備を明確に提示し、<br>
				安心して外出をサポートします。<br>
				専門用語解説も含め、気軽にカフェを楽しんでいただけます。<br>
				新たな憩いの場を見つけ、交流を楽しんでください。<br>
				当サイトでは、地域社会への参加を支援を自信をもってお手伝いします。<br>
				</p>
				<div class="post"></div>
				<div class="post"></div>
				<div class="post"></div>
				<div class="post"></div>
			</section>
		</ul>

		<p>
			<br> <br> <br> <br> <br> <br> <br>
			<br> <br> <br> <br> <br> <br> <br>
			<br> <br> <br> <br> <br> <br> <br>
			<br>
		</p>



	</main>

	<footer
		style="font-size: 20px; background-color: #F6F5EA; color: rgb(85, 60, 34); text-align: center; font-weight: bold; margin: -8px; padding: 16px;">
		©Nyandaful </footer>

	<script src="https://code.jquery.com/jquery-3.4.1.min.js"
		integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/slick-carousel@1.8.1/slick/slick.min.js"></script>
	<script src="js/TOP.js"></script>

</body>

</html>