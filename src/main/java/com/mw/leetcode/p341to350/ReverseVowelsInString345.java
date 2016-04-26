package com.mw.leetcode.p341to350;

import java.util.HashSet;

/**
 * Created by mwang on 25/04/2016.
 */
public class ReverseVowelsInString345
{
    public String reverseVowels(String s)
    {
        HashSet<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');


        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');

        int j = s.length() - 1;
        char[] array = s.toCharArray();
        for (int i = 0 ; i < j; i++)
        {
            if (set.contains(array[i]))
            {
                while (i < j && !set.contains(array[j]))
                    j--;
                char c = array[j];
                array[j--] = array[i];
                array[i] = c;
            }
        }
        return new String(array);
    }

    public static void main(String[] args)
    {
        ReverseVowelsInString345 app = new ReverseVowelsInString345();
        System.out.println(app.reverseVowels(""));
        System.out.println(app.reverseVowels("e"));
        System.out.println(app.reverseVowels("le"));
        System.out.println(app.reverseVowels("el"));
        System.out.println(app.reverseVowels("hello"));
        System.out.println(app.reverseVowels("leetcode"));
    }
}
