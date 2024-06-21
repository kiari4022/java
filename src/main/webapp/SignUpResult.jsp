<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>カフェサイト「いっぷく」新規登録完了</title>
<link rel="stylesheet" href="CSS/SignUp.css">
<link href="https://fonts.googleapis.com/earlyaccess/sawarabimincho.css"
	rel="stylesheet" />
<link rel="icon" href="IMG/logo.png" type="IMG/logo.png">
</head>
<body   style="background-color: #F6F5EA;">
	<div style="text-align: center; " >
		<img src="IMG/logo.png" width=15% height=15%>
	</div>

	<div class="container" style=" padding-bottom:140px;">
		<p class="fsize">新規登録完了</p>
		<form action="LoginServlet" method="post">
			<table>
				<tr><p class="result"style="padding-bottom:1px; transform:translate(10px,10px);">登録が完了しました。<br>さっそく始めましょう。</p>
				</tr>
				<tr  style="text-align:center;">
					<td><input type="submit" value="ログイン画面へ"  style="transform:translate(160px,109px);"></td>
				</tr>
			</table>
		</form>
	</div>

</body>
</html>