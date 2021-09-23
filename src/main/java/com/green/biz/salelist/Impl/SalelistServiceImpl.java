package com.green.biz.salelist.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.biz.dao.SalelistDAO;
import com.green.biz.dto.ProductVO;
import com.green.biz.salelist.SalelistService;

@Service("salelistService")
public class SalelistServiceImpl implements SalelistService {
	@Autowired
	private SalelistDAO sDao;
	
	//판매 목록  높은 가격순으로 정렬
	@Override
	public List<ProductVO> hochGeld(ProductVO vo) {
		return sDao.hochGeld(vo);
	}

	//판매 목록 낮은 가격순으로 정렬
	@Override
	public List<ProductVO> niedrigGeld(ProductVO vo) {
		return sDao.niedrigGeld(vo);
	}

	//판매 목록 카테고리별 정렬
	@Override
	public List<ProductVO> saleCategory(ProductVO vo) {
		return sDao.saleCategory(vo);
	}

	//판매 목록에서 검색
	@Override
	public List<ProductVO> searchProductlist(String key) {

		return sDao.searchProductlist(key);
	}

	
}
