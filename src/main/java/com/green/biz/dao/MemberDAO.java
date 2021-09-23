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
	
	// ȸ��ID ���� Ȯ��
		public int confirmID(MemberVO vo) {
			
			String pwd = mybatis.selectOne("MemberDAO.confirmID", vo);
			
			if (pwd!=null) {
				return 1;
			} else {
				return -1;
			}
		}
	
	//��� ���� �ҷ�����
	public MemberVO memberInfo(MemberVO vo) {
		
		return mybatis.selectOne("MemberDAO.memberInfo",vo);
	}
	
	//��� ���� ����
		public void updateMember(MemberVO vo) {
			
			mybatis.update("MemberDAO.updateMember",vo);
		}
		
		
		//�ּ� ����
				public void updateAddress(MemberVO vo) {
					
					mybatis.update("MemberDAO.updateAddress",vo);
				}
		
		// ȸ������ ��ȸ
		public MemberVO getMember(String email_id) {
					
				return mybatis.selectOne("MemberDAO.getMember", email_id);
			}
				
		//ȸ�� �̸��� ����
		public int confirmID(String email_id) {
		
			String pwd = mybatis.selectOne("MemberDAO.confirmID", email_id);
		
			if (pwd!=null) {
				return 1;
			}else {
				return -1;
			}
		}
		//ȸ�� �߰�
		public void insertMember(MemberVO vo) {
			
			mybatis.insert("MemberDAO.insertMember", vo);
		}
		
		

		/*
		 *  �����ȣ ã�� ȭ�� ��û ó��
		 */
		@RequestMapping(value="/find_zip_num", method=RequestMethod.GET)
		public String findZipNumView() {
			
			return "member/findZipNum";
		}
		
		
		
		//ȸ�� �α���
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

	//����
	public MemberVO findPassword(MemberVO vo) {
		return mybatis.selectOne("MemberDAO.findPassword", vo);
	}



	//��й�ȣ ����
	public int updatePw(MemberVO vo) {
		return mybatis.update("MemberDAO.updatePw", vo);
	}



	//����
	public void changePassword(MemberVO vo) {
		mybatis.update("MemberDAO.changePassword", vo);

		
}
}