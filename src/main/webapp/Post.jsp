<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="CSS/Post.css">
<link href="https://fonts.googleapis.com/earlyaccess/sawarabimincho.css"
	rel="stylesheet" />
		<link rel="icon" href="IMG/logo.png" type="IMG/logo.png">
	<title>カフェサイト「いっぷく」投稿</title>
<style>
body {
	background-image: url('IMG/cafe3.jpg'); /* 背景となる画像のURLを指定します */
	background-size: cover; /* 画面全体に背景画像を広げます */
	background-position: center; /* 背景画像を中央に配置します */
}
footer {
    margin: 0;
    padding: 0;
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


	<main >
		<h1 class="Team">～ みなさまの投稿一覧 ～</h1>
		<br> <br>
		<div class="Post">
			<c:forEach var="post" items="${post}">
				<form action="PostDetailServlet" method="post">
					<input type="hidden" name="PostID" value="${post.postID}">
				
					<!-- method属性をpostに設定 -->
					<!-- <table>
				<tr>
											<td>お出かけ日：</td>
						<td>${post.date}</td> 
					</tr>
				</table>-->
					<br>
					<table>

						<tr>
							<img src="${post.photo}" alt="写真" class="photo"
								style="width: 450px; height: 320px; object-fit: cover; overflow: hidden;">
						</tr>
					<!-- 	
						<tr>
							<input type="hidden" name="PostID" value="${post.postID}">
							<td>投稿：</td>
							<td>${post.postID}</td>
						</tr>
						 <table>
			<tr>
				<td>お店の名前：</td>
				<td>${post.store}</td>
			</tr>
			<tr>
				<td>おすすめポイント：</td>
				<td>${post.text}</td>
			</tr>
			<tr>
				<td>おすすめメニュー：</td>
				<td>${post.menu}</td>
			</tr>
			<tr>
				<td>お値段：</td>
				<td>${post.price}円</td>
			</tr>
			<tr>
				<td>最寄駅からの所要時間：</td>
				<td>${post.time}分</td>
			</tr>
			<tr>
				<td>お店の場所：</td>
				<td>${post.address}</td>
			</tr>
	  <input type="image" src="photo.jpg" alt="写真">
		</table>
		-->
					</table>
					<br> <input  type="submit" value="店名・詳細をみる" class="button">

				</form>
				<br>
				<br>
			</c:forEach>
		</div>

	</main>
<footer style="font-size:20px; background-color: #F6F5EA; color: rgb(85, 60, 34); text-align:center; font-weight: bold; margin: -8px; padding: 16px;">
    ©Nyandaful
</footer>
</body>
</html>