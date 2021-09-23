package com.green.biz.mainlist;

import java.util.List;

import com.green.biz.dto.ProductVO;

public interface MainlistService {

	//메인 리스트(물건 목록)호출
	public List<ProductVO> getMainlist(ProductVO vo);

	//물건 검색
	public List<ProductVO> searchProduct(String key);
	
	//높은 가격순으로 정렬
	public List<ProductVO> highPrice(ProductVO vo);

	//낮은 가격순으로 정렬
	public List<ProductVO> rowPrice(ProductVO vo);
	
	//카테고리별 정렬
	public List<ProductVO> category(int category);
		
}
