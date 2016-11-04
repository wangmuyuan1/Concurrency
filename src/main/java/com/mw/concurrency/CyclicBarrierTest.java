package com.mw.concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest
{

    public static void main(String[] args)
    {
        Runnable runnable1 = new Runnable()
        {
            public void run()
            {
                System.out.println("All Parties arrived. Barrier 1 released.");
            }
        };

        Runnable runnable2 = new Runnable()
        {
            public void run()
            {
                System.out.println("All Parties arrived. Runnable 2 executed.");
            }
        };

        CyclicBarrier barrier1 = new CyclicBarrier(2, runnable1); // When two threads await on this barrier, then execute the runnable.
        CyclicBarrier barrier2 = new CyclicBarrier(2, runnable2);

        CyclicBarrierRunnable workingThread1 = new CyclicBarrierRunnable(barrier1, barrier2);
        CyclicBarrierRunnable workingThread2 = new CyclicBarrierRunnable(barrier1, barrier2);

        new Thread(workingThread1).start();
        new Thread(workingThread2).start();
    }

    static class CyclicBarrierRunnable implements Runnable
    {
        private CyclicBarrier barrier1 = null;
        private CyclicBarrier barrier2 = null;

        public CyclicBarrierRunnable(CyclicBarrier barrier1, CyclicBarrier barrier2)
        {
            this.barrier1 = barrier1;
            this.barrier2 = barrier2;
        }

        public void run()
        {
            try
            {
                System.out.println(Thread.currentThread().getName() + " started running to barrier 1.");
                Thread.sleep(5000);
                System.out.println(Thread.currentThread().getName() + " waiting at barrier 1.");
                barrier1.await();

                System.out.println(Thread.currentThread().getName() + " started running to barrier 1.");
                Thread.sleep(5000);
                System.out.println(Thread.currentThread().getName() + " waiting at barrier 2.");
                barrier2.await();

                System.out.println(Thread.currentThread().getName() + " done.");
            }
            catch (BrokenBarrierException | InterruptedException e)
            {
                e.printStackTrace();  //TODO - remove
            }
        }
    }
}
