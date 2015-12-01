package com.mw.leetcode.p131to140;

public class SingleNumberII137
{
    public int singleNumber(int[] nums)
    {
        int[] bitCount = new int[32];
        for (int i = 0; i < 32; i++) {
            bitCount[i] = 0;
        }

        for (int j = 0; j < nums.length; j++) {
            int n = nums[j];
            for (int i = 0; i < 32; i++) {
                boolean hasBit = (n & (1 << i)) != 0;
                if (hasBit) {
                    bitCount[i] = (bitCount[i] + 1) % 3; //当一个数重复三次的时候，这个位数应该是0，当重复次数较小的时候，应该是1或者2.
                }
            }
        }

        int except = 0;
        for (int i = 0; i < 32; i++) {
          if (bitCount[i] > 0) {
              except |= (1 << i); //设置此位数为1.
          }
        }
        return except;
    }

    public static void main(String[] args)
    {
        int[] nums = {1,1,1,27,27,27,3,3,3,5,5};
        System.out.println(new SingleNumberII137().singleNumber(nums));
    }
}
