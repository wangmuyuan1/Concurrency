package com.mw.leetcode.p71to80;

import java.util.ArrayList;
import java.util.List;

public class SimplifyPath71
{
    public static String simplifyPath(String path)
    {
        StringBuilder sb = new StringBuilder(path.length());
        List<String> directory = new ArrayList<>();

        int dots = 0;
        StringBuilder curName = new StringBuilder();
        for (int i = 0; i < path.length(); i++)
        {
            char c = path.charAt(i);
            if (c == '.')
            {
                dots++;
            }
            else if (c != '.' && c != '/') // /..abc..../
            {
                for (int j = 0; j < dots; j++)
                    curName.append(".");
                dots = 0;
                curName.append(c);
            }
            else if (c == '/')
            {
                processCurrentDirectory(directory, dots, curName);
                curName = new StringBuilder();
                dots = 0;
            }

            if (i == path.length() - 1) // dots = 1 should be ignored.
            {
                processCurrentDirectory(directory, dots, curName);
            }
        }

        sb.append("/");
        for (int i = 0; i < directory.size(); i++)
        {
            sb.append(directory.get(i));
            if (i < directory.size() - 1)
                sb.append("/");
        }

        return sb.toString();
    }

    private static void processCurrentDirectory(List<String> directory, int dots, StringBuilder curName)
    {
        if (curName.length() == 0 && dots == 2)
        {
            if (!directory.isEmpty())
                directory.remove(directory.size() - 1);
        }
        else if (curName.length() > 0 || dots > 2)
        {
            for (int j = 0; j < dots; j++)
                curName.append(".");
            directory.add(curName.toString());
        }
    }

    public static void main(String[] args)
    {
        System.out.println(simplifyPath("/home/"));
        System.out.println(simplifyPath("/c"));
        System.out.println(simplifyPath("/home/foo/.ssh/authorized_keys"));
    }
}
