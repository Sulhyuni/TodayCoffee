package com.today.goods.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.today.goods.vo.GoodsVO;
import com.today.io.db.DB;
import com.webjjang.util.PageObject;

public class GoodsDAOImpl implements GoodsDAO {

	private Connection con = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	@Override
	public List<GoodsVO> list(PageObject pageObject) throws Exception {
		System.out.println("GoodsDAOImpl.list().......");
		// 결과 전달할(리턴) 변수 선언
		List<GoodsVO> list = null;
		try {
			// 1.db확인 연결
			con = DB.getConnection();
			System.out.println("1.2.DB확인/연결");
			// 3.sql
			// list에 이미지와 상품 이름만 출력
			String sql = "select goodsNo, fileName, name_kr, price, stock, goodsDiv from goods ";
			
			
			//검색 조건 처리
			sql += searchSQL(pageObject);			
			sql += " order by goodsNo desc";
			//   3-2. 순서 번호 붙이기
			sql = "select rownum rnum, goodsNo, fileName, name_kr, price, stock, goodsDiv  "
				+ " from (" + sql + ")";
			//   3-3. 페이지 데이터 조건문
			sql = "select goodsNo, fileName, name_kr, price, stock, goodsDiv  "
					+ " from (" + sql + ") where rnum between ? and ? ";
			
			System.out.println("GoodsDAOImpl.list().sql : " + sql);
		
			
			// 4.실행객체+데이터세팅
			pstmt = con.prepareStatement(sql);
			System.out.println("4.실행객체 데이터 세팅");
			
			int idx=0;
			//검색에 대한 데이터 세팅
			idx = searchDataSet(pageObject, idx);
			pstmt.setLong(++idx, pageObject.getStartRow());
			pstmt.setLong(++idx, pageObject.getEndRow());
			
			// 5.실행
			rs = pstmt.executeQuery();
			System.out.println("5.실행완료");
			// 6.데이터저장- 위에 생성한 list 변수에 데이터 저장
			if (rs != null) {
				while (rs.next()) {
					// rs에 다음 데이터가 있으면 그 다음데이터로 포인트를 이동한다.
					if (list == null)
						list = new ArrayList<>();
					// list 가 null 이면 한번만 생성한다.

					// 데이터를 담을 vo 객체 생성하기
					GoodsVO vo = new GoodsVO();
					vo.setGoodsNo(rs.getLong("goodsNo"));
					vo.setFileName(rs.getString("fileName"));
					vo.setName_kr(rs.getString("name_kr"));
					vo.setPrice(rs.getLong("price"));
					vo.setStock(rs.getLong("stock"));
					vo.setGoodsDiv(rs.getString("goodsDiv"));
					// rs데이터를 vo에 담고 -->list에 담는다.
					list.add(vo);
				} // while
				System.out.println("6.데이터 저장");
			} // if
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("게시판 리스트 DB처리 중 오류 발생");
		} finally {
			// 7.닫기
			DB.close(con, pstmt, rs);
			System.out.println("7.닫기성공");
		}
		return list;
	}

	//검색을 위한 sql 작성
		private String searchSQL(PageObject pageObject) {
			String sql = "";
			String word = pageObject.getWord();
			System.out.println("word:" + word);
			String key = pageObject.getKey();		
			System.out.println("key:"+key);
			if(word != null && !word.equals("")) {
				sql +=" where (1=0 ";
				//if(key.indexOf("t")>=0) sql+=" or title like '%" + word + "%' "; 
				if(key.indexOf("nk")>=0) sql+=" or name_kr like ?"; 
				if(key.indexOf("ne")>=0) sql+=" or name_en like ?"; 
				if(key.indexOf("goodsDiv")>=0) sql+=" or goodsDiv like ?"; 
				sql +=")";
			}
			return sql;
		}

		//검색을 위한 데이터 세팅
		private int searchDataSet(PageObject pageObject, int idx) throws SQLException{
			String word = pageObject.getWord();
			String key = pageObject.getKey();	
			if(word != null && !word.equals("") ) {
				if(key.indexOf("nk")>=0)pstmt.setString(++idx, "%"+word+"%"); 
				if(key.indexOf("ne")>=0)pstmt.setString(++idx, "%"+word+"%"); 
				if(key.indexOf("goodsDiv")>=0)pstmt.setString(++idx, "%"+word+"%"); 
			}
			return idx;
		}
		
		
		@Override
		public long getTotalRow(PageObject pageObject) throws Exception {
			System.out.println("GoodsDAOImpl.getTotlaRow() :" +pageObject);
			
			//리턴데이터 선언
			long totalRow = 0;
			try {
				//1,2.드라이버 확인, 연결
				con = DB.getConnection();
				System.out.println("1,2.확인,연결");
				//3.sql
				String sql = "select count(*) from goods ";
				sql += searchSQL(pageObject);
				System.out.println("3. getTotlaRow : " + sql);
				//4.실행객체, 데이터 저장
				pstmt=con.prepareStatement(sql);
				int idx = 0;
				idx = searchDataSet(pageObject, idx);
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
				throw new Exception("list의 전체 데이터 개수 DB처리중 에러 발생.");
			}finally {
				//7.닫기
				DB.close(con, pstmt);
				System.out.println("7.닫기완료");
			}
			return totalRow;
		}// 메서드의 끝
	
	
	
	
	
	
	
