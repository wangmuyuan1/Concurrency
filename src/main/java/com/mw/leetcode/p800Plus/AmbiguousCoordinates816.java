package com.mw.leetcode.p800Plus;

import com.mw.ProjectUtil;

import java.util.ArrayList;
import java.util.List;

public class AmbiguousCoordinates816
{
    public List<String> ambiguousCoordinates(String s)
    {
        s = s.substring(1, s.length() - 1);

        List<String> res = new ArrayList<>();
        for (int i = 1; i < s.length(); i++)
        {
            List<String> left = check(s.substring(0, i));
            List<String> right = check(s.substring(i, s.length()));

            for (String l : left)
            {
                for (String r : right)
                {
                    res.add("(" + l + "," + r + ")");
                }
            }
        }

        return res;
    }

    private List<String> check(String s)
    {
        int n = s.length();
        List<String> res = new ArrayList<>();
        if (s.charAt(0) == '0' && s.charAt(n - 1) == '0') // 0xxxx0
        {
            res.add("0");
            return res;
        }

        if (s.charAt(0) == '0') // 0xxxxxx
        {
            res.add("0." + s.substring(1, n));
            return res;
        }

        if (s.charAt(n - 1) == '0') // xxxxx0
        {
            res.add(s);
            return res;
        }

        res.add(s);

        // xxxxxx
        for (int i = 1; i < n; i++)
        {
            res.add(s.substring(0, i) + "." + s.substring(i, n));
        }

        return res;
    }

    public static void main(String[] args)
    {
        AmbiguousCoordinates816 app = new AmbiguousCoordinates816();
        List<String> res = app.ambiguousCoordinates("123");
        ProjectUtil.printList(res);
    }
}
