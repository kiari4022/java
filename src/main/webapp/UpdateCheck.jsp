<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>カフェサイト「いっぷく」更新確認</title>
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
		<h1 class="Team">～ 更新内容確認 ～</h1>
	
		<!-- ここにコードを記載 -->
		<form action="UpdateResultServlet" method="post">
			<table  class="form"  style="width: 900px;">
				<input type="hidden" name="userID" value="${userID}" />
				<input type="hidden" name="postID" value="${postID}" />
				<input type="hidden" name="date" value="${date}" />
				<h3>更新内容を確認してください。</h3>
				<tr>
					<td style="width: 35%;">店舗名</td>
					<td style="width: 65%;"><c:out value="${shop}" /></td>
					<input type="hidden" name="store" value="${shop}" />
				</tr>
				<tr>
					<td style="width: 35%;">おすすめメニュー</td>
					<td style="width: 65%;"><c:out value="${menu}" /></td>
					<input type="hidden" name="menu" value="${menu}" />
				</tr>
				<tr>
					<td style="width: 35%;">値段</td>
					<td style="width: 65%;"><c:out value="${price}" />円</td>
					<input type="hidden" name="price" value="${price}" />
				</tr>
				<tr>
					<td style="width: 35%;">訪れた日付</td>
					<td style="width: 65%;">${date}</td>
					<input type="hidden" name="date" value="${date}" />
				</tr>
				<tr>
					<td style="width: 35%;">住所</td>
					<td style="width: 65%;"><c:out value="${address}" /></td>
					<input type="hidden" name="address" value="${address}" />
				</tr>
				<tr>
					<td style="width: 35%;">最寄駅からの時間</td>
					<td style="width: 65%;"><c:out value="${time}" />分</td>
					<input type="hidden" name="time" value="${time}" />
				</tr>
				<tr>
					<td style="width: 35%;">おすすめポイント</td>
					<td style="width: 65%;"><c:out value="${text}" /></td>
					<input type="hidden" name="text" value="${text}" />
				</tr>
				<tr>
					<td style="width: 35%;">写真</td>
					<td style="width: 65%;"><img src="${requestScope.photo}" style="border:solid 4px rgb(85, 60, 34); width: 400px; height: 300px; object-fit: cover; overflow: hidden;"/></td>
					<td><input type="hidden" name="picture"
						value="${requestScope.photo}" />
				</tr>
				
			</table>
			<input type="submit" class="FeatureButton" value="みんなに教える" >
		</form>
		<form action="UpdateServlet" method="post" >
			<input type="submit" value="戻る"  class="backbutton">
			<input type="hidden" value="${requestScope.postID}" name="postID"><br>
		
		</form>
	</main>
	<footer style="font-size:20px; background-color: #F6F5EA; color: rgb(85, 60, 34); text-align:center; font-weight: bold; margin: -8px; padding: 16px;">
    ©Nyandaful
</footer>
</body>
</html>