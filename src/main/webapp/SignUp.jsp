<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>カフェサイト「いっぷく」新規登録</title>
<link rel="stylesheet" href="CSS/SignUp.css">
<link href="https://fonts.googleapis.com/earlyaccess/sawarabimincho.css"
	rel="stylesheet" />
<link rel="icon" href="IMG/logo.png" type="IMG/logo.png">
</head>
<body   style="background-color: #F6F5EA;">
	<div style="text-align: center">
		<img src="IMG/logo.png" width=15% height=15%>
	</div>

	<div class="container">
		<p class="fsize">新規登録</p>
		<form action="SignUpCheckServlet" method="post">
			<table>
				<tr>
					<td style="font-weight:bold;">名前</td>
					<td><input type="text" name="name" id="name"></td>
				</tr>
				<tr>
					<td style="font-weight:bold;">電話番号</td>
					<td><input type="tel" name="tell" id="name"></td>
				</tr>
				<tr>
					<td style="font-weight:bold;">パスワード</td>
					<td><input type="password" name="pass" id="name"></td>
				</tr>
				<tr>
					<td style="font-weight:bold;">パスワード確認用</td>
					<td><input type="password" name="repass" id="name"></td>
				</tr>
				<tr>
					<td style="font-weight:bold;">生年月日</td>
					<td><input type="date" name="date" id="name"></td>
				</tr>
				<tr>
					<td style="transform:translate(160px,22px);"><input type="submit" value="確認"></td>
				</tr>
			</table>
		</form>

	</div>
</body>
</html>