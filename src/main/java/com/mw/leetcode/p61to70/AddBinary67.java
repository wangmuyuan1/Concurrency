package com.mw.leetcode.p61to70;

public class AddBinary67
{
    /**
     * From the last index of the two string, add the value.
     */
    public static String addBinary(String a, String b)
    {
        boolean extra = false;
        StringBuilder sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1;
        for (; i >= 0 && j >=0; i--, j--)
        {
            int val = getVal(a.charAt(i)) + getVal(b.charAt(j)) + (extra ? 1 : 0);
            sb.append(val % 2);
            extra = (val / 2 > 0);
        }

        while (i >= 0)
        {
            int val = getVal(a.charAt(i)) + (extra ? 1 : 0);
            sb.append(val % 2);
            extra = (val / 2 > 0);
            i--;
        }
        while (j >= 0)
        {
            int val = getVal(b.charAt(j)) + (extra ? 1 : 0);
            sb.append(val % 2);
            extra = (val / 2 > 0);
            j--;
        }

        if (extra)
        {
            sb.append("1");
        }

        return sb.reverse().toString();
    }

    private static int getVal(char c)
    {
        return c == '0' ? 0 : 1;
    }

    public static void main(String[] args)
    {
        System.out.println(addBinary("11", "11"));
    }
}
