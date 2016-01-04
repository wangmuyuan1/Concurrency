package com.mw.leetcode.p311top320;

import com.mw.ProjectUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CountofSmallerNumbersAfterSelf315
{
    public List<Integer> countSmaller(int[] nums)
    {
        Integer[] ans = new Integer[nums.length];
        TreeNode root = null;
        for (int i = nums.length - 1; i >= 0; i--)
            root = insert(nums[i], root, ans, i, 0);
        return Arrays.asList(ans);
    }

    private TreeNode insert(int val, TreeNode node, Integer[] ans, int i, int presum)
    {
        if (node == null)
        {
            node = new TreeNode(val, 0, 1);
            ans[i] = presum;
        }
        else if (node.val == val)
        {
            node.dup++;
            ans[i] = presum + node.sum;
        }
        else if (node.val > val)// insert left.
        {
            node.sum++;
            node.left = insert(val, node.left, ans, i, presum);
        }
        else
        {
            node.right = insert(val, node.right, ans, i, presum + node.sum + node.dup);
        }

        return node;
    }

    public List<Integer> countSmallerMergeSort(int[] nums)
    {
        List<Integer> result = new ArrayList<>(nums.length);
        if (nums == null || nums.length == 0)
            return result;
        Node[] nodes = new Node[nums.length];

        for (int i = 0; i < nums.length; i++)
            nodes[i] = new Node(i, nums[i], 0);

        // Merge Sort Node
        mergeSort(nodes, 0, nums.length - 1);

        for (Node node : nodes)
            result.add(node.count);

        return result;
    }

    private Node[] mergeSort(Node[] nodes, int start, int end)
    {
        // termination condition.
        if (start == end)
        {
            Node[] result = new Node[1];
            result[0] = nodes[start];
            return result;
        }

        int mid = start + (end - start) / 2;
        Node[] left = mergeSort(nodes, start, mid);
        Node[] right = mergeSort(nodes, mid + 1, end);

        int i = 0;
        int j = 0;
        int k = 0;
        Node[] result = new Node[left.length + right.length];
        // ? Add count checker.
        while (i < left.length && j < right.length)
        {
            if (left[i].val <= right[j].val)
                result[k++] = left[i++];
            else
            {
                int t = i;
                while (t < left.length)
                    left[t++].count++;
                result[k++] = right[j++];
            }
        }

        while (i < left.length)
            result[k++] = left[i++];

        while (j < right.length)
            result[k++] = right[j++];

        return result;
    }

    public static void main(String[] args)
    {
        int[] nums = {5, 2, 2, 7, 6, 1};
        ProjectUtil.printList(new CountofSmallerNumbersAfterSelf315().countSmaller(nums));
    }
}

class TreeNode
{
    public int val;
    public int sum; // SUM of left side.
    public int dup;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int val, int sum, int dup)
    {
        this.val = val;
        this.sum = sum;
        this.dup = dup;
    }
}

class Node
{
    public int index;
    public int val;
    public int count;

    public Node(int index, int val, int count)
    {
        this.index = index;
        this.val = val;
        this.count = count;
    }
}