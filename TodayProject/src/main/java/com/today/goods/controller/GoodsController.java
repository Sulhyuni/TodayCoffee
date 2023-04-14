package com.today.goods.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.today.goods.vo.GoodsVO;
import com.today.main.Execute;
import com.today.main.ServiceInterface;
import com.webjjang.util.PageObject;

public class GoodsController {

	//null point  뜨면 Init클래스 확인하자
	
	//private 서비스 생성
	private ServiceInterface goodsListService;
	private ServiceInterface goodsViewService;
	private ServiceInterface goodsWriteService;
	private ServiceInterface goodsUpdateService;
	private ServiceInterface goodsUpdateImgService;
	private ServiceInterface goodsDeleteService;

	//setter생성하여 위 service를 받는다.
	public void setGoodsListService(ServiceInterface goodsListService) {
		this.goodsListService = goodsListService;
	}
	
	
	public void setGoodsViewService(ServiceInterface goodsViewService) {
		this.goodsViewService = goodsViewService;
	}


	public void setGoodsWriteService(ServiceInterface goodsWriteService) {
		this.goodsWriteService = goodsWriteService;
	}


	public void setGoodsUpdateService(ServiceInterface goodsUpdateService) {
		this.goodsUpdateService = goodsUpdateService;
	}


	public void setGoodsUpdateImgService(ServiceInterface goodsUpdateImgService) {
		this.goodsUpdateImgService = goodsUpdateImgService;
	}


	public void setGoodsDeleteService(ServiceInterface goodsDeleteService) {
		this.goodsDeleteService = goodsDeleteService;
	}


