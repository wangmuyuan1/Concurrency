package com.mw.leetcode.p251to260;

import com.mw.ProjectUtil;
import com.mw.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths257
{
    public List<String> binaryTreePaths(TreeNode root)
    {
        List<String> result = new ArrayList<>();
        binaryTreePaths(root, new ArrayList<>(), result);
        return result;
    }

    private void binaryTreePaths(TreeNode root, List<TreeNode> cur, List<String> result)
    {
        if (root == null)
            return;

        if (root.left == null && root.right == null) // leaf.
        {
            StringBuilder sb = new StringBuilder();
            for (TreeNode node : cur)
                sb.append(node.val).append("->");
            sb.append(root.val);
            result.add(sb.toString());
            return;
        }

        cur.add(root);
        binaryTreePaths(root.left, cur, result);
        binaryTreePaths(root.right, cur, result);
        cur.remove(root);
    }

    public static void main(String[] args)
    {
        TreeNode node = ProjectUtil.generateTree("1");
        new BinaryTreePaths257().binaryTreePaths(node);
    }
}
