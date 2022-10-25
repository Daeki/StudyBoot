package com.iu.home.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {
	@Autowired
	private MemberMapper memberMapper;
	
	public int setAdd(MemberVO memberVO)throws Exception{
		int result = memberMapper.setAdd(memberVO);
		
		result = memberMapper.setMemberRole(memberVO);
		
		return result;
	}
	
	public MemberVO getLogin(MemberVO memberVO)throws Exception{
		return memberMapper.getLogin(memberVO);
	}

}
