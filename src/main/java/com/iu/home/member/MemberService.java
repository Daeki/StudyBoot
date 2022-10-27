package com.iu.home.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class MemberService {
	@Autowired
	private MemberMapper memberMapper;
	
	public Integer getIdCheck(MemberVO memberVO)throws Exception{
		return memberMapper.getIdCheck(memberVO);
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
	
	public MemberVO getLogin(MemberVO memberVO)throws Exception{
		return memberMapper.getLogin(memberVO);
	}

}
