package com.multicampus.web.controller.user;

import com.multicampus.web.controller.Controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class LogoutController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("로그아웃 처리");
		
		//로그아웃 요청한 브라우저와 매핑된 세션 객체를 획득한다. 
		 HttpSession session = request.getSession();
		
		// 세션 객체를 강제로 제거한다. 
		session.invalidate();				
		return "index";
	}

}
