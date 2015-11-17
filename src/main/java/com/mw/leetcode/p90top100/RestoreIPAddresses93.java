package com.mw.leetcode.p90top100;

import com.mw.ProjectUtil;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses93
{
    public static List<String> restoreIpAddresses(String s)
    {
        List<String> result = new ArrayList<>();
        if (s != null && s.length() >= 4)
            dfs(4, 0, s, new StringBuilder(), result);
        return result;
    }

    private static void dfs(int remainSection, int start, String s, StringBuilder sb, List<String> result)
    {
        if (remainSection == 0 && start == s.length())
        {
            result.add(sb.toString());
            return;
        }

        if (
                (remainSection == 0 && start < s.length())
                || (remainSection > 0
                        && (start + 3 * remainSection < s.length()
                            || start + remainSection > s.length())
                   )
                )
            return;

        for (int i = 1; i <= 3; i++)
        {
            if (start + i > s.length())
                continue;
            String temp = s.substring(start, start + i);
            if (isValid(temp))
            {
                int lastLength = sb.length();
                sb.append(temp);
                if (remainSection > 1)
                    sb.append(".");
                dfs(remainSection - 1, start + i, s, sb, result);
                sb.delete(lastLength, sb.length());
            }
        }
    }

    private static boolean isValid(String s)
    {
        if (s.length() > 1 && s.charAt(0) == '0')
            return false;
        return Integer.parseInt(s) <= 255;
    }

    public static void main(String[] args)
    {
        ProjectUtil.printList(restoreIpAddresses("0000"));
    }
}
