package com.mw.leetcode.p331to340;

import java.util.Stack;

public class VerifyPreorderSerializationofaBinaryTree331
{
    public boolean isValidSerialization(String preorder)
    {
        String[] nodes = preorder.split(",");
        int diff = 1;
        for (String node : nodes)
        {
            diff--;
            if (diff < 0) return false;
            if (!node.equals("#")) diff += 2;
        }

        return diff == 0;
    }

    public static void main(String[] args)
    {
        VerifyPreorderSerializationofaBinaryTree331 app = new VerifyPreorderSerializationofaBinaryTree331();
        System.out.println(app.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
    }
}
