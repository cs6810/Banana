package com.green.biz.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.green.biz.dto.MemberVO;

@Repository
public class MypageDAO {
	
	@Autowired
	private SqlSessionTemplate mybaits;
	
	//��� ���� �ҷ�����
		public MemberVO getMember(MemberVO vo) {
			System.out.println("MypageDAO: vo=" + vo);
			return mybaits.selectOne("MypageDAO.getMember",vo.getEmail_id());
		}
}
