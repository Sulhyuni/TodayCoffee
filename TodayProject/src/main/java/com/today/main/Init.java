package com.today.main;

import java.util.HashMap;
import java.util.Map;

import com.today.error.controller.ErrorController;
import com.today.cart.controller.CartController;
import com.today.cart.dao.CartDAOImpl;
import com.today.cart.service.CartAddServiceImpl;
import com.today.cart.service.CartAllDeleteServiceImpl;
import com.today.cart.service.CartDeleteServiceImpl;
import com.today.cart.service.CartListServiceImpl;
import com.today.cart.service.CartNoListServiceImpl;
import com.today.cart.service.CartOptionAddServiceImpl;
import com.today.cart.service.CartOptionViewServiceImpl;
import com.today.cart.service.CartUpdateServiceImpl;
import com.today.cart.service.CartViewServiceImpl;
import com.today.cart.service.CartmmNoServiceImpl;
import com.today.event.controller.EventController;
import com.today.event.dao.EventDAOImpl;
import com.today.event.service.EventApplyListServiceImpl;
import com.today.event.service.EventApplyUpdateServiceImpl;
import com.today.event.service.EventApplyWriteServiceImpl;
import com.today.event.service.EventCurrentListServiceImpl;
import com.today.event.service.EventDeleteServiceImpl;
import com.today.event.service.EventLastListServiceImpl;
import com.today.event.service.EventListServiceImpl;
import com.today.event.service.EventReservedListServiceImpl;
import com.today.event.service.EventUpdateServiceImpl;
import com.today.event.service.EventUserApplyListServiceImpl;
import com.today.event.service.EventViewServiceImpl;
import com.today.event.service.EventWriteServiceImpl;
import com.today.goods.controller.GoodsController;
import com.today.goods.dao.GoodsDAOImpl;
import com.today.goods.service.GoodsDeleteServiceImpl;
import com.today.goods.service.GoodsListServiceImpl;
import com.today.goods.service.GoodsUpdateImgServiceImpl;
import com.today.goods.service.GoodsUpdateServiceImpl;
import com.today.goods.service.GoodsViewServiceImpl;
import com.today.goods.service.GoodsWriteServiceImpl;
import com.today.main.controller.MainController;
import com.today.member.controller.MemberController;
import com.today.member.controller.MemberSleepThread;
import com.today.member.dao.MemberDAOImpl;
import com.today.member.service.MemberChangeGradeNoServiceImpl;
import com.today.member.service.MemberChangePwNowServiceImpl;
import com.today.member.service.MemberChangePwServiceImpl;
import com.today.member.service.MemberChangeStatusServiceImpl;
import com.today.member.service.MemberCheckIdServiceImpl;
import com.today.member.service.MemberCheckPwServiceImpl;
import com.today.member.service.MemberDeleteServiceImpl;
import com.today.member.service.MemberFindIdServiceImpl;
import com.today.member.service.MemberFindPwServiceImpl;
import com.today.member.service.MemberListServiceImpl;
import com.today.member.service.MemberLoginServiceImpl;
import com.today.member.service.MemberSleepServiceImpl;
import com.today.member.service.MemberUpdateServiceImpl;
import com.today.member.service.MemberViewServiceImpl;
import com.today.member.service.MemberWakeUpServiceImpl;
import com.today.member.service.MemberWriteServiceImpl;
import com.today.mymenu.controller.MyMenuController;
import com.today.mymenu.dao.MyMenuDAOImpl;
import com.today.mymenu.service.MyMenuAddServiceImpl;
import com.today.mymenu.service.MyMenuAllDeleteServiceImpl;
import com.today.mymenu.service.MyMenuDeleteServiceImpl;
import com.today.mymenu.service.MyMenuListServiceImpl;
import com.today.mymenu.service.MyMenuNoListServiceImpl;
import com.today.mymenu.service.MyMenuOptionAddServiceImpl;
import com.today.mymenu.service.MyMenuOptionViewServiceImpl;
import com.today.mymenu.service.MyMenuUpdateServiceImpl;
import com.today.mymenu.service.MyMenuViewServiceImpl;
import com.today.notice.controller.NoticeController;
import com.today.notice.dao.NoticeDAOImpl;
import com.today.notice.service.NoticeCurrentListServiceImpl;
import com.today.notice.service.NoticeDeleteServiceImpl;
import com.today.notice.service.NoticeLastListServiceImpl;
import com.today.notice.service.NoticeListServiceImpl;
import com.today.notice.service.NoticeReservedListServiceImpl;
import com.today.notice.service.NoticeUpdateServiceImpl;
import com.today.notice.service.NoticeViewServiceImpl;
import com.today.notice.service.NoticeWriteServiceImpl;
import com.today.order.controller.OrderController;
import com.today.order.dao.OrderDAOImpl;
import com.today.order.service.OrderCartDeleteServiceImpl;
import com.today.order.service.OrderCartListServiceImpl;
import com.today.order.service.OrderDeleteServiceImpl;
import com.today.order.service.OrderListServiceImpl;
import com.today.order.service.OrderMmListServiceImpl;
import com.today.order.service.OrderOpDetailViewServiceImpl;
import com.today.order.service.OrderOptionAddServiceImpl;
import com.today.order.service.OrderOptionViewServiceImpl;
import com.today.order.service.OrderPerListServiceImpl;
import com.today.order.service.OrderStockServiceImpl;
import com.today.order.service.OrderUpdateServiceImpl;
import com.today.order.service.OrderViewServiceImpl;
import com.today.order.service.OrderWriteServiceImpl;

