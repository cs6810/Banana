package com.green.biz.mail.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.green.biz.dao.MailDAO;
import com.green.biz.dto.MailVO;
import com.green.biz.mail.MailService;

@Service("mailService")
public class MailServiceImpl implements MailService {

	@Autowired
	private MailDAO mDao;
	
	@Override
	public void insertMail(String id, MailVO vo) {
		
		mDao.insertMail(id, vo);
	}

}
