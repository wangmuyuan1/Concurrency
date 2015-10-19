package com.mw.leetcode.p31top40;

public class CountAndSay38
{
    public static String countAndSay(int n)
    {
        if (n <= 0)
            return "";

        if (n == 1)
            return "1";

        int i = 1;
        String result = "1";
        while (i < n)
        {
            result = getStr(result);
            i++;
        }

        return result;
    }

    private static String getStr(String str)
    {
        StringBuilder sb = new StringBuilder();
        char prev = str.charAt(0);
        int count = 1;
        for (int i = 1; i < str.length(); i++)
        {
            if (str.charAt(i) == prev)
            {
                count++;
            }
            else
            {
                sb.append(count).append(prev);
                prev = str.charAt(i);
                count = 1;
            }
        }

        if (count > 0)
        {
            sb.append(count).append(prev);
        }
        return sb.toString();
    }

    public static void main(String[] args)
    {
        System.out.println(countAndSay(2));
    }
}
