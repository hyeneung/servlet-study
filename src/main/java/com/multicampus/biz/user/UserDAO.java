package com.multicampus.biz.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.multicampus.biz.common.JDBCUtil;

//dao data access object 클래스
public class UserDAO {
	// jdbc 관련 변수 선언
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	// users 테이블 관련 sql 선언
	private String USER_INSERT = "INSERT INTO USERS VALUES(?,?,?,?)";
	private String USER_UPDATE = "UPDATE USERS SET NAME=?, ROLE=? WHERE ID=?";
	private String USER_DELETE = "DELETE USERS WHERE ID=?";
	private String USER_LIST = "SELECT * FROM USERS ORDER BY ID ASC";
	private String USER_GET = "SELECT * FROM USERS WHERE ID=?";
	
	// users 테이블 관련 crud 기능의 메소드
	// 회원 등록
	public void insertUser(UserVO vo) {
		try {
			conn = JDBCUtil.getConnection();			
			stmt = conn.prepareStatement(USER_INSERT);
			stmt.setString(1, vo.getId());
			stmt.setString(2, vo.getPassword());
			stmt.setString(3, vo.getName());
			stmt.setString(4, vo.getRole());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	
	// 회원 수정
	public void updateUser(UserVO vo) {
		try {
			conn = JDBCUtil.getConnection();			
			stmt = conn.prepareStatement(USER_UPDATE); //jdbcPreparedStatement
			stmt.setString(1, vo.getName());
			stmt.setString(2, vo.getRole());
			stmt.setString(3, vo.getId());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	// 회원 삭제
	public void deleteUser(UserVO vo) {		
		try {
			conn = JDBCUtil.getConnection();			
			stmt = conn.prepareStatement(USER_DELETE); //jdbcPreparedStatement
			stmt.setString(1, vo.getId());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	// 회원 상세 조회
	public UserVO getUser(UserVO vo) {
		UserVO user = null;
		
		try {
			conn = JDBCUtil.getConnection();			
			stmt = conn.prepareStatement(USER_GET); //jdbcPreparedStatement
			stmt.setString(1, vo.getId());
			rs = stmt.executeQuery();
			if(rs.next()) {
				user = new UserVO();
				user.setId(rs.getString("ID"));
				user.setPassword(rs.getString("PASSWORD"));
				user.setName(rs.getString("NAME"));
				user.setRole(rs.getString("ROLE"));
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn); //resultset 도 닫아야
		}
		return user;
	}
	
	
	// 회원 목록 검색
	public List<UserVO> getUserList() {
		List<UserVO> userList = new ArrayList<UserVO>();
		
		try {
			conn = JDBCUtil.getConnection();			
			stmt = conn.prepareStatement(USER_LIST); //jdbcPreparedStatement
			rs = stmt.executeQuery();
			while(rs.next()) {
				// 검색결과 한 row 당 하나의 user vo 객체에 매핑하여 list에 등록한다
				UserVO user = new UserVO();
				user.setId(rs.getString("ID"));
				user.setPassword(rs.getString("PASSWORD"));
				user.setName(rs.getString("NAME"));
				user.setRole(rs.getString("ROLE"));
				userList.add(user);
			}			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCUtil.close(rs, stmt, conn); //resultset 도 닫아야
		}
		return userList;
	}
}
