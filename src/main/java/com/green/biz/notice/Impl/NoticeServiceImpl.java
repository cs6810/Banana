package com.green.biz.notice.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.biz.dao.NoticeDAO;
import com.green.biz.dto.NoticeVO;
import com.green.biz.notice.NoticeService;

@Service("noticeService")
public class NoticeServiceImpl implements NoticeService {
	
	@Autowired
	private NoticeDAO nDao;

	
	@Override
	public List<NoticeVO> getNoticeList() {

		return nDao.getNoticeList();
	}
	//�Խñ� �ҷ�����
		@Override
		public List<NoticeVO> getNoticeList1() {

			return nDao.getNoticeList1();
		}
}
