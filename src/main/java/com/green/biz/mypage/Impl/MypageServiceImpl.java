package com.green.biz.mypage.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.biz.dao.MypageDAO;
import com.green.biz.dto.MemberVO;
import com.green.biz.mypage.MypageService;

@Service("mypageService")
public class MypageServiceImpl implements MypageService  {
	@Autowired
	private MypageDAO mDao;
	
	//회원정보 가져오기
		@Override
		public MemberVO getMember(MemberVO vo) {

			return mDao.getMember(vo);
		}

}
