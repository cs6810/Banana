package com.green.biz.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.biz.dto.ProductVO;

@Repository
public class MainlistDAO {
	
	@Autowired
	private SqlSessionTemplate mybaits;
	
	//메인 리스트(물건 목록)불러오기
	public List<ProductVO> getMainlist(ProductVO vo) {
		System.out.println("메인 리스트 불러오기");
		return mybaits.selectList("MainlistDAO.getMainlist",vo);
	}
	
	//물건 검색
	public List<ProductVO> searchProduct(String key){
	System.out.println("물건 검색");
	return mybaits.selectList("MainlistDAO.searchProduct", key);
	}
	
	//높은 가격순으로 정렬
	public List<ProductVO> highPrice(ProductVO vo) {
		System.out.println("높은 가격순으로 정렬");
		return mybaits.selectList("MainlistDAO.highPrice",vo);
	}
	
	//낮은 가격순으로 정렬
	public List<ProductVO> rowPrice(ProductVO vo) {
		System.out.println("낮은 가격순으로 정렬");
		return mybaits.selectList("MainlistDAO.rowPrice",vo);
	}

	//카테고리정렬
	public List<ProductVO> category(int category) {

		return mybaits.selectList("MainlistDAO.category",category);
	}
}
