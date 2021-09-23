package com.green.biz.member.Impl;

import java.io.PrintWriter;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.mail.HtmlEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.biz.dao.MemberDAO;

import com.green.biz.dto.MemberVO;
import com.green.biz.member.MemberService;

@Service("memberService")
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDAO memberDao;
	


	//ȸ������ ��������
	@Override
	public MemberVO memberInfo(MemberVO vo) {

		return memberDao.memberInfo(vo);
	}

	//������Ʈ ���
		@Override
		public void updateMember(MemberVO vo) {
			
			memberDao.updateMember(vo);
			System.out.println("������Ʈ �Ϸ�");
		}
		
		@Override
		public MemberVO getMember(String email_id) {
			
			return memberDao.getMember(email_id);
		}

		@Override
		public int confirmID(String email_id) {
			
			return memberDao.confirmID(email_id);
		}

		@Override
		public void insertMember(MemberVO vo) {
			
			memberDao.insertMember(vo);
			
		}
		
		@Override
		public int loginID(MemberVO vo) {
			return memberDao.loginID(vo);

	}
		
		

		@Override
		public MemberVO getMemberByNameAndPhnm(MemberVO vo) {
			
			return memberDao.getMemberByNameAndPhnm(vo);
		}

		
		/*

		
	@Override
		public void sendEmail(MemberVO vo, String div) throws Exception {
			// Mail Server ����
			String charSet = "utf-8";
			String hostSMTP = "smtp.gmail.com"; //���̹� �̿�� smtp.naver.com
			String hostSMTPid = "���� �̸��� �ּ�(������ ��� �̸��� �ּ�)";
			String hostSMTPpwd = "���� �̸��� ���(������ ��� �̸��� ���)";

			// ������ ��� EMail, ����, ����
			String fromEmail = "������ ��� �̸����ּ�(�޴� ��� �̸��Ͽ� ǥ�õ�)";
			String fromName = "������Ʈ�̸� �Ǵ� ������ ��� �̸�";
			String subject = "";
			String msg = "";

			if(div.equals("findpw")) {
				subject = "�������� �ӽ� ��й�ȣ �Դϴ�.";
				msg += "<div align='center' style='border:1px solid black; font-family:verdana'>";
				msg += "<h3 style='color: blue;'>";
				msg += vo.getEmail_id() + "���� �ӽ� ��й�ȣ �Դϴ�. ��й�ȣ�� �����Ͽ� ����ϼ���.</h3>";
				msg += "<p>�ӽ� ��й�ȣ : ";
				msg += vo.getPwd() + "</p></div>";
			}

			// �޴� ��� E-Mail �ּ�
			String mail = vo.getEmail_id();
			try {
				HtmlEmail email = new HtmlEmail();
				email.setDebug(true);
				email.setCharset(charSet);
				email.setSSL(true);
				email.setHostName(hostSMTP);
				email.setSmtpPort(465); //���̹� �̿�� 587

				email.setAuthentication(hostSMTPid, hostSMTPpwd);
				email.setTLS(true);
				email.addTo(mail, charSet);
				email.setFrom(fromEmail, fromName, charSet);
				email.setSubject(subject);
				email.setHtmlMsg(msg);
				email.send();
			} catch (Exception e) {
				System.out.println("���Ϲ߼� ���� : " + e);
			}
		}


	@Override
	public void findPw(HttpServletResponse response, MemberVO vo) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		MemberVO ck = memberDao.getMember(vo.getEmail_id());
		PrintWriter out = response.getWriter();
		// ���Ե� ���̵� ������
		if(!vo.getEmail_id().equals(ck.getEmail_id())) {
			out.print("��ϵ��� ���� �̸����Դϴ�.");
			out.close();
		}
		// ���Ե� ��ȭ��ȣ�� �ƴϸ�
		else if(!vo.getPh_nm().equals(ck.getPh_nm())) {
			out.print("��ϵ��� ���� ��ȭ��ȣ�Դϴ�.");
			out.close();
			
		}else {
			// �ӽ� ��й�ȣ ����
			String pwd = "";
			for (int i = 0; i < 12; i++) {
				pwd += (char) ((Math.random() * 26) + 97);
			}
			vo.setPwd(pwd);
			// ��й�ȣ ����
			memberDao.updatePw(vo);
			// ��й�ȣ ���� ���� �߼�
			sendEmail(vo, "findpw");

			out.print("�̸��Ϸ� �ӽ� ��й�ȣ�� �߼��Ͽ����ϴ�.");
			out.close();
		}
	}

	@Override
	public int updatePw(MemberVO vo) throws Exception {
		 return memberDao.updatePw(vo);
	}
		
	}

*/


	//����
		@Override
		public MemberVO findPassword(MemberVO vo) {
			
			return memberDao.findPassword(vo);
		}
	//����
		@Override
		public void changePassword(MemberVO vo) {
			
			memberDao.changePassword(vo);
		
		}

		@Override
		public void updateAddress(MemberVO vo) {
			memberDao.updateAddress(vo);
			
		}

		
}
		
	

