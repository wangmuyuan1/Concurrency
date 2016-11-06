package com.mw.concurrency;

import java.util.concurrent.Semaphore;

/**
 * Created by mwang on 04/11/2016.
 */
public class SemaphoreTest
{

    public static void main(String[] args)
    {
        Semaphore semaphore = new Semaphore(1);
        new Thread(new Producer(semaphore)).start();
        new Thread(new Consumer(semaphore)).start();
    }

    static class Producer implements Runnable
    {
        private Semaphore semaphore;

        public Producer(Semaphore semaphore)
        {
            this.semaphore = semaphore;
        }

        @Override
        public void run()
        {
            int i = 0;
            while (i < 100)
            {
                try
                {
                    semaphore.acquire();
                    System.out.println("produces product " + i);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                i++;
            }
        }
    }

    static class Consumer implements Runnable
    {
        private Semaphore semaphore;

        public Consumer(Semaphore semaphore)
        {
            this.semaphore = semaphore;
        }

        public void run()
        {

            int i = 0;
            while (i < 100)
            {
                if (semaphore.availablePermits() == 0)
                {
                    semaphore.release();

                    System.out.println("consumes product " + i);
                    i++;
                }
            }
        }
    }
}
