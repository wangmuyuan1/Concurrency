package com.mw.leetcode.p1to10;

public class ZigZagConversion6
{
    public static String convert(String s, int numRows)
    {
        if (numRows == 1)
        {
            return s;
        }

        StringBuilder sb = new StringBuilder();

        int step = 2 * (numRows - 1); // the width of step. in the example of p   A, the width is 2;
                                      //                                      A P L
                                      //                                      Y

        // We fill row by row.
        for (int i = 0; i < numRows; i++)
        {
            //first & last rows
            if (i == 0 || i == numRows - 1)
            {
                for (int j = i; j < s.length(); j = j + step) // for the first row and last row try to fill the char.
                {
                    sb.append(s.charAt(j));
                }
            }
            else // Middle rows.
            {
                int j = i;
                boolean addingStep1 = true;
                int step1 = 2 * (numRows - 1 - i); // the width of step. in the example of p     I
                                                   //                                      A   L S , the width of step 1 is 2, step 2 is 1;
                                                   //                                      Y A
                                                   //                                      P


                int step2 = step - step1;
                while (j < s.length())
                {
                    sb.append(s.charAt(j));
                    j = j + (addingStep1 ? step1 : step2);
                    addingStep1 = !addingStep1;
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args)
    {
        System.out.println(convert("PAYPALISHIRING", 3));
    }
}
