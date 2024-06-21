<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>カフェサイト「いっぷく」投稿</title>
<link rel="stylesheet" href="CSS/Feature.css">
<link href="https://fonts.googleapis.com/earlyaccess/sawarabimincho.css"
	rel="stylesheet" />
		<link rel="icon" href="IMG/logo.png" type="IMG/logo.png">
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
			<span class="welcome" style="margin-left: 30px;">ようこそ、 <c:out
					value="${sessionScope.session.name}" /> さん
			</span>
			<ul>
				<li><a href="TopServlet">TOP</a></li>
				<li><a href="PostServlet">投稿</a></li>
				<li><a href="ExplanasionServlet">用語解説</a></li>
				<li><a href="MyPageServlet">マイページ</a></li>
				<form action="LogoutCheckServlet" method="post">
					<input type="submit" value="ログアウト" class="logoutbutton"><br>
				</form>
			</ul>
		</nav>
	</header>
	<main>
		<h1 class="Team">～ 店舗情報入力フォーム ～</h1>
		<form action="InsertCheckServlet" method="post"
			enctype="multipart/form-data">
			<table class="form">
<h3>全ての項目を入力してください。</h3>

				<!--"${userID}"にかえること！！！！-->
				
				<tr>
					<td>店舗名</td>
					<td><input type="text" id="shop" name="shop" id="text"></td>
				</tr>

				<tr>
					<td>おすすめメニュー</td>
					<td><input type="text" id="menu" name="menu" id="text"></td>
				</tr>

				<tr>
					<td>値段</td>
					<td><input type="text" id="price" name="price" id="text"> 円</td>
				</tr>

				<tr>
					<td>訪れた日付</td>
					<td><input type="date" id="date" name="date" id="text"></td>
				</tr>
				<tr>
					<td>住所</td>
					<td><input type="address" id="address" name="address" id="text"></td>
				</tr>
				<tr>
					<td>最寄駅からの時間</td>
					<td><input type="text" id="time" name="time" id="text"> 分</td>
				</tr>
				<tr>
					<td>おすすめポイント</td>
					<td><input type="text"  id="time" name="text"></td>
				</tr>
				<tr >
					<td>写真</td>
					<td><input type="file" id="photo" name="photo"></td>
				</tr>


			</table>

			<input type="submit" value="確認する" class="CheckButton">

		</form>
	</main>
	<footer style="font-size:20px; background-color: #F6F5EA; color: rgb(85, 60, 34); text-align:center; font-weight: bold; margin: -8px; padding: 16px;">
    ©Nyandaful
</footer>
</body>
</html>