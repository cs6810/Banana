package com.green.biz.mainlist.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.biz.dao.MainlistDAO;
import com.green.biz.dto.ProductVO;
import com.green.biz.mainlist.MainlistService;

@Service("mainlistService")
public class MainlistServiceImpl implements MainlistService {
	@Autowired
	private MainlistDAO mainDao;
	
	//���� ����Ʈ �ҷ�����
	@Override
	public List<ProductVO> getMainlist(ProductVO vo) {

		return mainDao.getMainlist(vo);
	}

		//���� �˻�
		@Override
		public List<ProductVO> searchProduct(String key) {

			return mainDao.searchProduct(key);
		}

		/*//���� ���ݼ����� ����
		@Override
		public List<ProductVO> highPrice(ProductVO vo) {
			
			return mainDao.highPrice(vo);
		}
		
		//���� ���ݼ����� ����
		@Override
		public List<ProductVO> rowPrice(ProductVO vo) {

			return mainDao.rowPrice(vo);
		}*/

	//ī�װ�����
	@Override
	public List<ProductVO> category(int category, String searchKey) {
		
		return mainDao.category(category, searchKey);
	}
	
	// �˻� ��� �� ���͸�
	@Override
	public List<ProductVO> filtering(int category, int filter, boolean flag, String search_key) {
		
		return mainDao.searchFilter(category, filter, flag, search_key);
	}

	
}
