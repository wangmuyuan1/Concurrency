package com.mw.leetcode.p291to300;

import java.util.*;

/**
 * Created by mwang on 16/04/2016.
 */
public class BullsAndCows299
{
    public String getHint(String secret, String guess)
    {
        Map<Character, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < secret.length(); i++)
        {
            char c = secret.charAt(i);
            if (map.containsKey(c))
                map.get(c).add(i);
            else
            {
                Set<Integer> set = new HashSet<>();
                set.add(i);
                map.put(c, set);
            }
        }

        int bull = 0;
        int cow = 0;
        Map<Character, Integer> guessMap = new HashMap<>();
        for (int i = 0; i < guess.length(); i++)
        {
            char c = guess.charAt(i);
            if (map.containsKey(c))
            {
                Set<Integer> set = map.get(c);
                if (set.contains(i))
                {
                    bull++;
                    set.remove(i);
                }
                else
                {
                    if (guessMap.containsKey(c))
                        guessMap.put(c, guessMap.get(c) + 1);
                    else
                        guessMap.put(c, 1);
                }
            }
        }

        for (Map.Entry<Character, Set<Integer>> entry : map.entrySet())
        {
            int missed = entry.getValue().size();
            if (guessMap.containsKey(entry.getKey()))
            {
                cow += Math.min(guessMap.get(entry.getKey()), missed);
            }
        }
        return bull + "A" + cow + "B";
    }

    public static void main(String[] args)
    {
        BullsAndCows299 app = new BullsAndCows299();
        System.out.println(app.getHint("1807", "7810"));
        System.out.println(app.getHint("1123", "0111"));
        System.out.println(app.getHint("11807", "07801"));
    }
}
