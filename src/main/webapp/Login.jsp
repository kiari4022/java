<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン</title>
<link rel="stylesheet" href="CSS/Login.css">
</head>
<body  style="background-color: #F6F5EA;">
	<div style="text-align: center">
		<img src="IMG/logo.png" width=15% height=15%>
	</div>

	<div class="container">
		<p class="fsize">ログイン画面</p>
		<form action="LoginServlet" method="post">
	
				
					<p class="title">電話番号</p>
					<input type="text" name="phone"><br>
				
				
					<p class="title">パスワード</p>
					<input type="password" name="pass"><br>
				

			<input type="submit" value="ログイン">
		</form>
		<br>


		<form action="SignUpServlet" method="post">
					<td style="text-align: center;"><input type="submit" value="新規登録"></td>
		</form>
		<br>

		<form action="GestServlet" method="post">	
					<td style="text-align: center;"><input type="submit" value="ゲスト"></td>
				
		</form>
	</div>

</body>
</html>