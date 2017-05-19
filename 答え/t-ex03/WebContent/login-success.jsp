<%@ page language="java" contentType="text/html; charset=Windows-31J"
    pageEncoding="Windows-31J"%>
<%@ page import="model.entity.UserBean"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=Windows-31J">
<title>ログイン成功画面</title>
</head>
<body>
    <div align="center">
        <font size="5" color="#000aff">ログイン成功画面</font>
    </div>
    <div align="center">
        <h2>ユーザ情報</h2>
        <br>
        <%
            UserBean userBean = (UserBean)session.getAttribute("userBean");
        %>
        <table>
            <tr>
                <td align="left">氏名</td>
                <td align="left"><%=userBean.getName()%></td>
            </tr>
            <tr>
                <td align="left">氏名（カナ）</td>
                <td align="left"><%=userBean.getKanaName()%></td>
            </tr>
            <tr>
                <td align="left">性別</td>
                <td align="left"><%=userBean.getStrSex()%></td>
            </tr>
            <tr>
                <td align="left">年齢</td>
                <td align="left"><%=userBean.getAge()%></td>
            </tr>
        </table>
        <br>
        <form action="login" method="POST">
            <input type="submit" value="ログアウト" name="ACTION">
        </form>
    </div>
</body>
</html>