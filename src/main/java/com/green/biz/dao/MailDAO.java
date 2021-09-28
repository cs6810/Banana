package com.green.biz.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.green.biz.dto.MailVO;

import javax.mail.internet.MimeMessage; 
import org.springframework.mail.javamail.JavaMailSenderImpl; 
import org.springframework.mail.javamail.MimeMessageHelper;

@Repository
public class MailDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	@Autowired
	private ConfigurableApplicationContext ctx;
	
	@Autowired
	private JavaMailSenderImpl mailSender;
	
	@RequestMapping(value = "sendMail", method = {RequestMethod.GET, RequestMethod.POST})
	public void insertMail(String id, MailVO vo) {
		
		mailSender =  (JavaMailSenderImpl)ctx.getBean("mailSender");
		
		String admin = "22hyeok@naver.com"; //관리자 메일 주소
		
		try {
			// mail 발송위한 sender 설정
			MimeMessage mail = mailSender.createMimeMessage();
			MimeMessageHelper mailHelper = new MimeMessageHelper(mail, "UTF-8");

			// mailHelper에 set
			mailHelper.setFrom(admin);	// 보내는사람 (실제 발송자 ID를 넣을 수 있으나 naver계정에서 발송자 주소 차단되는 경우 있음)
			mailHelper.setTo(admin);		// 받는사람 (관리자의 메일 계정)
			mailHelper.setSubject(vo.getTitle() + "  / 문의자 이메일주소 : " + id);	// 제목, (네이버 발송자 메일주소 차단되는 경우 때문에 제목에 실제 발송자 ID 삽입)
			mailHelper.setText(vo.getContents());	// 내용

			// 발송부분
			mailSender.send(mail);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		mybatis.insert("MailDAO.insertMail", vo);
		
	}
}
