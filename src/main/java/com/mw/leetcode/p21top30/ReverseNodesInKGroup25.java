package com.mw.leetcode.p21top30;

public class ReverseNodesInKGroup25
{
    public static ListNode reverseKGroup(ListNode head, int k)
    {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode fast = dummy.next;

        boolean first = true;

        // reverse the from cur to cur + step.
        ListNode prev = new ListNode(0); // Point to previous node of last iteration.
        prev.next = head;
        while (fast != null)
        {
            int step = 0;
            while (step < k)
            {
                fast = fast.next;
                step++;
                if (fast == null)
                {
                    break;
                }
            }

            // If step less than k step, return;
            if (step < k)
                break;

            // the current node pointer in this iteration.
            ListNode curr = prev.next;
            ListNode currHead = curr;
            ListNode currTail = curr;
            while (step > 1)
            {
                // break the link from 1 - 2,
                // if 1 is null
                ListNode node0 = curr;
                ListNode node1 = curr.next; // Could be null;
                ListNode node2 = null;

                if (node1 == null) // 0->null no need to swap.
                    break;
                else
                    node2 = node1.next; // Nullable.

                // if 1 is not null 0->1->2(nullable)
                // point 1 to current head
                node1.next = currHead; // 0<->1 2

                // point 0 to 2;
                node0.next = node2; // 1->0->2

                // mark node 1 as temp head;
                currHead = node1;

                // make 0 as temp tail.
                currTail = node0;

                // move curr to node 0;
                curr = node0; // 1(curHead)->0(cur)->2

                step--;
            }

            // make prev node point to the cur head of this iteration.
            prev.next = currHead;
            // move prev to the tail of this iteration.
            prev = currTail;

            if (first) // If this is first execution, assign the prev to dummy, so dummy point to the head from first iteration.
            {
                dummy.next = currHead;
                first = false;
            }
        }

        return dummy.next;
    }

    public static void main(String[] args)
    {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node = reverseKGroup(node, 1);
        while (node != null)
        {
            System.out.println(node.val);
            node = node.next;
        }
        /*
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(4);
        node = reverseKGroup(node, 2);
        while (node != null)
        {
            System.out.println(node.val);
            node = node.next;
        }*/
    }
}
