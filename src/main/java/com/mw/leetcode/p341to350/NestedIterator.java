package com.mw.leetcode.p341to350;

import java.util.*;

/**
 * Created by mwang on 25/04/2016.
 */
public class NestedIterator implements Iterator<Integer>
{
    Stack<ListIterator<NestedInteger>> stack = new Stack<>();
    public NestedIterator(List<NestedInteger> nestedList)
    {
        stack.push(nestedList.listIterator());
    }

    @Override
    public Integer next()
    {
        hasNext();
        return stack.peek().next().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!stack.empty()) {
            if (!stack.peek().hasNext()) {
                stack.pop();
            } else {
                NestedInteger x = stack.peek().next();
                if (x.isInteger())
                    return stack.peek().previous() == x;
                stack.push(x.getList().listIterator());
            }
        }
        return false;
    }

    public static void main(String args[])
    {
        //[[1,1],2,[1,1]]
        List<NestedInteger> subChild = new ArrayList<>();
        subChild.add(new NestedIntegerImpl(1, null));
        subChild.add(new NestedIntegerImpl(1, null));

        List<NestedInteger> subChild2 = new ArrayList<>();
        subChild2.add(new NestedIntegerImpl(1, null));
        subChild2.add(new NestedIntegerImpl(1, null));

        List<NestedInteger> main = new ArrayList<>();
        main.add(new NestedIntegerImpl(null, subChild));
        main.add(new NestedIntegerImpl(2, null));
        main.add(new NestedIntegerImpl(null, subChild2));

        NestedIterator iter = new NestedIterator(main);

        while(iter.hasNext())
        {
            System.out.print(iter.next() + ",");
        }
    }
}

interface NestedInteger {
        // @return true if this NestedInteger holds a single integer, rather than a nested list.
        boolean isInteger();

        // @return the single integer that this NestedInteger holds, if it holds a single integer
        // Return null if this NestedInteger holds a nested list
        Integer getInteger();

        // @return the nested list that this NestedInteger holds, if it holds a nested list
        // Return null if this NestedInteger holds a single integer
        List<NestedInteger> getList();
}

class NestedIntegerImpl implements NestedInteger
{
    Integer intVal;
    List<NestedInteger> listVal;

    public NestedIntegerImpl(Integer intVal, List<NestedInteger> listVal)
    {
        this.intVal = intVal;
        this.listVal = listVal;
    }

    @Override
    public boolean isInteger()
    {
        return listVal == null;
    }

    @Override
    public Integer getInteger()
    {
        return intVal;
    }

    @Override
    public List<NestedInteger> getList()
    {
        return listVal;
    }
}
