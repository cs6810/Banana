package com.green.view.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.green.biz.dto.ProductVO;
import com.green.biz.mainlist.MainlistService;

@Controller
public class MainlistController {

	@Autowired
	private MainlistService service;
	
	//메인 페이지 불러오기
	@RequestMapping(value="/index",method=RequestMethod.GET)
	public String getMainList(ProductVO vo,Model model) {
		
	List<ProductVO> getMainlist = service.getMainlist(vo);
	model.addAttribute("getMainlist",getMainlist);
	System.out.println(vo);
	return "mainlist/mainlist";
	}
	
	//검색 기능
		@RequestMapping(value="/search",method=RequestMethod.GET)
		public String searchProduct(
				@RequestParam(value="key",defaultValue="") String key, 
				Model model) {
			
			List<ProductVO> searchProduct = service.searchProduct(key);
		
			model.addAttribute("getMainlist",searchProduct);
			
			return "mainlist/mainlist";
		}
		
		//가격이 높은 순으로 정렬하기
		@RequestMapping(value="/high_price_form",method=RequestMethod.GET)
		public String highPrice(ProductVO vo,Model model) {
			
		List<ProductVO> highPrice = service.highPrice(vo);
		model.addAttribute("getMainlist",highPrice);
		System.out.println(vo);
		return "mainlist/mainlist";
		}
		
		//가격이 낮은 순으로 정렬하기
		@RequestMapping(value="/row_price_form",method=RequestMethod.GET)
		public String rowPrice(ProductVO vo,Model model) {
			
		List<ProductVO> rowPrice = service.rowPrice(vo);
		model.addAttribute("getMainlist",rowPrice);
		System.out.println(vo);
		return "mainlist/mainlist";
		}
		
		//카테고리정렬
		@RequestMapping(value="/products_by_category",method=RequestMethod.GET)
		public String category(@RequestParam(value="category") int category, Model model) {
			
			List<ProductVO> listProduct = service.category(category);
			model.addAttribute("getMainlist", listProduct);
			//System.out.println(vo);
			return "mainlist/mainlist";
		}
		
}
