<%@ page language="java" contentType="text/html; charset=Windows-31J"
    pageEncoding="Windows-31J"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=Windows-31J">
<title>�^�X�N�ꗗ���</title>
</head>
<body>
    <form action="TaskListServlet" method="GET">
        <input type="submit" value="�߂�">
    </form>
    <form action="TaskListServlet" method="POST">
        <input type="submit" value="�N���A" name="ACTION">
    </form>
    <table border="double">
        <tr>
            <td>�^�X�N��</td>
            <td>�J�n����</td>
            <td>�I������</td>
            <td>���e</td>
        </tr>
    </table>
</body>
</html>