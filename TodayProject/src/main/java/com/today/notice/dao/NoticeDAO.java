package com.today.notice.dao;

import java.util.List;

import com.today.notice.vo.NoticeVO;
import com.webjjang.util.PageObject;

public interface NoticeDAO {

	//모든 list
	public List<NoticeVO> list(PageObject pageObject) throws Exception;
	//에약된 list
	public List<NoticeVO> reservedList(PageObject pageObject) throws Exception;
	//지난 list
	public List<NoticeVO> lastList(PageObject pageObject) throws Exception;
	//현재
	public List<NoticeVO> currentList(PageObject pageObject) throws Exception;
	
	//페이징처리
	public long getTotalRow(PageObject pageObject) throws Exception;
	
	//view 리턴타입 NoticeVO
	public NoticeVO view(long no) throws Exception;

	//increase
	public int increase(long no)throws Exception;
	
	//글쓰기
	public int write(NoticeVO vo) throws Exception;

	//글수정
	public Integer update(NoticeVO vo) throws Exception;
	
	//글삭제
	public Integer delete(NoticeVO vo) throws Exception;
}
