package com.multicampus.web.common;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;

@WebFilter("*.do")
public class TimeCheckFilter extends HttpFilter implements Filter {

	private static final long serialVersionUID = 1L; // 직렬화 역직렬화 id 프로그램 실행 시 영향x

	public TimeCheckFilter() {
        System.out.println("===> TimeCheckFilter 생성");
    }

//	public void init(FilterConfig fConfig) throws ServletException {
//		System.out.println("---> init() 호출");
//	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// System.out.println("--- [ 사전 처리 ] ---");
		long startTime = System.currentTimeMillis();
		
		// 이 시점에 브라우저가 요청한 서블릿이 실행된다.
		chain.doFilter(request, response);
		//System.out.println("--- [ 사후 처리 ] ---");		
		long endTime = System.currentTimeMillis();

		HttpServletRequest req = (HttpServletRequest) request;
		String uri = req.getRequestURI(); // getrequestid는 httpservletrequest 메서드임. 자식 쪽에. 
		
		System.out.println(uri + "수행 속도 : " + (endTime - startTime) + "(ms)초");
	}

//	public void destroy() {
//		System.out.println("---> destroy() 호출");
//	}
}
