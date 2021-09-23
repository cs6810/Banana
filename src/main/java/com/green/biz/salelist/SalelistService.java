package com.green.biz.salelist;

import java.util.List;

import com.green.biz.dto.ProductVO;

public interface SalelistService {

	//판매 목록 높은 가격순으로 정렬
	public List<ProductVO> hochGeld(ProductVO vo);
	
	//판매 목록 낮은 가격순으로 정렬
	public List<ProductVO> niedrigGeld(ProductVO vo);
	
	//판매 목록 카테고리별 정렬
	public List<ProductVO> saleCategory(ProductVO vo);
	
	//판매 목록에서 검색
	public List<ProductVO> searchProductlist(String key);

}
