package com.mw.concurrency.executor;

import java.util.concurrent.*;

public class ThreadPoolExecutorExample
{
    public static void main(String[] args)
    {
        ExecutorService executor = Executors.newCachedThreadPool();
        Future<Integer> future = executor.submit(new Callable<Integer>()
        {
            @Override
            public Integer call() throws Exception
            {
                System.out.println("Executing Task.");
                TimeUnit.SECONDS.sleep(10);
                return 10;
            }
        });

        try
        {
            while (future.get() == null)
            {
                TimeUnit.SECONDS.sleep(5);
            }

            System.out.println("Result = " + future.get());
        }
        catch (InterruptedException | ExecutionException e)
        {
            e.printStackTrace();
        }

        executor.shutdown();
    }
}
