package com.today.order.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.today.goods.vo.GoodsVO;
import com.today.main.Execute;
import com.today.main.ServiceInterface;
import com.today.member.vo.MemberVO;
import com.today.order.vo.OrderVO;
import com.webjjang.util.PageObject;

public class OrderController {
	 
	private ServiceInterface orderListService;
	private ServiceInterface orderPerListService;
	private ServiceInterface orderViewService;
	private ServiceInterface orderWriteService;
	private ServiceInterface orderUpdateService;
	private ServiceInterface orderDeleteService;
	private ServiceInterface goodsViewService;
	private ServiceInterface orderOptionAddService;
	private ServiceInterface orderOptionViewService;
	private ServiceInterface orderOpDetailViewService;
	private ServiceInterface orderCartListService;
	private ServiceInterface orderMmListService;
	private ServiceInterface orderCartDeleteService;
	private ServiceInterface orderStockService;
	
	public void setOrderListService(ServiceInterface orderListService) {
		this.orderListService = orderListService;
	}
	public void setOrderPerListService(ServiceInterface orderPerListService) {
		this.orderPerListService = orderPerListService;
	}
	public void setOrderViewService(ServiceInterface orderViewService) {
		this.orderViewService = orderViewService;
	}
	public void setOrderWriteService(ServiceInterface orderWriteService) {
		this.orderWriteService = orderWriteService;
	}
	public void setOrderUpdateService(ServiceInterface orderUpdateService) {
		this.orderUpdateService = orderUpdateService;
	}
	public void setOrderDeleteService(ServiceInterface orderDeleteService) {
		this.orderDeleteService = orderDeleteService;
	}
	public void setGoodsViewService(ServiceInterface goodsViewService) {
		this.goodsViewService = goodsViewService;
	}
	public void setOrderOptionAddService(ServiceInterface orderOptionAddService) {
		this.orderOptionAddService = orderOptionAddService;
	}
	public void setOrderOptionViewService(ServiceInterface orderOptionViewService) {
		this.orderOptionViewService = orderOptionViewService;
	}	
	public void setOrderOpDetailViewService(ServiceInterface orderOpDetailViewService) {
		this.orderOpDetailViewService = orderOpDetailViewService;
	}
	public void setOrderCartListService(ServiceInterface orderCartListService) {
		this.orderCartListService = orderCartListService;
	}
	public void setOrderMmListService(ServiceInterface orderMmListService) {
		this.orderMmListService = orderMmListService;
	}
	
	public void setOrderCartDeleteService(ServiceInterface orderCartDeleteService) {
		this.orderCartDeleteService = orderCartDeleteService;
	}
	
