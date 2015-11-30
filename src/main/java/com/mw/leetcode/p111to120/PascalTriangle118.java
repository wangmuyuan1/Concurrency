package com.mw.leetcode.p111to120;

import com.mw.ProjectUtil;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle118
{
    public List<List<Integer>> generate(int numRows)
    {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();

        for (int i = 0; i < numRows; i++)
        {
            cur.add(0, 1);
            for (int j = 1; j < cur.size() - 1; j++)
            {
                cur.set(j, cur.get(j) + cur.get(j + 1));
            }

            result.add(new ArrayList<>(cur));
        }
        return result;
    }

    public static void main(String[] args)
    {
        ProjectUtil.printList(new PascalTriangle118().generate(4));
    }
}
