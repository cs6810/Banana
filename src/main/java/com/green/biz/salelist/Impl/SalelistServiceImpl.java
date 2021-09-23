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
	
	//�Ǹ� ���  ���� ���ݼ����� ����
	@Override
	public List<ProductVO> hochGeld(ProductVO vo) {
		return sDao.hochGeld(vo);
	}

	//�Ǹ� ��� ���� ���ݼ����� ����
	@Override
	public List<ProductVO> niedrigGeld(ProductVO vo) {
		return sDao.niedrigGeld(vo);
	}

	//�Ǹ� ��� ī�װ��� ����
	@Override
	public List<ProductVO> saleCategory(ProductVO vo) {
		return sDao.saleCategory(vo);
	}

	//�Ǹ� ��Ͽ��� �˻�
	@Override
	public List<ProductVO> searchProductlist(String key) {

		return sDao.searchProductlist(key);
	}

	
}
