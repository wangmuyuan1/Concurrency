package com.mw.leetcode.p21top30;

import java.util.*;

public class MergeKSortedList23
{
    public ListNode mergeKListsMininumHeap(ListNode[] lists)
    {
        List<ListNode> allList = new ArrayList<>();
                Collections.addAll(allList, lists);

        // Min Heap The heap will minimize the search time.
        Queue<ListNode> heap = new PriorityQueue<>(10, new Comparator<ListNode>()
        {
            @Override
            public int compare(ListNode n1, ListNode n2)
            {
                return n1.val-n2.val;
            }
        });

        for (ListNode node : allList) // Insert all element into heap.
        {
            if (node != null)
            {
                heap.offer(node);
            }
        }

        ListNode head = new ListNode(0);
        ListNode dummy = head;
        while (heap.size() > 0)
        {
            ListNode cur = heap.poll();
            head.next = cur;
            head = head.next;

            // Put the next value from the picked list node into heap
            if (cur.next!=null)
                heap.offer(cur.next);
        }
        return dummy.next;
    }

    public ListNode mergeKLists(ListNode[] lists)
    {
        if (lists.length == 0)
            return null;
        if (lists.length == 1)
            return lists[0];

        // Find the smallest from k list k
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        List<ListNode> allList = new ArrayList<>();
        Collections.addAll(allList, lists);

        Iterator<ListNode> iter = allList.iterator();
        while (iter.hasNext())
        {
            ListNode node = iter.next();
            if (node == null)
                iter.remove();
        }

        while (!allList.isEmpty())
        {
            int target = 0;
            if (allList.get(0) == null)
            {
                allList.remove(0);
                continue;
            }
            int min = allList.get(0).val;
            for (int i = 1; i < allList.size(); i++)
            {
                ListNode node = allList.get(i);
                if (node.val < min)
                {
                    min = node.val;
                    target = i;
                }
            }

            ListNode targetNode = allList.get(target);

            // append val.
            dummy.next = targetNode;

            // if target next is not null move target to next.
            if (targetNode.next != null)
            {
                allList.set(target, targetNode.next);
            }
            else
            {
                allList.remove(target);
            }

            dummy = dummy.next;
        }

        return head.next;
    }
}
