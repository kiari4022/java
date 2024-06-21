<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Page</title>
</head>
<body  style="font-size: 20px; font-weight: bold;">
	<header style="display:flex;">
		<img src="IMG/0.png" alt="ロゴ" class="logo" style="width: 150px;">
		<nav class="nav-left">


			<p style="padding-top:40px;">
				<a href="TopServlet" style="font-size: 32px; text-decoration: none;">TOP</a>
				<a href="PostServlet"
					style="font-size: 32px; text-decoration: none;">投稿</a> <a
					href="ExplanasionServlet"
					style="font-size: 32px; text-decoration: none;">用語解説</a> <a
					href="MyPageServlet"
					style="font-size: 32px; text-decoration: none;">マイページ</a>
			
			
			<a href="ExplanasionServlet" style="font-size: 32px; text-decoration: none;">TaaaaOP</a>
			
			</p>
		</nav>

	</header>
	<main>
	<h1>過去の自分の投稿</h1>
	
<c:forEach var="post" items="${post}"> 
	<table>
		<tr>
			<td>日付：</td>
			<td>${post.date}</td>
		</tr>
	</table>
	<img src="${post.photo}" alt="写真" style="width: 450px;">
	<table>
		<tr>
			<td>UserID：</td>
			<td>${post.userID}</td>
		</tr>
		<tr>
			<td>お店：</td>
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
			<td>料金：</td>
			<td>${post.price}円</td>
		</tr>
		<td>最寄駅からの時間：</td>
		<td>${post.time}分</td>
		</tr>
		<tr>
			<td>住所：</td>
			<td>${post.address}</td>
		</tr>
		<tr>

			<!-- コメントをはずしてpostを${post.text}みたく全部に追加！！！！ -->
	</table>
	</c:forEach>

	</main>
	<footer> <h4 style="text-align:center;">©Nyandaful</h4> </footer>
</body>
</html>