package com.green.view.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.green.biz.dto.MemberVO;
import com.green.biz.dto.ProductVO;
import com.green.biz.salelist.SalelistService;
@Controller
@SessionAttributes("loginUser")
public class SalelistController {

	@Autowired
	private SalelistService service;
	
	//�Ǹ� ��� ���� ���ݼ����� ����
	@RequestMapping(value="/hoch_geld_form",method=RequestMethod.GET)
	public String hochGeld(ProductVO vo,Model model,HttpSession session) {
		
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");

		if(loginUser==null) {
			System.out.println("���Ÿ�� �ҷ����� ����");
			return "member/login";
		}else {
		
			//�α����� ������ ������ ��������
			vo.setEmail_id(loginUser.getEmail_id());
			
			List<ProductVO> hochGeld = service.hochGeld(vo);
		
			model.addAttribute("saleList",hochGeld);
			System.out.println(vo);
			System.out.println("�ǸŸ�� ���� ���ݼ� ����");
			return "salelist/salelist";
		}
	}
	
	//�Ǹ� ��� ���� ���ݼ����� ����
	@RequestMapping(value="/niedrig_geld_form",method=RequestMethod.GET)
	public String niedrigGeld(ProductVO vo,Model model,HttpSession session) {
		
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");

		if(loginUser==null) {
			System.out.println("���Ÿ�� �ҷ����� ����");
			return "member/login";
		}else {
		
			//�α����� ������ ������ ��������
			vo.setEmail_id(loginUser.getEmail_id());
			
			List<ProductVO> niedrigGeld = service.niedrigGeld(vo);
			
			model.addAttribute("saleList",niedrigGeld);
			
			System.out.println(vo);
			System.out.println("�ǸŸ�� ���� ���ݼ� ����");
			return "salelist/salelist";
		}
	}
		
	//�Ǹ� ��� ī�װ������� ����
	@RequestMapping(value="/products_sale_category",method=RequestMethod.GET)
	public String saleCategory(@RequestParam(value="category") int category,Model model,
			HttpSession session,ProductVO vo) {
		
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			System.out.println("�α����� �ʿ��մϴ�");
			return "login/login_form";
		}else {
			//�α����� ������ ������ ��������
		vo.setEmail_id(loginUser.getEmail_id());
		vo.setCategory(category+"");
				
			
		List<ProductVO> saleCategory = service.saleCategory(vo);
		model.addAttribute("saleList",saleCategory);
		System.out.println("�ǸŸ�� ī�װ� ����");
		return "salelist/salelist";
		}
	}
	
		//�ǸŸ�Ͽ��� �˻� ���
		@RequestMapping(value="/searchProduct",method=RequestMethod.GET)
		public String searchProduct(
				@RequestParam(value="key",defaultValue="") String key, 
				Model model,HttpSession session,ProductVO vo) {
			
			MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
			
			if(loginUser == null) {
				System.out.println("�α����� �ʿ��մϴ�");
				return "login/login_form";
			}else {
			vo.setEmail_id(loginUser.getEmail_id());

			List<ProductVO> searchProductlist = service.searchProductlist(key);
		
			model.addAttribute("saleList",searchProductlist);
			System.out.println(vo);
			System.out.println("�ǸŸ�Ͽ��� �˻� ����");
			return "salelist/salelist";
			}
		}
}
