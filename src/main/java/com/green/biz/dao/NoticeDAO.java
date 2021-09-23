package com.green.biz.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.biz.dto.NoticeVO;


@Repository
public class NoticeDAO {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	public List<NoticeVO> getNoticeList() {
		
		return	mybatis.selectList("NoticeDAO.getNoticeList");
	}
	
	//게시글 불러오기
		public List<NoticeVO> getNoticeList1(){
			
			return	mybatis.selectList("NoticeDAO.getNoticeList1");
		}
}
