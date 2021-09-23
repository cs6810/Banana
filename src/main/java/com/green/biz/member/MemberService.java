package com.green.biz.member;

import java.util.List;

import javax.servlet.http.HttpServletResponse;


import com.green.biz.dto.MemberVO;

public interface MemberService {


	//회원정보 호출
	public MemberVO memberInfo(MemberVO vo);
	
	//회원정보 수정
	public void updateMember(MemberVO vo);
	// 회원정보 조회
		MemberVO getMember(String email_id);

		//회원 이메일 컨펌
		int confirmID(String email_id);

		//회원 추가
		void insertMember(MemberVO vo);
		
		//주소 수정
		public void updateAddress(MemberVO vo);
		
		
		// 회원 로그인
		public int loginID(MemberVO vo);
		
		//우편번호 찾기


			//사용자 이름과 전화번호를 조건으로 사용자 정보조회
		public MemberVO getMemberByNameAndPhnm(MemberVO vo);
			
		
		//기존  사용자 아이디와 이름, 이메일을 조건으로 사용자 정보 조회
		
		public MemberVO findPassword(MemberVO vo);
			
		//기존 사용자 암호변경
		
		public void changePassword(MemberVO vo);
		
		

		/*
		//NEW 이메일발송
		public void sendEmail(MemberVO vo, String div) throws Exception;

		//NEW 비밀번호찾기
		public void findPw(HttpServletResponse response, MemberVO vo) throws Exception;

		//NEW비밀번호 변경
		public int updatePw(MemberVO vo) throws Exception;
*/
		
		
	}