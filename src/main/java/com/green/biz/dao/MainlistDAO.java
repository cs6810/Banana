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
	
	//���� ����Ʈ(���� ���)�ҷ�����
	public List<ProductVO> getMainlist(ProductVO vo) {
		System.out.println("���� ����Ʈ �ҷ�����");
		return mybatis.selectList("MainlistDAO.getMainlist",vo);
	}
	
	//���� �˻�
	public List<ProductVO> searchProduct(String key){
	System.out.println("���� �˻�");
	return mybatis.selectList("MainlistDAO.searchProduct", key);
	}
	
	//���� ���ݼ����� ����
	public List<ProductVO> highPrice(ProductVO vo) {
		System.out.println("���� ���ݼ����� ����");
		return mybatis.selectList("MainlistDAO.highPrice",vo);
	}
	
	//���� ���ݼ����� ����
	public List<ProductVO> rowPrice(ProductVO vo) {
		System.out.println("���� ���ݼ����� ����");
		return mybatis.selectList("MainlistDAO.rowPrice",vo);
	}

	//ī�װ�����
	public List<ProductVO> category(int category, String searchKey) {
		Map hmap = new HashMap<>();
		
		hmap.put("category", category);
		hmap.put("searchKey", searchKey);
		return mybatis.selectList("MainlistDAO.category",hmap);
	}
	
	// �˻���� ���͸�
	/*
	 * �Է� �Ķ����:
	 *    category: ��ǰ ī�װ�
	 *    filter : ��ȸ ����� �˻� ���� ��
	 *    flag: �˻����� ���� ����
	 *    key: �˻��� 
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
