package com.green.biz.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.biz.dto.IntproductVO;

@Repository
public class IntproductDAO {
	
	@Autowired 	
	private SqlSessionTemplate mybatis;
	
	//관심상품 가져오기
	public List<IntproductVO> intproductList(IntproductVO vo){
		System.out.println("관심상품 가져오기");
		return mybatis.selectList("IntproductDAO.intproductList",vo);
	}
	
	//관심상품 등록하기
	public void insertintProduct(IntproductVO vo) {
		System.out.println("관심상품 등록하기");
		mybatis.insert("IntproductDAO.insertintProduct", vo);
	}
	
	// 관심상품 삭제
	public void deleteIntProduct(int pd_number) {
		System.out.println("관심상품 삭제");
		mybatis.delete("IntproductDAO.deleteIntProduct", pd_number);
	}
}
