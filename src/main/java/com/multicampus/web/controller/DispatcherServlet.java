package com.multicampus.web.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private HandlerMapping handlerMapping;
	private ViewResolver viewResolver;
	
	public void init() throws ServletException {
		handlerMapping = new HandlerMapping();
		viewResolver = new ViewResolver();
		viewResolver.setPrefix("./WEB-INF/board/");
		viewResolver.setSuffix(".jsp");		
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 사용자 요청 path 정보를 추출한다.
		// 업무 요청사항 받음
		String uri = request.getRequestURI(); // aaa/bbb/test.do
		String path = uri.substring(uri.lastIndexOf("/")); // /test.do
		
		// 2. HandlerMapping을 통해 path에 해당하는 Controller를 검색한다.
		// 해당 업무 담당자 찾음
		Controller ctrl = handlerMapping.getController(path);
		
		// 3. 검색된 Controller를 실행하고 정보를 리턴받는다.
		// 담당자는 일 하고 후속 조치할 사람 이름만 알려줌
		String viewName = ctrl.handleRequest(request, response);
		
		// 4. ViewResolver를 통해 viewName에 해당하는 경로를 완성한다.
		// 후속 조치할 사람 사무실 주소 ViewResolver한테 받음
		String view = null;
		if (!viewName.contains(".do")) {
			if(viewName.equals("index")) {
				view = viewName + ".jsp";
			}
			else {
				view = viewResolver.getView(viewName);
			}
		} else {
			view = viewName;
		}
		
		// 5. ViewResolver를 통해 완성한 화면으로 이동한다.
		// 후속 조치할 사람한테 찾아가서 후속 조치 받음
		RequestDispatcher rd = request.getRequestDispatcher(view);
		rd.forward(request, response);
	}
}
