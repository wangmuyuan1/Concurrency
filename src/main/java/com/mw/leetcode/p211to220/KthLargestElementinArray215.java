package com.mw.leetcode.p211to220;

import java.util.PriorityQueue;

public class KthLargestElementinArray215
{
    public int findKthLargest(int[] nums, int k)
    {
        PriorityQueue<Integer> heap = new PriorityQueue<>(k);

        for (int num : nums)
        {
            if (heap.size() == k)
            {
                if (num > heap.peek())
                {
                    heap.poll(); // remove the smallest.
                    heap.add(num);
                }
            }
            else
            {
                heap.add(num);
            }
        }

        return heap.poll();
    }

    public static void main(String[] args)
    {
        int[] num = {2, 1};
        System.out.println(new KthLargestElementinArray215().findKthLargest(num, 1));
    }
}
