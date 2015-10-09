package com.mw.leetcode.p21top30;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class MergeKSortedList23
{
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
