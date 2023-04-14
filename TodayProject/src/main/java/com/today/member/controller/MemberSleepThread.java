package com.today.member.controller;

import java.sql.Date;
import java.util.Calendar;

import com.today.main.Execute;
import com.today.main.ServiceInterface;

public class MemberSleepThread  extends Thread {
//		new Thread(new MemberSleepThread()).start();

	private ServiceInterface memberSleepService;

	public void setMemberSleepService(ServiceInterface memberSleepService) {
		this.memberSleepService = memberSleepService;
	}
	
	@Override
	public void run() {
		while (true) {
			try {
				System.out.println("스레드실행");
				Calendar cal = Calendar.getInstance();
				cal.add(Calendar.DATE, -1);
				Date date = new Date(cal.getTimeInMillis());
				Execute.run(memberSleepService, date);
				Thread.sleep(1000 * 30 * 1);
			} catch (Exception e) {
				e.printStackTrace();
				try {
					Thread.sleep(1000 * 30 * 1);
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
//					interrupt();
				}
			}
		}
	}
}
