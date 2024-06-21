<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="CSS/PostDetail.css">
<link href="https://fonts.googleapis.com/earlyaccess/sawarabimincho.css"
	rel="stylesheet" />
<link rel="icon" href="IMG/logo.png" type="IMG/logo.png">
<title>カフェサイト「いっぷく」投稿詳細</title>
<style>
body {
	background-image: url('IMG/cafe3.jpg'); /* 背景となる画像のURLを指定します */
	background-size: cover; /* 画面全体に背景画像を広げます */
	background-position: center; /* 背景画像を中央に配置します */
	background-attachment: fixed; /* 背景画像を固定 */
}
</style>
</head>
<body>



	<header style="display: flex;">
		<nav>

			<img src="IMG/logo4.png" style="width: 85px; margin-left: 60px;">
			<img src="IMG/logomoji.png" alt="ロゴ"
				style="width: 200px; margin-bottom: 20px; margin-left: 10px;">
			<span class="welcome" style="margin-left: 30px;">ようこそ、 ゲスト さん
			</span>
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
		<h1 class="Team">～ カフェの魅力をお届け ～</h1>
		<br>
		<c:if test="${empty errorMessage}">

			<img src="${post.photo}" alt="photo" class="photo"
				style="width: 950px; height: 620px; object-fit: cover; overflow: hidden;">
			<br>
			<br>
			<table style="width: 950px;">
				<!-- <tr>
					<td style="width: 35%;">投稿番号：</td>
					<td style="width: 65%;">${post.postID}</td>
				</tr>
				 <tr>
					<td style="width: 30%;">お客様ID：</td>
					<td style="width: 70%;">${post.userID}</td>
				</tr>-->
				<tr>
					<td style="width: 35%;">店舗名</td>
					<td style="width: 65%;">${post.store}</td>
				</tr>
				<tr>
					<td style="width: 35%;">おすすめメニュー</td>
					<td style="width: 65%;">${post.menu}</td>
				</tr>
				<tr>
					<td style="width: 35%;">値段</td>
					<td style="width: 65%;">${post.price}円</td>
				</tr>
				<tr>
					<td style="width: 35%;">訪れた日付</td>
					<td style="width: 65%;">${post.date}</td>
				</tr>
				<tr>
					<td style="width: 35%;">住所</td>
					<td style="width: 65%;">${post.address}</td>
				</tr>
				<tr>
					<td style="width: 35%;">最寄駅からの所要時間</td>
					<td style="width: 65%;">${post.time}分</td>
				</tr>
				<tr>
					<td style="width: 35%;">おすすめポイント</td>
					<td style="width: 65%;">${post.text}</td>
				</tr>
			</table>
		</c:if>
		<c:if test="${not empty errorMessage}">
			<p>${errorMessage}</p>
		</c:if>
		<br> <br> <br>
		<form action="GuestPostServlet">
			<input type="submit" value="戻る" class=backbutton>
		</form>

	</main>

<footer style="font-size:20px; background-color: #F6F5EA; color: rgb(85, 60, 34); text-align:center; font-weight: bold; margin: -8px; padding: 16px;">
    ©Nyandaful
</footer>
</body>
</html>