<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>カフェサイト「いっぷく」ログアウト</title>
<link rel="stylesheet" href="CSS/Logout1.css">
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
.hello {
	text-align: center;
}
</style>
<script>
function confirmLogout() {
    if (confirm("本当にログアウトしますか？")) {
        // ユーザーが OK をクリックした場合の処理
        // フォームをサブミットする
          alert("ログアウトしました。またのご利用を心よりお待ちしております。");
        document.getElementById("logoutForm").submit();
    } else {
        // ユーザーがキャンセルをクリックした場合の処理
        alert("ログアウトをキャンセルしました。");
        // フォームの送信をキャンセルする
        return false;
    }
}
</script>
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
<h1 class="Team">～ ログアウト ～</h1>
		    <center>
        
        <form id="logoutForm" action="LogoutServlet" method="post" onsubmit="return confirmLogout()">
            <p>ログアウトしますか？</p>
            
            <table>
            
                <tr>
                    <td><input type="submit" value="ログアウト" class="logoutbutton1"></td>
                </tr>
            </table>
        </form>
    </center>
	</main>
<footer style="font-size:20px; background-color: #F6F5EA; color: rgb(85, 60, 34); text-align:center; font-weight: bold; margin: -8px; padding: 16px;">
    ©Nyandaful
</footer>

</body>

</html>