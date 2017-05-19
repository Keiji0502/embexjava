/*
 * 総合４ 解答例  BookManagementServlet.java
 *
 * Copyright(C) 2016 emBex Education Inc. All Rights Reserved.
 */
package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BookDAO;
import entity.BookBean;

/**
 * Servlet implementation class BookManagementServlet
 *
 * @author emBex Education
 * @version 1.00
 */
@WebServlet("/book")
public class BookManagementServlet extends HttpServlet {

    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookManagementServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("search.jsp");
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
        if("検索".equals(action)) {
            ArrayList<BookBean> list = new ArrayList<BookBean>();
            BookDAO dao = new BookDAO();

            try {
                list = dao.select(BookBean.createBookBean(request));
            } catch(Exception e) {
                e.printStackTrace();
            }

            request.setAttribute("bookList", list);
            url = "search.jsp";

            // リクエストACTIONの値を判定し、移譲先をurlに格納
        } else if("新規登録".equals(action)) {
            url = "create.jsp";

            // リクエストACTIONの値を判定し、移譲先をurlに格納
        } else if("削除".equals(action)) {
            BookDAO dao = new BookDAO();
            String[] ids = request.getParameterValues("delete");
            try {
                dao.delete(ids);
            } catch(Exception e) {
                e.printStackTrace();
            }
            url = "search.jsp";

            // リクエストACTIONの値を判定し、移譲先をurlに格納
        } else if("キャンセル".equals(action)) {
            url = "search.jsp";

            // リクエストACTIONの値を判定し、移譲先をurlに格納
        } else if("登録".equals(action)) {
            BookDAO dao = new BookDAO();

            try {
                dao.insert(BookBean.createBookBean(request));
            } catch(Exception e) {
                e.printStackTrace();
            }
            url = "search.jsp";
        } else {
            /* DO NOTHING */
        }

        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.forward(request, response);
    }
}
