package com.mw.leetcode.p781to790;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthSmallestPrimeFraction
{
    public int[] kthSmallestPrimeFraction(int[] A, int K) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(K, new Comparator<int[]>()
        {
            @Override
            public int compare(int[] o1, int[] o2)
            {
                int r1 = o1[0] * o2[1];
                int r2 = o2[0] * o1[1];
                return r2 - r1;
            }
        });

        for (int i = 0; i < A.length; i++)
        {
            for (int j = 0; j < i; j++)
            {
                if (queue.size() < K)
                {
                    queue.offer(new int[]{A[j], A[i]});
                    continue;
                }
                int[] max = queue.peek();
                if ((double)A[j] / A[i] < (double)max[0] / max[1])
                {
                    queue.poll();
                    queue.offer(new int[]{A[j], A[i]});
                }
            }
        }

        return queue.peek();
    }

    public static void main(String[] args)
    {
        int[] A = {1, 2, 5, 7};
        KthSmallestPrimeFraction app = new KthSmallestPrimeFraction();
        int[] res = app.kthSmallestPrimeFraction(A, 2);
        System.out.println(res[0] + "/" + res[1]);
    }
}
