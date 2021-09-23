package com.green.biz.dto;

public class NoticeVO {
	private int    notice_seq;
	private String title;
	private String content;
	
	public int getNotice_seq() {
		return notice_seq;
	}
	public void setNotice_seq(int notice_seq) {
		this.notice_seq = notice_seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	@Override
	public String toString() {
		return "NoticeVO [notice_seq=" + notice_seq + ", title=" + title + ", content=" + content + "]";
	}
}
