package com.today.order.vo;

import java.util.ArrayList;
import java.util.List;

public class OrderVO {

	private String id; // 아이디 
	private long gradeNo, stockQuantity; // 등급번호
	private long totalPrice, payPrice ,point, usePoint; // 총주문금액, 최종결제금액, 포인트
	private String payMethod, orderDate, orderStatus; // 
	private long orderDetailNo, orderNo, goodsNo, optionNo, cartNo, mmNo, quantity, orderPrice; // 주문상세번호, 주문번호, 상품번호, 옵션번호, 나만의메뉴번호, 수량, 주문금액
	private String fileName, goodsName, goodsPrice, cupSize, cup, syrup, heating, goodsDiv; // 파일이름, 상품이름, 상품가격, 컵사이즈, 컵종류, 시럽, 데움, 상품분류
	private List<OrderVO> list = new ArrayList<>();
	
	public String getId() {
		return id;
	}	
	public long getGradeNo() {
		return gradeNo;
	}
	public void setGradeNo(long gradeNo) {
		this.gradeNo = gradeNo;
	}

	public void setId(String id) {
		this.id = id;
	}
	public long getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(long totalPrice) {
		this.totalPrice = totalPrice;
	}
	public long getPayPrice() {
		return payPrice;
	}
	public void setPayPrice(long payPrice) {
		this.payPrice = payPrice;
	}
	public long getPoint() {
		return point;
	}
	public void setPoint(long point) {
		this.point = point;
	}
	public long getUsePoint() {
		return usePoint;
	}
	public void setUsePoint(long usePoint) {
		this.usePoint = usePoint;
	}
	public String getPayMethod() {
		return payMethod;
	}
	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public long getOrderDetailNo() {
		return orderDetailNo;
	}
	public void setOrderDetailNo(long orderDetailNo) {
		this.orderDetailNo = orderDetailNo;
	}
	public long getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(long orderNo) {
		this.orderNo = orderNo;
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
	public long getCartNo() {
		return cartNo;
	}
	public void setCartNo(long cartNo) {
		this.cartNo = cartNo;
	}
	public long getMmNo() {
		return mmNo;
	}
	public void setMmNo(long mmNo) {
		this.mmNo = mmNo;
	}
	public long getQuantity() {
		return quantity;
	}
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
	public long getOrderPrice() {
		return orderPrice;
	}
	public void setOrderPrice(long orderPrice) {
		this.orderPrice = orderPrice;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getGoodsName() {
		return goodsName;
	}
	public void setGoodsName(String goodsName) {
		this.goodsName = goodsName;
	}
	public String getGoodsPrice() {
		return goodsPrice;
	}
	public void setGoodsPrice(String goodsPrice) {
		this.goodsPrice = goodsPrice;
	}
	public String getCupSize() {
		return cupSize;
	}
	public void setCupSize(String cupSize) {
		this.cupSize = cupSize;
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
	public String getHeating() {
		return heating;
	}
	public void setHeating(String heating) {
		this.heating = heating;
	}
	public String getGoodsDiv() {
		return goodsDiv;
	}
	public void setGoodsDiv(String goodsDiv) {
		this.goodsDiv = goodsDiv;
	}
	public List<OrderVO> getList() {
		return list;
	}
	public void setList(List<OrderVO> list) {
		this.list = list;
	}
	
	public long getStockQuantity() {
		return stockQuantity;
	}
	public void setStockQuantity(long stockQuantity) {
		this.stockQuantity = stockQuantity;
	}
	@Override
	public String toString() {
		return "OrderVO [id=" + id + ", gradeNo=" + gradeNo + ", stockQuantity=" + stockQuantity + ", totalPrice="
				+ totalPrice + ", payPrice=" + payPrice + ", point=" + point + ", usePoint=" + usePoint + ", payMethod="
				+ payMethod + ", orderDate=" + orderDate + ", orderStatus=" + orderStatus + ", orderDetailNo="
				+ orderDetailNo + ", orderNo=" + orderNo + ", goodsNo=" + goodsNo + ", optionNo=" + optionNo
				+ ", cartNo=" + cartNo + ", mmNo=" + mmNo + ", quantity=" + quantity + ", orderPrice=" + orderPrice
				+ ", fileName=" + fileName + ", goodsName=" + goodsName + ", goodsPrice=" + goodsPrice + ", cupSize="
				+ cupSize + ", cup=" + cup + ", syrup=" + syrup + ", heating=" + heating + ", goodsDiv=" + goodsDiv
				+ ", list=" + list + "]";
	}
	
}
