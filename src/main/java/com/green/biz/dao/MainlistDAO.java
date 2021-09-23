package com.green.biz.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.biz.dto.ProductVO;

@Repository
public class MainlistDAO {
	
	@Autowired
	private SqlSessionTemplate mybaits;
	
	//���� ����Ʈ(���� ���)�ҷ�����
	public List<ProductVO> getMainlist(ProductVO vo) {
		System.out.println("���� ����Ʈ �ҷ�����");
		return mybaits.selectList("MainlistDAO.getMainlist",vo);
	}
	
	//���� �˻�
	public List<ProductVO> searchProduct(String key){
	System.out.println("���� �˻�");
	return mybaits.selectList("MainlistDAO.searchProduct", key);
	}
	
	//���� ���ݼ����� ����
	public List<ProductVO> highPrice(ProductVO vo) {
		System.out.println("���� ���ݼ����� ����");
		return mybaits.selectList("MainlistDAO.highPrice",vo);
	}
	
	//���� ���ݼ����� ����
	public List<ProductVO> rowPrice(ProductVO vo) {
		System.out.println("���� ���ݼ����� ����");
		return mybaits.selectList("MainlistDAO.rowPrice",vo);
	}

	//ī�װ�����
	public List<ProductVO> category(int category) {

		return mybaits.selectList("MainlistDAO.category",category);
	}
}
