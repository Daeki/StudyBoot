package com.iu.home.member.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
@Component
@Slf4j
public class LoginSuccess implements AuthenticationSuccessHandler {
	
	
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		log.info("========= 로그인 성공 =====");
		log.info("Auth => {}", authentication);
		log.info("ID : {}", request.getParameter("id"));
		
		String check = request.getParameter("rememberId");
		
		log.info("Check = > {} ", check);
		
		if(check!=null && check.equals("on")) {
			
			Cookie cookie = new Cookie("userId", request.getParameter("id"));
			cookie.setHttpOnly(true);
			cookie.setMaxAge(60);//초
			cookie.setPath("/");//같은 도메인 내에서 어느 URL에서 사용 가능한가 적용
			
			response.addCookie(cookie);
		}else {
			Cookie [] cookies= request.getCookies();
			
			for(Cookie cookie:cookies) {
				if(cookie.getName().equals("userId")) {
					cookie.setMaxAge(0);
					cookie.setPath("/");//cookie 삭제시 cookie 만들 때의 path와 동일해야 함
					response.addCookie(cookie);
					log.info("==== Cookie 삭제 ====");
					break;
				}
			}
			
		}
		response.sendRedirect("/");
		
	}

}
