package com.mw.leetcode.p281to290;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mwang on 27/04/2016.
 */
public class WordPattern290
{
    public boolean wordPattern(String pattern, String str) {
        String[] array = str.split(" ");
        if (array.length != pattern.length())
            return false;
        Map map = new HashMap();
        for (int i = 0; i < array.length; i++)
        {
            if (map.put(array[i], i) != map.put(pattern.charAt(i), i))
                return false;
        }

        return true;
    }

    public static void main(String[] args)
    {
        WordPattern290 app = new WordPattern290();
        System.out.println(app.wordPattern("ab", "b c"));

    }
}
