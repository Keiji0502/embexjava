<%@ page language="java" contentType="text/html; charset=Windows-31J"
  pageEncoding="Windows-31J"%>
<%@ page import="entity.BookBean"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="Windows-31J">
<title>���Ќ������</title>
</head>
<body>
    <form action="book" method="POST">
        <table border="1">
            <tr>
                <td>���Ж�</td>
                <td colspan="3"><input type="text" maxlength="60" size="90"
                  name="bookTitle"></td>
                <td>���Җ�</td>
                <td colspan="2"><input type="text" maxlength="50" size="75"
                  name="authorName"></td>
            </tr>
            <tr>
                <td>�o�ŎЖ�</td>
                <td><input type="text" maxlength="40" size="60"
                  name="publisherName"></td>
                <td>�o�ŔN</td>
                <td><input type="text" maxlength="4" size="6"
                  name="publisherYear"></td>
                <td>ISBN�R�[�h</td>
                <td><input type="text" maxlength="13" size="20" name="isbnCode">
                </td>
                <td align="right">
                    <input type="submit" value="����" name="ACTION">
                    <input type="submit" value="�V�K�o�^" name="ACTION">
                </td>
            </tr>
        </table>
    </form>
    <hr>
    <form action="book" method="POST">
        <input type="submit" value="�폜" name="ACTION">
        <table border="1">
            <col width="50px">
            <col width="50px">
            <tr>
                <td>�폜</td>
                <td>No.</td>
                <td>���Ж�</td>
                <td>���Җ�</td>
                <td>�o�ŎЖ�</td>
                <td>�o�ŔN</td>
                <td>ISBN�R�[�h</td>
            </tr>
            <%
               ArrayList<BookBean> bookList = (ArrayList<BookBean>) request
                       .getAttribute("bookList");
               if(bookList != null) {
                   for(int i = 0; i < bookList.size(); i++) {
                        BookBean book = bookList.get(i);
            %>
            <tr>
                <td align="center">
                    <input type="checkbox" name="delete" value="<%=book.getId()%>">
                </td>
                <td><%=i + 1%></td>
                <td><%=book.getBookTitle()%></td>
                <td><%=book.getAuthorName()%></td>
                <td><%=book.getPublisherName()%></td>
                <td><%=book.getPublisherYear()%></td>
                <td><%=book.getIsbnCode()%></td>
            </tr>
            <%
                   }
               }
            %>
        </table>
    </form>
</body>
</html>