package com.mw.leetcode.p111to120;

import com.mw.ProjectUtil;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle119II
{
    public List<Integer> getRow(int rowIndex)
    {
        List<Integer> list = new ArrayList<>(rowIndex + 1);
        for (int i = 0; i < rowIndex + 1; i++)
        {
            list.add(0, 1); //为了每次iteration给字符串增加一个长度
            for (int j = 1; j < list.size() - 1; j++) {
                list.set(j, list.get(j) + list.get(j + 1));
            }
        }
        return list;
    }

    public static void main(String[] args)
    {
        ProjectUtil.printList(new PascalTriangle119II().getRow(3));
    }
}
