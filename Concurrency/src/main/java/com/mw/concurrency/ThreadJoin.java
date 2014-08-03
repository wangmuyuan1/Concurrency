package com.mw.concurrency;

public class ThreadJoin implements Runnable {
	
	private int id;
	
	public ThreadJoin(int id) {
		this.id = id;
	}
	
	public void run() {
		for (int i = 0; i < 10; i++) {
			System.out.println("Thread " + id + " printing " + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main (String[] args) {
		Thread t1 = new Thread(new ThreadJoin(1));
		Thread t2 = new Thread(new ThreadJoin(2));
		t1.start();
		
		// This will not change the execution of the threads.
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		try {
			t1.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		// t2 won't start until t1 finishes.
		t2.start();
	}
}
