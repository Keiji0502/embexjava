/*
 * 総合１ 解答例	TaskListServlet.java
 *
 * Copyright(C) 2016 emBex Education Inc. All Rights Reserved.
 */
package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class TaskListServlet
 *
 * @author emBex Education
 * @version 1.00
 */
@WebServlet("/TaskListServlet")
public class TaskListServlet extends HttpServlet {

    /**
     * @see HttpServlet#HttpServlet()
     */
    public TaskListServlet() {
        super();
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher rd = request.getRequestDispatcher("regist.html");
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

        // セッション情報を取得
        HttpSession session = request.getSession();

        // 画面の入力情報を取得
        HashMap<String, String> map = new HashMap<String, String>();
        map.put("taskName", request.getParameter("taskName"));
        map.put("startDate", request.getParameter("startDate"));
        map.put("endDate", request.getParameter("endDate"));
        map.put("content", request.getParameter("content"));

        ArrayList<HashMap<String, String>> list = (ArrayList<HashMap<String, String>>) session
                .getAttribute("list");
        // セッション情報がない場合、生成し加える
        if(list == null) {
            list = new ArrayList<HashMap<String, String>>();
        }
        list.add(map);
        session.setAttribute("list", list);


        RequestDispatcher rd = request.getRequestDispatcher("display.jsp");
        rd.forward(request, response);
    }
}
