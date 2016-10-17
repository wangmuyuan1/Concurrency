package com.mw.leetcode.p381to390;

import com.mw.leetcode.ListNode;

import java.util.Random;

/**
 * Created by mwang on 14/10/2016.
 */
public class LinkedListRandomNode382
{
    class Solution
    {
        ListNode head = null;
        Random random = new Random();

        public Solution(ListNode head)
        {
            this.head = head;
        }

        /**
         * Returns a random node's value.
         */
        public int getRandom()
        {
            ListNode result = head;
            ListNode current = head;
            for (int n = 1; current != null; n++)
            {
                if (random.nextInt(n) == 0)
                {
                    result = current;
                }
                current = current.next;
            }
            return result.val;
        }
    }
}
