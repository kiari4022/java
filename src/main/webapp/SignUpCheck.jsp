<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>カフェサイト「いっぷく」新規登録確認</title>
<link rel="stylesheet" href="CSS/SignUp.css">
<link href="https://fonts.googleapis.com/earlyaccess/sawarabimincho.css"
	rel="stylesheet" />
<link rel="icon" href="IMG/logo.png" type="IMG/logo.png">
</head>
<body   style="background-color: #F6F5EA;">
	<div style="text-align: center">
		<img src="IMG/logo.png" width=15% height=15%>
	</div>

	<div class="container" style=" padding-bottom:46px;">
		<p class="fsize">新規登録確認</p>
		<form action="SignResultServlet" method="post">
			<!--	request.getParameter("name")のときに必要なコード	-->
			<table class="Check" >
				<tr>
					<td style="font-weight:bold;">名前</td>
					<td id="name">${name}</td>
					<input type="hidden" value="${name}" name="name" id="name">
				</tr>

				<tr>
					<td style="font-weight:bold;">電話番号</td>
					<td  id="name">${tell}</td>
					<input type="hidden" value="${tell}" name="tell" id="name">
				<tr>
					<td style="font-weight:bold;">パスワード</td>
					<td  id="name">${pass}</td>
					<input type="hidden" value="${pass}" name="pass" id="name">
				</tr>

				<tr>
					<td style="font-weight:bold;">生年月日</td>
					<td id="name">${date}</td>
					<input type="hidden" value="${date}" name="date" id="name">
				</tr>



				<tr>
					<td style="transform:translate(132px,44px);"><input type="submit" value="新規登録する"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>