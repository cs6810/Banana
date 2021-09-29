package com.green.biz.mainlist;

import java.util.List;

import com.green.biz.dto.ProductVO;

public interface MainlistService {

	//���� ����Ʈ(���� ���)ȣ��
	public List<ProductVO> getMainlist(ProductVO vo);

	//���� �˻�
	public List<ProductVO> searchProduct(String key);
	
	/*//���� ���ݼ����� ����
	public List<ProductVO> highPrice(ProductVO vo);

	//���� ���ݼ����� ����
	public List<ProductVO> rowPrice(ProductVO vo);
	*/
	
	//ī�װ��� ����
	public List<ProductVO> category(int category, String searchKey);
	
	// �˻� ��� �� ���͸�
	public List<ProductVO> filtering(int category, int filter, boolean flag, String search_key);
		
}
