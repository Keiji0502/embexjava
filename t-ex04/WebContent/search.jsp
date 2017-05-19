<%@page import="beans.Bookbean"%>
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
ArrayList<Bookbean> book_arry=new ArrayList<Bookbean>();
book_arry=(ArrayList<Bookbean>)request.getAttribute("book_arry");




%>

<form action="BookManagementServlet" method="post">
<table border="1">

<tr>
<td>書式名</td>
<td><input type="text" name="book_title" size="50"></td>
<td>著者名</td>
<td><input type="text" name="author_name" size="40"></td>
</tr>


<tr>
<td>出版社名</td>
<td><input type="text" name="publisher_name" size="30"></td>
<td>出版年</td>
<td><input type="text" name="publisher_year" size="10"></td>
<td>ISBNコード</td>
<td><input type="text" name="isbn_code" size="20"></td>
<td align="right">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="検索" name="code"><input type="submit" value="新規登録" name="code"></td>
</tr>



</table>

</form>

<form action="BookManagementServlet" method="post">
<input type="submit" value="削除" name="code">
<table border="2">
<tr>
<th>削除</th>
<th>No</th>
<th>書籍名</th>
<th>著作名</th>
<th>出版社名</th>
<th>出版社年</th>
<th>ISBNコード</th>


</tr>


<%
int i=1;
	if (!(book_arry == null)) {
for(Bookbean rec :book_arry ){

%>
<tr>
<td><input type="checkbox" name="delete_ck"  value="<%=rec.getId()%>"></td>
<td><%=rec.getId()%></td>
<td><%=rec.getBook_title()%></td>
<td><%=rec.getAuthor_name()%></td>
<td><%=rec.getPublisher_name()%></td>
<td><%=rec.getPublisher_year()%></td>
<td><%=rec.getIsbn_code()%></td>
</tr>

<%i++;	}

}



%>

</table>
</form>
</body>
</html>