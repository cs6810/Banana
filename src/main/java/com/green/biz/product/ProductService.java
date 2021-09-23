package com.green.biz.product;

import java.util.List;

import com.green.biz.dto.BuylistVO;
import com.green.biz.dto.ProductVO;

public interface ProductService {

	//�Ǹ� ����Ʈ ȣ���ϱ�
	public List<ProductVO> saleList(ProductVO vo);
	
	//���� ����Ʈ ȣ���ϱ�
	public List<BuylistVO> buyList(BuylistVO vo);
	
	//��ǰ��������
	ProductVO getProduct(ProductVO vo);
	
	//��ǰ ����ϱ�
	public void insertProduct(ProductVO vo);
	
	//��ǰ �����ϱ�
	public void updateProduct(ProductVO vo);
}
