package com.green.view.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
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
import org.springframework.web.multipart.MultipartFile;

import com.green.biz.dto.BuylistVO;
import com.green.biz.dto.MemberVO;
import com.green.biz.dto.ProductVO;
import com.green.biz.product.ProductService;

@Controller
@SessionAttributes("loginUser")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	//판매목록 불러오기
	@RequestMapping(value="/sale_list_form",method=RequestMethod.GET)
	public String saleList(Model model,ProductVO vo,HttpSession session){
		
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");

		if(loginUser==null) {
			System.out.println("판매목록 불러오기 실패");
			return "member/login";
		}else {
		
			//로그인한 유저의 정보를 가져오기
			vo.setEmail_id(loginUser.getEmail_id());
			
			List<ProductVO> saleList = productService.saleList(vo);
			
			model.addAttribute("saleList", saleList);
			System.out.println(saleList);
			return "salelist/salelist";
			}
	}
	
	//구매목록 불러오기
	@RequestMapping(value="/buy_list_form",method=RequestMethod.GET)
	public String buyList(Model model, BuylistVO vo1,ProductVO vo,HttpSession session) {
		

		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");

		if(loginUser==null) {
			System.out.println("구매목록 불러오기 실패");
			return "member/login";
		}else {
		
			//로그인한 유저의 정보를 가져오기
			vo1.setBuy_email(loginUser.getEmail_id());
			
				List<BuylistVO> buyList = productService.buyList(vo1);
				
				model.addAttribute("buyList", buyList);
				System.out.println(buyList);
				return "buylist/buylist";
		}
	}
	
	//상품등록 화면 호출
	@RequestMapping(value = "/product_form", method = RequestMethod.POST)
	public String productForm() {
		return "product/product_insert"; 	//product_insert.jsp
	}
	
	//상품 등록 실행
	@RequestMapping(value="insert_product", method = {RequestMethod.GET, RequestMethod.POST})
	public String adminProductWrite(@RequestParam(value="productImage") MultipartFile uploadFile,
			@RequestParam(value="emailID") String email_id,
			@RequestParam(value="phNm") String ph_nm,
			ProductVO vo, HttpSession session) {
		
		
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		if (loginUser == null) {
			return "redirect:/index";
		} else {		
			String imgFile = "";
			
			if (!uploadFile.isEmpty()) {
				imgFile = uploadFile.getOriginalFilename();
				vo.setImage1(imgFile); 
				
				String image_path 
				= session.getServletContext().getRealPath("WEB-INF/resources/images/product/");
				System.out.println("이동 이미지 경로: " +image_path );
				
				try {
					File file = new File(image_path+imgFile);
					uploadFile.transferTo(file); 
				} catch (IllegalStateException | IOException e) {
					e.printStackTrace();
				}	
			}
			
			vo.setPh_nm(ph_nm);
			vo.setEmail_id(email_id);
			productService.insertProduct(vo);
			
			System.out.println("상품등록완료");
			
			//return "redirect:product/product_detail?pd_id="+vo.getPd_id();
			return "redirect:/index";
		}
	}
	
	//상품 수정화면 호출
	@RequestMapping(value = "/update_form", method = RequestMethod.POST)
	public String updateForm(ProductVO vo, Model model) {
		
		ProductVO product = productService.getProduct(vo);
		
		model.addAttribute("productVO", product);
		
		return "product/product_update"; 	//product_update.jsp
	}
	
	//상품 수정 저장 실행
	@RequestMapping(value = "/update_product", method = {RequestMethod.GET, RequestMethod.POST})
	public String productUpdate(@RequestParam(value="productImage") MultipartFile uploadFile,
			@RequestParam(value="emailID") String email_id,
			@RequestParam(value="phNm") String ph_nm,
			ProductVO vo, HttpSession session) {
		
		MemberVO loginUser = (MemberVO)session.getAttribute("loginUser");
		
		if (loginUser == null) {
			return "redirect:/index";
		} else {		
			String imgFile = "";
			
			if (!uploadFile.isEmpty()) {
				imgFile = uploadFile.getOriginalFilename();
				vo.setImage1(imgFile); 
				
				String image_path 
				= session.getServletContext().getRealPath("WEB-INF/resources/images/product/");
				System.out.println("이동 이미지 경로: " +image_path );
				
				try {
					File file = new File(image_path+imgFile);
					uploadFile.transferTo(file); 
				} catch (IllegalStateException | IOException e) {
					e.printStackTrace();
				}	
			}
			
			vo.setPh_nm(ph_nm);
			vo.setEmail_id(email_id);
			
			
			productService.updateProduct(vo);
			
			System.out.println("상품수정완료");
			
			return "redirect:/index";
		}
	}
	
	//상품 상세화면 보기 product_detail
	@RequestMapping(value="/product_detail", method = {RequestMethod.GET, RequestMethod.POST})
	public String productDetail(ProductVO vo, Model model) {
		
		ProductVO product = productService.getProduct(vo);
		model.addAttribute("productVO", product);
		
		return "product/product_detail";
	}
	
}
