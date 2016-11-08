package com.mw.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ProducerConsumerLockCondition
{
    static class Producer implements Runnable
    {
        private int id;
        private volatile List<String> productQueue;
        private int threshold;
        private Lock lock;
        private Condition notFull;
        private Condition notEmpty;

        public Producer(int id, List<String> productQueue, int threshold, Lock lock, Condition notFull, Condition notEmpty)
        {
            this.id = id;
            this.threshold = threshold;
            this.productQueue = productQueue;
            this.lock = lock;
            this.notFull = notFull;
            this.notEmpty = notEmpty;
        }

        public void run()
        {
            while (true)
            {
                lock.lock();
                try
                {
                    while (productQueue.size() == threshold)
                    {
                        notFull.await();
                    }

                    String product = UUID.randomUUID().toString();
                    TimeUnit.SECONDS.sleep(2);
                    productQueue.add(product);
                    System.out.println("Producer " + id + " produced " + product);
                    notEmpty.signal();
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                finally
                {
                    lock.unlock();
                }
            }
        }
    }

    static class Consumer implements Runnable
    {
        private int id;
        private volatile List<String> productQueue;
        private int threshold;
        private Lock lock;
        private Condition notFull;
        private Condition notEmpty;

        public Consumer(int id, List<String> productQueue, int threshold, Lock lock, Condition notFull, Condition notEmpty)
        {
            this.id = id;
            this.threshold = threshold;
            this.productQueue = productQueue;
            this.lock = lock;
            this.notFull = notFull;
            this.notEmpty = notEmpty;
        }

        public void run()
        {
            while (true)
            {
                lock.lock();
                try
                {
                    while (productQueue.isEmpty())
                    {
                        notEmpty.await();
                    }
                    TimeUnit.SECONDS.sleep(2);
                    String product = productQueue.remove(productQueue.size() - 1);
                    System.out.println("Consumer " + id + " consumed " + product);
                    notFull.signal();
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                finally
                {
                    lock.unlock();
                }
            }
        }
    }

    public static void main(String[] args)
    {
        List<String> productQueue = new ArrayList<>(100);
        Lock lock = new ReentrantLock(true);
        Condition notFull = lock.newCondition();
        Condition notEmpty = lock.newCondition();

        for (int i = 1; i <= 3; i++)
        {
            new Thread(new Producer(i, productQueue, 10, lock, notFull, notEmpty)).start();
        }

        for (int i = 1; i <= 2; i++)
        {
            new Thread(new Consumer(i, productQueue, 10, lock,  notFull, notEmpty)).start();
        }
    }
}
