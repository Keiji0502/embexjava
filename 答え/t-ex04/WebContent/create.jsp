<%@ page language="java" contentType="text/html; charset=Windows-31J"
  pageEncoding="Windows-31J"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="Windows-31J">
<title>���Гo�^���</title>
</head>
<body>
    <form action="book" method="POST">
        <table border="1">
            <tr>
                <td>���Ж�</td>
                <td><input type="text" size="60" name="bookTitle"></td>
            </tr>
            <tr>
                <td>���Җ�</td>
                <td><input type="text" size="50" name="authorName"></td>
            </tr>
            <tr>
                <td>�o�ŎЖ�</td>
                <td><input type="text" size="30" name="publisherName">
                </td>
            </tr>
            <tr>
                <td>�o�ŔN</td>
                <td><input type="text" size="6" name="publisherYear"></td>
            </tr>
            <tr>
                <td>ISBN�R�[�h</td>
                <td><input type="text" size="20" name="isbnCode"></td>
            </tr>
            <tr>
                <td colspan="2" align="right">
                    <input type="submit" value="�L�����Z��" name="ACTION">
                    <input type="submit" value="�o�^" name="ACTION">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>