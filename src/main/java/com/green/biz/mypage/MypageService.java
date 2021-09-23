package com.green.biz.mypage;

import com.green.biz.dto.MemberVO;

public interface MypageService {

	//회원정보 호출
	public MemberVO getMember(MemberVO vo);
}
