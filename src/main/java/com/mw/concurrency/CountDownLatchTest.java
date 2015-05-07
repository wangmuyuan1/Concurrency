package com.mw.concurrency;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchTest
{
    public static void main(String[] args)
    {
        CountDownLatch latch = new CountDownLatch(5);
        new Thread(new Consumer(latch)).start();
        new Thread(new Producer(latch)).start();
    }

    static class Consumer implements Runnable
    {
        private CountDownLatch latch;

        public Consumer(CountDownLatch latch)
        {
            this.latch = latch;
        }

        @Override
        public void run()
        {
            try
            {
                this.latch.await();
                System.out.println("Consumed all.");
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();  //TODO - remove
            }
        }
    }

    static class Producer implements Runnable
    {
        private CountDownLatch latch;

        public Producer(CountDownLatch latch)
        {
            this.latch = latch;
        }

        @Override
        public void run()
        {
            try
            {
                Thread.sleep(1000);
                System.out.println("Produced 1.");
                this.latch.countDown();

                Thread.sleep(1000);
                System.out.println("Produced 2.");
                this.latch.countDown();

                Thread.sleep(1000);
                System.out.println("Produced 3.");
                this.latch.countDown();

                Thread.sleep(1000);
                System.out.println("Produced 4.");
                this.latch.countDown();

                Thread.sleep(1000);
                System.out.println("Produced 5.");
                this.latch.countDown();
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();  //TODO - remove
            }
        }
    }
}
