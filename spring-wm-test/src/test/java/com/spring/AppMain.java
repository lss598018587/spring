package com.spring;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AppMain {
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {

				Thread t2  = new Thread(new Runnable() {
					@Override
					public void run() {
						SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
						while (true){
							try {
								Thread.sleep(2000);
							} catch (InterruptedException e) {
								e.printStackTrace();
							}
							System.out.println("守护线程再跑："+dateFormat.format(new Date()));
						}
					}
				});
				t2.setDaemon(true);
				t2.start();

			}
		});
		t1.setDaemon(true);
		t1.start();
		Thread.sleep(10000);
	}
}
