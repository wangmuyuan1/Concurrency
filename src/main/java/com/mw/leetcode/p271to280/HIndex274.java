package com.mw.leetcode.p271to280;

/**
 * Created by mwang on 08/05/2016.
 */
public class HIndex274
{
    public int hIndex(int[] citations)
    {
        int[] array = new int[citations.length + 1];

        for (int i = 0; i < citations.length; i++)
        {
            if (citations[i] >= citations.length) array[citations.length]++;
            else array[citations[i]]++;
        }

        int sum = 0;
        for (int i = citations.length; i >= 0; i--)
        {
            sum = sum + array[i];
            if (sum >= i) return i;
        }
        return 0;
    }

    public static void main(String[] args)
    {
        int[] citations = {13, 10, 16, 11, 15};
        HIndex274 app = new HIndex274();
        System.out.println(app.hIndex(citations));
    }
}
