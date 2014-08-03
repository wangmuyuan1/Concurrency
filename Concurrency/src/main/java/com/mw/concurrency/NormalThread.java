package com.mw.concurrency;

public class NormalThread implements Runnable {
	
	private int id;
	
	public NormalThread(int id) {
		this.id = id;
	}
	
	public void run() {
		for (int i = 0; i < 1000000; i++) {
			System.out.println("Thread " + id + " printing " + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void main (String[] args) {
		Thread t1 = new Thread(new NormalThread(1));
		Thread t2 = new Thread(new NormalThread(2));
		t1.start();
		t2.start();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
