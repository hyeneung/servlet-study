package com.multicampus.web.common;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebFilter(urlPatterns = {"/getBoardList.do", "/getBoard.do", "/deleteBoard.do"})
public class AuthenticationFilter extends HttpFilter implements Filter {

	private static final long serialVersionUID = 1L; // 직렬화 역직렬화 id 프로그램 실행 시 영향x

	public AuthenticationFilter() {
        System.out.println("===> AuthenticationFilter 생성");
    }

	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req; // getsession 쓰기 위함 
		HttpServletResponse response = (HttpServletResponse) res;
		
		// 0. 상태 정보 체크(session 기반)
		// 글 목록을 요청한 브라우저와 매핑된 세션 객체를 획득한다.
		HttpSession session = request.getSession();

		// 세션에 등록된 상태 정보를 확인한다
		if (session.getAttribute("user") == null) {
			// 세션에 회원 아이디가 없으면 인증에 실패한 브라우저로 판단한다
			response.sendRedirect("/");
		} else {		
			// 이 시점에 브라우저가 요청한 서블릿이 실행된다.
			chain.doFilter(request, response);
		}
	}
}
