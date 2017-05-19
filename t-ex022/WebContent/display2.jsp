<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>



<form action="TaskListServlet" method="get">
<input type="submit" value="戻る">
</form>

<form action="TaskListServlet" method="post">
<input type="submit" value="クリア" name="botan">
</form>
<table border="1">

<tr>
<th>タスク名</th>
<th>開始日時</th>
<th>終了日時</th>
<th>内容</th>
</tr>







</table>






</body>
</html>