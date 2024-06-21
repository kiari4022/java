<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="CSS/Explanasion.css">
<link href="https://fonts.googleapis.com/earlyaccess/sawarabimincho.css"
	rel="stylesheet" />
<link rel="icon" href="IMG/logo.png" type="IMG/logo.png">
<title>カフェサイト「いっぷく」用語解説</title>
<style>
body {
	background-image: url('IMG/cafe3.jpg');
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
			<span class="welcome" style="margin-left: 30px;">ようこそ、 ゲスト さん </span>
			<ul>

				<li><a href="GestServlet">TOP</a></li>
				<li><a href="GuestPostServlet">投稿</a></li>
				<li><a href="GuestExplanasionServlet">用語解説</a></li>
				<form action="SignUpServlet" method="post">
					<input type="submit" value="新規登録" class="logoutbutton"><br>
				</form>
			</ul>
		</nav>
	</header>




	<main>


		<h1 class="Team">～ これで安心。カフェについての用語解説 ～</h1>
		<br> <br>
		<div class="Explanasion" style="font-size: 1.75rem;">
			<p>
			<p class="Title">～ カフェオレ ～</p>
			<br>エスプレッソに温かいミルクを加えたコーヒードリンクで、まろやかな味わいが特徴です。朝食時に人気のある一杯です。
			</p>

			<br> <br>

			<p>
			<p class="Title">～ エスプレッソ ～</p>
			<br>濃厚で香り高いコーヒーの一種で、高圧で抽出したコーヒーを指します。短時間で深い味わいを楽しむことができます。
			</p>

			<br> <br>

			<p>
			<p class="Title">～ カプチーノ ～</p>
			<br>エスプレッソに蒸しミルクを注ぎ、ミルクフォームをトッピングしたイタリアのコーヒードリンクです。豊かな泡立ちと濃厚な味わいが魅力です。
			</p>

			<br> <br>

			<p>
			<p class="Title">～ フラペチーノ ～</p>
			<br>フローズン状にしたエスプレッソや紅茶に、ミルクやシロップ、アイスクリームなどを混ぜ合わせた、甘くて爽やかなカフェドリンクです。
			</p>

			<br> <br>

			<p>
			<p class="Title">～ マキアート ～</p>
			<br>エスプレッソに少量の蒸しミルクを加えたイタリアのコーヒードリンクで、エスプレッソの力強さとミルクのまろやかさが絶妙にマッチした一杯です。
			</p>

		</div>

	</main>

	<footer
		style="font-size: 20px; background-color: #F6F5EA; color: rgb(85, 60, 34); text-align: center; font-weight: bold; margin: -8px; padding: 16px;">
		©Nyandaful </footer>
</body>
</html>