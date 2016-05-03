package com.mw.leetcode.p341to350;

import com.mw.ProjectUtil;

import java.util.*;

/**
 * Created by mwang on 02/05/2016.
 */
public class TopKFrequentElements347
{


    public List<Integer> topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator()
        {
            @Override
            public int compare(Object o1, Object o2)
            {
                return map.getOrDefault(o2, 0) - map.getOrDefault(o1, 0);
            }
        });


        List<Integer> result = new ArrayList<>();
        for (int num : nums)
            map.put(num, map.getOrDefault(num, 0) + 1);

        for (Map.Entry<Integer, Integer> entry : map.entrySet())
            heap.offer(entry.getKey());

        for (int i = 0; i < k; i++)
        {
            result.add(heap.poll());
        }
        return result;
    }

    public static void main(String[] args)
    {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        TopKFrequentElements347 app = new TopKFrequentElements347();
        ProjectUtil.printList(app.topKFrequent(nums, k));
    }
}