public class Init {
	// controller 저장변수 선언
	private static Map<String, Object> controllerMap = new HashMap<>();
	private static Map<String, ServiceInterface> serviceMap = new HashMap<>();
	private static Map<String, Object> daoMap = new HashMap<>();
	public static MemberSleepThread mst = new MemberSleepThread();
	
	public static void init() {
		// controller 생성
		controllerMap.put("mainController", new MainController());
		controllerMap.put("noticeController", new NoticeController());
		controllerMap.put("eventController", new EventController());
		controllerMap.put("memberController", new MemberController());
		controllerMap.put("cartController", new CartController());
		controllerMap.put("mymenuController", new MyMenuController());
		controllerMap.put("goodsController", new GoodsController());
		controllerMap.put("orderController", new OrderController());
		controllerMap.put("errorController", new ErrorController());
		
		// dao 생성
		daoMap.put("noticeDAO", new NoticeDAOImpl());
		daoMap.put("eventDAO", new EventDAOImpl());
		daoMap.put("memberDAO", new MemberDAOImpl());
		daoMap.put("cartDAO", new CartDAOImpl());
		daoMap.put("mymenuDAO", new MyMenuDAOImpl());
		daoMap.put("goodsDAO", new GoodsDAOImpl());
		daoMap.put("orderDAO", new OrderDAOImpl());

		
		// Service 생성 - list, view, write, update, delete ...
		// 공지사항
		serviceMap.put("noticeListServiceImpl", new NoticeListServiceImpl());
		serviceMap.put("noticeCurrentListServiceImpl", new NoticeCurrentListServiceImpl());
		serviceMap.put("noticeLastListServiceImpl", new NoticeLastListServiceImpl());
		serviceMap.put("noticeReservedListServiceImpl", new NoticeReservedListServiceImpl());
		serviceMap.put("noticeViewServiceImpl", new NoticeViewServiceImpl());
		serviceMap.put("noticeWriteServiceImpl", new NoticeWriteServiceImpl());
		serviceMap.put("noticeUpdateServiceImpl", new NoticeUpdateServiceImpl());
		serviceMap.put("noticeDeleteServiceImpl", new NoticeDeleteServiceImpl());

		// 이벤트
		serviceMap.put("eventListServiceImpl", new EventListServiceImpl());
		serviceMap.put("eventCurrentListServiceImpl", new EventCurrentListServiceImpl());
		serviceMap.put("eventLastListServiceImpl", new EventLastListServiceImpl());
		serviceMap.put("eventReservedListServiceImpl", new EventReservedListServiceImpl());
		serviceMap.put("eventViewServiceImpl", new EventViewServiceImpl());
		serviceMap.put("eventWriteServiceImpl", new EventWriteServiceImpl());
		serviceMap.put("eventUpdateServiceImpl", new EventUpdateServiceImpl());
		serviceMap.put("eventDeleteServiceImpl", new EventDeleteServiceImpl());
		serviceMap.put("eventApplyListServiceImpl", new EventApplyListServiceImpl());
		serviceMap.put("eventApplyWriteServiceImpl", new EventApplyWriteServiceImpl());
		serviceMap.put("eventApplyUpdateServiceImpl", new EventApplyUpdateServiceImpl());
		serviceMap.put("eventUserApplyListServiceImpl", new EventUserApplyListServiceImpl());
		
		
		// 회원관리 서비스 생성
		serviceMap.put("memberLoginServiceImpl", new MemberLoginServiceImpl());
		serviceMap.put("memberWriteServiceImpl", new MemberWriteServiceImpl());
		serviceMap.put("memberListServiceImpl", new MemberListServiceImpl());
		serviceMap.put("memberViewServiceImpl", new MemberViewServiceImpl());
		serviceMap.put("memberCheckIdServiceImpl", new MemberCheckIdServiceImpl());
		serviceMap.put("memberFindIdServiceImpl", new MemberFindIdServiceImpl());
		serviceMap.put("memberFindPwServiceImpl", new MemberFindPwServiceImpl());
		serviceMap.put("memberChangePwServiceImpl", new MemberChangePwServiceImpl());
		serviceMap.put("memberChangePwNowServiceImpl", new MemberChangePwNowServiceImpl());
		serviceMap.put("memberChangeStatusServiceImpl", new MemberChangeStatusServiceImpl());
		serviceMap.put("memberChangeGradeNoServiceImpl", new MemberChangeGradeNoServiceImpl());
		serviceMap.put("memberCheckPwServiceImpl", new MemberCheckPwServiceImpl());
		serviceMap.put("memberUpdateServiceImpl", new MemberUpdateServiceImpl());
		serviceMap.put("memberDeleteServiceImpl", new MemberDeleteServiceImpl());
		serviceMap.put("memberWakeUpServiceImpl", new MemberWakeUpServiceImpl());
		serviceMap.put("memberSleepServiceImpl", new MemberSleepServiceImpl());

		// 장바구니 서비스 생성
		serviceMap.put("cartListServiceImpl", new CartListServiceImpl());
		serviceMap.put("cartViewServiceImpl", new CartViewServiceImpl());
		serviceMap.put("cartAddServiceImpl", new CartAddServiceImpl());
		serviceMap.put("cartUpdateServiceImpl", new CartUpdateServiceImpl());
		serviceMap.put("cartDeleteServiceImpl", new CartDeleteServiceImpl());
		serviceMap.put("cartAllDeleteServiceImpl", new CartAllDeleteServiceImpl());
		serviceMap.put("cartOptionAddServiceImpl", new CartOptionAddServiceImpl());
		serviceMap.put("cartOptionViewServiceImpl", new CartOptionViewServiceImpl());
		serviceMap.put("cartNoListServiceImpl", new CartNoListServiceImpl());
		serviceMap.put("cartmmNoServiceImpl", new CartmmNoServiceImpl());
		
		// 나만의 메뉴 서비스 생성
		serviceMap.put("mymenuListServiceImpl", new MyMenuListServiceImpl());
		serviceMap.put("mymenuViewServiceImpl", new MyMenuViewServiceImpl());
		serviceMap.put("mymenuAddServiceImpl",  new MyMenuAddServiceImpl());
		serviceMap.put("mymenuUpdateServiceImpl",  new MyMenuUpdateServiceImpl());
		serviceMap.put("mymenuDeleteServiceImpl",  new MyMenuDeleteServiceImpl());
		serviceMap.put("mymenuAllDeleteServiceImpl",  new MyMenuAllDeleteServiceImpl());
		serviceMap.put("mymenuOptionAddServiceImpl",  new MyMenuOptionAddServiceImpl());
		serviceMap.put("mymenuOptionViewServiceImpl",  new MyMenuOptionViewServiceImpl());
		serviceMap.put("mymenuNoListServiceImpl", new MyMenuNoListServiceImpl());
		
		// 상품관리 서비스 생성
		serviceMap.put("goodsListServiceImpl", new GoodsListServiceImpl());
		serviceMap.put("goodsViewServiceImpl", new GoodsViewServiceImpl());
		serviceMap.put("goodsWriteServiceImpl", new GoodsWriteServiceImpl());
		serviceMap.put("goodsUpdateServiceImpl", new GoodsUpdateServiceImpl());
		serviceMap.put("goodsUpdateImgServiceImpl", new GoodsUpdateImgServiceImpl());
		serviceMap.put("goodsDeleteServiceImpl", new GoodsDeleteServiceImpl());
		
		// 주문관리 서비스 생성
		serviceMap.put("orderListServiceImpl", new OrderListServiceImpl());
		serviceMap.put("orderPerListServiceImpl", new OrderPerListServiceImpl());
		serviceMap.put("orderViewServiceImpl", new OrderViewServiceImpl());
		serviceMap.put("orderWriteServiceImpl", new OrderWriteServiceImpl());
		serviceMap.put("orderUpdateServiceImpl", new OrderUpdateServiceImpl());
		serviceMap.put("orderDeleteServiceImpl", new OrderDeleteServiceImpl());
		serviceMap.put("orderOptionAddServiceImpl", new OrderOptionAddServiceImpl());
		serviceMap.put("orderOptionViewServiceImpl", new OrderOptionViewServiceImpl());
		serviceMap.put("orderOpDetailViewServiceImpl", new OrderOpDetailViewServiceImpl());
		serviceMap.put("orderCartListServiceImpl", new OrderCartListServiceImpl());
		serviceMap.put("orderMmListServiceImpl", new OrderMmListServiceImpl());
		serviceMap.put("orderCartDeleteServiceImpl", new OrderCartDeleteServiceImpl());
		serviceMap.put("orderStockServiceImpl", new OrderStockServiceImpl());
		
		//dao -> service : 조립
		// 공지사항
		serviceMap.get("noticeListServiceImpl").setDao(daoMap.get("noticeDAO"));
		serviceMap.get("noticeReservedListServiceImpl").setDao(daoMap.get("noticeDAO"));
		serviceMap.get("noticeLastListServiceImpl").setDao(daoMap.get("noticeDAO"));
		serviceMap.get("noticeCurrentListServiceImpl").setDao(daoMap.get("noticeDAO"));
		serviceMap.get("noticeViewServiceImpl").setDao(daoMap.get("noticeDAO"));
		serviceMap.get("noticeWriteServiceImpl").setDao(daoMap.get("noticeDAO"));
		serviceMap.get("noticeUpdateServiceImpl").setDao(daoMap.get("noticeDAO"));
		serviceMap.get("noticeDeleteServiceImpl").setDao(daoMap.get("noticeDAO"));	
		
		serviceMap.get("eventListServiceImpl").setDao(daoMap.get("eventDAO"));
		serviceMap.get("eventReservedListServiceImpl").setDao(daoMap.get("eventDAO"));
		serviceMap.get("eventLastListServiceImpl").setDao(daoMap.get("eventDAO"));
		serviceMap.get("eventCurrentListServiceImpl").setDao(daoMap.get("eventDAO"));
		serviceMap.get("eventViewServiceImpl").setDao(daoMap.get("eventDAO"));
		serviceMap.get("eventWriteServiceImpl").setDao(daoMap.get("eventDAO"));
		serviceMap.get("eventUpdateServiceImpl").setDao(daoMap.get("eventDAO"));
		serviceMap.get("eventDeleteServiceImpl").setDao(daoMap.get("eventDAO"));	
		serviceMap.get("eventApplyListServiceImpl").setDao(daoMap.get("eventDAO"));
		serviceMap.get("eventApplyWriteServiceImpl").setDao(daoMap.get("eventDAO"));
		serviceMap.get("eventApplyUpdateServiceImpl").setDao(daoMap.get("eventDAO"));
		serviceMap.get("eventUserApplyListServiceImpl").setDao(daoMap.get("eventDAO"));
		
				// 회원관리 조립
		serviceMap.get("memberLoginServiceImpl").setDao(daoMap.get("memberDAO"));
		serviceMap.get("memberWriteServiceImpl").setDao(daoMap.get("memberDAO"));
		serviceMap.get("memberListServiceImpl").setDao(daoMap.get("memberDAO"));
		serviceMap.get("memberViewServiceImpl").setDao(daoMap.get("memberDAO"));
		serviceMap.get("memberCheckIdServiceImpl").setDao(daoMap.get("memberDAO"));
		serviceMap.get("memberFindIdServiceImpl").setDao(daoMap.get("memberDAO"));
		serviceMap.get("memberFindPwServiceImpl").setDao(daoMap.get("memberDAO"));
		serviceMap.get("memberChangePwServiceImpl").setDao(daoMap.get("memberDAO"));
		serviceMap.get("memberChangePwNowServiceImpl").setDao(daoMap.get("memberDAO"));
		serviceMap.get("memberChangeStatusServiceImpl").setDao(daoMap.get("memberDAO"));
		serviceMap.get("memberChangeGradeNoServiceImpl").setDao(daoMap.get("memberDAO"));
		serviceMap.get("memberCheckPwServiceImpl").setDao(daoMap.get("memberDAO"));
		serviceMap.get("memberUpdateServiceImpl").setDao(daoMap.get("memberDAO"));
		serviceMap.get("memberDeleteServiceImpl").setDao(daoMap.get("memberDAO"));
		serviceMap.get("memberWakeUpServiceImpl").setDao(daoMap.get("memberDAO"));
		serviceMap.get("memberSleepServiceImpl").setDao(daoMap.get("memberDAO"));
		
		// 장바구니 조립
		serviceMap.get("cartListServiceImpl").setDao(daoMap.get("cartDAO"));
		serviceMap.get("cartViewServiceImpl").setDao(daoMap.get("cartDAO"));
		serviceMap.get("cartAddServiceImpl").setDao(daoMap.get("cartDAO"));
		serviceMap.get("cartUpdateServiceImpl").setDao(daoMap.get("cartDAO"));
		serviceMap.get("cartDeleteServiceImpl").setDao(daoMap.get("cartDAO"));
		serviceMap.get("cartAllDeleteServiceImpl").setDao(daoMap.get("cartDAO"));
		serviceMap.get("cartOptionAddServiceImpl").setDao(daoMap.get("cartDAO"));
		serviceMap.get("cartOptionViewServiceImpl").setDao(daoMap.get("cartDAO"));
		serviceMap.get("cartNoListServiceImpl").setDao(daoMap.get("cartDAO"));
		serviceMap.get("cartmmNoServiceImpl").setDao(daoMap.get("cartDAO"));
		
		// 나만의 메뉴 조립
		serviceMap.get("mymenuListServiceImpl").setDao(daoMap.get("mymenuDAO"));
		serviceMap.get("mymenuViewServiceImpl").setDao(daoMap.get("mymenuDAO"));
		serviceMap.get("mymenuAddServiceImpl").setDao(daoMap.get("mymenuDAO"));
		serviceMap.get("mymenuUpdateServiceImpl").setDao(daoMap.get("mymenuDAO"));
		serviceMap.get("mymenuDeleteServiceImpl").setDao(daoMap.get("mymenuDAO"));
		serviceMap.get("mymenuAllDeleteServiceImpl").setDao(daoMap.get("mymenuDAO"));
		serviceMap.get("mymenuOptionAddServiceImpl").setDao(daoMap.get("mymenuDAO"));
		serviceMap.get("mymenuOptionViewServiceImpl").setDao(daoMap.get("mymenuDAO"));
		serviceMap.get("mymenuNoListServiceImpl").setDao(daoMap.get("mymenuDAO"));
		
		// 상품관리 조립
		serviceMap.get("goodsListServiceImpl").setDao(daoMap.get("goodsDAO"));
		serviceMap.get("goodsViewServiceImpl").setDao(daoMap.get("goodsDAO"));
		serviceMap.get("goodsWriteServiceImpl").setDao(daoMap.get("goodsDAO"));
		serviceMap.get("goodsUpdateServiceImpl").setDao(daoMap.get("goodsDAO"));
		serviceMap.get("goodsUpdateImgServiceImpl").setDao(daoMap.get("goodsDAO"));
		serviceMap.get("goodsDeleteServiceImpl").setDao(daoMap.get("goodsDAO"));	
		
		// 주문관리 조립
		serviceMap.get("orderListServiceImpl").setDao(daoMap.get("orderDAO"));
		serviceMap.get("orderPerListServiceImpl").setDao(daoMap.get("orderDAO"));
		serviceMap.get("orderViewServiceImpl").setDao(daoMap.get("orderDAO"));
		serviceMap.get("orderWriteServiceImpl").setDao(daoMap.get("orderDAO"));
		serviceMap.get("orderUpdateServiceImpl").setDao(daoMap.get("orderDAO"));
		serviceMap.get("orderDeleteServiceImpl").setDao(daoMap.get("orderDAO"));	
		serviceMap.get("orderOptionAddServiceImpl").setDao(daoMap.get("orderDAO"));	
		serviceMap.get("orderOptionViewServiceImpl").setDao(daoMap.get("orderDAO"));	
		serviceMap.get("orderOpDetailViewServiceImpl").setDao(daoMap.get("orderDAO"));	
		serviceMap.get("orderCartListServiceImpl").setDao(daoMap.get("orderDAO"));	
		serviceMap.get("orderMmListServiceImpl").setDao(daoMap.get("orderDAO"));	
		serviceMap.get("orderCartDeleteServiceImpl").setDao(daoMap.get("orderDAO"));	
		serviceMap.get("orderStockServiceImpl").setDao(daoMap.get("orderDAO"));	
		
		// service -> controller : 조립
		// 메인
		((MainController)(controllerMap.get("mainController"))).setNoticeListService(serviceMap.get("noticeListServiceImpl"));
		((MainController)(controllerMap.get("mainController"))).setEventListService(serviceMap.get("eventListServiceImpl"));
		((MainController)(controllerMap.get("mainController"))).setGoodsListService(serviceMap.get("goodsListServiceImpl"));
		
		// 공지사항
		((NoticeController)(controllerMap.get("noticeController"))).setNoticeListService(serviceMap.get("noticeListServiceImpl"));
		((NoticeController)(controllerMap.get("noticeController"))).setNoticeReservedListService(serviceMap.get("noticeReservedListServiceImpl"));
		((NoticeController)(controllerMap.get("noticeController"))).setNoticeLastListService(serviceMap.get("noticeLastListServiceImpl"));
		((NoticeController)(controllerMap.get("noticeController"))).setNoticeCurrentListService(serviceMap.get("noticeCurrentListServiceImpl"));
		((NoticeController)(controllerMap.get("noticeController"))).setNoticeViewService(serviceMap.get("noticeViewServiceImpl"));
		((NoticeController)(controllerMap.get("noticeController"))).setNoticeWriteService(serviceMap.get("noticeWriteServiceImpl"));
		((NoticeController)(controllerMap.get("noticeController"))).setNoticeUpdateService(serviceMap.get("noticeUpdateServiceImpl"));
		((NoticeController)(controllerMap.get("noticeController"))).setNoticeDeleteService(serviceMap.get("noticeDeleteServiceImpl"));		
		
		// 이벤트
		((EventController)(controllerMap.get("eventController"))).setEventListService(serviceMap.get("eventListServiceImpl"));
		((EventController)(controllerMap.get("eventController"))).setEventReservedListService(serviceMap.get("eventReservedListServiceImpl"));
		((EventController)(controllerMap.get("eventController"))).setEventLastListService(serviceMap.get("eventLastListServiceImpl"));
		((EventController)(controllerMap.get("eventController"))).setEventCurrentListService(serviceMap.get("eventCurrentListServiceImpl"));
		((EventController)(controllerMap.get("eventController"))).setEventViewService(serviceMap.get("eventViewServiceImpl"));
		((EventController)(controllerMap.get("eventController"))).setEventWriteService(serviceMap.get("eventWriteServiceImpl"));
		((EventController)(controllerMap.get("eventController"))).setEventUpdateService(serviceMap.get("eventUpdateServiceImpl"));
		((EventController)(controllerMap.get("eventController"))).setEventDeleteService(serviceMap.get("eventDeleteServiceImpl"));		
		((EventController)(controllerMap.get("eventController"))).setEventApplyListService(serviceMap.get("eventApplyListServiceImpl"));
		((EventController)(controllerMap.get("eventController"))).setEventApplyWriteService(serviceMap.get("eventApplyWriteServiceImpl"));
		((EventController)(controllerMap.get("eventController"))).setEventApplyUpdateService(serviceMap.get("eventApplyUpdateServiceImpl"));
		((EventController)(controllerMap.get("eventController"))).setEventUserApplyListService(serviceMap.get("eventUserApplyListServiceImpl"));
	
		// 회원관리
		((MemberController)(controllerMap.get("memberController"))).setMemberLoginService(serviceMap.get("memberLoginServiceImpl"));
		((MemberController)(controllerMap.get("memberController"))).setMemberWriteService(serviceMap.get("memberWriteServiceImpl"));
		((MemberController)(controllerMap.get("memberController"))).setMemberListService(serviceMap.get("memberListServiceImpl"));
		((MemberController)(controllerMap.get("memberController"))).setMemberViewService(serviceMap.get("memberViewServiceImpl"));
		((MemberController)(controllerMap.get("memberController"))).setMemberCheckIdService(serviceMap.get("memberCheckIdServiceImpl"));
		((MemberController)(controllerMap.get("memberController"))).setMemberFindIdService(serviceMap.get("memberFindIdServiceImpl"));
		((MemberController)(controllerMap.get("memberController"))).setMemberFindPwService(serviceMap.get("memberFindPwServiceImpl"));
		((MemberController)(controllerMap.get("memberController"))).setMemberChangePwService(serviceMap.get("memberChangePwServiceImpl"));
		((MemberController)(controllerMap.get("memberController"))).setMemberChangePwNowService(serviceMap.get("memberChangePwNowServiceImpl"));
		((MemberController)(controllerMap.get("memberController"))).setMemberChangeStatusService(serviceMap.get("memberChangeStatusServiceImpl"));
		((MemberController)(controllerMap.get("memberController"))).setMemberChangeGradeNoService(serviceMap.get("memberChangeGradeNoServiceImpl"));
		((MemberController)(controllerMap.get("memberController"))).setMemberCheckPwService(serviceMap.get("memberCheckPwServiceImpl"));
		((MemberController)(controllerMap.get("memberController"))).setMemberUpdateService(serviceMap.get("memberUpdateServiceImpl"));
		((MemberController)(controllerMap.get("memberController"))).setMemberDeleteService(serviceMap.get("memberDeleteServiceImpl"));
		((MemberController)(controllerMap.get("memberController"))).setMemberWakeUpService(serviceMap.get("memberWakeUpServiceImpl"));
		mst.setMemberSleepService(serviceMap.get("memberSleepServiceImpl"));
		
		// 장바구니
		((CartController)(controllerMap.get("cartController"))).setCartListService(serviceMap.get("cartListServiceImpl"));
		((CartController)(controllerMap.get("cartController"))).setCartViewService(serviceMap.get("cartViewServiceImpl"));
		((CartController)(controllerMap.get("cartController"))).setCartAddService(serviceMap.get("cartAddServiceImpl"));
		((CartController)(controllerMap.get("cartController"))).setCartUpdateService(serviceMap.get("cartUpdateServiceImpl"));
		((CartController)(controllerMap.get("cartController"))).setCartDeleteService(serviceMap.get("cartDeleteServiceImpl"));
		((CartController)(controllerMap.get("cartController"))).setCartAllDeleteService(serviceMap.get("cartAllDeleteServiceImpl"));
		((CartController)(controllerMap.get("cartController"))).setCartOptionAddService(serviceMap.get("cartOptionAddServiceImpl"));
		((CartController)(controllerMap.get("cartController"))).setCartOptionViewService(serviceMap.get("cartOptionViewServiceImpl"));
		((CartController)(controllerMap.get("cartController"))).setCartNoListService(serviceMap.get("cartNoListServiceImpl"));
		((CartController)(controllerMap.get("cartController"))).setCartmmNoService(serviceMap.get("cartmmNoServiceImpl"));
		
		// 나만의 메뉴
		((MyMenuController)(controllerMap.get("mymenuController"))).setMyMenuListService(serviceMap.get("mymenuListServiceImpl"));
		((MyMenuController)(controllerMap.get("mymenuController"))).setMyMenuViewService(serviceMap.get("mymenuViewServiceImpl"));
		((MyMenuController)(controllerMap.get("mymenuController"))).setMyMenuAddService(serviceMap.get("mymenuAddServiceImpl"));
		((MyMenuController)(controllerMap.get("mymenuController"))).setMyMenuUpdateService(serviceMap.get("mymenuUpdateServiceImpl"));
		((MyMenuController)(controllerMap.get("mymenuController"))).setMyMenuDeleteService(serviceMap.get("mymenuDeleteServiceImpl"));
		((MyMenuController)(controllerMap.get("mymenuController"))).setMyMenuAllDeleteService(serviceMap.get("mymenuAllDeleteServiceImpl"));
		((MyMenuController)(controllerMap.get("mymenuController"))).setMyMenuOptionAddService(serviceMap.get("mymenuOptionAddServiceImpl"));
		((MyMenuController)(controllerMap.get("mymenuController"))).setMyMenuOptionViewService(serviceMap.get("mymenuOptionViewServiceImpl"));
		((MyMenuController)(controllerMap.get("mymenuController"))).setMyMenuNoListService(serviceMap.get("mymenuNoListServiceImpl"));
		
		// 상품관리
		((GoodsController)(controllerMap.get("goodsController"))).setGoodsListService(serviceMap.get("goodsListServiceImpl"));
		((GoodsController)(controllerMap.get("goodsController"))).setGoodsViewService(serviceMap.get("goodsViewServiceImpl"));
		((GoodsController)(controllerMap.get("goodsController"))).setGoodsWriteService(serviceMap.get("goodsWriteServiceImpl"));
		((GoodsController)(controllerMap.get("goodsController"))).setGoodsUpdateService(serviceMap.get("goodsUpdateServiceImpl"));
		((GoodsController)(controllerMap.get("goodsController"))).setGoodsUpdateImgService(serviceMap.get("goodsUpdateImgServiceImpl"));
		((GoodsController)(controllerMap.get("goodsController"))).setGoodsDeleteService(serviceMap.get("goodsDeleteServiceImpl"));
		
		// 주문관리
		((OrderController)(controllerMap.get("orderController"))).setOrderListService(serviceMap.get("orderListServiceImpl"));
		((OrderController)(controllerMap.get("orderController"))).setOrderPerListService(serviceMap.get("orderPerListServiceImpl"));
		((OrderController)(controllerMap.get("orderController"))).setOrderViewService(serviceMap.get("orderViewServiceImpl"));
		((OrderController)(controllerMap.get("orderController"))).setOrderWriteService(serviceMap.get("orderWriteServiceImpl"));
		((OrderController)(controllerMap.get("orderController"))).setOrderUpdateService(serviceMap.get("orderUpdateServiceImpl"));
		((OrderController)(controllerMap.get("orderController"))).setOrderDeleteService(serviceMap.get("orderDeleteServiceImpl"));		
		((OrderController)(controllerMap.get("orderController"))).setGoodsViewService(serviceMap.get("goodsViewServiceImpl"));		
		((OrderController)(controllerMap.get("orderController"))).setOrderOptionAddService(serviceMap.get("orderOptionAddServiceImpl"));		
		((OrderController)(controllerMap.get("orderController"))).setOrderOptionViewService(serviceMap.get("orderOptionViewServiceImpl"));		
		((OrderController)(controllerMap.get("orderController"))).setOrderOpDetailViewService(serviceMap.get("orderOpDetailViewServiceImpl"));		
		((OrderController)(controllerMap.get("orderController"))).setOrderCartListService(serviceMap.get("orderCartListServiceImpl"));		
		((OrderController)(controllerMap.get("orderController"))).setOrderMmListService(serviceMap.get("orderMmListServiceImpl"));		
		((OrderController)(controllerMap.get("orderController"))).setOrderCartDeleteService(serviceMap.get("orderCartDeleteServiceImpl"));		
		((OrderController)(controllerMap.get("orderController"))).setOrderStockService(serviceMap.get("orderStockServiceImpl"));		
	}
	
	// controller 꺼내가기 - 변수가 private이라서 직접 사용 할 수 없고 getter를 이용해서 꺼내간다.
	public static Object getController(String key) {
		return controllerMap.get(key);
	}
}
