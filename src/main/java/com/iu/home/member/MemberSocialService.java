package com.iu.home.member;

import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MemberSocialService extends DefaultOAuth2UserService{
	
	@Override
	public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
		log.info("===== Social Login 시도 =====");
		log.info("UserRequest {} ", userRequest);
		log.info("AccessToken {} ", userRequest.getAccessToken());
		log.info("Reg => {}", userRequest.getClientRegistration());
		
		OAuth2User auth2User= super.loadUser(userRequest);
		log.info("==========   사용자 정보 =====================");
		log.info("Name =>  {} ", auth2User.getName());
		log.info("Attr =>  {} " , auth2User.getAttributes());
		log.info("Auth => {}", auth2User.getAuthorities());
		
		return null;
	}
	
	private OAuth2User socialJoinCheck(OAuth2UserRequest userRequest) {
		//회원가입 유무
		
	}

}
