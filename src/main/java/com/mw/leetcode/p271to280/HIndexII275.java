package com.mw.leetcode.p271to280;

/**
 * Created by mwang on 08/05/2016.
 */
public class HIndexII275
{
    public int hIndex(int[] citations)
    {
        int left=0;
        int len = citations.length, right= len-1,  mid;
        while(left<=right)
        {
            mid=left+ (right-left)/2;
            if(citations[mid] >= (len-mid)) right = mid - 1;
            else left = mid + 1;
        }
        return len - left;
    }

    public static void main(String[] args)
    {
        int[] citations = {0, 5, 5, 5, 5};
        HIndexII275 app = new HIndexII275();
        System.out.println(app.hIndex(citations));
    }
}
