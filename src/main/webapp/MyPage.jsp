<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>カフェサイト「いっぷく」マイページ</title>
<link rel="stylesheet" href="CSS/MyPage.css">
<link href="https://fonts.googleapis.com/earlyaccess/sawarabimincho.css"
	rel="stylesheet" />
<link rel="icon" href="IMG/logo.png" type="IMG/logo/png">	


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
		<h1 class="Team">～マイページ～</h1>
		<br>
		<form action="InsertServlet" method="post">
			<input type="submit" value="投稿する" class="postbutton"><br>
		</form>

		<h1 style = "transform: translate(120px,0px);">- - - - - 過去の自分の投稿 - - - - -</h1>

		<c:forEach var="post" items="${post}">
		
		<div class="table2">
	
			<img src="${post.photo}" alt="写真" 
			style="width: 450px; height: 320px;  object-fit: cover; overflow: hidden; transform: translate(220px,0px); border-radius:20px; " >
			
			<table>
				<tr>
					<td style="width:25%">店舗名</td>
					<td style="width:65%">${post.store}</td>
				</tr>
				<tr>
					<td style="width:25%">おすすめメニュー</td>
					<td style="width:65%">${post.menu}</td>
				</tr>
				<tr>
					<td style="width:25%">値段</td>
					<td style="width:65%">${post.price} 円</td>
				</tr>
				<tr>
					<td style="width:25%">訪れた日付</td>
					<td style="width:65%">${post.date}</td>
				</tr>
				<tr>
					<td style="width:25%">住所</td>
					<td style="width:65%">${post.address}</td>
				</tr>
				<tr>
				<td style="width:25%">最寄駅からの時間</td>
				<td style="width:65%">${post.time} 分</td>
				</tr>
				<tr>
					<td style="width:25%; transform: translate(0px,0px);" class="point">おすすめポイント</td>
					<td style="width:65%">${post.text}</td>
				</tr>
		

					<!-- コメントをはずしてpostを${post.text}みたく全部に追加！！！！ -->
			</table>

			<form action="UpdateServlet" method="post">
				<input type="submit" value="更新" class="updatebutton"><br>
				<input type="hidden" value="${post.postID}" name="postID">
			</form>
			<form action="DeleteCheckServlet" method="post">
				<input type="submit" value="削除" class="deletebutton"><br>
				<input type="hidden" value="${post.postID}" name="postID">
			</form>
			
		</div>	

		</c:forEach>
	</main>


	<footer style="font-size:20px; background-color: #F6F5EA; color: rgb(85, 60, 34); text-align:center; font-weight: bold; margin: -8px; padding: 16px;">
		©Nyandaful
		
	</footer>


</body>
</html>