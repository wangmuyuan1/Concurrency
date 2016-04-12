package com.mw.leetcode.p301to310;

import com.mw.leetcode.SegmentTreeNode;

/**
 * Created by mwang on 11/04/2016.
 */
public class NumArrayMutable
{
    static class NumArray
    {
        SegmentTreeNode root;

        public NumArray(int[] nums) {
            if (nums.length > 0)
                this.root = new SegmentTreeNode(0, nums.length - 1, nums);
        }

        void update(int i, int val)
        {
            if (root == null)
                return;
            update(i, val, root);
        }

        private void update(int i, int val, SegmentTreeNode root)
        {
            if (root.start == root.end)
            {
                root.value = val;
                return;
            }

            if (i <= root.left.end)
            {
                update(i, val, root.left);
                root.value = root.left.value + root.right.value; // update root value.
            }
            else if (i >= root.right.start)
            {
                update(i, val, root.right);
                root.value = root.left.value + root.right.value; // update root value.
            }
        }

        public int sumRange(int i, int j)
        {
            if (root == null)
                return 0;

            return sumRange(i, j, root);
        }

        private int sumRange(int i, int j, SegmentTreeNode root)
        {
            if (root.start == i && root.end == j)
                return root.value;
            // how to search?
            // if i and j both in left tree
            if (j <= root.left.end)
                return sumRange(i, j, root.left);
            // if i and j both in right tree.
            else if (i >= root.right.start)
                return sumRange(i, j, root.right);
            // if i and j across left to right.
            else
            {
                return sumRange(i, root.left.end, root.left) + sumRange(root.right.start, j, root.right);
            }
        }
    }

    public static void main(String[] args)
    {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray numArray = new NumArray(nums);
        System.out.println(numArray.sumRange(0, 4));
        numArray.update(3, -1);
        System.out.println(numArray.sumRange(0, 4));
    }
}
