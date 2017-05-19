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
ArrayList<ArrayList<String>> emp_list=new ArrayList<ArrayList<String>>();
emp_list =(ArrayList<ArrayList<String>>)session.getAttribute("emp_list");
String sex=null;

%>
<%=emp_list.get(0) %>
<form action="LoginManagementServlet" method="post">
<div align="center">
			<h1>ログイン成功画面</h1>
			<h1>ユーザー情報</h1>
		</div>
		<%for(ArrayList<String> rec: emp_list){ %>
		<div align="center">
			<p>氏名:<%=rec.get(0) %></p>
			<p>氏名(カナ):<%=rec.get(1) %></p>
			<%
				String i2 = rec.get(2);
					if (i2.equals("0")) {
						sex = "男";
					} else {
						sex = "女";
					}
			%>
			<p>性別:<%=sex%></p>
			<p>年齢:<%=rec.get(3) %></p>
	</div>
<%} %>

<div align="center"><input type="submit" value="ログアウト" name="login"></div>
</form>


</body>
</html>