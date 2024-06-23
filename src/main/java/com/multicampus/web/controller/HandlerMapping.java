package com.multicampus.web.controller;

import java.util.HashMap;
import java.util.Map;

import com.multicampus.web.controller.board.DeleteBoardController;
import com.multicampus.web.controller.board.GetBoardController;
import com.multicampus.web.controller.board.GetBoardListController;
import com.multicampus.web.controller.board.InsertBoardController;
import com.multicampus.web.controller.board.InsertBoardViewController;
import com.multicampus.web.controller.board.UpdateBoardController;
import com.multicampus.web.controller.user.InsertUserController;
import com.multicampus.web.controller.user.InsertUserViewController;
import com.multicampus.web.controller.user.LoginController;
import com.multicampus.web.controller.user.LoginViewController;
import com.multicampus.web.controller.user.LogoutController;

public class HandlerMapping {
	// 게시판 프로그램에서 사용할 모든 Controller를 저장할 Map
	private Map<String, Controller> mappings;
	public HandlerMapping() {
		// Controller 객체들을 Map에 등록한다.
		mappings = new HashMap<String, Controller>();
		
		// 회원 관련 Controller
		mappings.put("/insertUserView.do", new InsertUserViewController());
		mappings.put("/insertUser.do", new InsertUserController());
		mappings.put("/loginView.do", new LoginViewController());
		mappings.put("/login.do", new LoginController());
		mappings.put("/logout.do", new LogoutController());
		
		// 게시판 관련 Controller
		mappings.put("/getBoardList.do", new GetBoardListController());
		mappings.put("/insertBoardView.do", new InsertBoardViewController());
		mappings.put("/insertBoard.do", new InsertBoardController());
		mappings.put("/updateBoard.do", new UpdateBoardController());
		mappings.put("/deleteBoard.do", new DeleteBoardController());
		mappings.put("/getBoard.do", new GetBoardController());
		
	}
	public Controller getController(String path) {
		// path에 해당하는 Controller 객체를 리턴한다.
		return mappings.get(path);
	}
}
