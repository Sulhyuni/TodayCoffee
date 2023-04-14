package com.today.notice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.today.io.db.DB;
import com.today.notice.vo.NoticeVO;
import com.webjjang.util.PageObject;

public class NoticeDAOImpl implements NoticeDAO {
	
	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	
	@Override
	public List<NoticeVO> list(PageObject pageObject) throws Exception {

		System.out.println("NoticeDAOImpl.list()");
		// 결과를 전달 변수 List<NoticeVO>
		List<NoticeVO> list = null;
		try {
			// 1. 확인 2. 연결
			con = DB.getConnection();
			// 3. sql
			//   3-1. 원본 데이터 가져오기
			String sql = "select no, title, "
					+ " to_char(startDate, 'yyyy-mm-dd') startDate,  "
					+ " to_char(endDate, 'yyyy-mm-dd') endDate,  "
					+ " to_char(updateDate, 'yyyy-mm-dd') updateDate, "
					+ " hit  "
					+ " from notice";
			
			//검색조건처리
			sql += searchSQL(pageObject);
			
			sql += " order by no desc";
			//   3-2. 순서 번호 붙이기
			sql = " select rownum rnum, no, title, startDate, endDate, updateDate, hit  "
				+ " from (" + sql + ")";
			//   3-3. 페이지 데이터 조건문
			sql = " select no, title, startDate, endDate, updateDate, hit "
					+ " from (" + sql + ") where rnum between ? and ? ";
			
			System.out.println("NoticeDAOImpl.list().sql : " + sql);
			
			// 4. 실행객체 & 데이터 세팅
			pstmt = con.prepareStatement(sql);
			//검색에 대한 데이터 세팅
			int idx=0;
			idx = searchDataSet(pageObject, idx);
			pstmt.setLong(++idx, pageObject.getStartRow());
			pstmt.setLong(++idx, pageObject.getEndRow());
			// 5. 실행 -> rs
			rs = pstmt.executeQuery();
			// 6. 데이터 저장 - list
			// rs가 null 이 아니면 처리하자
			//6.데이터 저장(list변수에 저장) 
			if(rs!=null) {
				while(rs.next()) {
					//데이터가 있다.
					//rs에 다음 데이터가 있으면 아래로 처리한다.
					//list가 null 이면 한번만 생성한다. 세미콜론 주의!
					if(list==null)list = new ArrayList<>();
					
					//데이터를 담은 vo 객체를 생성한다.
					NoticeVO vo = new NoticeVO();		
					vo.setNo(rs.getLong("no"));
					vo.setTitle(rs.getString("title"));
					vo.setStartDate(rs.getString("startDate"));
					vo.setEndDate(rs.getString("endDate"));
					vo.setUpdateDate(rs.getString("updateDate"));
					vo.setHit(rs.getLong("hit"));
					//rs데이터를 vo에 담고 -> list에 담는다 ( add )
					list.add(vo); 
				}//while의 끝
			}//if 끝
			

		} catch (Exception e) {
			e.printStackTrace(); //개발자 위한 코드
			throw new Exception("공지사항 리스트 처리중오류발생");
		} finally {
			//7.닫기
			 DB.close(con, pstmt, rs);
		}// try~finally의 끝
		
		//데이터가 null이 나올경우 syso로 한번 찍어봐야한다.
		return list;
		
	} //list 메서드 의 끝

	
	//현재공지  startDate <=sysDate
	// 현재 공지 리스트 
		public List<NoticeVO> currentList(PageObject pageObject) throws Exception {
			System.out.println("NoticeDAOImpl.currentList()...");
			List<NoticeVO> list = null;
			
			try {
				// 1 드라이버 확인 2 접속
				con = DB.getConnection();
				System.out.println("1. 드라이버 확인 2. 접속");
				// 3 sql
				String sql = "select no,title,"
						+ " to_char(startDate,'yyyy-mm-dd')startDate,"
						+ " to_char(endDate,'yyyy-mm-dd')endDate," 
						+ " to_char(updateDate,'yyyy-mm-dd')updateDate, "
						+ " hit "
						+ " from notice where startDate <= sysdate and trunc(sysdate) <= enddate  "
						+ " order by updateDate desc";
				System.out.println("3. sql :" + sql);
				// 4 실행객체생성 및 데이터 세팅
				pstmt = con.prepareStatement(sql);
				System.out.println("4. 실행객체생성");
				// 5 실행
				rs = pstmt.executeQuery();
				System.out.println("5. 실행완료");
				// 6 표시 및 저장
				if (rs != null) {
					while (rs.next()) {
						if (list == null)
							list = new ArrayList<NoticeVO>();
						NoticeVO vo = new NoticeVO();
						vo.setNo(rs.getLong("no"));
						vo.setTitle(rs.getString("title"));
						vo.setStartDate(rs.getString("startDate"));
						vo.setEndDate(rs.getString("endDate"));
						vo.setUpdateDate(rs.getString("updateDate"));
						vo.setHit(rs.getLong("hit"));
						list.add(vo);
					}
					return list;
				}		 
				System.out.println("6. 담기 성공 ");
			} catch (Exception e) {
				e.printStackTrace();
				throw new Exception("현재공지 DB 처리 중 오류가 발생되었습니다");
			} finally {
				// 7. 닫기
				DB.close(con, pstmt, rs);
				System.out.println("7.객체 닫기 성공");
			}
			return list;
		} 

////예약된 공지
	@Override
	public List<NoticeVO> reservedList(PageObject pageObject) throws Exception {
		System.out.println("NoticeDAOImpl.reservedList()...");
	List<NoticeVO> list = null;
	
	try {
		// 1 드라이버 확인 2 접속
		con = DB.getConnection();
		System.out.println("1. 드라이버 확인 2. 접속");
		// 3 sql
		String sql = "select no,title, "
				+ " to_char(startDate,'yyyy-mm-dd')startDate, "
				+ " to_char(endDate,'yyyy-mm-dd')endDate,"
				+ " to_char(updateDate,'yyyy-mm-dd')updateDate, "
				+ " hit  "
				+ " from notice "
				+ " where startDate > sysDate "
				+ " order by updateDate desc";
		System.out.println("3. sql :" + sql);
		// 4 실행객체생성 및 데이터 세팅
		pstmt = con.prepareStatement(sql);
		System.out.println("4. 실행객체생성");
		// 5 실행
		rs = pstmt.executeQuery();
		System.out.println("5. 실행완료");
		// 6 표시 및 저장
		if (rs != null) {
			while (rs.next()) {
				if (list == null)
					list = new ArrayList<NoticeVO>();
				NoticeVO vo = new NoticeVO();
				vo.setNo(rs.getLong("no"));
				vo.setTitle(rs.getString("title"));
				vo.setStartDate(rs.getString("startDate"));
				vo.setEndDate(rs.getString("endDate"));
				vo.setUpdateDate(rs.getString("updateDate"));
				vo.setHit(rs.getLong("hit"));
				
				list.add(vo);
			}
			return list;
		}		
		System.out.println("6.객체 담기 성공 ");
	} catch (Exception e) {
		e.printStackTrace();
		throw new Exception("지난공지 DB 처리 중 오류가 발생되었습니다");
		
	} finally {
		// 7. 닫기
		DB.close(con, pstmt, rs);
		System.out.println("7.객체 닫기 성공");
		
	}
	return list;
	
} 

////지난 공지
	@Override
	public List<NoticeVO> lastList(PageObject pageObject) throws Exception {
		System.out.println("NoticeDAOImpl.lastList()...");
		List<NoticeVO> list = null;
		
		try {
			// 1 드라이버 확인 2 접속
			con = DB.getConnection();
			System.out.println("1. 드라이버 확인 2. 접속");
			// 3 sql
			String sql = "select no,title,to_char(startDate,'yyyy-mm-dd')startDate, "
					+ " to_char(endDate,'yyyy-mm-dd')endDate," 
					+ " to_char(updateDate,'yyyy-mm-dd')updateDate, "
					+ " hit "
					+ " from notice "
					+ " where endDate + 1 < sysDate  "
					+ " order by updateDate desc";
			System.out.println("3. sql :" + sql);
			// 4 실행객체생성 및 데이터 세팅
			pstmt = con.prepareStatement(sql);
			System.out.println("4. 실행객체생성");
			// 5 실행
			rs = pstmt.executeQuery();
			System.out.println("5. 실행완료");
			// 6 표시 및 저장
			if (rs != null) {
				while (rs.next()) {
					if (list == null)
						list = new ArrayList<NoticeVO>();
					NoticeVO vo = new NoticeVO();
					vo.setNo(rs.getLong("no"));
					vo.setTitle(rs.getString("title"));
					vo.setStartDate(rs.getString("startDate"));
					vo.setEndDate(rs.getString("endDate"));
					vo.setUpdateDate(rs.getString("updateDate"));
					vo.setHit(rs.getLong("hit"));
					
					list.add(vo);
				}
				return list;
			}		// end of if	
			System.out.println("6.객체 담기 성공 ");
		} catch (Exception e) {
			e.printStackTrace();
		throw new Exception("예약공지 DB 처리 중 오류가 발생되었습니다"); 
		} finally {
			// 7. 닫기
			DB.close(con, pstmt, rs);
			System.out.println("7.객체 닫기 성공");
			
		}
		return list;
		
	}// end of currentList()
	
	
	

