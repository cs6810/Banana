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
	
	//���ɻ�ǰ ��� �ҷ�����
	@RequestMapping(value="/int_product_list_form",method=RequestMethod.GET)
	public String intproductList(Model model,MemberVO vo1,IntproductVO vo,HttpSession session){

		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");

		
		if(loginUser==null) {
			System.out.println("���ɻ�ǰ ��� �ҷ����� ����");
			return "member/login";
		}else {
			//�α����� ������ ������ ��������
			vo1.setEmail_id(loginUser.getEmail_id());
			vo.setUser_id(loginUser.getEmail_id());
			
			List<IntproductVO> intproductList = service.intproductList(vo);
			
			model.addAttribute("intproductList", intproductList);
			System.out.println(vo);
			return "intproduct/intproduct";
		}
	}
}
