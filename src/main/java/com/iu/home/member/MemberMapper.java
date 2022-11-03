package com.iu.home.member;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Mapper
public interface MemberMapper {
	
	public Integer getIdCheck(MemberVO memberVO)throws Exception;
	public int setAdd(MemberVO memberVO)throws Exception;
	public int setMemberRole(MemberVO memberVO)throws Exception;
	public MemberVO getLogin(String username)throws UsernameNotFoundException;

}
