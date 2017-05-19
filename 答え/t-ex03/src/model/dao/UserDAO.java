/*
 * 総合３ 解答例  UserDAO.java
 *
 * Copyright(C) 2016 emBex Education Inc. All Rights Reserved.
 */
package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.entity.UserBean;

public class UserDAO {
    public UserBean loginCheck(int userID, String password) throws Exception {

        // データベースへの接続の取得
        ConnectionManager cm = ConnectionManager.getInstance();

        String sql = "SELECT * FROM user where user_id = ? and password = ?";
        UserBean userBean = new UserBean();

        try(Connection con = cm.getConnection();
                PreparedStatement pstmt = con.prepareStatement(sql)) {

            // SQLステートメントの実行（参照系）
            pstmt.setInt(1, userID);
            pstmt.setString(2, password);
            ResultSet res = pstmt.executeQuery();

            // 結果を取得
            while(res.next()) {
                userBean.setName(res.getString("name"));
                userBean.setKanaName(res.getString("kana_name"));
                userBean.setSex(res.getInt("sex"));
                userBean.setAge(res.getInt("age"));
            }

            // SQLに関する例外処理
        } catch(SQLException e) {
            System.out.println("処理結果：異常が発生しました。");
            e.printStackTrace();
        }

        // UserBean型の値をreturn
        return userBean;
    }
}
