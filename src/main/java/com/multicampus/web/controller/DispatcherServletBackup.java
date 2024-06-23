package com.multicampus.web.controller;

import java.io.IOException;

import com.multicampus.biz.board.BoardDAO;
import com.multicampus.biz.board.BoardVO;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

// @WebServlet("*.do")
public class DispatcherServletBackup extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 사용자 요청 path 정보를 추출한다.
		String uri = request.getRequestURI(); // aaa/bbb/test.do
		String path = uri.substring(uri.lastIndexOf("/")); // /test.do
		System.out.println("PATH : " + path); 
		
		// 추출한 path에 해당하는 로직으로 분기처리한다.
		if(path.equals("/login.do")) {			
			
			
		} else if(path.equals("/logout.do")) {
			
			
		} else if(path.equals("/insertUser.do")) {
			
		} else if(path.equals("/insertBoard.do")) {
			System.out.println("글 등록 처리");
			//1. 사용자 입력정보 추출
			String title = request.getParameter("title");
			String writer = request.getParameter("writer");
			String content = request.getParameter("content");		
			
			// 2. DB 연동 처리
			BoardVO vo = new BoardVO();
			vo.setTitle(title);
			vo.setWriter(writer);
			vo.setContent(content);
			
			BoardDAO dao = new BoardDAO();
			dao.insertBoard(vo);
			
			// 3. 화면 이동
			// 글 목록 다시 가져와야 해서 .do 컨트롤러 처리하도록 함
			response.sendRedirect("getBoardList.do");			
			
		} else if(path.equals("/updateBoard.do")) {
			System.out.println("글 수정 처리");
			
			// 1. 사용자 입력정보 추출
			String title = request.getParameter("title");
			String seq = request.getParameter("seq");
			String content = request.getParameter("content");			
			// 2. DB 연동 처리
			BoardVO vo = new BoardVO();
			vo.setTitle(title);
			vo.setSeq(Integer.parseInt(seq));
			vo.setContent(content);
			
			BoardDAO dao = new BoardDAO();
			dao.updateBoard(vo);
			
			// 3. 화면 이동
			RequestDispatcher rd = request.getRequestDispatcher("getBoardList.do");
			rd.forward(request, response);
			
		} else if(path.equals("/deleteBoard.do")) {
			System.out.println("글 삭제 처리");
			//1. 사용자 입력 정보 추출
			String seq = request.getParameter("seq");		
			
			// 2. DB 연동 처리
			BoardVO vo = new BoardVO();
			vo.setSeq(Integer.parseInt(seq));
			
			BoardDAO dao = new BoardDAO();
			dao.deleteBoard(vo);
			
			// 3. 화면 이동
			RequestDispatcher rd = request.getRequestDispatcher("getBoardList.do");
			rd.forward(request, response);			
		} else if(path.equals("/getBoard.do")) {
			System.out.println("글 상세 조회 처리");
			//1. 사용자 입력 정보 추출
			String seq = request.getParameter("seq");
			/* if (session.getAttribute("user") == null) { // authentication Filter 쓰고 있음
				// 3. 화면 이동
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
			} */  

			// 2. DB 연동 처리
			BoardVO vo = new BoardVO();
			vo.setSeq(Integer.parseInt(seq));

			BoardDAO dao = new BoardDAO();
			BoardVO board = dao.getBoard(vo);
			dao.increaseBoardCount(vo);
			
			// **** 중요 ****
			// 3. 검색 결과를 request에 등록한다. 
			request.setAttribute("board", board);
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/board/getBoard.jsp");
			rd.forward(request, response);
			
		} else if(path.equals("/getBoardList.do")) {
					
			
		} else if(path.equals("/loginView.do")) {
			System.out.println("로그인 화면으로 이동");
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/board/login.jsp");
			rd.forward(request, response);
		} else if(path.equals("/insertBoardView.do")) {
			System.out.println("글 등록 화면으로 이동");
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/board/insertBoard.jsp");
			rd.forward(request, response);
		} else if(path.equals("/insertUserView.do")) {
			
		} else {
			System.out.println("요청 URL에 문제가 있습니다. ");
		}
	}
}
