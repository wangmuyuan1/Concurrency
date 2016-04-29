package com.mw.leetcode.p301to310;

import com.mw.ProjectUtil;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by mwang on 29/04/2016.
 */
public class RemoveInvalidParentheses301
{
    public List<String> removeInvalidParentheses(String s)
    {
        // get lc and rc
        int rmL  = 0;
        int rmR = 0;
        for (int i = 0; i < s.length(); i++)
        {
            if (s.charAt(i) == '(')
                rmL++;
            else if (s.charAt(i) == ')')
            {
                if (rmL > 0) rmL--;
                else rmR++; // the right ')' has to be removed.
            }
        }

        Set<String> result = new HashSet<>();

        dfs(result, s, 0, rmL, rmR, 0, new StringBuilder());

        return new ArrayList<>(result);
    }

    private void dfs(Set<String> result, String s, int i, int rmL, int rmR, int open, StringBuilder sb)
    {
        if (i == s.length() && rmL == 0 && rmR == 0 && open == 0)
        {
            result.add(sb.toString());
            return;
        }
        if (i == s.length() || rmL <0 || rmR <0 || open < 0) return;

        char c = s.charAt(i);
        int len = sb.length();

        if (c == '(')
        {
            dfs(result, s, i + 1, rmL - 1, rmR, open, sb); // try to remove the left.
            dfs(result, s, i + 1, rmL, rmR, open + 1, sb.append(c)); // try to remove the right. we have an open.
        }
        else if (c == ')')
        {
            dfs(result, s, i + 1, rmL, rmR - 1, open, sb);
            dfs(result, s, i + 1, rmL, rmR, open - 1, sb.append(c)); // we have one open less.
        }
        else
        {
            dfs(result, s, i + 1, rmL, rmR, open, sb.append(c));
        }

        sb.setLength(len);
    }

    public static void main(String[] args)
    {
        RemoveInvalidParentheses301 app = new RemoveInvalidParentheses301();
        ProjectUtil.printList(app.removeInvalidParentheses("()())()"));
        System.out.println();
        ProjectUtil.printList(app.removeInvalidParentheses("(a)())()"));
        System.out.println();
        ProjectUtil.printList(app.removeInvalidParentheses(")("));
    }
}
