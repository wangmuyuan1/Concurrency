package com.mw.leetcode;

/**
 * Created by mwang on 12/04/2016.
 */
public class SegmentTreeNode
{
    public int start;
    public int end;
    public SegmentTreeNode left;
    public SegmentTreeNode right;
    public int value;

    public SegmentTreeNode(int start, int end, int[] nums)
    {
        this.start = start;
        this.end = end;
        if (start != end)
        {
            int mid = start + (end - start) / 2;
            this.left = new SegmentTreeNode(start, mid, nums);
            this.right = new SegmentTreeNode(mid + 1, end, nums);
            this.value = left.value + right.value;
        }
        else //leaf node.
        {
            this.value = nums[start];
        }
    }
}
