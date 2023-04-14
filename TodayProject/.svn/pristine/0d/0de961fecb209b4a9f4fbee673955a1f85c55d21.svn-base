package com.today.main;

public class Execute {
	// 서비스 실행 메서드
	public static Object run(ServiceInterface service, Object obj) throws Exception {
		Object result = null;
		long start = System.currentTimeMillis();
		System.out.println("------------------------------------");
		System.out.println(" * 실행 객체 : " + service.getClass().getSimpleName());
		System.out.println(" * 넘어가는 데이터 : " + obj);
		result = service.service(obj);
		System.out.println(" * 결과 데이터 : " + result);
		long end = System.currentTimeMillis();
		System.out.println(" * 처리 시간 : " + ((end-start)/1000) + "초");
		System.out.println("------------------------------------");
		return result;
	}
}
