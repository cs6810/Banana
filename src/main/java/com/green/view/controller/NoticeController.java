package com.green.view.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.green.biz.dto.NoticeVO;
import com.green.biz.notice.NoticeService;


@Controller
public class NoticeController {

	@Autowired
	private NoticeService noticeService;
	
	@RequestMapping(value="/customer_center", method=RequestMethod.GET)
	public String getNoticeList(Model model){
		
		List<NoticeVO> noticeList = noticeService.getNoticeList();
		
		model.addAttribute("noticeList", noticeList);
		
		return "customer_center/customer_center";
	}
	
	//게시글 불러오기
			@RequestMapping(value="/notice_form", method=RequestMethod.GET)
			public String getNoticeList1(Model model){
				
				List<NoticeVO> noticeList1 = noticeService.getNoticeList1();
				
				model.addAttribute("noticeList1", noticeList1);
				
				return "customer_center/customer_center";
			}
}
