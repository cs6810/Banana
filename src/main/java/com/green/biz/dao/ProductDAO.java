package com.green.biz.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.biz.dto.BuylistVO;
import com.green.biz.dto.ProductVO;

@Repository
public class ProductDAO {
	
	@Autowired 	// �̰� ���߿� ����
	private SqlSessionTemplate mybatis;
	
	public List<ProductVO> saleList(ProductVO vo){
		System.out.println("�ǸŸ�� ��������");
		return mybatis.selectList("ProductDAO.saleList",vo);
	}
	
	public List<BuylistVO> buyList(BuylistVO vo){
		System.out.println("���Ÿ�� ��������");
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
