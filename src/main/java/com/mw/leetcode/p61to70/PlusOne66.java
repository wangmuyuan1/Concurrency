package com.mw.leetcode.p61to70;

public class PlusOne66
{
    /***
     * from the end, we try to add 1 to every digit, until the result of adding is still less than 10. eg. 897 add 1 is 898.
     * 899 add 1 is 900, still has no extra digit needed.
     *
     * But 999 will result 000, in this case, we check if the first digit is not zero then we return. other wise we return 1 + 000
     */
    public static int[] plusOne(int[] digits)
    {
        for (int i = digits.length - 1; i >= 0; i--)
        {
            digits[i] = (digits[i] + 1) % 10;
            if (digits[i] > 0)
            {
                break;
            }
        }

        if (digits[0] != 0)
        {
            return digits;
        }
        else
        {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            for (int i = 0; i < digits.length; i++)
            {
                result[i + 1] = 0;
            }
            return result;
        }
    }

    public static void main(String[] args)
    {
        int[] number = {9, 9};
        for (int i : plusOne(number))
            System.out.print(i);
    }
}
