package com.green.biz.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.biz.dto.ProductVO;

@Repository
public class SalelistDAO {

	@Autowired
	private SqlSessionTemplate mybaits;
	
		//판매 목록높은 가격순으로 정렬
		public List<ProductVO> hochGeld(ProductVO vo){
			System.out.println("판매 목록 높은 가격순으로 정렬");
			return mybaits.selectList("SalelistDAO.hochGeld",vo);
		}
		
		//판매 목록 낮은 가격순으로 정렬
		public List<ProductVO> niedrigGeld(ProductVO vo) {
			System.out.println("판매 목록 낮은 가격순으로 정렬");
			return mybaits.selectList("SalelistDAO.niedrigGeld",vo);
		}

		//판매 목록 카테고리정렬
		public List<ProductVO> saleCategory(ProductVO vo) {

			return mybaits.selectList("SalelistDAO.saleCategory",vo);
		}
		
		//판매목록에서 검색
		public List<ProductVO> searchProductlist(String key) {
			System.out.println("물건 검색");
			return mybaits.selectList("SalelistDAO.searchProductlist",key);
		}
}
