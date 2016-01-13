package com.mw.leetcode.p291to300;

import java.util.Comparator;
import java.util.PriorityQueue;

public class FindMedianfromDataStream295
{
    // two heap min and max
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>(new Comparator<Integer>()
    {
        @Override
        public int compare(Integer o1, Integer o2)
        {
            return o2 - o1;
        }
    });
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>();

    // Adds a number into the data structure.
    public void addNum(int num) {

        if (minHeap.size() < maxHeap.size())
        {
            // if min heap is not
            if (!maxHeap.isEmpty() && num > maxHeap.peek()) // add to maxHeap
            {
                minHeap.offer(maxHeap.poll());
                maxHeap.offer(num);
            }
            else
            {
                minHeap.offer(num);
            }
        }
        else
        {
            if (!minHeap.isEmpty() && num < minHeap.peek()) // add to maxHeap
            {
                maxHeap.offer(minHeap.poll());
                minHeap.offer(num);
            }
            else
            {
                maxHeap.offer(num);
            }
        }
    }

    // Returns the median of current data stream
    public double findMedian()
    {
        if (minHeap.size() == maxHeap.size())
            return (minHeap.peek().doubleValue() + maxHeap.peek().doubleValue()) / 2;
        else
            return maxHeap.peek().doubleValue();
    }

    public static void main(String[] args)
    {
        FindMedianfromDataStream295 app = new FindMedianfromDataStream295();
        app.addNum(2);
        System.out.println(app.findMedian());
        app.addNum(3);
        System.out.println(app.findMedian());
    }
}
