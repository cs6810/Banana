package com.green.biz.Intproduct;

import java.util.List;

import com.green.biz.dto.IntproductVO;


public interface IntProductService {
		//관심상품 목록 불러오기
		public List<IntproductVO> intproductList(IntproductVO vo);

		//관심상품 등록하기
		public void insertintProduct(IntproductVO vo);
		
		//관심상품 삭제하기
		public void deleteIntProduct(int pd_number);
}


