package com.green.biz.product.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.biz.dao.ProductDAO;
import com.green.biz.dto.BuylistVO;
import com.green.biz.dto.ProductVO;
import com.green.biz.product.ProductService;

@Service("productService")
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDAO pDao;
	
	//판매 리스트 불러오기
	@Override
	public List<ProductVO> saleList(ProductVO vo) {
		
		return pDao.saleList(vo);
	}

	@Override
	public List<BuylistVO> buyList(BuylistVO vo) {
		
		return pDao.buyList(vo);
	}

	@Override
	public void insertProduct(ProductVO vo) {
		
		pDao.insertProduct(vo);
	}

	@Override
	public ProductVO getProduct(ProductVO vo) {
		
		return pDao.getProduct(vo);
	}
	
	@Override
	public void updateProduct(ProductVO vo) {
		
		pDao.updateProduct(vo);
	}

}
