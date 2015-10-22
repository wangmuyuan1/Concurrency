package com.mw.leetcode.p41to50;

public class MultiplyStrings43
{
    public static String multiply(String num1, String num2)
    {
        StringBuffer result = new StringBuffer();
        if (num1.equals("") || num2.equals(""))
            return result.toString();
        String n1 = new StringBuffer(num1).reverse().toString();
        String n2 = new StringBuffer(num2).reverse().toString();

        int[] array = new int[n1.length() + n2.length()];

        // fill the array.
        for (int i = 0; i < n1.length(); i++)
        {
            for (int j = 0; j < n2.length(); j++)
            {
                array[i + j] += (n1.charAt(i) - '0') * (n2.charAt(j) - '0'); // for 1 + 0 and 0 + 1, two result will be added.
            }
        }

        int temp = 0;
        for (int i = 0; i < array.length; i++)
        {
            array[i] = array[i] + temp; // add the temp from last digit.
            temp = array[i] / 10; // compute temp of this digit.
            result.append(array[i] % 10); // append only the last digit.
        }

         //remove front 0's
        while(result.charAt(result.length() - 1) == '0' && result.length()> 1)
        {
            result.deleteCharAt(result.length() - 1);
        }

        return result.reverse().toString();
    }

    public static void main(String[] args)
    {
        System.out.println(multiply("1", "1"));
    }
}
