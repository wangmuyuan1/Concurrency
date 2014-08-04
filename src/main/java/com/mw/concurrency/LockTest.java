package com.mw.concurrency;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {

	static class Counter {

		private static int count = 0;
		private static final Lock lock = new ReentrantLock();
		private int num;
		
		public Counter(int i) {
			num = i;
		}

		public void add() {
			try {
				// Blocking mode of the lock.
				System.out.println("Thread " + num + " Add Method Aquiring Lock...");
				lock.lock();
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				count++;
				System.out.println("Thread " + num + " Add Method Releasing Lock... count = " + count);
			} finally {
				lock.unlock();
			}
		}
		
		public void delete() {
			boolean ok = false;
			try {
				// Non-blocking mode of the lock.
				System.out.println("Thread " + num + " Delete Method Aquiring Lock...");
				do {
					ok = lock.tryLock();
				} while (!ok);
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				count--;
				System.out.println("Thread " + num + " Delete Method Releasing Lock... count = " + count);
			} finally {
				if (ok) {
					lock.unlock();
				}
			}
		}
	}
	
	static class RunningThread implements Runnable {

		private Counter counter;
		private int num;
		
		public RunningThread(int i) {
			counter = new Counter(i);
			num = i;
		}
		
		public void run() {
			if (num == 1) {
				for (int i = 0; i < 10; i++) {
					counter.add();
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			} else {
				for (int i = 0; i < 10; i++) {
					counter.delete();
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		Thread t1 = new Thread(new RunningThread(1));
		Thread t2 = new Thread(new RunningThread(2));
		t1.start();
		t2.start();
	}
}
