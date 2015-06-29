package com.mw.java8.c7;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

import static com.mw.java8.c7.SumTest.measureSumPerf;

public class ForkJoinSumCalculator extends java.util.concurrent.RecursiveTask<Long>
{
    private final long[] numbers;
    private final int start;
    private final int end;

    private static final long THRESHOLD = 10_000;

    public ForkJoinSumCalculator(long[] numbers)
    {
        this(numbers, 0, numbers.length);
    }

    public ForkJoinSumCalculator(long[] numbers, int start, int end)
    {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute()
    {
        int length = end - start;
        if (length <= THRESHOLD)
        {
            return computeSequentially();
        }

        ForkJoinSumCalculator leftTask = new ForkJoinSumCalculator(numbers, start, start + length / 2);
        leftTask.fork();
        ForkJoinSumCalculator rightTask = new ForkJoinSumCalculator(numbers, start + length / 2, end);
        Long rightResult = rightTask.compute();
        Long leftResult = leftTask.join();
        return leftResult + rightResult;
    }

    private Long computeSequentially()
    {
        long sum = 0;
        for (int i = 0; i < end; i++)
        {
            sum += numbers[i];
        }
        return sum;
    }

    public static long forkJoinSum(long n)
    {
        long[] numbers = LongStream.rangeClosed(1, n).toArray();
        ForkJoinTask<Long> task = new ForkJoinSumCalculator(numbers);
        return new ForkJoinPool().invoke(task);
    }

    public static void main(String[] args)
    {
        System.out.println("ForkJoin sum done in: " + measureSumPerf(ForkJoinSumCalculator::forkJoinSum, 10_000_000) + " msecs" );
    }
}
