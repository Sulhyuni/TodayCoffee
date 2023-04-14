package com.today.mymenu.dao;

import java.util.List;

import com.today.mymenu.vo.MyMenuVO;

public interface MyMenuDAO {

	// 리스트
	public List<MyMenuVO> list(String id) throws Exception;

	// 보기
	public MyMenuVO view(long no) throws Exception;

	// 담기
	public int mymenuAdd(MyMenuVO vo) throws Exception;

	// 수정
	public int update(MyMenuVO vo) throws Exception;

	// 삭제
	public int delete(MyMenuVO vo) throws Exception;

	// 전체삭제
	public int Alldelete(MyMenuVO vo) throws Exception;

	// 옵션 담기
	public int optionAdd(MyMenuVO vo) throws Exception;

	// 옵션번호불러오기
	public MyMenuVO optionView(MyMenuVO vo) throws Exception;
	
	// 여러개의 나만의 메뉴 번호 불러오기
	public List<MyMenuVO> myMenuList(List<Long>noList)throws Exception;
}
