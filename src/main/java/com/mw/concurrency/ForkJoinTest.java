package com.mw.concurrency;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class ForkJoinTest extends RecursiveAction {
	
	private int start;
	private int end;
	
	public ForkJoinTest(int start, int end) {
		this.start = start;
		this.end = end;
	}

	@Override
	protected void compute() {
		
		if (this.start >= this.end - 1) {
			System.out.println("start = " + start + " end = " + end);
			return;
		}
		
		int mid = (start + end) / 2;
		System.out.println("Splitted into start = " + start + " mid = " + mid + " end = " + end);
		invokeAll(new ForkJoinTest(start, mid), new ForkJoinTest(mid + 1, end));
	}

	
	public static void main(String[] args) {
		ForkJoinTest test = new ForkJoinTest(1, 10);
		ForkJoinPool pool = new ForkJoinPool();
		pool.invoke(test);
	}
}
