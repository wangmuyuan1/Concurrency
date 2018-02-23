package com.mw.leetcode.p731top740;

import java.util.ArrayList;
import java.util.List;

public class MyCalendarTwo
{
    private List<int[]> books = new ArrayList<>();
    public MyCalendarTwo() {

    }

    public boolean book(int start, int end) {

        // we need firstly to check if there is an existing overlap to the entries.
        MyCalendar overlaps = new MyCalendar();// we use second guard map.
        for (int[] book : books)
        {
            if (Math.max(book[0], start) < Math.min(book[1], end)) // overlap exists.
            {
                if (!overlaps.book(Math.max(book[0], start), Math.min(book[1], end))) return false; // overlaps overlapped
                // if the overlaps map doesnt have the entry but the main app have. then we allow.
            }
        }
        books.add(new int[]{start, end});
        return true;
    }

    private static class MyCalendar // we dont allow overlap in this case.
    {
        private List<int[]> books = new ArrayList<>(); // another calendar.
        public boolean book(int start, int end) {
            for (int[] b : books)
                if (Math.max(b[0], start) < Math.min(b[1], end)) return false;
            books.add(new int[]{ start, end });
            return true;
        }
    }
}
