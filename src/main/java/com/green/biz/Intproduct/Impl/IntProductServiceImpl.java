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
	
	//���ɻ�ǰ ��� �ҷ�����
	@Override
	public List<IntproductVO> intproductList(IntproductVO vo) {
		
		return iDao.intproductList(vo);
	}

	//���ɻ�ǰ �߰�
	@Override
	public void insertintProduct(IntproductVO vo) {

		iDao.insertintProduct(vo);
	}

	//���ɻ�ǰ����
	@Override
	public void deleteIntProduct(int pd_number) {
		
		iDao.deleteIntProduct(pd_number);
		
	}

	

}