	//실행메서드- return 되는 String데이터는 jsp 또는 url 정보.
	public String execute(HttpServletRequest request) throws Exception{
		System.out.println("GoodsController.execute().request : " + request);
		
		//어떤 요청 하는지
		String uri = request.getRequestURI();
		String method = request.getMethod();
		System.out.println("GoodsController.method() : " + method);
		
		//*파일 업로드를 위한 정보!!!*
		//파일 저장된 위치
		String path = "/upload/image";
		//실제적인 파일 시스템 위치가 필요함
		String realPath = request.getServletContext().getRealPath(path);
		System.out.println("GoodsController.execute().realPath : " +realPath);
		int size = 100*1024*1024;
		
		
		//상품(이미지)등록시 아이디가 session에 저장되어있다. (관리자만 등록가능)
		//HttpSession session = request.getSession();
		String jsp = null;
		
		switch (uri) {
		case "/goods/list.do":
			//페이지 정보 받기
			PageObject pageObject = PageObject.getInstance(request);
			
			//데이터 수집
			 request.setAttribute("list", Execute.run(goodsListService, pageObject));
			 request.setAttribute("pageObject", pageObject);
			 jsp = "goods/list";
			 
			break;
			
			
		case "/goods/view.do":
			//데이터수집	
			long no = Long.parseLong(request.getParameter("no"));
			//System.out.println(no);
			//데이터 처리 -> request에 담고 jsp에서 꺼내 쓴다.
			GoodsVO viewVO = (GoodsVO) Execute.run(goodsViewService, no);
			//내용 줄바꿈 처리
			viewVO.setGoodsView(viewVO.getGoodsView().replace("\r\n", "<br>"));
			request.setAttribute("vo", viewVO);
			jsp = "goods/view";
			
			break;
			
		case "/goods/write.do":
			//writeForm 으로. get 방식
			if(request.getMethod().equals("GET")) {
				jsp  = "goods/write";
			}else {
				//post방식이라면
				//파일 업로드 실행 -> 객체 생성과 동시에 업로드 해준다.
				//request 대신 MultipartRequest multi에 데이터를 넣어둔다.
				//DefaultFileRenamePolicy() - 중복 이름 삭제
				MultipartRequest multi = new MultipartRequest(request, realPath,size,"utf-8", new DefaultFileRenamePolicy());
				
				//데이터 수집
				GoodsVO writeVO = new GoodsVO();
				long price = Long.parseLong(multi.getParameter("price"));
				long stock = Long.parseLong(multi.getParameter("stock"));
				
				writeVO.setGoodsDiv(multi.getParameter("goodsDiv"));
				writeVO.setName_kr(multi.getParameter("name_kr"));
				writeVO.setName_en(multi.getParameter("name_en"));
				writeVO.setGoodsView(multi.getParameter("goodsView"));
				writeVO.setPrice(price);
				writeVO.setStock(stock);
				writeVO.setFileName(path +"/"+multi.getFilesystemName("fileName"));
				System.out.println("GoodsController.execute().writeVO : " + writeVO);
				
				//글등록
				Execute.run(goodsWriteService, writeVO);
				jsp = "redirect:list.do";
			}
			
			break;
			
		case "/goods/update.do":
			//updateVO 변수 생헝하고 view서비스에서 번호를 가져오기
			long updateNo = Long.parseLong(request.getParameter("no"));
			if(request.getMethod().equals("GET")) {
				//데이터 처리
				request.setAttribute("vo", Execute.run(goodsViewService, updateNo));
				jsp="goods/update";
			}else {
				long price = Long.parseLong(request.getParameter("price"));
				long stock= Long.parseLong(request.getParameter("stock"));
				//post방식
				GoodsVO updateVO=new GoodsVO();
				//데이터 수집
				updateVO.setGoodsNo(updateNo);
				updateVO.setGoodsDiv(request.getParameter("goodsDiv"));
				updateVO.setName_kr(request.getParameter("name_kr"));
				updateVO.setName_en(request.getParameter("name_en"));
				updateVO.setGoodsView(request.getParameter("goodsView"));
				updateVO.setPrice(price);
				updateVO.setStock(stock);
				//DB처리하기
				Execute.run(goodsUpdateService, updateVO);
				jsp="redirect:view.do?no="+updateNo;
			}
			break;
		case "/goods/updateImg.do":
			//파일 업로드를 실행 
			//request 대신 multi
			MultipartRequest multi = new MultipartRequest(request, realPath,size,"utf-8", new DefaultFileRenamePolicy());
			
			//데이터 수집
			long updateImgNo = Long.parseLong(multi.getParameter("no"));
						
			//삭제할 이미지 파일
			String deleteFileName = multi.getParameter("deleteFile");
			System.out.println("GoodsController.execute().deleteFile : " + deleteFileName);
			String realDeleteFile = request.getServletContext().getRealPath(deleteFileName);
			File deleteFile = new File(realDeleteFile);
			if(deleteFile.exists())
				System.out.println("삭제 파일이 존재 합니다.");
			
			GoodsVO updateImgVO=new GoodsVO();
			updateImgVO.setGoodsNo(updateImgNo);
			updateImgVO.setFileName(path + "/" + multi.getFilesystemName("imageFile"));
			System.out.println("GoodsController.execute().updateimgVO : " + updateImgVO);
			
			//등록 처리
			Execute.run(goodsUpdateImgService, updateImgVO);
			jsp="redirect:view.do?no="+updateImgNo;
			break;
			
		case "/goods/delete.do":

			//데이터수집- 글번호
			long deleteNo = Long.parseLong(request.getParameter("no"));
			deleteFileName = request.getParameter("deleteFile");
			
			//DB삭제
			Execute.run(goodsDeleteService, deleteNo);
			
			//데이터가 삭제되면 파일도 삭제
			realDeleteFile = request.getServletContext().getRealPath(deleteFileName);
			deleteFile = new File(realDeleteFile);
			deleteFile.delete();
			
			jsp = "redirect:list.do";
			break;

		default:
			throw new Exception("잘못된 페이지를 요청했습니다.");
		}
		
		return jsp;
	}
	
}
