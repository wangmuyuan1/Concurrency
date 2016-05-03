package com.mw.leetcode.p221top230;

import com.mw.ProjectUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mwang on 03/05/2016.
 */
public class SummaryRange228
{
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        if (nums.length == 0)
            return result;

        int cur = 0;
        while (cur < nums.length)
        {
            int i = cur;
            StringBuilder sb = new StringBuilder().append(nums[i]);
            while (i < nums.length - 1 && nums[i + 1] == nums[i] + 1)
                i++;

            if (i > cur) sb.append("->").append(nums[i]);

            result.add(sb.toString());
            cur = i + 1;
        }
        return result;
    }

    public static void main(String[] args)
    {
        int[] nums = {0,1,2,4,5,7};
        SummaryRange228 app = new SummaryRange228();
        ProjectUtil.printList(app.summaryRanges(nums));
    }
}
