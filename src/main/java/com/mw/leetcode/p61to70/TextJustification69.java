package com.mw.leetcode.p61to70;

import java.util.ArrayList;
import java.util.List;

public class TextJustification69
{
    public static List<String> fullJustify(String[] words, int maxWidth)
    {
        List<String> result = new ArrayList<>();

        // Scan the word.
        // for each word, if sum length + n - 1 space is le than maxWidth. go ahead.
        int length = 0;
        int nCount = 0;
        List<String> cur = new ArrayList<>();
        for (String word : words)
        {
            if (word.length() + length + nCount <= maxWidth)
            {
                cur.add(word);
                length += word.length();
                nCount++;
            }
            else // the word + prev > max
            {
                // format current row.
                adjust(maxWidth, cur, result, false);
                cur.clear();

                cur.add(word);
                length = word.length();
                nCount = 1;
            }
        }

        if (!cur.isEmpty())
        {
            adjust(maxWidth, cur, result, true);
        }
        return result;
    }

    private static void adjust(int maxWidth, List<String> cur, List<String> result, boolean last)
    {
        StringBuilder sb = new StringBuilder(maxWidth);
        int noOfSpace = cur.size() - 1;
        int totalLen = 0;
        for (String s : cur)
        {
            totalLen += s.length();
        }
        if (last || cur.size() == 1)
        {
            for (int i = 0; i < cur.size(); i++)
            {
                sb.append(cur.get(i));
                if (i < cur.size() - 1)
                {
                    sb.append(" ");
                }
            }
            for (int n = 0; n < maxWidth - totalLen - noOfSpace; n++)
            {
                sb.append(" ");
            }
        }
        else
        {
            int spaceWidth = (maxWidth - totalLen) / noOfSpace; // 10 / 4 = 2
            int extra = (maxWidth - totalLen) % noOfSpace; // 10 % 4 = 2, so should be 3, 3, 2, 2

            for (int i = 0; i < cur.size(); i++)
            {
                sb.append(cur.get(i));
                if (i < cur.size() - 1)
                {
                    for (int n = 0; n < spaceWidth; n++)
                    {
                        sb.append(" ");
                    }
                    if (extra > 0)
                    {
                        sb.append(" ");
                        extra--;
                    }
                }
            }
        }
        result.add(sb.toString());
    }

    public static void main(String[] args)
    {
//        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
//        for (String s: fullJustify(words, 16))
//            System.out.println(s);
        String[] words = {"Here","is","an","example","of","text","justification."};
        for (String s: fullJustify(words, 14))
              System.out.println(s);
    }
}
