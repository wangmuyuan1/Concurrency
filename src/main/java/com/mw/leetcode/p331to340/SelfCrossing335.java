package com.mw.leetcode.p331to340;

/**
 * Created by mwang on 10/04/2016.
 */
public class SelfCrossing335
{
    public boolean isSelfCrossing(int[] x)
    {
        if (x.length < 4)
            return false;

        // case 0. cross at the fourth line.
        // ------
        // |    |
        // ------
        if (x.length >=5 && x[3] == x[1] && x[4] + x[0] >= x[2])
            return true;

        for (int i = 3; i < x.length; i++)
        {
            // case 1. cross at the fourth line.
            // ------
            // |    |
            // --------
            //      |
            if (x[i] >= x[i - 2] && x[i - 1] <= x[i - 3])
            {
                return true;
            }
            // case 2. cross at the six line.
            // ------
            // |    |
            // |   -----|
            // |        |
            // ----------
            if (i >= 5
                    && x[i - 2] >= x[i - 4]
                    && x[i - 3] >= x[i - 1]
                    && x[i] + x[i - 4] >= x[i - 2]
                    && x[i - 1] + x[i - 5] >= x[i - 3])
            {
                return true;
            }
        }

        return false;
    }
}
