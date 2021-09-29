package com.green.biz.Intproduct.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.biz.Intproduct.IntProductService;
import com.green.biz.dao.IntproductDAO;
import com.green.biz.dto.IntproductVO;

@Service("IntProductService")
public class IntProductServiceImpl implements IntProductService {

	@Autowired
	private IntproductDAO iDao;
	
	//관심상품 목록 불러오기
	@Override
	public List<IntproductVO> intproductList(IntproductVO vo) {
		
		return iDao.intproductList(vo);
	}

	//관심상품 추가
	@Override
	public void insertintProduct(IntproductVO vo) {

		iDao.insertintProduct(vo);
	}

	//관심상품제거
	@Override
	public void deleteIntProduct(int pd_number) {
		
		iDao.deleteIntProduct(pd_number);
		
	}

	

}
