package com.today.goods.vo;

public class GoodsVO {

	private long goodsNo,price,stock;
	private String fileName,name_kr,name_en,goodsView,goodsDiv;
	 //filename은 서버의 파일명
	public long getGoodsNo() {
		return goodsNo;
	}
	public void setGoodsNo(long goodsNo) {
		this.goodsNo = goodsNo;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public long getStock() {
		return stock;
	}
	public void setStock(long stock) {
		this.stock = stock;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
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
	public String getGoodsView() {
		return goodsView;
	}
	public void setGoodsView(String goodsView) {
		this.goodsView = goodsView;
	}
	public String getGoodsDiv() {
		return goodsDiv;
	}
	public void setGoodsDiv(String goodsDiv) {
		this.goodsDiv = goodsDiv;
	}
	
	@Override
	public String toString() {
		return "GoodsVO [goodsNo=" + goodsNo + ", price=" + price + ", stock=" + stock + ", fileName=" + fileName
				+ ", name_kr=" + name_kr + ", name_en=" + name_en + ", goodsView=" + goodsView + ", goodsDiv="
				+ goodsDiv + "]";
	}
	
	
	
	
}
