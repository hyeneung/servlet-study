package com.multicampus.web.common;

import jakarta.servlet.ServletContextAttributeEvent;
import jakarta.servlet.ServletContextAttributeListener;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

// @WebListener
public class BoardWebListener implements ServletContextListener, ServletContextAttributeListener {

    public BoardWebListener() {
        System.out.println("===> BoardWebListener 생성");
    }
	
    public void contextInitialized(ServletContextEvent sce) {
    	System.out.println("---> contextInitialized() : 컨테이너가 생성된다.");
    }

    @Override
    public void attributeAdded(ServletContextAttributeEvent scae) {
    	System.out.println("---> attributeAdded() : ServletContext에 뭔가 등록됨");
    }
    
    @Override
    public void attributeReplaced(ServletContextAttributeEvent scae) {
    	System.out.println("---> attributeReplaced() : ServletContext에 뭔가 대체됨");
    }
    
    @Override
    public void attributeRemoved(ServletContextAttributeEvent scae) {
    	System.out.println("---> attributeRemoved() : ServletContext에 뭔가 삭제됨");
    }
    
    public void contextDestroyed(ServletContextEvent sce) {
    	// 콘솔에 보이진 않지만 실행은 됨
    	System.out.println("---> contextDestroyed() : 컨테이너가 종료된다.");
    }
}
