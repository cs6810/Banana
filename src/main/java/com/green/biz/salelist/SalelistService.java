package com.green.biz.salelist;

import java.util.List;

import com.green.biz.dto.ProductVO;

public interface SalelistService {

	//�Ǹ� ��� ���� ���ݼ����� ����
	public List<ProductVO> hochGeld(ProductVO vo);
	
	//�Ǹ� ��� ���� ���ݼ����� ����
	public List<ProductVO> niedrigGeld(ProductVO vo);
	
	//�Ǹ� ��� ī�װ��� ����
	public List<ProductVO> saleCategory(ProductVO vo);
	
	//�Ǹ� ��Ͽ��� �˻�
	public List<ProductVO> searchProductlist(String key);

}
