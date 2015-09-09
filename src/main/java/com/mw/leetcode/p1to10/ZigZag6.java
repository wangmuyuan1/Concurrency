package com.mw.leetcode.p1to10;

/**
 The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 P   A   H   N
 A P L S I I G
 Y   I   R
 And then read line by line: "PAHNAPLSIIGYIR"
 Write the code that will take a string and make this conversion given a number of rows:

 string convert(string text, int nRows);
 convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 */
public class ZigZag6
{
    public static String convert(String s, int numRows)
    {
        /**
         *  0     4
         * 0P    2A   H   N
         *  1  3
         * 4A 5P L S I I G
         *  2
         * 11Y   I   R
         */
        char[][] array = new char[numRows][s.length()];
        for (int i = 0; i < s.length(); i++)
        {
        }
        return null;
    }

    public static void main(String[] args)
    {
        System.out.println(convert("PAYPALISHIRING", 3));
    }
}
