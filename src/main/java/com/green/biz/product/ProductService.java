package com.green.biz.product;

import java.util.List;

import com.green.biz.dto.BuylistVO;
import com.green.biz.dto.ProductVO;

public interface ProductService {

	//판매 리스트 호출하기
	public List<ProductVO> saleList(ProductVO vo);
	
	//구매 리스트 호출하기
	public List<BuylistVO> buyList(BuylistVO vo);
	
	//상품가져오기
	ProductVO getProduct(ProductVO vo);
	
	//상품 등록하기
	public void insertProduct(ProductVO vo);
	
	//상품 수정하기
	public void updateProduct(ProductVO vo);
}
