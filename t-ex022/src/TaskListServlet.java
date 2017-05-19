
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class TaskListServlet
 */
@WebServlet("/TaskListServlet")
public class TaskListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public TaskListServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher disp = null;
		disp = request.getRequestDispatcher("regist.html");
		disp.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();

		RequestDispatcher disp = null;

		String botan = request.getParameter("botan");
		System.out.println(botan);

		switch (botan) {
		case "登録":

			ArrayList<ArrayList<String>> task_arry = (ArrayList<ArrayList<String>>) session.getAttribute("task_arry");
			ArrayList<String> task_list = new ArrayList<String>();

			String task_name = request.getParameter("task_name");
			String first_time = request.getParameter("first_time");
			String end_time = request.getParameter("end_time");
			String content_name = request.getParameter("content_name");

			/* 配列に値を追加 */
			task_list.add(task_name);
			task_list.add(first_time);
			task_list.add(end_time);
			task_list.add(content_name);

			/* セッションがない場合は追加する */ 
			if (task_arry == null) {
				task_arry = new ArrayList<ArrayList<String>>();
			}

			/* 配列に追加 */
			task_arry.add(task_list);

			/* セッションに保存 */
			session.setAttribute("task_arry", task_arry);

			/* フォワードでdisplay.jspに送る */

			disp = request.getRequestDispatcher("display.jsp");
			disp.forward(request, response);

			break;

		case "クリア":
			ArrayList<ArrayList<String>> task_arry2 = (ArrayList<ArrayList<String>>) session.getAttribute("task_arry");

			session.invalidate();
			disp = request.getRequestDispatcher("display2.jsp");
			disp.forward(request, response);

		default:
			break;
		}

	}

}