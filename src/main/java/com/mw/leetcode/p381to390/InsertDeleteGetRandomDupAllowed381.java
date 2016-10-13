package com.mw.leetcode.p381to390;

/**
 * Created by mwang on 13/10/2016.
 */
import java.util.*;

public class InsertDeleteGetRandomDupAllowed381
{
    List<Integer> array = new ArrayList<>();
    Map<Integer, Set<Integer>> map = new HashMap<>();
    Random random = new Random();

    /** Initialize your data structure here. */
    public InsertDeleteGetRandomDupAllowed381() {

    }

    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        array.add(val);
        int index = array.size();
        if (map.containsKey(val))
        {
            map.get(val).add(index); // add the latest index.
            return false;
        }
        else
        {
            Set<Integer> pos = new LinkedHashSet<>();
            pos.add(index);
            map.put(val, pos);
            return true;
        }
    }

    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val))
            return false;
        Set<Integer> pos = map.get(val);
        int loc = pos.iterator().next(); // find the loc of target val.
        int lastVal = array.get(array.size() - 1); // find last value.

        pos.remove(loc);

        if (loc <= array.size() - 1)
        {
            array.set(loc, lastVal);
        }
        array.remove(array.size() - 1);

        if (pos.isEmpty())
            map.remove(val);

        return true;
    }

    /** Get a random element from the collection. */
    public int getRandom() {
        int index = random.nextInt(array.size());
        return array.get(index);
    }

    public static void main(String[] args)
    {
        InsertDeleteGetRandomDupAllowed381 app = new InsertDeleteGetRandomDupAllowed381();
        app.insert(1);
        app.remove(2);
        app.insert(2);
        app.getRandom();
    }
}
