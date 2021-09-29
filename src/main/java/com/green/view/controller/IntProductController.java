package com.green.view.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.green.biz.Intproduct.IntProductService;
import com.green.biz.dto.IntproductVO;
import com.green.biz.dto.MemberVO;

@Controller
//@SessionAttributes("loginUser")
public class IntProductController {

	@Autowired
	private IntProductService service;
	
	//관심상품 목록 불러오기
	@RequestMapping(value="/int_product_list_form",method=RequestMethod.GET)
	public String intproductList(Model model,MemberVO vo1,IntproductVO vo,HttpSession session){

		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");

		
		if(loginUser==null) {
			System.out.println("관심상품 목록 불러오기 실패");
			return "member/login";
		}else {
			//로그인한 유저의 정보를 가져오기
			vo1.setEmail_id(loginUser.getEmail_id());
			vo.setUser_id(loginUser.getEmail_id());
			
			List<IntproductVO> intproductList = service.intproductList(vo);
			
			model.addAttribute("intproductList", intproductList);
			System.out.println(vo);
			return "intproduct/intproduct";
		}
	}
}
