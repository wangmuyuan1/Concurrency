package com.mw.leetcode.p161to170;

import java.util.HashMap;
import java.util.Map;

public class FractionToRecurringDecimal166
{
    public String fractionToDecimal(int numerator, int denominator)
    {
        if (denominator == 0) return "NaN";
        if (numerator == 0) return "0";
        StringBuilder result = new StringBuilder();
        Long n = (long) numerator;
        Long d = (long) denominator;

        if (n * d < 0) result.append("-");

        n = Math.abs(n);
        d = Math.abs(d);
        result.append(Long.toString(n / d));

        if (n % d == 0) return result.toString();
        else result.append(".");

        Map<Long, Integer> map = new HashMap<>();
        Long r = n % d;
        while (r > 0)
        {
            if (map.containsKey(r))
            {
                result.insert(map.get(r), "(").append(")");
                break;
            }
            map.put(r, result.length());
            r *= 10;
            result.append(r / d);
            r = r % d;
        }
        return result.toString();
    }

    public static void main(String[] args)
    {
        System.out.println(new FractionToRecurringDecimal166().fractionToDecimal(25, 22));
    }
}
