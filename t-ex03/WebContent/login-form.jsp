<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="LoginManagementServlet" method="post">

		<div align="center">
			<h1>ログイン画面</h1>
			<h1>名前とパスワードを入力してください</h1>
		</div>
		<div align="center">
			ユーザID:<input type="text" name="user_id">
		</div>
		<div align="center">
			パスワード:<input type="password" name="user_pass">
		</div>
		<div align="center">
			<input type="submit" value="ログイン" name="login">
		</div>
	</form>


</body>
</html>