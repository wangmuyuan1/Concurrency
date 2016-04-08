package com.mw.leetcode.p331to340;

import com.mw.ProjectUtil;

/**
 * Created by mwang on 07/04/2016.
 */
public class CountingBits {

    public int[] countBits(int num) {
        int[] array = new int[num + 1];

        for (int i = 0; i <= num; i++)
        {
            array[i] = array[i >> 1] + (i & 1); // 0 is 0, 1 is 1, 2 is 1, 3 is 2. eg 6 which is 110 is 3 << 1 , 7 which is 3 << 1 + 1, 9 is 4 << 1 + 1
        }

        return array;
    }

    public static void main(String[] args)
    {
        CountingBits app = new CountingBits();
        ProjectUtil.printIntArray(app.countBits(4));
    }
}
