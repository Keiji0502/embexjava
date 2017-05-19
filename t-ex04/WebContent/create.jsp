<%@page import="beans.DBConnector"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%><%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		ArrayList<ArrayList<String>> book_arry = new ArrayList<ArrayList<String>>();
		book_arry = (ArrayList<ArrayList<String>>) session.getAttribute("book_arry");
	%>
	<form action="BookManagementServlet" method="post">
		<table border="2">
			<tr>
				<td>書式名</td>
				<td><input type="text" name="book_title" size="50"></td>
			</tr>

			<tr>
				<td>著者名</td>
				<td><input type="text" name="author_name" size="40"></td>
			</tr>

			<tr>
				<td>出版社名</td>
				<td><input type="text" name="publisher_name" size="30"></td>
			</tr>

			<tr>
				<td>出版年</td>
				<td><input type="text" name="publisher_year" size="10"></td>
			</tr>

			<tr>
				<td>ISBNコード</td>
				<td><input type="text" name="isbn_code" size="20"></td>
			</tr>

			<tr>
				<td></td>
				<td align="right"><input type="submit" value="キャンセル"
					name="code"><input type="submit" value="登録" name="code"></td>


			</tr>


		</table>

	</form>
</body>
</html>