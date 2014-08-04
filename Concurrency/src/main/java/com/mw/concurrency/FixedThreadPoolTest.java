package com.mw.concurrency;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class FixedThreadPoolTest implements Runnable {
	
	private int num;
	
	public FixedThreadPoolTest(int i) {
		num = i;
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Thread " + num + " i = " + i);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args) {
		Executor executor = Executors.newFixedThreadPool(4);
		executor.execute(new FixedThreadPoolTest(1));
		executor.execute(new FixedThreadPoolTest(2));
		executor.execute(new FixedThreadPoolTest(3));
		executor.execute(new FixedThreadPoolTest(4));
		// The fifth thread will not executed until the previous four threads finished.
		executor.execute(new FixedThreadPoolTest(5));
		
		// Programme will not exit since all threads created are non-daemon threads.
	}

}
