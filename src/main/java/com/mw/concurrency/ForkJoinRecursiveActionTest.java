package com.mw.concurrency;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

// Can also use RecursiveTask here.
public class ForkJoinRecursiveActionTest extends RecursiveAction {
	
	private int start;
	private int end;
	
	public ForkJoinRecursiveActionTest(int start, int end) {
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
		invokeAll(new ForkJoinRecursiveActionTest(start, mid), new ForkJoinRecursiveActionTest(mid + 1, end));
	}

	
	public static void main(String[] args) {
		ForkJoinRecursiveActionTest task = new ForkJoinRecursiveActionTest(1, 10);
		ForkJoinPool pool = new ForkJoinPool();
		pool.invoke(task);
	}
}
