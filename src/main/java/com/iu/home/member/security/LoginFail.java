package com.iu.home.member.security;

import java.io.IOException;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
@Component
@Slf4j
public class LoginFail implements AuthenticationFailureHandler {
	
	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		// TODO Auto-generated method stub
		log.info("====== LoginFail ======");
		log.info("ClassName => {}", exception.getClass().toString());
		log.info("LocalMessage => {}", exception.getLocalizedMessage());
		log.info("Cause = {} ", exception.getCause());
		log.info("Message => {}", exception.getMessage());
//		String name = exception.getClass().toString();
//		name = name.substring(name.lastIndexOf("."));
//		if(name.equals(".BadCredentialsException")) {
//			name="비번 틀림";
//		}
		String result=null;
		// 참조변수명 instanceof 클래스명
		if(exception instanceof BadCredentialsException) {
			result="비번 틀림";
		}else if(exception instanceof InternalAuthenticationServiceException) {
			result="없는 ID";
		}else {
			result="로그인 실패";
		}
		
		
		
		//redirect
		//result = URLEncoder.encode(result, "UTF-8");
		//response.sendRedirect("/member/login?error=true&message="+result);
		
		//JSP를 바로 찾아감
		//request.setAttribute("msg", result);
		//request.getRequestDispatcher("/WEB-INF/views/member/login.jsp").forward(request, response);
		
		//POST 방식으로 Controller의 메서드를 요청 함
		request.setAttribute("msg", result);
		request.getRequestDispatcher("/member/login").forward(request, response);
		
		
	}
}
