package pkg;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Bookbean;
import beans.DBConnector;

/**
 * Servlet implementation class BookManagementServlet
 */
@WebServlet("/BookManagementServlet")
public class BookManagementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public BookManagementServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/* 文字コードUTF-8を宣言 */
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		/* セッションの宣言 */
		HttpSession session = request.getSession();

		/* フォワード宣言 */
		RequestDispatcher disp = null;
		Bookbean book = new Bookbean();
		/* 検索の配列を宣言 */
		ArrayList<Bookbean> book_arry = new ArrayList<Bookbean>();

		/* データベース接続のクラス宣言 */
		DBConnector dbc = new DBConnector();

		/* 新規登録時の値の受け取り */
		String code = request.getParameter("code");

		/* SQL文を入れる変数 */
		String sql = null;
		String sql2 = null;

		switch (code) {
		case "検索":
			book_arry = dbc.execute(book.cBookbean(request));
			request.setAttribute("book_arry", book_arry);
			disp = request.getRequestDispatcher("search.jsp");
			disp.forward(request, response);

			break;
		case "新規登録":
			disp = request.getRequestDispatcher("create.jsp");
			disp.forward(request, response);

			break;
		case "登録":
			dbc.insert(book.cBookbean(request));
			disp = request.getRequestDispatcher("search.jsp");
			disp.forward(request, response);
			break;
		case "削除":

			String[] delete_ck = request.getParameterValues("delete_ck");

			if (delete_ck.length == 1) {
				System.out.println(delete_ck[0]);
				dbc.delete(delete_ck[0]);

			} else {
				for (int i = 0; i < delete_ck.length; i++) {
					System.out.println(delete_ck[i]);
					dbc.delete(delete_ck[i]);

				}

			}

			disp = request.getRequestDispatcher("search.jsp");
			disp.forward(request, response);
			break;

		case "キャンセル":
			book_arry = dbc.execute(book.cBookbean(request));
			request.setAttribute("book_arry", book_arry);

			disp = request.getRequestDispatcher("search.jsp");
			disp.forward(request, response);
			break;
		default:
			break;
		}

	}

}
