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
	
	//판매 목록 높은 가격순으로 정렬
	@RequestMapping(value="/hoch_geld_form",method=RequestMethod.GET)
	public String hochGeld(ProductVO vo,Model model,HttpSession session) {
		
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");

		if(loginUser==null) {
			System.out.println("구매목록 불러오기 실패");
			return "member/login";
		}else {
		
			//로그인한 유저의 정보를 가져오기
			vo.setEmail_id(loginUser.getEmail_id());
			
			List<ProductVO> hochGeld = service.hochGeld(vo);
		
			model.addAttribute("saleList",hochGeld);
			System.out.println(vo);
			System.out.println("판매목록 높은 가격순 정렬");
			return "salelist/salelist";
		}
	}
	
	//판매 목록 낮은 가격순으로 정렬
	@RequestMapping(value="/niedrig_geld_form",method=RequestMethod.GET)
	public String niedrigGeld(ProductVO vo,Model model,HttpSession session) {
		
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");

		if(loginUser==null) {
			System.out.println("구매목록 불러오기 실패");
			return "member/login";
		}else {
		
			//로그인한 유저의 정보를 가져오기
			vo.setEmail_id(loginUser.getEmail_id());
			
			List<ProductVO> niedrigGeld = service.niedrigGeld(vo);
			
			model.addAttribute("saleList",niedrigGeld);
			
			System.out.println(vo);
			System.out.println("판매목록 낮은 가격순 정렬");
			return "salelist/salelist";
		}
	}
		
	//판매 목록 카테고리순으로 정렬
	@RequestMapping(value="/products_sale_category",method=RequestMethod.GET)
	public String saleCategory(@RequestParam(value="category") int category,Model model,
			HttpSession session,ProductVO vo) {
		
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		if(loginUser == null) {
			System.out.println("로그인이 필요합니다");
			return "login/login_form";
		}else {
			//로그인한 유저의 정보를 가져오기
		vo.setEmail_id(loginUser.getEmail_id());
		vo.setCategory(category+"");
				
			
		List<ProductVO> saleCategory = service.saleCategory(vo);
		model.addAttribute("saleList",saleCategory);
		System.out.println("판매목록 카테고리 정렬");
		return "salelist/salelist";
		}
	}
	
		//판매목록에서 검색 기능
		@RequestMapping(value="/searchProduct",method=RequestMethod.GET)
		public String searchProduct(
				@RequestParam(value="key",defaultValue="") String key, 
				Model model,HttpSession session,ProductVO vo) {
			
			MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
			
			if(loginUser == null) {
				System.out.println("로그인이 필요합니다");
				return "login/login_form";
			}else {
			vo.setEmail_id(loginUser.getEmail_id());

			List<ProductVO> searchProductlist = service.searchProductlist(key);
		
			model.addAttribute("saleList",searchProductlist);
			System.out.println(vo);
			System.out.println("판매목록에서 검색 성공");
			return "salelist/salelist";
			}
		}
}
