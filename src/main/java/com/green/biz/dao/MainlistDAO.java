package com.green.biz.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.biz.dto.ProductVO;

@Repository
public class MainlistDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	//메인 리스트(물건 목록)불러오기
	public List<ProductVO> getMainlist(ProductVO vo) {
		System.out.println("메인 리스트 불러오기");
		return mybatis.selectList("MainlistDAO.getMainlist",vo);
	}
	
	//물건 검색
	public List<ProductVO> searchProduct(String key){
	System.out.println("물건 검색");
	return mybatis.selectList("MainlistDAO.searchProduct", key);
	}
	
	//높은 가격순으로 정렬
	public List<ProductVO> highPrice(ProductVO vo) {
		System.out.println("높은 가격순으로 정렬");
		return mybatis.selectList("MainlistDAO.highPrice",vo);
	}
	
	//낮은 가격순으로 정렬
	public List<ProductVO> rowPrice(ProductVO vo) {
		System.out.println("낮은 가격순으로 정렬");
		return mybatis.selectList("MainlistDAO.rowPrice",vo);
	}

	//카테고리정렬
	public List<ProductVO> category(int category, String searchKey) {
		Map hmap = new HashMap<>();
		
		hmap.put("category", category);
		hmap.put("searchKey", searchKey);
		return mybatis.selectList("MainlistDAO.category",hmap);
	}
	
	// 검색결과 필터링
	/*
	 * 입력 파라미터:
	 *    category: 제품 카테고리
	 *    filter : 조회 결과내 검색 필터 값
	 *    flag: 검색조건 존재 여부
	 *    key: 검색어 
	 */
	public List<ProductVO> searchFilter(int category, int filter, boolean flag, String key) {
		Map hmap = new HashMap<>();
		
		hmap.put("category", category);
		hmap.put("filter", filter);
		hmap.put("search_flag", flag);
		hmap.put("search_key", key);
		
		return mybatis.selectList("MainlistDAO.searchFilter", hmap);
	}
}
