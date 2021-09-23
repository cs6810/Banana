package com.green.biz.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.biz.dto.BuylistVO;
import com.green.biz.dto.ProductVO;

@Repository
public class ProductDAO {
	
	@Autowired 	// 이거 나중에 봐라
	private SqlSessionTemplate mybatis;
	
	public List<ProductVO> saleList(ProductVO vo){
		System.out.println("판매목록 가져오기");
		return mybatis.selectList("ProductDAO.saleList",vo);
	}
	
	public List<BuylistVO> buyList(BuylistVO vo){
		System.out.println("구매목록 가져오기");
		return mybatis.selectList("ProductDAO.buyList",vo);
	}
	

	public ProductVO getProduct(ProductVO vo) {
		
		return mybatis.selectOne("ProductDAO.getProduct", vo);
	}
	
	public void insertProduct(ProductVO vo) {
		
		mybatis.insert("ProductDAO.insertProduct", vo);
	}
	
	public void updateProduct(ProductVO vo) {
		
		mybatis.update("ProductDAO.updateProduct", vo);
	}
}
