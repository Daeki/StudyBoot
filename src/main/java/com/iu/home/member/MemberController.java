package com.iu.home.member;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/member/*")
@Slf4j
public class MemberController {
	@Autowired
	private MemberService memberService;
	
	@GetMapping("idCheck")
	@ResponseBody
	public int getIdCheck(MemberVO memberVO)throws Exception{
		return memberService.getIdCheck(memberVO);
//		int result=0; //memberVO == null
//		
//		if(memberVO != null) {
//			result =1;
//		}
//		
//		return result;
		
	}
	
	@GetMapping("add")
	public void setAdd(@ModelAttribute MemberVO memberVO)throws Exception{
		//MemberVO memberVO = new MemberVO();
		//model.addAttribute("vo", memberVO);
	}
	
	@PostMapping("add")
	public ModelAndView setAdd(@Valid MemberVO memberVO, BindingResult bindingResult, ModelAndView mv)throws Exception{
		
		if(bindingResult.hasErrors()) {
			//검증에 실패하면 회원가입하는 jsp로 foward
			log.info("===== 검증 에러 발생 =====");
			mv.setViewName("member/add");
			return mv;
		}
		
		//int result = memberService.setAdd(memberVO); 
		
		mv.setViewName("redirect:../");
		return mv;
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
