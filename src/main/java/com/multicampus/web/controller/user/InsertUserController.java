package com.multicampus.web.controller.user;

import com.multicampus.biz.user.UserDAO;
import com.multicampus.biz.user.UserVO;
import com.multicampus.web.controller.Controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class InsertUserController implements Controller {

	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {		
		// System.out.println("회원가입 처리");
		//1. 사용자 입력 정보 추출
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String role = request.getParameter("role");
		
		// 2. DB 연동 처리
		UserVO vo = new UserVO();
		vo.setId(id);
		vo.setPassword(password);
		vo.setName(name);
		vo.setRole(role);
		
		UserDAO dao = new UserDAO();
		dao.insertUser(vo);
		
//		// 3. 화면 이동
//		RequestDispatcher rd = request.getRequestDispatcher("getBoardList.do");
//		rd.forward(request, response);
		
		return "index"; // 회원가입 성공하면 index.jsp로 이동
	}

}
