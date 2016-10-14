package com.mw.leetcode.p351to360;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

/**
 * Created by mwang on 14/10/2016.
 */
public class SummaryRanges352
{
    TreeMap<Integer, Interval> map = new TreeMap<>();

    /** Initialize your data structure here. */
    public SummaryRanges352()
    {

    }

    public void addNum(int val)
    {
        if (map.containsKey(val))
            return;
        Integer ceil = map.ceilingKey(val);
        Integer floor = map.floorKey(val);

        if (ceil != null && floor != null)
        {
            Interval floorInterval = map.get(floor);
            if (floorInterval.end >= val)
                return;
            if (floorInterval.end == val - 1)
            {
                // merge floor
                floorInterval.end++;
            }
            if (ceil == val + 1)
            {
                // merge ceil
                // is floor now connected with ceil?
                Interval interval;
                if (floorInterval.end == val)
                {
                    interval = floorInterval;
                }
                else
                {
                    interval = newInterval(val);
                }
                interval.end = map.get(ceil).end;
                map.remove(ceil);
            }

            if (floorInterval.end < val - 1 && ceil > val + 1)
            {
                newInterval(val);
            }
        }
        else if (ceil != null)
        {
            Interval ceilInterval = map.get(ceil);
            if (ceil == val + 1)
            {
                // merge floor
                Interval interval = new Interval();
                interval.start = val;
                interval.end = ceilInterval.end;
                map.put(val, interval);
                map.remove(ceil);
            }
            else
            {
                newInterval(val);
            }
        }
        else if (floor != null)
        {
            Interval floorInterval = map.get(floor);
            if (floorInterval.end >= val)
                return;
            if (floorInterval.end == val - 1)
            {
                // merge floor
                floorInterval.end++;
            }
            else
            {
                newInterval(val);
            }
        }
        else
        {
            newInterval(val);
        }
    }

    private Interval newInterval(int val)
    {
        Interval interval = new Interval();
        interval.start = val;
        interval.end = val;
        map.put(val, interval);
        return interval;
    }

    public List<Interval> getIntervals()
    {
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args)
    {
        SummaryRanges352 app = new SummaryRanges352();
        app.addNum(6);
        app.addNum(6);
        app.addNum(0);
        app.addNum(4);
        print(app);
        /*
        app.addNum(8);
        app.addNum(7);
        app.addNum(6);
        app.addNum(4);
        app.addNum(7);
        app.addNum(5);*/

        print(app);
    }

    private static void print(SummaryRanges352 app)
    {
        for (Interval interval : app.getIntervals())
        {
            System.out.println("[" + interval.start + "," + interval.end + "]");
        }
    }

    class Interval {
        int start;
        int end;
         Interval() { start = 0; end = 0; }
         Interval(int s, int e) { start = s; end = e; }
    }
}

