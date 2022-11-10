package com.iu.home.member.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.iu.home.member.MemberVO;

import lombok.extern.slf4j.Slf4j;
@Component
@Slf4j
public class LogoutSuccessCustom implements LogoutSuccessHandler{
	
	@Value("${spring.security.oauth2.client.registration.kakao.client-id}")
	private String clientId;
	
	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		MemberVO memberVO =(MemberVO)authentication.getPrincipal(); //memberVO
		String social = memberVO.getSocial();
		if(social != null) {
			if(social.equals("kakao")) {
				
				StringBuffer sb = new StringBuffer();
				sb.append("https://kauth.kakao.com/oauth/logout?");
				sb.append("client_id=");
				sb.append(clientId);
				sb.append("&logout_redirect_uri=http://localhost:81/member/logoutResult");
				
				
				//https://developers.kakao.com/logout
				response.sendRedirect(sb.toString());
//				RestTemplate restTemplate = new RestTemplate();
//				//header X
//				//parameter X
//				MultiValueMap<String, String> map = new LinkedMultiValueMap<>();
//				map.add("client_id", "09d18b9999ed8defbd3ebd94a5a254a2");
//				
//				HttpEntity<MultiValueMap<String, String>> req = new HttpEntity<MultiValueMap<String,String>>(map, null);
//				
//				log.info("Kakao logout");
//				ResponseEntity<String> res = restTemplate.getForEntity("https://developers.kakao.com/logout",String.class, req);
//				log.info("res => {} ", res);
//				response.sendRedirect("/");
				
			}else if(social.equals("google")) {
				
			}else {
				
			}
		}else {
			log.info("=== logout 성공시에만 실행 ===");
			response.sendRedirect("/");
		
		}
		
	}

}
