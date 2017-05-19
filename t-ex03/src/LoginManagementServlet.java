
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.DBConnector;

/**
 * Servlet implementation class LoginManagementServlet
 */
@WebServlet("/LoginManagementServlet")
public class LoginManagementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginManagementServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher disp = null;
		disp = request.getRequestDispatcher("login-form.jsp");
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
		DBConnector dbc = new DBConnector();
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		ArrayList<ArrayList<String>> emp_list = new ArrayList<ArrayList<String>>();

		String user_id = request.getParameter("user_id");
		String user_pass = request.getParameter("user_pass");
		String login = request.getParameter("login");

		if (login.equals("ログアウト")) {
			session.invalidate();
			disp = request.getRequestDispatcher("login-form.jsp");
			disp.forward(request, response);
		}

		String sql = null;

		sql = "select user_id,password from user where user_id='" + user_id + "' AND password='" + user_pass + "'";

		result = dbc.execute(sql);
		System.out.println(result);

		if (!(result == null)) {
			String sql2 = null;
			sql2 = "select name,kana_name,sex,age from user";
			emp_list = dbc.execute(sql2);
			session.setAttribute("emp_list", emp_list);
			disp = request.getRequestDispatcher("login-success.jsp");
			disp.forward(request, response);

		} else {
			disp = request.getRequestDispatcher("login-failure.jsp");
			disp.forward(request, response);
		}

	}

}
