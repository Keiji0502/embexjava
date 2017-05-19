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
	private static String dataBaseName = "user_db";
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
	public ArrayList<ArrayList<String>> execute(String sql) {
		ArrayList<ArrayList<String>> arrayTbl = new ArrayList<ArrayList<String>>();
		int intRec = 0;
		int column = 0;
		try {
			con.setAutoCommit(false);
			System.out.println(sql);
			rs = st.executeQuery(sql);
			con.commit();
			rsmd = rs.getMetaData();
			column = rsmd.getColumnCount();


			while (rs.next()) {
				ArrayList<String> rec = new ArrayList<String>();
				for (int cnt = 1; cnt <= column; cnt++) {
					rec.add(rs.getString(cnt));
				}
				arrayTbl.add(rec);
				intRec = 1;
			}
			if (0 == intRec) {
				arrayTbl = null;
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
	public void insert(String sql) {
		try {
			con.setAutoCommit(false);
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
	public void delete(String sql) {
		try {
			con.setAutoCommit(false);
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
