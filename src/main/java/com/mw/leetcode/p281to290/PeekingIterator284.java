package com.mw.leetcode.p281to290;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Created by mwang on 29/04/2016.
 */
public class PeekingIterator284
{
    public static void main(String[] args)
    {
        PeekingIterator app = new PeekingIterator(Arrays.asList(1, 2, 3, 4).iterator());
        while (app.hasNext())
        {
            System.out.println(app.peek());
            System.out.println(app.next());
        }
    }
}

class PeekingIterator implements Iterator<Integer>
{
    private Integer next = null;
    private Iterator<Integer> iterator;

    public PeekingIterator(Iterator<Integer> iterator) {
        if (iterator.hasNext())
            next = iterator.next();
        this.iterator = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        return next;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        Integer result = next;
        if (iterator.hasNext())
            next = iterator.next();
        else
            next = null;
        return result;
    }

    @Override
    public boolean hasNext() {
        return next != null;
    }
}
