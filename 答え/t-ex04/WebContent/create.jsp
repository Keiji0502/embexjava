<%@ page language="java" contentType="text/html; charset=Windows-31J"
  pageEncoding="Windows-31J"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="Windows-31J">
<title>書籍登録画面</title>
</head>
<body>
    <form action="book" method="POST">
        <table border="1">
            <tr>
                <td>書籍名</td>
                <td><input type="text" size="60" name="bookTitle"></td>
            </tr>
            <tr>
                <td>著者名</td>
                <td><input type="text" size="50" name="authorName"></td>
            </tr>
            <tr>
                <td>出版社名</td>
                <td><input type="text" size="30" name="publisherName">
                </td>
            </tr>
            <tr>
                <td>出版年</td>
                <td><input type="text" size="6" name="publisherYear"></td>
            </tr>
            <tr>
                <td>ISBNコード</td>
                <td><input type="text" size="20" name="isbnCode"></td>
            </tr>
            <tr>
                <td colspan="2" align="right">
                    <input type="submit" value="キャンセル" name="ACTION">
                    <input type="submit" value="登録" name="ACTION">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>