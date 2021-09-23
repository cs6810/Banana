package com.green.biz.notice;

import java.util.List;

import com.green.biz.dto.NoticeVO;

public interface NoticeService {
	
	public List<NoticeVO> getNoticeList();

	//게시글 불러오기
		public List<NoticeVO> getNoticeList1();
}
