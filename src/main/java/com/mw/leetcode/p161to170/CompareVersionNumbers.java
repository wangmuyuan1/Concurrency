package com.mw.leetcode.p161to170;

public class CompareVersionNumbers
{
    public int compareVersion(String version1, String version2)
    {
        String[] a1 = version1.split("\\.");
        String[] a2 = version2.split("\\.");

        int maxLen = Math.max(a1.length, a2.length);
        for (int i = 0; i < maxLen; i++)
        {
            Integer v1 = i < a1.length ? Integer.parseInt(a1[i]) : 0;
            Integer v2 = i < a2.length ? Integer.parseInt(a2[i]) : 0;
            int compare = v1.compareTo(v2);
            if (compare != 0) {
                return compare;
            }
        }
        return 0;
    }

    public static void main(String[] args)
    {
        CompareVersionNumbers app = new CompareVersionNumbers();
        System.out.println(app.compareVersion("1", "0"));
    }
}
