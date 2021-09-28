package com.green.view.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.green.biz.dto.MailVO;
import com.green.biz.mail.MailService;

@Controller
public class MailController {

	@Autowired
	private MailService mailService;
	

	@RequestMapping(value = "mail_form", method = RequestMethod.POST)
	public String mail() {
		return "customer_center/mail"; 	//mail.jsp
	}
	
	@RequestMapping(value="send_email", method = RequestMethod.POST)
	public String MailWrite(MailVO vo, @RequestParam(value="emailID") String email_id) {
			mailService.insertMail(email_id, vo);			
			return "customer_center/customer_center";		//발송 완료 후 customer_center.jsp
	}
}
