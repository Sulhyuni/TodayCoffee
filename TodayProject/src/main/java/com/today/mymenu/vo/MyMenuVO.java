package com.today.mymenu.vo;

public class MyMenuVO {
	// 나만의 메뉴 번호 , 상품번호 굿즈번호
	private long mmNo,goodsNo,optionNo,opPrice,totalPrice;
	private String id,mmName;
	private String cup_size,cup,syrup; // 컵사이즈 컵종류 시럽
	// 한글이름 영문 상품설명 가격 분류
	private String name_kr,name_en,goodsview,price,goodsDiv;
	private String fileName;
	private String heating;
	// getter & setter
	public long getMmNo() {
		return mmNo;
	}
	public void setMmNo(long mmNo) {
		this.mmNo = mmNo;
	}
	public long getGoodsNo() {
		return goodsNo;
	}
	public void setGoodsNo(long goodsNo) {
		this.goodsNo = goodsNo;
	}
	public long getOptionNo() {
		return optionNo;
	}
	public void setOptionNo(long optionNo) {
		this.optionNo = optionNo;
	}
	public long getOpPrice() {
		return opPrice;
	}
	public void setOpPrice(long opPrice) {
		this.opPrice = opPrice;
	}
	public long getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(long totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getMmName() {
		return mmName;
	}
	public void setMmName(String mmName) {
		this.mmName = mmName;
	}
	public String getCup_size() {
		return cup_size;
	}
	public void setCup_size(String cup_size) {
		this.cup_size = cup_size;
	}
	public String getCup() {
		return cup;
	}
	public void setCup(String cup) {
		this.cup = cup;
	}
	public String getSyrup() {
		return syrup;
	}
	public void setSyrup(String syrup) {
		this.syrup = syrup;
	}
	public String getName_kr() {
		return name_kr;
	}
	public void setName_kr(String name_kr) {
		this.name_kr = name_kr;
	}
	public String getName_en() {
		return name_en;
	}
	public void setName_en(String name_en) {
		this.name_en = name_en;
	}
	public String getGoodsview() {
		return goodsview;
	}
	public void setGoodsview(String goodsview) {
		this.goodsview = goodsview;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getGoodsDiv() {
		return goodsDiv;
	}
	public void setGoodsDiv(String goodsDiv) {
		this.goodsDiv = goodsDiv;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getHeating() {
		return heating;
	}
	public void setHeating(String heating) {
		this.heating = heating;
	}
	@Override
	public String toString() {
		return "MyMenuVO [mmNo=" + mmNo + ", goodsNo=" + goodsNo + ", optionNo=" + optionNo + ", opPrice=" + opPrice
				+ ", totalPrice=" + totalPrice + ", id=" + id + ", mmName=" + mmName + ", cup_size=" + cup_size
				+ ", cup=" + cup + ", syrup=" + syrup + ", name_kr=" + name_kr + ", name_en=" + name_en + ", goodsview="
				+ goodsview + ", price=" + price + ", goodsDiv=" + goodsDiv + ", fileName=" + fileName + ", heating="
				+ heating + "]";
	}

}
