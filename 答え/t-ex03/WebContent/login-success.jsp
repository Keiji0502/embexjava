<%@ page language="java" contentType="text/html; charset=Windows-31J"
    pageEncoding="Windows-31J"%>
<%@ page import="model.entity.UserBean"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=Windows-31J">
<title>���O�C���������</title>
</head>
<body>
    <div align="center">
        <font size="5" color="#000aff">���O�C���������</font>
    </div>
    <div align="center">
        <h2>���[�U���</h2>
        <br>
        <%
            UserBean userBean = (UserBean)session.getAttribute("userBean");
        %>
        <table>
            <tr>
                <td align="left">����</td>
                <td align="left"><%=userBean.getName()%></td>
            </tr>
            <tr>
                <td align="left">�����i�J�i�j</td>
                <td align="left"><%=userBean.getKanaName()%></td>
            </tr>
            <tr>
                <td align="left">����</td>
                <td align="left"><%=userBean.getStrSex()%></td>
            </tr>
            <tr>
                <td align="left">�N��</td>
                <td align="left"><%=userBean.getAge()%></td>
            </tr>
        </table>
        <br>
        <form action="login" method="POST">
            <input type="submit" value="���O�A�E�g" name="ACTION">
        </form>
    </div>
</body>
</html>