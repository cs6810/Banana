package com.green.biz.dto;

public class MailVO {
	private String sender;
	private String receiver;
	private String title;
	private String contents;
	public String getSender() {
		return sender;
	}
	public void setSender(String sender) {
		this.sender = sender;
	}
	public String getReceiver() {
		return receiver;
	}
	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}
	@Override
	public String toString() {
		return "MailVO [sender=" + sender + ", receiver=" + receiver + ", title=" + title + ", contents=" + contents
				+ "]";
	}
	
	
	
}
