package com.green.view.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.green.biz.dto.MemberVO;
import com.green.biz.mypage.MypageService;

@Controller
@SessionAttributes("loginUser")
public class MypageController {

	@Autowired
	private MypageService mypageService;
	
	//���� ������ �ҷ����� 
	@RequestMapping(value="/my_page_form",method=RequestMethod.GET)
	public String getMypage(Model model,MemberVO vo,HttpSession session){
		
		//�α��� ��Ȳ�� ����
		//vo.setEmail_id("kdju203@gmail.com");
		
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		if(loginUser==null) {
			System.out.println("���������� �ҷ����� ����");
			return "member/login";
		}else {
		
		MemberVO getMember = mypageService.getMember(loginUser);
		
		model.addAttribute("getMember", getMember);
		
		return "mypage/my_page";
		}
	}
	
}
