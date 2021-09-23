package com.green.biz.dto;

import java.sql.Timestamp;

public class MemberVO {
	private String email_id;
	private String pwd;
	private String name;
	private String nk_name;
	private String zip_num;
	private String address;
	private String ph_nm;
	private String like;
	private String profile_img;
	private Timestamp regdate;
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNk_name() {
		return nk_name;
	}
	public void setNk_name(String nk_name) {
		this.nk_name = nk_name;
	}
	public String getZip_num() {
		return zip_num;
	}
	public void setZip_num(String zip_num) {
		this.zip_num = zip_num;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPh_nm() {
		return ph_nm;
	}
	public void setPh_nm(String ph_nm) {
		this.ph_nm = ph_nm;
	}
	public String getLike() {
		return like;
	}
	public void setLike(String like) {
		this.like = like;
	}
	public String getProfile_img() {
		return profile_img;
	}
	public void setProfile_img(String profile_img) {
		this.profile_img = profile_img;
	}
	public Timestamp getRegdate() {
		return regdate;
	}
	public void setRegdate(Timestamp regdate) {
		this.regdate = regdate;
	}
	@Override
	public String toString() {
		return "MemberVO [email_id=" + email_id + ", pwd=" + pwd + ", name=" + name + ", nk_name=" + nk_name
				+ ", zip_num=" + zip_num + ", address=" + address + ", ph_nm=" + ph_nm + ", like=" + like
				+ ", profile_img=" + profile_img + ", regdate=" + regdate + "]";
	}

}


