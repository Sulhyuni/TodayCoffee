package com.today.cart.dao;

import java.util.List;

import com.today.cart.vo.CartVO;
import com.today.mymenu.vo.MyMenuVO;

public interface CartDAO {
	// 리스트
	public List<CartVO> list(String id)throws Exception;
	
	// 보기
	public CartVO view(long no)throws Exception; 
	
	// 담기
	public int cartAdd(CartVO vo)throws Exception;
	
	// 수정
	public int update(CartVO vo) throws Exception;
	
	// 삭제
	public int delete(CartVO vo) throws Exception;
	
	// 전체삭제
	public int Alldelete(CartVO vo) throws Exception;
	
	// 옵션 담기
	public int optionAdd(CartVO vo) throws Exception;
	
	// 옵션번호불러오기
	public CartVO optionView(CartVO vo) throws Exception;
	
	public List<CartVO> cartList(List<Long>noList)throws Exception;
	
	// 나만의 메뉴 번호 불러오기
	public CartVO mmNo(long mmNo)throws Exception;
}
