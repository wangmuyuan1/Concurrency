package com.mw.p301to310;

public class AdditiveNumber306
{
    public boolean isAdditiveNumber(String num)
    {
        if (num == null || num.length() < 3)
            return false;
        int n = num.length();
        for (int i = 1; i < n; i++)
        {
            if (num.charAt(0) == '0') break;
            for (int j = i + 1; j < n; j++)
            {
                int first = 0; // first number always start from the zero index;
                int second = i;
                int third = j;

                if (num.charAt(second) == '0' && third > second + 1) break; // second start with 0.

                while (third < n) // the start of third number is less than n.
                {
                    Long result = (Long.parseLong(num.substring(first, second)) + Long.parseLong(num.substring(second, third)));
                    if (num.substring(third).startsWith(result.toString()))
                    {
                        first = second;
                        second = third;
                        third += result.toString().length();
                    }
                    else
                        break;
                }

                if (third == n) return true; // the third number reached the end.
            }
        }
        return false;
    }
}
