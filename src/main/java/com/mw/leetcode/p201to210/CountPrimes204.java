package com.mw.leetcode.p201to210;

public class CountPrimes204
{
    public int countPrimes(int n)
    {
        if (n <= 2)
            return 0;
        // Store in a collection.
        boolean[] nonPrime = new boolean[n];
        int sum = 1;
        int upper = (int) Math.sqrt(n);
        for (int i = 3; i < n; i = i + 2) // as we dont need even numbers.
        {
            if (!nonPrime[i]) // then it is prime. for 3 as we know it is not prime.
            {
                sum++;

                if (i > upper)
                    continue;

                for (int j = i * i; j < n; j = j + i) // we fill the result by step.
                {
                    nonPrime[j] = true; // it is not prime.
                }
            }
        }
        return sum;
    }
}