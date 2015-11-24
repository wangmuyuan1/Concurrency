package com.mw.leetcode.p111to120;

import com.mw.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class PathSumII113
{
    public List<List<Integer>> pathSum(TreeNode root, int sum)
    {
        List<List<Integer>> result = new ArrayList<>();
        pathSum(root, sum, result, new ArrayList<>());
        return result;
    }

    private void pathSum(TreeNode root, int sum, List<List<Integer>> res, List<Integer> temp)
    {
        if (root == null)
            return;
        temp.add(root.val);
        if (root.val == sum && root.left == null && root.right == null)
        {
            res.add(new ArrayList<>(temp));

        }
        else
        {
            pathSum(root.left, sum - root.val, res, temp);
            pathSum(root.right, sum - root.val, res, temp);
        }
        temp.remove(temp.size() - 1);
    }
}
