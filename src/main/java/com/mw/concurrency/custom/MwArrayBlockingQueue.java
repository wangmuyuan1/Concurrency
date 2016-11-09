package com.mw.concurrency.custom;

import java.util.AbstractQueue;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * This is a custom Blocking Queue class.
 */
public class MwArrayBlockingQueue<E> extends AbstractQueue<E> implements BlockingQueue<E>
{
    // Need condition for not full.
    private final Object[] items;
    private Lock lock;
    private Condition notFull;
    private Condition notEmpty;
    private int count;

    public MwArrayBlockingQueue(int capacity)
    {
        items = new Object[capacity];
        this.lock = new ReentrantLock();
        this.notEmpty = lock.newCondition();
        this.notFull = lock.newCondition();
    }

    // Need condition for not empty.

    @Override
    // This requires custom iterator class.
    public Iterator<E> iterator()
    {
        return null;
    }

    @Override
    public int size()
    {
        lock.lock();
        try
        {
            return count;
        }
        finally
        {
            lock.unlock();
        }
    }

    @Override
    public void put(E e) throws InterruptedException
    {
        lock.lock();
        try
        {
            if (count == items.length)
            {
                notFull.await();
            }
            enqueue(e);
        }
        finally
        {
            lock.unlock();
        }
    }

    @Override
    // Non Blocking
    public boolean offer(E e, long timeout, TimeUnit unit) throws InterruptedException
    {
        long nanos = unit.toNanos(timeout);
        lock.lockInterruptibly();
        try
        {
            while (count == items.length)
            {
                if (nanos <= 0)
                    return false;
                nanos = notFull.awaitNanos(nanos);
            }
            enqueue(e);
        }
        finally
        {
            lock.unlock();
        }
        return false;
    }

    @Override
    public E take() throws InterruptedException
    {
        lock.lock();
        try
        {
            if (count == 0)
            {
                notEmpty.await();
            }
            return dequeue();
        }
        finally
        {
            lock.unlock();
        }
    }

    @Override
    public E poll(long timeout, TimeUnit unit) throws InterruptedException
    {
        long nanos = unit.toNanos(timeout);
        lock.lockInterruptibly();
        try
        {
            while (count == 0)
            {
                if (nanos <= 0)
                    return null;
                nanos = notEmpty.awaitNanos(nanos);
            }
            return dequeue();
        }
        finally
        {
            lock.unlock();
        }
    }

    @Override
    public int remainingCapacity()
    {
        lock.lock();
        try
        {
            return items.length - count;
        }
        finally
        {
            lock.unlock();
        }
    }

    @Override
    public int drainTo(Collection<? super E> c)
    {
        return 0;
    }

    @Override
    public int drainTo(Collection<? super E> c, int maxElements)
    {
        return 0;
    }

    @Override
    public boolean offer(E e)
    {
        lock.lock();
        try {
            if (count == items.length)
                return false;
            else {
                enqueue(e);
                return true;
            }
        } finally {
            lock.unlock();
        }
    }

    @Override
    public E poll()
    {
        lock.lock();
        try {
            if (count == 0)
                return null;
            else {
                return dequeue();
            }
        } finally {
            lock.unlock();
        }
    }

    @Override
    public E peek()
    {
        lock.lock();
        try {
            if (count == 0)
                return null;
            else {
                return (E)items[count];
            }
        } finally {
            lock.unlock();
        }
    }

    private void enqueue(E e)
    {
        items[count] = e;
        count++;
        notEmpty.signal();
    }

    private E dequeue()
    {
        E e = (E)items[count];
        items[count] = null;
        count--;
        notFull.signal();
        return e;
    }

    class Iter implements Iterator<E>
    {
        // last pointer.
        E last;

        // next pointer.
        E next;

        // current pointer.
        E cur;

        int counter;
        int max;

        Iter()
        {
            lock.lock();
            try
            {
                if (count > 0)
                {
                    Object[] clone = Arrays.copyOf(items, items.length); // create copy.
                    this.max = count; // Set counter.
                    cur = (E) items[0]; // first
                    counter = 1;
                    if (max > 1)
                    {
                        next = (E) items[1]; // next;
                        counter++;
                    }
                }
            }
            finally
            {
                lock.unlock();
            }
        }

        @Override
        public boolean hasNext()
        {
            if (next != null)
                return true;
            return false;
        }

        @Override
        public E next()
        {
            if (counter == max)
            {
                next = null; // no more node.
                return null;
            }
            else
            {
                cur = next;
                next = (E) items[counter + 1];
                return cur;
            }
        }
    }
}
