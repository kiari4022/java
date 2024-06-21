<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>カフェサイト「いっぷく」更新</title>
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

			<img src="IMG/logo2.png" style="width: 85px; margin-left: 60px;">
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
		<h1 class="Team">～ 更新内容入力フォーム ～</h1>
		<form action="UpdateCheckServlet" method="post"
			enctype="multipart/form-data">
			<table class="form" style="width: 900px; margin-top: -250px;">
				<h3>更新したい項目を入力してください。</h3>
				<h3 style="text-decoration: underline; ">お手数ですが、写真は再度ご提示ください。</h3>
				<input type="hidden" name="userID"
					value="${requestScope.post.userID}">
				<input type="hidden" name="postID"
					value="${requestScope.post.postID}">
				<tr>
					<td style="width: 35%;">店舗名</td>
					<td style="width: 65%;"><input type="text" name="store"
						id="store" value="${requestScope.post.store}"></td>
				</tr>
				<tr>
					<td style="width: 35%;">おすすめメニュー</td>
					<br>
					<td style="width: 65%;"><input type="text" name="menu"
						id="menu" value="${requestScope.post.menu}"></td>
				</tr>
				<tr>
					<td style="width: 35%;">値段</td>
					<br>
					<td style="width: 65%;"><input type="text" name="price"
						id="price" value="${requestScope.post.price}"></td>
				</tr>
				<tr>
					<td style="width: 35%;">訪れた日付</td>
					<br>
					<td style="width: 65%;"><input type="date" name="date"
						id="date" value="${requestScope.post.date}"></td>
				</tr>
				<tr>
					<td style="width: 35%;">住所</td>
					<br>
					<td style="width: 65%;"><input type="text" name="address"
						id="address" value="${requestScope.post.address}"></td>
				</tr>
				<tr>
					<td style="width: 35%;">最寄駅からの時間</td>
					<br>
					<td style="width: 65%;"><input type="text" name="time"
						id="time" value="${requestScope.post.time}"></td>
				</tr>
				<tr>
					<td style="width: 35%;">おすすめポイント</td>
					<br>
					<td style="width: 65%;"><input type="text" name="text"
						id="text" value="${requestScope.post.text}"></td>
				</tr>
				<tr>
					<td style="width: 35%;">写真</td>
					<br>
					<td style="width: 65%;"><img src="${requestScope.post.photo}"
						style="border:solid 4px rgb(85, 60, 34); width: 400px; height: 300px; object-fit: cover; overflow: hidden;" /></td>
					<td><input type="hidden" name="pic"
						value="${requestScope.post.photo}" accept="image/*"></td>
				</tr>
				<table class="File">
					<tr>
						<td><input type="file" name="picture" accept="image/*"
							id="photo"></td>
					</tr>
				</table>



			</table>

			<!-- ここにコードを記載 -->
			<input type="submit" value="確認する" class="CheckButton">
		</form>
	</main>
	<footer style="font-size:20px; background-color: #F6F5EA; color: rgb(85, 60, 34); text-align:center; font-weight: bold; margin: -8px; padding: 16px;">
    ©Nyandaful
</footer>
</body>
</html>