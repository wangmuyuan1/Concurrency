package com.mw.leetcode.p311top320;

public class SuperUglyNumber313
{
    public int nthSuperUglyNumber(int n,
                                      int[] primes)
    {
        if (n == 1)
            return 1;

        int[] pointer = new int[primes.length]; // stores the current pointer times for the given prime in the dp array
        int[] dp = new int[n]; // store the 1 to nth number that consisted with primes.

        dp[0] = 1; // the first item is prime.

        for (int i = 1; i < n; i++) // Compute the 1 to nth number
        {
            // dp[i] = min of factor of the number consists of prime
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
