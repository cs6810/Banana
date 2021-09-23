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
	
	@RequestMapping(value = "sendMail", method = RequestMethod.POST)
	public void insertMail(MailVO vo) {
		
		mybatis.insert("MailDAO.insertMail", vo);
		
		mailSender =  (JavaMailSenderImpl)ctx.getBean("mailSender");
		
		String from = "22hyeok@naver.com";
		String to = "22hyeok@naver.com";
		String subject = vo.getTitle();
		String content = vo.getContents();
		
		try {
			// 메일 내용 넣을 객체와, 이를 도와주는 Helper 객체 생성
			MimeMessage mail = mailSender.createMimeMessage();
			MimeMessageHelper mailHelper = new MimeMessageHelper(mail, "UTF-8");

			// 메일 내용을 채워줌
			mailHelper.setFrom(from);	// 보내는 사람 셋팅
			mailHelper.setTo(to);		// 받는 사람 셋팅
			mailHelper.setSubject(subject);	// 제목 셋팅
			mailHelper.setText(content);	// 내용 셋팅

			// 메일 전송
			mailSender.send(mail);
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
