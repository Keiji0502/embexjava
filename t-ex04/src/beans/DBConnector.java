package beans;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



public class DBConnector {
	private static String driverName = "com.mysql.jdbc.Driver";
	private static String dataBasePass = "jdbc:mysql://localhost/";
	private static String dataBaseName = "book_db";
	private static String userName = "root";
	private static String userPass = "root";
	private static String sql = null;
	private Connection con = null;
	private Statement st = null;

	/************
	 * コンストラクタ
	 ************/
	public DBConnector() {
		run(this.dataBaseName, this.userName, this.userPass);
	}

	/************************
	 * コンストラクタデータベース変更
	 *
	 * @param DBName
	 * @param user
	 * @param pass
	 ************************/
	public DBConnector(String DBName, String user, String pass) {
		dataBaseName = DBName;
		userName = user;
		userPass = pass;
		run(this.dataBaseName, this.userName, this.userPass);
	}

	/********************
	 * データベースに接続する
	 *
	 * @param DBName
	 * @param user
	 * @param pass
	 ********************/
	private void run(String DBName, String user, String pass) {
		try {
			Class.forName(driverName);
			con = DriverManager.getConnection(dataBasePass + dataBaseName ,userName, userPass);
			st = con.createStatement();
		} catch (ClassNotFoundException e) {
			System.out.println(e);
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	private ResultSet rs;
	private ResultSetMetaData rsmd;

	/********************
	 * データベースを参照する
	 *
	 * @param sql
	 * @return
	 *********************/
	public ArrayList<Bookbean> execute(Bookbean param) {
		ArrayList<Bookbean> arrayTbl = new ArrayList<Bookbean>();
		int intRec = 0;
		int column = 0;
		try {
			con.setAutoCommit(false);
			System.out.println(sql);
			sql = "select id,book_title,author_name,publisher_name,publisher_year,isbn_code from book where id=id ";

			if (!(param.getBook_title().equals(""))) {
				sql += "AND book_title LIKE '%" + param.getBook_title() + "%' ";
			}

			if (!(param.getAuthor_name().equals(""))) {
				sql += "AND author_name LIKE '%" + param.getAuthor_name() + "%' ";
			}

			if (!(param.getPublisher_name().equals(""))) {
				sql += "AND publisher_name LIKE '%" + param.getPublisher_name() + "%' ";
			}

			if (!(param.getPublisher_year().equals(""))) {
				sql += "AND publisher_year LIKE '%" + param.getPublisher_year() + "%' ";
			}

			if (!(param.getIsbn_code().equals(""))) {
				sql += "AND isbn_code LIKE '%" + param.getIsbn_code() + "%' ";
			}
			rs = st.executeQuery(sql);
			con.commit();
			rsmd = rs.getMetaData();
			column = rsmd.getColumnCount();


			while (rs.next()) {
				Bookbean book =new Bookbean();
				book.setId(rs.getString(1));
				book.setBook_title(rs.getString(2));
				book.setAuthor_name(rs.getString(3));
				book.setPublisher_name(rs.getString(4));
				book.setPublisher_year(rs.getString(5));
				book.setIsbn_code(rs.getString(6));

				arrayTbl.add(book);


			}
			rs.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
		return arrayTbl;
	}

	/********************
	 * データベースに登録する
	 *
	 * @param sql
	 ********************/
	public void insert(Bookbean param) {
		try {
			con.setAutoCommit(false);
			sql = "INSERT INTO book (book_title, author_name, publisher_name, publisher_year, isbn_code)";
			sql += "VALUES ('" + param.getBook_title() + "', '" + param.getAuthor_name() + "', '" + param.getPublisher_name() + "', '" + param.getPublisher_year()
					+ "', '" + param.getIsbn_code() + "')";
			st.executeUpdate(sql);
			con.commit();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	/*********************
	 * データベースを更新する
	 *
	 * @param sql
	 *********************/
	public void update(String sql) {
		try {
			con.setAutoCommit(false);
			st.executeUpdate(sql);
			con.commit();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	/********************
	 * DBからデータを削除する
	 *
	 * @param table_name
	 * @param key_var
	 * @param key_value
	 ********************/
	public void delete(String param) {
		try {
			con.setAutoCommit(false);
			sql = "delete from book where id='" + param.toString() + "'";
			st.executeUpdate(sql);
			con.commit();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	/********************
	 * データベースを切断する
	 ********************/
	public void close() {
		try {
			if (st != null) {
				st.close();
			}
			if (con != null) {
				// con.rollback();
				// con.setAutoCommit(true);
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
