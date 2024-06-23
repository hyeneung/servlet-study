package com.multicampus.biz.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtil {
	public static Connection getConnection() {
		try {
			// 1단계 : 드라이버 객체 로딩
			// Class.forName("org.h2.Driver"); // 컴파일 에러 발생 못시킴. 런타임 에러.
			DriverManager.registerDriver(new org.h2.Driver()); // 해당 클래스 없으면 컴파일 에러.
			
			// 2단계 : Connection 연결
			// jdbcConneciton.class - connection 인터페이스의 구현체
			return DriverManager.getConnection("jdbc:h2:tcp://localhost/~/test","sa","");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public static void close(Statement stmt, Connection conn) {
		// 5단계 : 자원 해제
		try {
			if(stmt != null)
				stmt.close();
			// conn.close();  앞에서 에러 나면 실행 못함
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			stmt = null; // garbage collector에게 넘김
		}
		try {
			if(conn != null)
				conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			conn = null; // garbage collector에게 넘김
		}
		
	}
	public static void close(ResultSet rs, Statement stmt, Connection conn) {
		// 5단계 : 자원 해제
		try {
			if(rs != null)
				rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			rs = null; // garbage collector에게 넘김
		}
		
		try {
			if(stmt != null)
				stmt.close();
			// conn.close();  앞에서 에러 나면 실행 못함
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			stmt = null; // garbage collector에게 넘김
		}
		try {
			if(conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			conn = null; // garbage collector에게 넘김
		}		
	}
}
