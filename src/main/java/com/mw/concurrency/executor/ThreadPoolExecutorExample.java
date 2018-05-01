package com.mw.concurrency.executor;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorExample
{
    public static void main(String[] args) throws InterruptedException
    {
//        ExecutorService executor = Executors.newCachedThreadPool();
//        Future<Integer> future = executor.submit(new Callable<Integer>()
//        {
//            @Override
//            public Integer call() throws Exception
//            {
//                System.out.println("Executing Task.");
//                TimeUnit.SECONDS.sleep(10);
//                return 10;
//            }
//        });
//
//        try
//        {
//            while (future.get() == null)
//            {
//                TimeUnit.SECONDS.sleep(5);
//            }
//
//            System.out.println("Result = " + future.get());
//        }
//        catch (InterruptedException | ExecutionException e)
//        {
//            e.printStackTrace();
//        }
//
//        executor.shutdown();

        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate(() -> System.out.println("Systen time mills " + System.currentTimeMillis()), 1, 5, TimeUnit.SECONDS);

        TimeUnit.SECONDS.sleep(20);
        executorService.shutdown();
        executorService.shutdownNow();

        TimeUnit.SECONDS.sleep(100000);
    }
}
