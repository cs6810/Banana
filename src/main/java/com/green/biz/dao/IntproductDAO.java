package com.green.biz.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.biz.dto.IntproductVO;

@Repository
public class IntproductDAO {
	
	@Autowired 	
	private SqlSessionTemplate mybatis;
	
	//���ɻ�ǰ ��������
	public List<IntproductVO> intproductList(IntproductVO vo){
		System.out.println("���ɻ�ǰ ��������");
		return mybatis.selectList("IntproductDAO.intproductList",vo);
	}
	
	//���ɻ�ǰ ����ϱ�
	public void insertintProduct(IntproductVO vo) {
		System.out.println("���ɻ�ǰ ����ϱ�");
		mybatis.insert("IntproductDAO.insertintProduct", vo);
	}
	
	// ���ɻ�ǰ ����
	public void deleteIntProduct(int pd_number) {
		System.out.println("���ɻ�ǰ ����");
		mybatis.delete("IntproductDAO.deleteIntProduct", pd_number);
	}
}
