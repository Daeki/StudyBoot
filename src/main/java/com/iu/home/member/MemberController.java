package com.iu.home.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/member/*")
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	@GetMapping("add")
	public void setAdd()throws Exception{
		
	}
	
	@PostMapping("add")
	public String setAdd(MemberVO memberVO)throws Exception{
		int result = memberService.setAdd(memberVO); 
		
		
		return "redirect:../";
	}
	@GetMapping("login")
	public void getLogin()throws Exception{
		
	}
	@PostMapping("login")
	public String getLogin(MemberVO memberVO, HttpSession session)throws Exception{
		
		memberVO = memberService.getLogin(memberVO);
		
		session.setAttribute("member", memberVO);
		
		return "redirect:../";
	}
	
	@GetMapping("logout")
	public String getLogout(HttpSession session)throws Exception{
		session.invalidate();
		
		return "redirect:../";
	}

}
