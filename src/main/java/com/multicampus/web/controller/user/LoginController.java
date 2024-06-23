package com.multicampus.web.controller.user;

import com.multicampus.biz.user.UserDAO;
import com.multicampus.biz.user.UserVO;
import com.multicampus.web.controller.Controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LoginController implements Controller {

	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		// 로그인 prop.jsp
		System.out.println("로그인 처리");
		
		//1. 사용자 입력 정보 추출
		String id = request.getParameter("id");
		String password = request.getParameter("password");
		
		// 2. DB 연동 처리
		UserVO vo = new UserVO();
		vo.setId(id);
		
		UserDAO dao = new UserDAO();
		UserVO user = dao.getUser(vo);
		
		// 3. 화면 이동
		if (user != null && user.getPassword().equals(password)) {
			// 로그인 성공 시 세션에 회원 정보를 등록한다.
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			return "/getBoardList.do";
		} else {
			// 아이디 없음
			return "/loginView.do";
		}
		
	}

}
