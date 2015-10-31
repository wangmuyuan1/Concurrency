package com.mw.leetcode.p51to60;

import com.mw.leetcode.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals56
{
    public static List<Interval> merge(List<Interval> intervals)
    {
        List<Interval> result = new ArrayList<>();
        // sorting intervals.
        Collections.sort(intervals, new IntervalComparator());

        Interval prev = null;
        // for each, merge it with prevs
        for (Interval interval : intervals)
        {
            if (prev == null)
            {
                result.add(interval);
                prev = interval;
            }
            else
            {
                if (prev.end >= interval.start)
                {
                    if (prev.end < interval.end)
                    {
                        Interval temp = new Interval(prev.start, interval.end);
                        result.remove(result.size() - 1);
                        result.add(temp);
                        prev = temp;
                    }
                }
                else
                {
                    result.add(interval);
                    prev = interval;
                }
            }
        }
        return result;
    }

    static class IntervalComparator implements Comparator<Interval>
    {
        @Override
        public int compare(Interval o1, Interval o2)
        {
            return o1.start - o2.start;
        }
    }

    public static void main(String[] args)
    {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 3));
        intervals.add(new Interval(2, 6));
        intervals.add(new Interval(8, 10));
        intervals.add(new Interval(15, 18));

        for (Interval interval : merge(intervals))
        {
            System.out.println(interval.start + ", " + interval.end);
        }
    }
}