	@Override
	public GoodsVO view(long no) throws Exception {
		System.out.println("GoodsDAOImpl.view().......");
		// 리턴선언
		GoodsVO vo = null;
		try {
			// 1,2연결
			con = DB.getConnection();
			// 3.sql
			String sql = "select goodsNo, name_kr, name_en, goodsView, price, goodsDiv, stock, fileName "
					+ " from goods where goodsNo = ?";
			System.out.println("1,2.연결완료, 3.sql : " + sql);
			// 4.실행객체
			pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, no);
			System.out.println("4.실행객체,데이터저장");
			// 5.실행
			rs = pstmt.executeQuery();
			System.out.println("5.실행");
			// 6.데이터표시 rs->vo
			if (rs != null && rs.next()) {
				vo = new GoodsVO();
				vo.setGoodsNo(rs.getLong("goodsNo"));
				vo.setName_kr(rs.getString("name_kr"));
				vo.setName_en(rs.getString("name_en"));
				vo.setGoodsView(rs.getString("goodsView"));
				vo.setPrice(rs.getLong("price"));
				vo.setGoodsDiv(rs.getString("goodsDiv"));
				vo.setStock(rs.getLong("stock"));
				vo.setFileName(rs.getString("fileName"));
			}
			System.out.println("6.데이터표시");
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("게시판 보기 DB처리 중 오류 발생");
		} finally {
			DB.close(con, pstmt);
			System.out.println("7.닫기");
		} // try~finally 끝
		return vo;
	}// view의 끝

	@Override
	public Integer write(GoodsVO vo) throws Exception {
		System.out.println("GoodsDAOImpl.write().......");
		int result = 0;
		try {
			// 1,2.드라이버 확인, 연결 //3.sql
			con = DB.getConnection();
			String sql = "insert into goods (goodsNo, goodsDiv, name_kr, name_en, goodsView, price, stock ,fileName ) "
					+ " values(goods_seq.nextval,?,?,?,?,?,?,?)";
			System.out.println("1,2.확인,연결 ,3.sql : " + sql);
			// 4.실행객체,데이터 저장
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getGoodsDiv());
			pstmt.setString(2, vo.getName_kr());
			pstmt.setString(3, vo.getName_en());
			pstmt.setString(4, vo.getGoodsView());
			pstmt.setLong(5, vo.getPrice());
			pstmt.setLong(6, vo.getStock());
			pstmt.setString(7, vo.getFileName());
			System.out.println("4.실행객체,데이터저장");
			// 5.실행
			result = pstmt.executeUpdate();
			System.out.println("5.실행");
			// 6.데이터 표시
			System.out.println("6.1행 삽입완료");

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("게시판 쓰기 DB처리 중 오류 발생");
		} finally {
			DB.close(con, pstmt);
			System.out.println("7.닫기");
		}

		return result;
	}

	@Override
	public Integer update(GoodsVO vo) throws Exception {
		System.out.println("GoodsDAOImpl.update().......");
		int result = 0;
		try {
			// 1,2. 확인, 연결
			con = DB.getConnection();
			// 3.sql
			String sql = "update goods set goodsDiv=?, name_kr=?, name_en=?, goodsView=?, price=?, stock=? "
					+ " where goodsNo = ?";
			System.out.println("1,2.확인,연결 / 3. sql : " + sql);
			// 4.실행객체,데이터저장
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getGoodsDiv());
			pstmt.setString(2, vo.getName_kr());
			pstmt.setString(3, vo.getName_en());
			pstmt.setString(4, vo.getGoodsView());
			pstmt.setLong(5, vo.getPrice());
			pstmt.setLong(6, vo.getStock());
			pstmt.setLong(7, vo.getGoodsNo());
			System.out.println("4.실행객체, 데이터 저장");
			// 5.실행
			result = pstmt.executeUpdate();
			System.out.println("5.실행");
			// 6.표시
			System.out.println("6.표시 - 1행 수정완료");

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("게시판 업데이트 DB 처리중 오류 발생");
		} finally {
			DB.close(con, pstmt);
			System.out.println("7.닫기");
		}
		return result;
	}

	@Override
	public Integer delete(long no) throws Exception {
		System.out.println("GoodsDAOImpl.delete().no...... : " + no);
		int result = 0;
		try {
			con = DB.getConnection();
			String sql = "delete from goods where goodsNo = ?";
			System.out.println("1,2.연결확인 / 3.sql : " + sql);

			pstmt = con.prepareStatement(sql);
			pstmt.setLong(1, no);
			System.out.println("4.실행객체, 데이터저장");

			result = pstmt.executeUpdate();
			System.out.println("5.실행");

			// 표시
			System.out.println("6.표시");

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("게시판 삭제 DB 처리중 오류 발생");
		} finally {
			DB.close(con, pstmt);
			System.out.println("7.닫기");
		}
		return result;
	}// delete의 끝

	@Override
	public Integer updateImg(GoodsVO vo) throws Exception {
		System.out.println("GoodsDAOImpl.delete().vo...... : " + vo);

		int result = 0;
		try {

			con = DB.getConnection();
			String sql = "update goods set fileName = ? " + " where goodsNo = ? ";
			System.out.println("1,2.연결확인 / 3.sql : " + sql);

			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, vo.getFileName());
			pstmt.setLong(2, vo.getGoodsNo());
			System.out.println("4.실행, 데이터세팅");

			result = pstmt.executeUpdate();
			System.out.println("5.실행");

			// 표시
			System.out.println("6.이미지 파일명 수정완료");

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("게시판 이미지 수정 업로드 DB 처리중 오류 발생");
		} finally {
			DB.close(con, pstmt);
			System.out.println("7.닫기");
		}
		return result;
	}

}// class의 끝
