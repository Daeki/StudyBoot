package com.iu.home.member;

import java.sql.Date;
import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

import lombok.Data;

@Data
public class MemberVO {
	
	@NotBlank(message = "ID는 꼭 필요해!!!")
	private String id;
	@NotBlank
	@Pattern(regexp="(?=.*[0-9])(?=.*[a-z])(?=.*\\\\W)(?=\\\\S+$).{6,12}")
	private String pw;
	private String pwCheck;
	@NotBlank
	private String name;
	@Email
	@NotBlank
	private String email;
	
	@Range(max = 150, min = 0)
	private int age;
	
	@Past
	private Date birth;
	private boolean enabled;
	
	private List<RoleVO> roleVOs;
	
	
	

}
