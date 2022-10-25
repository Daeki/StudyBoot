package com.iu.home.member;

import java.util.List;

import lombok.Data;

@Data
public class MemberVO {
	
	private String id;
	private String pw;
	private String name;
	private String email;
	private boolean enabled;
	
	private List<RoleVO> roleVOs;
	
	
	

}
