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
	


	//회원정보 가져오기
	@Override
	public MemberVO memberInfo(MemberVO vo) {

		return memberDao.memberInfo(vo);
	}

	//업데이트 기능
		@Override
		public void updateMember(MemberVO vo) {
			
			memberDao.updateMember(vo);
			System.out.println("업데이트 완료");
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
			// Mail Server 설정
			String charSet = "utf-8";
			String hostSMTP = "smtp.gmail.com"; //네이버 이용시 smtp.naver.com
			String hostSMTPid = "서버 이메일 주소(보내는 사람 이메일 주소)";
			String hostSMTPpwd = "서버 이메일 비번(보내는 사람 이메일 비번)";

			// 보내는 사람 EMail, 제목, 내용
			String fromEmail = "보내는 사람 이메일주소(받는 사람 이메일에 표시됨)";
			String fromName = "프로젝트이름 또는 보내는 사람 이름";
			String subject = "";
			String msg = "";

			if(div.equals("findpw")) {
				subject = "베프마켓 임시 비밀번호 입니다.";
				msg += "<div align='center' style='border:1px solid black; font-family:verdana'>";
				msg += "<h3 style='color: blue;'>";
				msg += vo.getEmail_id() + "님의 임시 비밀번호 입니다. 비밀번호를 변경하여 사용하세요.</h3>";
				msg += "<p>임시 비밀번호 : ";
				msg += vo.getPwd() + "</p></div>";
			}

			// 받는 사람 E-Mail 주소
			String mail = vo.getEmail_id();
			try {
				HtmlEmail email = new HtmlEmail();
				email.setDebug(true);
				email.setCharset(charSet);
				email.setSSL(true);
				email.setHostName(hostSMTP);
				email.setSmtpPort(465); //네이버 이용시 587

				email.setAuthentication(hostSMTPid, hostSMTPpwd);
				email.setTLS(true);
				email.addTo(mail, charSet);
				email.setFrom(fromEmail, fromName, charSet);
				email.setSubject(subject);
				email.setHtmlMsg(msg);
				email.send();
			} catch (Exception e) {
				System.out.println("메일발송 실패 : " + e);
			}
		}


	@Override
	public void findPw(HttpServletResponse response, MemberVO vo) throws Exception {
		response.setContentType("text/html;charset=utf-8");
		MemberVO ck = memberDao.getMember(vo.getEmail_id());
		PrintWriter out = response.getWriter();
		// 가입된 아이디가 없으면
		if(!vo.getEmail_id().equals(ck.getEmail_id())) {
			out.print("등록되지 않은 이메일입니다.");
			out.close();
		}
		// 가입된 전화번호가 아니면
		else if(!vo.getPh_nm().equals(ck.getPh_nm())) {
			out.print("등록되지 않은 전화번호입니다.");
			out.close();
			
		}else {
			// 임시 비밀번호 생성
			String pwd = "";
			for (int i = 0; i < 12; i++) {
				pwd += (char) ((Math.random() * 26) + 97);
			}
			vo.setPwd(pwd);
			// 비밀번호 변경
			memberDao.updatePw(vo);
			// 비밀번호 변경 메일 발송
			sendEmail(vo, "findpw");

			out.print("이메일로 임시 비밀번호를 발송하였습니다.");
			out.close();
		}
	}

	@Override
	public int updatePw(MemberVO vo) throws Exception {
		 return memberDao.updatePw(vo);
	}
		
	}

*/


	//기존
		@Override
		public MemberVO findPassword(MemberVO vo) {
			
			return memberDao.findPassword(vo);
		}
	//기존
		@Override
		public void changePassword(MemberVO vo) {
			
			memberDao.changePassword(vo);
		
		}

		@Override
		public void updateAddress(MemberVO vo) {
			memberDao.updateAddress(vo);
			
		}

		
}
		
	

