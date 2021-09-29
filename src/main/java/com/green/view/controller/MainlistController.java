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
	private int product_category = 99;
	private String search_key = "";
	private Boolean search_flag = false;
	
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
			
			search_key = key;	// 화면에서 입력한 검색어를 글로벌 변수에 저장(필터릴에 사용하기 위함)
			search_flag = true;
			product_category = 99;	// 키워드 검색일 경우 제품 종류를 전체제품으로 초기화
			
			List<ProductVO> searchProduct = service.searchProduct(search_key);
		
			model.addAttribute("getMainlist",searchProduct);
			
			return "mainlist/mainlist";
		}
		
		/*//가격이 높은 순으로 정렬하기
		@RequestMapping(value="/high_price_form",method=RequestMethod.GET)
		public String highPrice(ProductVO vo,Model model) {
			
		List<ProductVO> highPrice = service.highPrice(vo);
		model.addAttribute("getMainlist",highPrice);
		System.out.println(vo);
		return "mainlist/mainlist";
		}*/
		
		/*//가격이 낮은 순으로 정렬하기
		@RequestMapping(value="/row_price_form",method=RequestMethod.GET)
		public String rowPrice(ProductVO vo,Model model) {
			
		List<ProductVO> rowPrice = service.rowPrice(vo);
		model.addAttribute("getMainlist",rowPrice);
		System.out.println(vo);
		return "mainlist/mainlist";
		}*/
		
		//카테고리정렬
		@RequestMapping(value="/products_by_category",method=RequestMethod.GET)
		public String category(@RequestParam(value="category") int category, @RequestParam(value="searchKey") String searchKey, Model model) {
			System.out.println("category: " + category);
			System.out.println("Key: " + searchKey);
			product_category = category;
			search_flag = false;	// 카테고리별 검색일 경우 키워드 검색 여부를 false로
			List<ProductVO> listProduct = service.category(product_category, searchKey);
			model.addAttribute("getMainlist", listProduct);
			//System.out.println(vo);
			return "mainlist/mainlist";
		}
		
		//필터링으로 검색 결과에서 재검색
		@RequestMapping(value="/search_filter", method=RequestMethod.GET)
		public String searchFilter(@RequestParam(value="filter") int filter, Model model) {
			
			System.out.printf("category=%d, filter=%d, search_flag=%b, search+key=%s\n",
					product_category, filter, search_flag, search_key);
			
			List<ProductVO> listProduct = service.filtering(product_category, filter, search_flag, search_key);
			
			model.addAttribute("getMainlist", listProduct);
			
			return "mainlist/mainlist";
		}
		
}
