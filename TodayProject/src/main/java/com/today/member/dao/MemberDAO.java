package com.today.member.dao;

import java.sql.Date;
import java.util.List;

import com.today.member.vo.MemberVO;
import com.webjjang.util.PageObject;

public interface MemberDAO {

	//로그인
	public MemberVO login(MemberVO inVO) throws Exception;

	//회원가입
	public int write(MemberVO vo) throws Exception;

	//회원리스트
	public List<MemberVO> list(PageObject pageObject) throws Exception;
	
	//전체페이지
	public long getTotalRow(PageObject pageObject) throws Exception;
	
	//회원상세보기
	public MemberVO view(String id) throws Exception;

	//아이디 중복체크
	public int checkId(String id) throws Exception;
	
	//아이디 찾기
	public String findId(MemberVO vo) throws Exception;
	
	//비밀번호 찾기
	public String findPw(MemberVO vo) throws Exception;
	
	//비밀번호 체크
	public MemberVO checkPw(MemberVO vo)throws Exception;
	
	// 최근접속일 업데이트
	public int updateConDate(String id)throws Exception;
	
	// 내정보 수정
	public int update(MemberVO vo)throws Exception;
	
	// 회원탈퇴
	public int delete(MemberVO vo)throws Exception;
	
	// 비밀번호 변경하기
	public int changePw(MemberVO vo)throws Exception;
	
	// 비밀번호 즉시변경하기
	public int changePwNow(MemberVO vo)throws Exception;
	
	// 상태 변경하기
	public int changeStatus(MemberVO vo)throws Exception;
	
	// 등급 변경하기
	public int changeGradeNo(MemberVO vo)throws Exception;
	
	// 휴면 해제하기
	public int wakeUp(MemberVO vo)throws Exception;
	
	// 휴면 유저만들기
	public int sleep(Date date)throws Exception;
}
