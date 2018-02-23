package com.mw.leetcode.p721top730;

import java.util.TreeMap;

public class MyCalendar
{
    TreeMap<Integer, Integer> map = new TreeMap<>();

    public MyCalendar() {

    }

    public boolean book(int start, int end) {
        /**
         * we have three cases that need reject.
         * for given [a, b]
         *     [a, start, b, end]
         *     [a, start, end, b] -> a < start && b > start
         *
         *     [start, a, end, b] -> a > start && a < end
         *     [start, a, b, end]
         */

        Integer a = map.floorKey(start);
        if (a != null && map.get(a) > start)
            return false;

        a = map.ceilingKey(start);
        if (a != null && a < end)
            return false;

        map.put(start, end);
        return true;
    }

    public static void main(String[] args)
    {
        MyCalendar app = new MyCalendar();
        System.out.println(app.book(10, 20));
        System.out.println(app.book(15, 25));
        System.out.println(app.book(20, 30));
    }
}
