package com.green.biz.member;

import java.util.List;

import javax.servlet.http.HttpServletResponse;


import com.green.biz.dto.MemberVO;

public interface MemberService {


	//ȸ������ ȣ��
	public MemberVO memberInfo(MemberVO vo);
	
	//ȸ������ ����
	public void updateMember(MemberVO vo);
	// ȸ������ ��ȸ
		MemberVO getMember(String email_id);

		//ȸ�� �̸��� ����
		int confirmID(String email_id);

		//ȸ�� �߰�
		void insertMember(MemberVO vo);
		
		//�ּ� ����
		public void updateAddress(MemberVO vo);
		
		
		// ȸ�� �α���
		public int loginID(MemberVO vo);
		
		//�����ȣ ã��


			//����� �̸��� ��ȭ��ȣ�� �������� ����� ������ȸ
		public MemberVO getMemberByNameAndPhnm(MemberVO vo);
			
		
		//����  ����� ���̵�� �̸�, �̸����� �������� ����� ���� ��ȸ
		
		public MemberVO findPassword(MemberVO vo);
			
		//���� ����� ��ȣ����
		
		public void changePassword(MemberVO vo);
		
		

		/*
		//NEW �̸��Ϲ߼�
		public void sendEmail(MemberVO vo, String div) throws Exception;

		//NEW ��й�ȣã��
		public void findPw(HttpServletResponse response, MemberVO vo) throws Exception;

		//NEW��й�ȣ ����
		public int updatePw(MemberVO vo) throws Exception;
*/
		
		
	}