package com.mw.leetcode.p161to170;

public class ExcelSheetColumnTitle
{
    public String convertToTitle(int n)
    {
        return n == 0 ? "" : convertToTitle(--n / 26) + (char)('A' + (n % 26));
    }

    public static void main(String[] args)
    {
        System.out.println(new ExcelSheetColumnTitle().convertToTitle(26));
    }
}
