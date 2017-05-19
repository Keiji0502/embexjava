<%@ page language="java" contentType="text/html; charset=Windows-31J"
    pageEncoding="Windows-31J"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=Windows-31J">
<title>タスク一覧画面</title>
</head>
<body>
    <form action="TaskListServlet" method="GET">
        <input type="submit" value="戻る">
    </form>
    <table border="double">
        <tr>
            <td>タスク名</td>
            <td>開始日時</td>
            <td>終了日時</td>
            <td>内容</td>
        </tr>
        <%
            ArrayList<HashMap<String, String>> list = (ArrayList<HashMap<String, String>>) session
                .getAttribute("list");

            for(int i = 0; i < list.size(); i++) {
                HashMap<String, String> data = list.get(i);
        %>

            <tr>
               <td><%=data.get("taskName") %></td>
               <td><%=data.get("startDate") %></td>
               <td><%=data.get("endDate") %></td>
               <td><%=data.get("content") %></td>
            </tr>
        <%
            }
        %>
    </table>
</body>
</html>