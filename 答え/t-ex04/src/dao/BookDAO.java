/*
 * 総合４ 解答例  BookDAO.java
 *
 * Copyright(C) 2016 emBex Education Inc. All Rights Reserved.
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import entity.BookBean;

/**
 * 書籍管理テーブルDAOクラス
 *
 * @author emBex Education
 * @version 1.00
 */
public class BookDAO {

    /**
     * 検索.
     *
     * @param param
     *            検索条件
     * @return 取得結果
     * @throws SQLException
     *             SQLエラー
     * @throws Exception
     *             接続エラー
     */
    public ArrayList<BookBean> select(BookBean param) throws Exception {

        ArrayList<BookBean> books = new ArrayList<BookBean>();
        StringBuffer sql = new StringBuffer("SELECT * FROM book ");

        // データベースへの接続の取得
        ConnectionManager cm = ConnectionManager.getInstance();

        try(Connection con = cm.getConnection();
                PreparedStatement pstmt = con.prepareStatement(sql.toString())) {

            // 何かしら検索条件が入力されていたら
            if(!(param.getBookTitle().isEmpty()
                    && param.getAuthorName().isEmpty()
                    && param.getPublisherName().isEmpty()
                    && param.getPublisherYear() == -1 && param.getIsbnCode()
                    .isEmpty())) {

                // WHERE句の追加
                sql.append("WHERE ");

                if(!param.getBookTitle().isEmpty()) {
                    sql.append("book_title LIKE ? AND ");
                }
                if(!param.getAuthorName().isEmpty()) {
                    sql.append("author_name = ? AND ");
                }
                if(!param.getPublisherName().isEmpty()) {
                    sql.append("publisher_name = ? AND ");
                }
                if(param.getPublisherYear() != -1) {
                    sql.append("publisher_year = ? AND ");
                }
                if(!param.getIsbnCode().isEmpty()) {
                    sql.append("isbn_code = ? AND ");
                }

                // 末尾のANDを削除
                sql.delete(sql.length() - 4, sql.length());

                // パラメーターの設定
                int setNum = 1;
                if(!param.getBookTitle().isEmpty()) {
                    // 書籍名はあいまい検索
                    pstmt.setString(setNum++, "%" + param.getBookTitle() + "%");
                }
                if(!param.getAuthorName().isEmpty()) {
                    // 著作者は前方一致検索
                    pstmt.setString(setNum++, param.getAuthorName() + "%");
                }
                if(!param.getPublisherName().isEmpty()) {
                    pstmt.setString(setNum++, param.getPublisherName());
                }
                if(param.getPublisherYear() != -1) {
                    pstmt.setInt(setNum++, param.getPublisherYear());
                }
                if(!param.getIsbnCode().isEmpty()) {
                    pstmt.setString(setNum++, param.getIsbnCode());
                }
            }

            // 検索処理
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()) {
                BookBean book = new BookBean();
                book.setId(rs.getInt(1));
                book.setBookTitle(rs.getString(2));
                book.setAuthorName(rs.getString(3));
                book.setPublisherName(rs.getString(4));
                book.setPublisherYear(rs.getInt(5));
                book.setIsbnCode(rs.getString(6));

                books.add(book);
            }
        } catch(SQLException e) {
            System.out.println("処理結果：異常が発生しました。");
            e.printStackTrace();
        }
        return books;
    }

    /**
     * 追加.
     *
     * @param book
     *            追加する書籍情報
     * @return 更新結果
     * @throws SQLException
     *             SQLエラー
     * @throws Exception
     *             接続エラー
     */
    public int insert(BookBean book) throws Exception {
        // 登録画面で入力された情報を追加
        String sql = "INSERT INTO book(book_title, author_name, publisher_name, publisher_year, isbn_code)"
                + " VALUES(?, ?, ?, ?, ?)";

        // データベースへの接続の取得
        ConnectionManager cm = ConnectionManager.getInstance();

        int result = 0;

        try(Connection con = cm.getConnection();
                PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setString(1, book.getBookTitle());
            pstmt.setString(2, book.getAuthorName());
            pstmt.setString(3, book.getPublisherName());
            pstmt.setInt(4, book.getPublisherYear());
            pstmt.setString(5, book.getIsbnCode());

            result = pstmt.executeUpdate();
        } catch(SQLException e) {
            System.out.println("処理結果：異常が発生しました。");
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 削除.
     *
     * @param ids
     *            削除ID（複数）
     * @return 削除件数
     * @throws SQLException
     *             SQLエラー
     * @throws Exception
     *             接続エラー
     */
    public int delete(String[] ids) throws Exception {

        if(ids == null) {
            return -1;
        }

        StringBuffer param = new StringBuffer();

        // 選択されたidから条件を作成
        for(String id : ids) {
            param.append(id);
            param.append(",");
        }

        if(param.length() > 0) {
            param.delete(param.length() - 1, param.length());
        }

        String sql = "DELETE FROM book WHERE id IN(" + param.toString() + ")";

        // データベースへの接続の取得
        ConnectionManager cm = ConnectionManager.getInstance();

        int result = 0;

        try(Connection con = cm.getConnection();
        PreparedStatement pstmt = con.prepareStatement(sql)) {

            result = pstmt.executeUpdate();
        } catch(SQLException e) {
            System.out.println("処理結果：異常が発生しました。");
            e.printStackTrace();
        }
        return result;
    }
}
