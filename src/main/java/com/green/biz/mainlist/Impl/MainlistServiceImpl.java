package com.green.biz.mainlist.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.biz.dao.MainlistDAO;
import com.green.biz.dto.ProductVO;
import com.green.biz.mainlist.MainlistService;

@Service("mainlistService")
public class MainlistServiceImpl implements MainlistService {
	@Autowired
	private MainlistDAO mainDao;
	
	//메인 리스트 불러오기
	@Override
	public List<ProductVO> getMainlist(ProductVO vo) {

		return mainDao.getMainlist(vo);
	}

		//물건 검색
		@Override
		public List<ProductVO> searchProduct(String key) {

			return mainDao.searchProduct(key);
		}

		/*//높은 가격순으로 정렬
		@Override
		public List<ProductVO> highPrice(ProductVO vo) {
			
			return mainDao.highPrice(vo);
		}
		
		//낮은 가격순으로 정렬
		@Override
		public List<ProductVO> rowPrice(ProductVO vo) {

			return mainDao.rowPrice(vo);
		}*/

	//카테고리정렬
	@Override
	public List<ProductVO> category(int category, String searchKey) {
		
		return mainDao.category(category, searchKey);
	}
	
	// 검색 결과 내 필터링
	@Override
	public List<ProductVO> filtering(int category, int filter, boolean flag, String search_key) {
		
		return mainDao.searchFilter(category, filter, flag, search_key);
	}

	
}
