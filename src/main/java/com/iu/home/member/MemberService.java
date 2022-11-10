package com.iu.home.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional(rollbackFor = Exception.class)
@Slf4j
public class MemberService {
	@Autowired
	private MemberMapper memberMapper;
	
	@Value("${social.kakao.admin}")
	private String adminKey;
	
	public int setDelete(MemberVO memberVO)throws Exception{
		int result=0;
		RestTemplate restTemplate=null;
		HttpHeaders headers=null;
		MultiValueMap<String, String> params =null;
		HttpEntity<MultiValueMap<String, String>> req=null;
		ResponseEntity<String> res=null;
		//////=============================== 로그아웃
		restTemplate= new RestTemplate();
		
		//--Header
		headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);//application/x-www-form-urlencoded
		headers.add("Authorization", "KakaoAK "+adminKey);
		
		//--parameter
		params = new LinkedMultiValueMap<>();
		params.add("target_id_type", "user_id");
		params.add("target_id", memberVO.getId());
		
		//-- 요청 객체
		req = new HttpEntity<>(params, headers);
		
		//-- 전송 후 결과 처리
		res = restTemplate.postForEntity("https://kapi.kakao.com/v1/user/logout", req, String.class);
		
		log.info("logOut => {} ", res.getBody());
		
	//////=============================== 연결 해제
		restTemplate = new RestTemplate();
		
		//--Header
		headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);//application/x-www-form-urlencoded
		headers.add("Authorization", "KakaoAK "+adminKey);
		
		//--parameter
		params = new LinkedMultiValueMap<>();
		params.add("target_id_type", "user_id");
		params.add("target_id", memberVO.getId());
		
		//-- 요청 객체
		req = new HttpEntity<>(params, headers);
		
		//-- 전송 후 결과 처리
		res = restTemplate.postForEntity("https://kapi.kakao.com/v1/user/unlink", req, String.class);
		
		log.info("res => {} ", res.getBody());
		
		if(res.getBody()!= null) {
			result=1;
		}
		

		return result;
	}
	
	public Integer getIdCheck(MemberVO memberVO)throws Exception{
		return memberMapper.getIdCheck(memberVO);
	}
	
	//사용자 정의 검증 메서드
	public boolean getMemberError(MemberVO memberVO, BindingResult bindingResult)throws Exception{
		boolean check=false;
		//check=false : 검증성공(error 없음)
		//check=true  : 검증실패(error 있음)
		
		//1. annotation 검증
		check = bindingResult.hasErrors();
		
		//2. password가 일치하는지 검증
		if(!memberVO.getPw().equals(memberVO.getPwCheck())) {
			check=true;
			//에러메세지
			//bindingResult.rejectValue("멤버변수명(path)", "properties의key(코드)");
			bindingResult.rejectValue("pwCheck", "member.password.notEqual");
			
		}
		
		//3. id가 중복 인지 검증
		int result = memberMapper.getIdCheck(memberVO);
		if(result>0) {
			check=true;
			bindingResult.rejectValue("id", "member.id.equal");
		}
		
		return check;
		
	}
	
	public int setAdd(MemberVO memberVO)throws Exception{
		int result = memberMapper.setAdd(memberVO);
		
		if(result<1) {
			throw new Exception();
		}
		
		result = memberMapper.setMemberRole(memberVO);
		
		if(result<1) {
			throw new Exception();
		}
		
		return result;
	}
	
	//로그인 처리는 Security에서 처리 함
//	public MemberVO getLogin(MemberVO memberVO)throws Exception{
//		
//		return memberMapper.getLogin(memberVO);
//	}

}
