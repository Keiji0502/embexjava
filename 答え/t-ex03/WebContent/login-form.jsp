<%@ page language="java" contentType="text/html; charset=Windows-31J"
    pageEncoding="Windows-31J"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=Windows-31J">
<title>���O�C�����</title>
</head>
<body>
	<div align="center">
		<font size="5" color="#000aff">���O�C�����</font>
	</div>
	<div align="center">
		<form action="login" method="POST">
			<h2>���O�ƃp�X���[�h����͂��Ă��������B</h2>
			<br>
			<table>
				<tr>
					<td align="left">���[�UID</td>
					<td align="left"><input type="text" name="USERID"></td>
				</tr>
				<tr>
					<td align="left">�p�X���[�h</td>
					<td align="left"><input type="password" name="PASSWORD"></td>
				</tr>
			</table>
			<br>
			<input type="submit" value="���O�C��" name="ACTION">&nbsp;&nbsp;
			<input type="reset" value="�N���A">
		</form>
	</div>
</body>
</html>