package com.mw.leetcode.p81to90;

import java.util.ArrayList;
import java.util.List;

import static com.mw.ProjectUtil.printList;

public class GrayCode89
{
    public static List<Integer> grayCode(int n)
    {
        List<Integer> result = new ArrayList<>();
        result.add(0);
        if (n == 0)
            return result;

        int prefNum = 1;
        for (int i = 1; i <= n; i++)
        {
            for (int j = result.size(); j > 0; j--)
            {
                result.add(result.get(j - 1) + prefNum);
            }
            prefNum <<= 1;
        }
        return result;
    }

    public static void main(String[] args)
    {
        printList(grayCode(3));
    }
}
