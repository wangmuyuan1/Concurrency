package com.mw.leetcode.p131to140;

public class Candy135
{
    /**
     * 左边发一圈糖，右边发一遍糖
     */
    public int candy(int[] ratings)
    {
        int[] result = new int[ratings.length];
        result[0] = 1;

        for (int i = 1; i < ratings.length; i++)
        {
            result[i] = 1;
            if (ratings[i] > ratings[i - 1])
            {
                result[i] = result[i - 1] + 1;
            }
        }

        for (int i = ratings.length - 2; i >= 0; i--)
        {
            if (ratings[i] > ratings[i + 1] && result[i] <= result[i + 1])
            {
                result[i] = result[i + 1] + 1;
            }
        }

        int sum = 0;
        for (int i = 0; i < result.length; i++)
            sum += result[i];
        return sum;
    }

    public static void main(String[] args)
    {
        int[] ratings = {4,2,3,4,1};
        Candy135 app = new Candy135();
        System.out.println(app.candy(ratings));
    }
}
