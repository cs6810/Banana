package com.green.biz.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.biz.dto.ProductVO;

@Repository
public class SalelistDAO {

	@Autowired
	private SqlSessionTemplate mybaits;
	
		//�Ǹ� ��ϳ��� ���ݼ����� ����
		public List<ProductVO> hochGeld(ProductVO vo){
			System.out.println("�Ǹ� ��� ���� ���ݼ����� ����");
			return mybaits.selectList("SalelistDAO.hochGeld",vo);
		}
		
		//�Ǹ� ��� ���� ���ݼ����� ����
		public List<ProductVO> niedrigGeld(ProductVO vo) {
			System.out.println("�Ǹ� ��� ���� ���ݼ����� ����");
			return mybaits.selectList("SalelistDAO.niedrigGeld",vo);
		}

		//�Ǹ� ��� ī�װ�����
		public List<ProductVO> saleCategory(ProductVO vo) {

			return mybaits.selectList("SalelistDAO.saleCategory",vo);
		}
		
		//�ǸŸ�Ͽ��� �˻�
		public List<ProductVO> searchProductlist(String key) {
			System.out.println("���� �˻�");
			return mybaits.selectList("SalelistDAO.searchProductlist",key);
		}
}
