<%@ page language="java" contentType="text/html; charset=Windows-31J"
    pageEncoding="Windows-31J"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=Windows-31J">
<title>ログイン画面</title>
</head>
<body>
	<div align="center">
		<font size="5" color="#000aff">ログイン画面</font>
	</div>
	<div align="center">
		<form action="login" method="POST">
			<h2>名前とパスワードを入力してください。</h2>
			<br>
			<table>
				<tr>
					<td align="left">ユーザID</td>
					<td align="left"><input type="text" name="USERID"></td>
				</tr>
				<tr>
					<td align="left">パスワード</td>
					<td align="left"><input type="password" name="PASSWORD"></td>
				</tr>
			</table>
			<br>
			<input type="submit" value="ログイン" name="ACTION">&nbsp;&nbsp;
			<input type="reset" value="クリア">
		</form>
	</div>
</body>
</html>