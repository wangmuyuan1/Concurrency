package com.mw.leetcode.p81to90;

import java.util.Stack;

public class LargestRectangleinHistogram84
{
    public static int largestRectangleArea(int[] height)
    {
        int max = 0;
        if (height.length == 0)
        {
            return max;
        }

        // great explanation. http://fisherlei.blogspot.ie/2012/12/leetcode-largest-rectangle-in-histogram.html
        Stack<Integer> stack = new Stack<>();

        // while ascending, we skip.
        int i = 0;
        while(i < height.length)
        {
            if (stack.isEmpty() // then the position 0 is handled.
                    || height[i] > height[stack.peek()]) // also we compare with the last one from the stack rather than the height.
            {
                stack.push(i);
                i++; // we do not increase the height until we find an index that lower than current from the left.
            }
            else
            {
                int p = stack.pop();
                int h = height[p];
                // if stack is Empty means there is no bar from the left could be shorter than cur.
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(h * w, max);
            }
        }

        // if we finish with ascending bars.
        while (!stack.isEmpty())
        {
            int p = stack.pop();
            int h = height[p];
            int w = stack.isEmpty() ? i : i - stack.peek() - 1;
            max = Math.max(h * w, max);
        }

        return max;
    }

    public static void main(String[] args)
    {
        int[] nums = {1, 2, 5, 6, 2, 3};
        System.out.println(largestRectangleArea(nums));
    }
}
