package com.mw.leetcode.p11to20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum15
{
    public static List<List<Integer>> threeSum(int[] nums)
    {
        List<List<Integer>> results = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++)
        {
            for (int j = i + 1, k = nums.length - 1; j < k;)
            {
                if (nums[i] + nums[j] + nums[k] < 0)
                {
                    j++;
                }
                else if (nums[i] + nums[j] + nums[k] > 0)
                {
                    k--;
                }
                else
                {
                    boolean found = false;
                    for (List<Integer> result : results)
                    {
                        if (result.get(0) == nums[i]
                                && result.get(1) == nums[j]
                                && result.get(2) == nums[k])
                        {
                            found = true;
                            break;
                        }
                    }
                    if (!found)
                        results.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                }
            }
        }

        return results;
    }

    public static void main(String[] args)
    {
        int[] s2 = {7,-1,14,-12,-8,7,2,-15,8,8,-8,-14,-4,-5,7,9,11,-4,-15,-6,1,-14,4,3,10,-5,2,1,6,11,2,-2,-5,-7,-6,2,-15,11,-6,8,-4,2,1,-1,4,-6,-15,1,5,-15,10,14,9,-8,-6,4,-6,11,12,-15,7,-1,-9,9,-1,0,-4,-1,-12,-2,14,-9,7,0,-3,-4,1,-2,12,14,-10,0,5,14,-1,14,3,8,10,-8,8,-5,-2,6,-11,12,13,-7,-12,8,6,-13,14,-2,-5,-11,1,3,-6};
        print(threeSum(s2));
    }

    public static void print(List<List<Integer>> results)
    {
        for (List<Integer> result: results)
        {
            for (int num : result)
            {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}
