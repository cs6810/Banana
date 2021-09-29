package com.green.biz.dto;

public class IntproductVO {

	private String user_id;
	private int pd_number;
	private String product_name;
	private String category;
	private int price;
	private String content;
	private String image1;
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public int getPd_number() {
		return pd_number;
	}
	public void setPd_number(int pd_number) {
		this.pd_number = pd_number;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImage1() {
		return image1;
	}
	public void setImage1(String image1) {
		this.image1 = image1;
	}
	@Override
	public String toString() {
		return "IntproductVO [user_id=" + user_id + ", pd_number=" + pd_number + ", product_name=" + product_name
				+ ", category=" + category + ", price=" + price + ", content=" + content + ", image1=" + image1 + "]";
	}
	

}