	//검색을 위한 sql 작성
	private String searchSQL(PageObject pageObject) {
		String sql = "";
		String word = pageObject.getWord();
		String key = pageObject.getKey();		
		if(word != null && !word.equals("")) {
			sql +=" where (1=0 ";
			if(key.indexOf("t")>=0) sql+=" or title like ?"; 
			if(key.indexOf("c")>=0) sql+=" or content like ?"; 
			sql +=")";
		}
		return sql;
	}

	//검색을 위한 데이터 세팅
	private int searchDataSet(PageObject pageObject, int idx) throws SQLException{
		String word = pageObject.getWord();
		String key = pageObject.getKey();	
		if(word != null && !word.equals("") ) {
			if(key.indexOf("t")>=0)pstmt.setString(++idx, "%"+word+"%"); 
			if(key.indexOf("c")>=0)pstmt.setString(++idx, "%"+word+"%"); 
		}
		return idx;
	}
	
	
	@Override
	public long getTotalRow(PageObject pageObject) throws Exception {
		System.out.println("NoticeDAOImpl.getTotlaRow() :" +pageObject);
		
		//리턴데이터 선언
		long totalRow = 0;
		try {
			//1,2.드라이버 확인, 연결
			con = DB.getConnection();
			System.out.println("1,2.확인,연결");
			//3.sql
			String sql = "select count(*) from notice";
			sql += searchSQL(pageObject);
			System.out.println("3. getTotlaRow : " + sql);
			//4.실행객체, 데이터 저장
			pstmt=con.prepareStatement(sql);
			int idx=0;
			idx=searchDataSet(pageObject, idx);
			//5.실행
			rs=pstmt.executeQuery();
			System.out.println("5.실행");
			
			//6.표시 rs->vo
			if(rs !=null && rs.next()) {
				totalRow=rs.getLong(1);
			}
			System.out.println("6.표시,저장완료");
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("공지사항 list의 전체 데이터 개수 DB처리중 에러 발생.");
		}finally {
			//7.닫기
			DB.close(con, pstmt);
			System.out.println("7.닫기완료");
		}
		return totalRow;
	}//view 메서드의 끝
	
	
	@Override
	public NoticeVO view(long no) throws Exception {
		System.out.println("NoticeDAOImpl.no() :" +no);
		
		//리턴데이터 선언
		NoticeVO vo = null;
		try {
			//1,2.드라이버 확인, 연결
			con = DB.getConnection();
			System.out.println("1,2.확인,연결");
			//3.sql
			String sql = "select no, title, content, "
					+ "to_char(startDate,'yyyy-mm-dd') startDate, "
					+ "to_char(endDate,'yyyy-mm-dd') endDate, "
					+ "to_char(updateDate,'yyyy-mm-dd') updateDate, "
					+ " hit "
					+ " from notice where no = ? ";
			System.out.println("3. .view.sql : " + sql);
			//4.실행객체, 데이터 저장
			pstmt=con.prepareStatement(sql);
			
			//첫번째 물음표
			pstmt.setLong(1, no);
			System.out.println("4.실행객체, 데이터 저장");
			
			//5.실행
			rs=pstmt.executeQuery();
			System.out.println("5.실행");
			
			//6.표시 rs->vo
			if(rs !=null && rs.next()) {
			vo = new NoticeVO();
			vo.setNo(rs.getLong("no"));
			vo.setTitle(rs.getString("title"));
			vo.setContent(rs.getString("content"));
			vo.setStartDate(rs.getString("startDate"));
			vo.setEndDate(rs.getString("endDate"));
			vo.setUpdateDate(rs.getString("updateDate"));
			vo.setHit(rs.getLong("hit"));
			}
			System.out.println("6.표시,저장완료");
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("공지사항 보기 DB처리중 에러 발생.");
		}finally {
			//7.닫기
			DB.close(con, pstmt);
			System.out.println("7.닫기완료");
		}
		return vo;
	}//view 메서드의 끝


