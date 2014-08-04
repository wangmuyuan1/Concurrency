package com.mw.concurrency;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinRecursiveTask extends RecursiveTask<Integer> {
	final int n;

	ForkJoinRecursiveTask(int n) {
		this.n = n;
	}

	protected Integer compute() {
		if (n <= 1)
			return n;
		ForkJoinRecursiveTask f1 = new ForkJoinRecursiveTask(n - 1);
		f1.fork();
		ForkJoinRecursiveTask f2 = new ForkJoinRecursiveTask(n - 2);
		return f2.compute() + f1.join();
	}
	
	public static void main(String[] args) {
		ForkJoinRecursiveTask task = new ForkJoinRecursiveTask(10);
		ForkJoinPool pool = new ForkJoinPool();
		int result = pool.invoke(task);
		System.out.println(result);
	}
}
