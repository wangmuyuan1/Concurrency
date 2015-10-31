package com.mw.leetcode.p51to60;

import com.mw.leetcode.Interval;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval57
{
    public static List<Interval> insert(List<Interval> intervals, Interval newInterval)
    {
        List<Interval> result = new ArrayList<>();


        for (Interval interval : intervals)
        {
            if (interval.end < newInterval.start) // if interval before new Interval, we add it.
            {
                result.add(interval);
            }
            else if (interval.start > newInterval.end) // if interval after new Interval, we add the new interval, and try to insert the interval. in reality, we can add rest of the intervals.
            {
                result.add(newInterval);
                newInterval = interval;
            }
            else if (interval.start <= newInterval.end || interval.end >= newInterval.start) // if it overlaps with current interval, we merge it into new newInterval, if the later still overlaps then we merge,
                                                                                             // until we find a interval is behind newInterval, we can insert this long interval.
            {
                newInterval = new Interval(Math.min(interval.start, newInterval.start), Math.max(newInterval.end, interval.end));
            }
        }
        result.add(newInterval);
        return result;
    }

    public static void main(String[] args)
    {

    }
}