	@Override
	public int increase(long no) throws Exception {
		System.out.println("NoticeDAOImpl.no() : " +no);
		int result=0;
		try {
			//1,2.드라이버 확인, 연결
			con = DB.getConnection();
			System.out.println("1,2.확인,연결");
			//3.sql
			String sql = "update notice set hit = hit+1 where no = ? ";
			System.out.println("3. NoticeDAOImpl.no().increase.sql : " + sql);
			//4.실행객체, 데이터 저장
			pstmt=con.prepareStatement(sql);
			pstmt.setLong(1, no);
			System.out.println("4.실행객체, 데이터 저장");
			
			//5.실행
			result=pstmt.executeUpdate();
			System.out.println("5.실행");

			//6.표시 rs->vo
			if(result==1) {
			System.out.println(".increase() -조회수 1증가완료");
			}else {
				throw new Exception("글이 존재하지 않습니다.");
			}//if 끝
			System.out.println("6.표시,저장완료");
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("공지 DB처리 중 에러 발생");
		}finally {
			//7.닫기
			DB.close(con, pstmt);
			System.out.println("7.닫기완료");
		}
		return result;
	}
	
	

	@Override
	public int write(NoticeVO vo) throws Exception {
		System.out.println("NoticeDAOImpl.write().vo"+ vo);
		int result = 0;
		try {
			//1,2.드라이버 확인, 연결
			con = DB.getConnection();
			System.out.println("1,2.확인,연결");
			//3.sql
			String sql = "insert into notice (no, title, content, startDate, endDate) "
					+ " values(notice_seq.nextval,?,?,?,?)  ";
			System.out.println("3. .write.sql : " + sql);
			//4.실행객체, 데이터 저장
			pstmt=con.prepareStatement(sql);
			//첫번째 물음표~
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getStartDate());
			pstmt.setString(4, vo.getEndDate());
			System.out.println("4.실행객체, 데이터 저장");
			
			//5.실행
			result=pstmt.executeUpdate();
			System.out.println("5.실행");
			
			//6.표시 rs->vo
			System.out.println("6. .write() - 1행 삽입 완료");
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("공지사항 쓰기 DB처리중 에러 발생.");
		}finally {
			//7.닫기
			DB.close(con, pstmt);
			System.out.println("7.닫기완료");
		}
		return result;
	}



	@Override
	public Integer update(NoticeVO vo) throws Exception {
		System.out.println("NoticeDAOImpl.update().vo"+ vo);
		int result = 0;
		try {
			//1,2.드라이버 확인, 연결
			con = DB.getConnection();
			System.out.println("1,2.확인,연결");
			//3.sql
			String sql = "update notice set title=?, content=?, startDate=?, endDate=?, updateDate=sysdate where no = ?  ";
			System.out.println("3. .update.sql : " + sql);
			//4.실행객체, 데이터 저장
			pstmt=con.prepareStatement(sql);
			//첫번째 물음표~
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getStartDate());
			pstmt.setString(4, vo.getEndDate());
			pstmt.setLong(5, vo.getNo());
			System.out.println("4.실행객체, 데이터 저장");
			
			//5.실행
			result=pstmt.executeUpdate();
			System.out.println("5.실행");
			
			//6.표시 rs->vo
			System.out.println("6. .update() - 1행 수정 완료");
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("공지사항 수정 DB처리중 에러 발생.");
		}finally {
			//7.닫기
			DB.close(con, pstmt);
			System.out.println("7.닫기완료");
		}
		return result;
	}

	
	public Integer delete(NoticeVO vo) throws Exception {
		System.out.println("NoticeDAOImpl.delete().vo"+ vo);
		int result = 0;
		
		try {
			//1,2.드라이버 확인, 연결
			con = DB.getConnection();
			System.out.println("1,2.확인,연결");
			//3.sql
			String sql = "delete from notice where no = ?   ";
			System.out.println("3. .delete.sql : " + sql);
			//4.실행객체, 데이터 저장
			pstmt=con.prepareStatement(sql);
			pstmt.setLong(1, vo.getNo());
			
			System.out.println("4.실행객체, 데이터 저장");
			
			//5.실행
			result=pstmt.executeUpdate();
			System.out.println("5.실행");
			
			//6.표시 rs->vo
			System.out.println("6. .delete() - 1행 삭제 완료");
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("공지사항 삭제 DB처리중 에러 발생.");
		}finally {
			//7.닫기
			DB.close(con, pstmt);
			System.out.println("7.닫기완료");
		}
		return result;
	}






}//class 끝
