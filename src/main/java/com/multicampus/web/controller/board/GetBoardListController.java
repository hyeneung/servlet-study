package com.multicampus.web.controller.board;

import java.util.List;

import com.multicampus.biz.board.BoardDAO;
import com.multicampus.biz.board.BoardVO;
import com.multicampus.web.controller.Controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class GetBoardListController implements Controller {

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("글 목록 검색 처리");
		// getBoardList.jsp의 자바 코드만(스크립트릿) 복붙
		// 1. 사용자 입력정보 추출
		String searchCondition = request.getParameter("searchCondition");
		String searchKeyword = request.getParameter("searchKeyword");
		
		// Null Check
		if(searchCondition == null) searchCondition = "TITLE";
		if(searchKeyword == null) searchKeyword = "";
		
		// 세션에 검색 조건과 키워드를 등록한다.
		HttpSession session = request.getSession();
		session.setAttribute("condition", searchCondition);
		session.setAttribute("keyword", searchKeyword);
		
		// 2. DB 연동 처리
		BoardVO vo = new BoardVO();
		vo.setSearchCondition(searchCondition);
		vo.setSearchKeyword(searchKeyword);
		
		BoardDAO dao = new BoardDAO();
		List<BoardVO> boardList = dao.getBoardList(vo);
		
		// *************중요***********
		// 3. Controller(Servlet)는 Model(DAO)을 이용하여 검색한 데이터를
		//     View(JSP)에서 사용할 수 있도록 request에 등록해야 한다. session/context에 해도 되는데 메모리 낭비
		request.setAttribute("boardList", boardList);		
		return "getBoardList";
	}

}
