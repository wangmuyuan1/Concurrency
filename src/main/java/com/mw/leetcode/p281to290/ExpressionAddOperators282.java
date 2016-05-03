package com.mw.leetcode.p281to290;

import com.mw.ProjectUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mwang on 01/05/2016.
 */
public class ExpressionAddOperators282
{
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();

        if (num.length() == 0) return result;

        divideAndConquer(result, 0, 0, new StringBuilder(), num, 0, target);
        return result;
    }

    private void divideAndConquer(List<String> result, long prev, long lastVal, StringBuilder sb, String num, int pos, int target)
    {
        // if i < nums.length, continue;
        if (pos == num.length())
        {
            if (target == prev)
                result.add(sb.toString());
            return;
        }

        for(int i = pos; i < num.length(); i++)
        {
            if (num.charAt(pos) == '0' && i != pos) break;
            long value = Long.parseLong(num.substring(pos, i + 1));
            int length = sb.length();
            if (pos == 0)
            {
                divideAndConquer(result, value, value, sb.append(value), num, i + 1, target);
                sb.setLength(length);
            }
            else
            {
                sb.append("+").append(value);
                divideAndConquer(result, prev + value, value, sb, num, i + 1, target);
                sb.setLength(length);

                sb.append("-").append(value);
                divideAndConquer(result, prev - value, -value, sb, num, i + 1, target);
                sb.setLength(length);

                sb.append("*").append(value);
                divideAndConquer(result, prev - lastVal + lastVal * value, lastVal * value, sb, num, i + 1, target);
                sb.setLength(length);
            }
        }
    }

    public static void main(String[] args)
    {
        ExpressionAddOperators282 app = new ExpressionAddOperators282();
        ProjectUtil.printList(app.addOperators("105", 5));
    }
}
