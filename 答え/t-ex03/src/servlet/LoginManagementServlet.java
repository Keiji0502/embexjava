/*
 * 総合３ 解答例	LoginManagementServlet.java
 *
 * Copyright(C) 2016 emBex Education Inc. All Rights Reserved.
 */
package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.dao.UserDAO;
import model.entity.UserBean;

/**
 * Servlet implementation class LoginServlet
 *
 * @author emBex Education
 * @version 1.00
 */
@WebServlet("/login")
public class LoginManagementServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginManagementServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        // GETリクエストならlogin.jsp
        RequestDispatcher rd = request.getRequestDispatcher("login-form.jsp");
        rd.forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        // エンコーディング指定
        request.setCharacterEncoding("Windows-31J");
        response.setCharacterEncoding("Windows-31J");

        // リクエストACTIONの値を取得
        String action = request.getParameter("ACTION");

        // 移譲先を格納する変数
        String url = null;

        // リクエストACTIONの値を判定し、移譲先をurlに格納
        if("ログイン".equals(action)) {
            // リクエストUSERID、PASSWORDの値を取得
            int userId = Integer.parseInt(request.getParameter("USERID"));
            String password = request.getParameter("PASSWORD");

            // DAO、Beanをインスタンス化
            UserDAO userDao = new UserDAO();
            UserBean userBean = new UserBean();

            // DAOからのreturnをBeanに格納
            try {
                userBean = userDao.loginCheck(userId, password);
            } catch(Exception e) {
                e.printStackTrace();
            }

            // ユーザ情報を判定し移譲先を格納
            if(userBean.getName() != null){
                HttpSession session = request.getSession();
                session.setAttribute("userBean", userBean);
                url = "login-success.jsp";
            } else {
                url = "login-failure.jsp";
            }

        //  リクエストACTIONの値を判定し、移譲先をurlに格納
        } else if("ログアウト".equals(action)) {
            HttpSession session = request.getSession();
            session.removeAttribute("userBean");
            session.invalidate();

            url = "logout.jsp";

        //  リクエストACTIONの値を判定し、移譲先をurlに格納
        } else if("ログイン画面へ".equals(action)) {
            url = "login-form.jsp";
        } else {
            /* DO NOTHING */
        }

        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.forward(request, response);
    }
}
