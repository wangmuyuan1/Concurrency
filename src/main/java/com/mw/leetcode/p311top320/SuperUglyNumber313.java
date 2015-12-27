package com.mw.leetcode.p311top320;

public class SuperUglyNumber313
{
    public int nthSuperUglyNumber(int n,
                                  int[] primes)
    {
        // similar approach.
        int[] pointer = new int[primes.length];
        if (n == 1)
            return 1;

        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1; i < n; i++)
        {
            //dp[i] = min of factor of all
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < primes.length; j++)
            {
                min = Math.min(min, primes[j] * dp[pointer[j]]);
            }
            dp[i] = min;

            for (int j = 0; j < primes.length; j++)
            {
                if (dp[i] == primes[j] * dp[pointer[j]])
                    pointer[j]++;
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args)
    {
        int[] primes = {2, 7, 13, 19};
        System.out.println(new SuperUglyNumber313().nthSuperUglyNumber(12, primes));
    }
}
