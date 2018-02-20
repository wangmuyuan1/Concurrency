package com.mw.leetcode.extra;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class DigitToTime
{
    private String res;
    private String state;

    public String getTime(int A, int B, int C, int D, int E, int F)
    {
        Queue<String> q = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        sb.append(A).append(B).append(C).append(D).append(E).append(F);
        q.offer(sb.toString());
        visited.add(sb.toString());

        while (!q.isEmpty())
        {
            while (!q.isEmpty())
            {
                String s = q.poll();
                if (isValid(s))
                {
                    res = (res == null || res.compareTo(s) > 0) ? s : res;
                }
                char[] array = s.toCharArray();
                // for each number, try to swap with the other.
                for (int i = 0; i < s.length(); i++)
                {
                    for (int j = i + 1; j < s.length(); j++)
                    {
                        swap(array, i, j);
                        String ts = String.valueOf(array);
                        if (!visited.contains(ts))
                        {
                            q.offer(ts);
                            visited.add(ts);
                        }
                        swap(array, i, j);
                    }
                }
            }
        }
        return res == null ? "NOT POSSIBLE" : formatRes(res);
    }

    private boolean isValid(String s)
    {
        int hour = Integer.valueOf(s.substring(0, 2));
        int min = Integer.valueOf(s.substring(2, 4));
        int sec = Integer.valueOf(s.substring(4, 6));
        return hour < 24 && min < 60 && sec < 60;
    }

    private String formatRes(String res)
    {
        return new StringBuilder().append(res.charAt(0)).append(res.charAt(1)).append(":")
                .append(res.charAt(2)).append(res.charAt(3)).append(":")
                .append(res.charAt(4)).append(res.charAt(5)).toString();
    }

    private void swap(char[] array, int i, int j)
    {
        char temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public static void main(String[] args)
    {
        DigitToTime app = new DigitToTime();
        System.out.println(app.getTime(1, 8,6, 4,2 ,3));

        app = new DigitToTime();
        System.out.println(app.getTime(0, 0,0, 7,8 ,9));

        app = new DigitToTime();
        System.out.println(app.getTime(7, 6,6, 7,8 ,9));
    }
}