	public void setOrderStockService(ServiceInterface orderStockService) {
		this.orderStockService = orderStockService;
	}
	@SuppressWarnings("unchecked")
	public String execute(HttpServletRequest request) throws Exception {
		System.out.println("orderController.execute().request : " + request);
		String uri = request.getRequestURI();
		String method = request.getMethod();
		System.out.println("orderController.execute().method : " + method);
		// session 받아오기
		HttpSession session = request.getSession();
		String jsp = null;
		
		switch (uri) {
		case "/order/list.do":
			MemberVO loginVO =((MemberVO)session.getAttribute("login"));
			PageObject pageObject = PageObject.getInstance(request);
			if(loginVO.getGradeNo() == 9 ) {		
				request.setAttribute("list", Execute.run(orderListService, pageObject));
			} else if (loginVO.getGradeNo() == 1) {
				String id = loginVO.getId();
				Object[] args = new Object[] {id, pageObject};
				request.setAttribute("list", Execute.run(orderPerListService, args));
			}
			request.setAttribute("pageObject", pageObject);
			jsp ="order/list";
			break;
		case "/order/view.do":
			long no = Long.parseLong(request.getParameter("no"));
			OrderVO viewVO = (OrderVO) Execute.run(orderViewService, no);
			MemberVO mVO = ((MemberVO)session.getAttribute("login"));
			viewVO.setGradeNo(mVO.getGradeNo());
			request.setAttribute("vo", viewVO);
			request.setAttribute("view", viewVO.getList());
			jsp = "order/view";
			break;
		// 상품정보에서 옵션선택하기
		case "/order/opAdd.do":
			if(request.getMethod().equals("GET")) {
				long goodsNo = Long.parseLong(request.getParameter("no"));
				GoodsVO goodsViewVO = (GoodsVO) Execute.run(goodsViewService, goodsNo);
				request.setAttribute("vo", goodsViewVO);
				jsp = "order/opAdd"; // 옵션정보 선택할 수 있는 창으로 보여줌
			} else {
				// 옵션테이블에 goodsNo, cup_size, cup, syrup, heating INSERT
				OrderVO opVO = new OrderVO();
				// opAdd에서 가져온 goodsNo로 goods정보 가져와서 opVO에 다 담기
				long goodsNo = Long.parseLong(request.getParameter("goodsNo"));
				GoodsVO goodsVO = (GoodsVO) Execute.run(goodsViewService, goodsNo);
				opVO.setGoodsNo(goodsVO.getGoodsNo()); // goodsVO의 goodsNo를 orderVO에 넣기
				opVO.setGoodsName(goodsVO.getName_kr()); // goodsVO의 name_kr을 orderVO에 넣기
				opVO.setGoodsDiv(goodsVO.getGoodsDiv()); // goodsVO의 goodsDiv를 orderVO에 넣기
				String heating = request.getParameter("heating");
				if (heating != null) {
					opVO.setHeating(heating);
				} else {
					opVO.setCupSize(request.getParameter("cup_size"));
					opVO.setCup(request.getParameter("cup"));
					opVO.setSyrup(request.getParameter("syrup"));
				}
				// 입력받은 사이즈, 컵종류, 시럽 option테이블에 insert
				Execute.run(orderOptionAddService, opVO);
				OrderVO opNo = new OrderVO();
				// 옵션번호 가져오기
				opNo = (OrderVO) Execute.run(orderOptionViewService, opVO);
				// 옵션번호, 수량, 총가격 담아서 pay.do로 넘기기
				opVO.setOptionNo(opNo.getOptionNo());
				long quantity = Long.parseLong(request.getParameter("quantity"));
				long orderPrice = Long.parseLong(request.getParameter("orderPrice"));
				opVO.setQuantity(quantity);
				opVO.setOrderPrice(orderPrice);
				// 최종으로 opVO에 담겨있는 것 - goodsNo, name_kr, goodsDiv, cup_size, cup, syrup, quantity, orderPrice
				// pay.do에서 장바구니 때문에 list로 받기 때문에 list에 담아서 보냄.
				List<OrderVO> list = new ArrayList<>();
				list.add(opVO);
				request.setAttribute("list", list);	
				opVO.setPoint(((MemberVO)session.getAttribute("login")).getPoint());
				request.setAttribute("vo", opVO);
				jsp = "redirect:/order/pay.do?goodsNo="+opVO.getGoodsNo()+"&optionNo="+opNo.getOptionNo()+"&quantity="+quantity+"&orderPrice="+orderPrice; // order/pay.do로 이동
			}
			break;
		// 상품정보+옵션정보로 결제
		case "/order/pay.do":
			// GET 방식일때는 결제정보 선택하는 창 보여주기
			if(request.getMethod().equals("GET")) {
				String[] cartNoArray = request.getParameterValues("cartNos");
				String[] mmNoArray = request.getParameterValues("mmNos");
				if(cartNoArray != null) {	
					// 장바구니에서 주문할 때
					List<Long> cartNoList = new ArrayList<>();
					for (String cartNoStr : cartNoArray) {
						String[] cartNoStrArray = cartNoStr.split(",");
						for (String cartNoSubStr : cartNoStrArray) {
				            Long cartNo = Long.parseLong(cartNoSubStr);
				            cartNoList.add(cartNo);	
				        }
					}
					request.setAttribute("list", Execute.run(orderCartListService, cartNoList));
					OrderVO vo = new OrderVO();
					vo.setPoint(((MemberVO)session.getAttribute("login")).getPoint());
					request.setAttribute("vo", vo);
				} else if (mmNoArray != null){
					// 나만의 메뉴에서 주문할 때
					List<Long> mmNoList = new ArrayList<>();
					for (String mmNoStr : mmNoArray) {
						String[] mmNoStrArray = mmNoStr.split(",");
						for (String mmNoSubStr : mmNoStrArray) {
				            Long mmNo = Long.parseLong(mmNoSubStr);
				            mmNoList.add(mmNo);	
				        }
					}
					request.setAttribute("list", Execute.run(orderMmListService, mmNoList));
					OrderVO vo = new OrderVO();
					vo.setPoint(((MemberVO)session.getAttribute("login")).getPoint());
					request.setAttribute("vo", vo);
				}else{
					// 상품 하나만 주문할 때
					GoodsVO goodsVO = new GoodsVO();
					// 링크 뒤에 줄줄이 붙은거 가져오기
					long goodsNo = Long.parseLong(request.getParameter("goodsNo")); // goodsNo 가져옴
					long optionNo = Long.parseLong(request.getParameter("optionNo")); // optionNo 가져옴
					long quantity = Long.parseLong(request.getParameter("quantity")); // opAdd에서 선택한 수량 가져옴
					long orderPrice = Long.parseLong(request.getParameter("orderPrice")); // opAdd에서 적용된 가격 가져옴
					goodsVO = (GoodsVO) Execute.run(goodsViewService, goodsNo); // goodsNo로 goods정보 가져와서 goodsVO에 담기
					// 옵션 정보 가져오기
					OrderVO opViewVO = new OrderVO();
					opViewVO.setGoodsNo(goodsNo);
					opViewVO.setOptionNo(optionNo);
					opViewVO = (OrderVO) Execute.run(orderOpDetailViewService, opViewVO);
					OrderVO vo = new OrderVO(); // pay.do로 보낼 vo 생성
					// OrderVO에 옮겨담기
					vo.setGoodsNo(goodsVO.getGoodsNo()); // 상품번호
					vo.setGoodsName(goodsVO.getName_kr()); // 상품이름
					vo.setGoodsDiv(goodsVO.getGoodsDiv()); // 상품분류
					vo.setFileName(goodsVO.getFileName()); // 파일이름
					if(opViewVO.getHeating() == null) {						
						vo.setCup(opViewVO.getCup()); // 컵종류
						vo.setCupSize(opViewVO.getCupSize()); // 컵사이즈
						vo.setSyrup(opViewVO.getSyrup()); // 시럽
					} else {				
						vo.setHeating(opViewVO.getHeating()); // 데움
					}
					vo.setOptionNo(optionNo); // 옵션번호
					vo.setQuantity(quantity); // 수량
					vo.setOrderPrice(orderPrice); // 가격
					vo.setPoint(((MemberVO)session.getAttribute("login")).getPoint());
					request.setAttribute("vo", vo);
				}
				jsp = "order/pay";
			// POST
			} else {
				String[] cartNoArray = request.getParameterValues("cartNos");
				String[] mmNoArray = request.getParameterValues("mmNos");
				OrderVO orderVO = new OrderVO();
				if(cartNoArray != null) {
					// 장바구니에서 결제 처리 할 때
					List<Long> cartNoList = new ArrayList<>();
					if(cartNoArray != null) {				
						for (String cartNoStr : cartNoArray) {
							String[] cartNoStrArray = cartNoStr.split(",");
							for (String cartNoSubStr : cartNoStrArray) {
								if(!cartNoSubStr.isEmpty()) {
									Long cartNo = Long.parseLong(cartNoSubStr);
									cartNoList.add(cartNo);
								}
					        }
						}	
					}
					List<OrderVO> olist = (List<OrderVO>) Execute.run(orderCartListService, cartNoList);
					for(OrderVO ovo : olist) {
						OrderVO o = new OrderVO();
						o.setGoodsNo(ovo.getGoodsNo());
						o.setOptionNo(ovo.getOptionNo());
						o.setQuantity(ovo.getQuantity());
						o.setOrderPrice(ovo.getOrderPrice());
						orderVO.getList().add(o);
					}
				} else if (mmNoArray != null){
					// 나만의메뉴에서 결제 처리 할 때
					List<Long> mmNoList = new ArrayList<>();
					if(mmNoArray != null) {				
						for (String mmNoStr : mmNoArray) {
							String[] mmNoStrArray = mmNoStr.split(",");
							for (String mmNoSubStr : mmNoStrArray) {
								if(!mmNoSubStr.isEmpty()) {
									Long mmNo = Long.parseLong(mmNoSubStr);
									mmNoList.add(mmNo);
								}
					        }
						}	
					}
					List<OrderVO> olist = (List<OrderVO>) Execute.run(orderMmListService, mmNoList);
					for(OrderVO ovo : olist) {
						OrderVO o = new OrderVO();
						o.setGoodsNo(ovo.getGoodsNo());
						o.setOptionNo(ovo.getOptionNo());
						o.setQuantity(1);
						o.setOrderPrice(ovo.getOrderPrice());
						orderVO.getList().add(o);
					}
				} else {
					// 상품 한개를 결제처리 할 때 - orderDetail 테이블에 담을거
					OrderVO o = new OrderVO();
					o.setOptionNo(Long.parseLong(request.getParameter("optionNo")));
					o.setGoodsNo(Long.parseLong(request.getParameter("goodsNo")));
					o.setQuantity(Long.parseLong(request.getParameter("quantity")));
					o.setOrderPrice(Long.parseLong(request.getParameter("orderPrice")));
					orderVO.getList().add(o);
				}
				// orderTable에 담을거
				orderVO.setId(((MemberVO)session.getAttribute("login")).getId());
				orderVO.setTotalPrice(Long.parseLong(request.getParameter("totalPrice")));
				orderVO.setPayPrice(Long.parseLong(request.getParameter("payPrice")));
				orderVO.setPayMethod(request.getParameter("payMethod"));
				// orderVO.setStockQuantity(Long.parseLong(request.getParameter("quantity")));
				Execute.run(orderWriteService, orderVO);
				// 장바구니 삭제 처리
				if(cartNoArray != null) {
					List<Long> cartNoList = new ArrayList<>();
					for (String cartNoStr : cartNoArray) {
						String[] cartNoStrArray = cartNoStr.split(",");
						for (String cartNoSubStr : cartNoStrArray) {
				            Long cartNo = Long.parseLong(cartNoSubStr);
				            cartNoList.add(cartNo);	
				        }
					}
					Execute.run(orderCartDeleteService, cartNoList);
				}
				// 포인트 차감처리
				String usePointStr = request.getParameter("usePoint");
				if(usePointStr != "") {
					Long usePoint = Long.parseLong(usePointStr);
					orderVO.setUsePoint(usePoint);
					Execute.run(orderDeleteService, orderVO);
				}
				jsp = "redirect:orderCompl.do"; // 주문완료창
			}
			break;
		case "/order/update.do":
			OrderVO upVO = new OrderVO();
			upVO.setOrderStatus(request.getParameter("orderStatus"));
			upVO.setOrderNo(Long.parseLong(request.getParameter("orderNo")));
			Execute.run(orderUpdateService, upVO);
			jsp = "redirect:view.do?no="+upVO.getOrderNo();
			break;
		case "/order/orderCompl.do":
			jsp = "order/orderCompl";
			break;
		default:
			throw new Exception("잘못된 페이지를 요청");
		}
		return jsp;
	} // end of execute
	

}
