package com.green.biz.dao;

import java.util.List
;


import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.green.biz.dto.MemberVO;

@Repository
public class MemberDAO {

	@Autowired
	private SqlSessionTemplate mybatis;
	
	// 회원ID 존재 확인
		public int confirmID(MemberVO vo) {
			
			String pwd = mybatis.selectOne("MemberDAO.confirmID", vo);
			
			if (pwd!=null) {
				return 1;
			} else {
				return -1;
			}
		}
	
	//멤버 정보 불러오기
	public MemberVO memberInfo(MemberVO vo) {
		
		return mybatis.selectOne("MemberDAO.memberInfo",vo);
	}
	
	//멤버 정보 수정
		public void updateMember(MemberVO vo) {
			
			mybatis.update("MemberDAO.updateMember",vo);
		}
		
		
		//주소 수정
				public void updateAddress(MemberVO vo) {
					
					mybatis.update("MemberDAO.updateAddress",vo);
				}
		
		// 회원정보 조회
		public MemberVO getMember(String email_id) {
					
				return mybatis.selectOne("MemberDAO.getMember", email_id);
			}
				
		//회원 이메일 컨펌
		public int confirmID(String email_id) {
		
			String pwd = mybatis.selectOne("MemberDAO.confirmID", email_id);
		
			if (pwd!=null) {
				return 1;
			}else {
				return -1;
			}
		}
		//회원 추가
		public void insertMember(MemberVO vo) {
			
			mybatis.insert("MemberDAO.insertMember", vo);
		}
		
		

		/*
		 *  우편번호 찾기 화면 요청 처리
		 */
		@RequestMapping(value="/find_zip_num", method=RequestMethod.GET)
		public String findZipNumView() {
			
			return "member/findZipNum";
		}
		
		
		
		//회원 로그인
	public int loginID(MemberVO vo) {
		int result = -1;
		String pwd = null;
		
		pwd = mybatis.selectOne("MemberDAO.confirmID", vo.getEmail_id());
		
		
		 if (pwd == null) { 
			result = -1;
		}else if(pwd.equals(vo.getPwd())) { 
			result = 1;
		}else { 		
			result = 0;
		}
		 return result;
	}

	

	public MemberVO getMemberByNameAndPhnm(MemberVO vo) {
		return mybatis.selectOne("MemberDAO.getMemberByNameAndPhnm",vo);
	}

	//기존
	public MemberVO findPassword(MemberVO vo) {
		return mybatis.selectOne("MemberDAO.findPassword", vo);
	}



	//비밀번호 변경
	public int updatePw(MemberVO vo) {
		return mybatis.update("MemberDAO.updatePw", vo);
	}



	//기존
	public void changePassword(MemberVO vo) {
		mybatis.update("MemberDAO.changePassword", vo);

		
}
}