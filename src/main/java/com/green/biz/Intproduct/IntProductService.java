package com.green.biz.Intproduct;

import java.util.List;

import com.green.biz.dto.IntproductVO;


public interface IntProductService {
		//���ɻ�ǰ ��� �ҷ�����
		public List<IntproductVO> intproductList(IntproductVO vo);

		//���ɻ�ǰ ����ϱ�
		public void insertintProduct(IntproductVO vo);
		
		//���ɻ�ǰ �����ϱ�
		public void deleteIntProduct(int pd_number);
}


