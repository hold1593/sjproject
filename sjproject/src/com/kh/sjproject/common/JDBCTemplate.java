package com.kh.sjproject.common;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCTemplate {

	private static Connection conn = null;

	public static Connection getConnection() {

		try {
			if (conn == null || conn.isClosed()) {

				Properties prop = new Properties();

				String fileName = JDBCTemplate.class.getResource("/com/kh/sjproject/sql/driver.properties").getPath();

				prop.load(new FileReader(fileName));

				// ojdbc6 라이브러리를
				// WebContent/WEB-INF/lib 폴더에 추가

				// jdbc 드라이버 로드
				Class.forName(prop.getProperty("driver"));

				conn = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("user"),
						prop.getProperty("password"));

				conn.setAutoCommit(false);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return conn;
	}

	public static void close(Statement stmt) {

		try {
			if (stmt != null && !stmt.isClosed()) {
				stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(ResultSet rset) {
		try {
			if (rset != null && !rset.isClosed()) {
				rset.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(Connection conn) {
		try {
			if (conn != null && !conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 처리 결과에 따른 트랜잭션 처리도 공통적인 업무임.
	// --> static으로 선언하여 코드길이 감소, 재사용성의 증가
	public static void commit(Connection conn) {
		try {
			if (conn != null && !conn.isClosed()) {
				conn.commit();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void rollback(Connection conn) {
		try {
			if (conn != null && !conn.isClosed()) {
				conn.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
