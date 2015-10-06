package com.mw.leetcode.p11to20;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum15
{
    public static List<List<Integer>> threeSum(int[] num)
    {
        // Start typing your Java solution below
        // DO NOT write main() function
        List<List<Integer>> res = new ArrayList<>();
        if(num.length<3) return res;

        Arrays.sort(num);
        for(int i=0;i<num.length-2;i++){
            if(i==0 || num[i]>num[i-1]){ //avoid duplicate solutions
                int j=i+1,
                    k=num.length-1;

                while(j<k){
                    if(num[j]+num[k]==-num[i]){
                        List<Integer> temp = new ArrayList<Integer>();
                        temp.add(num[i]);
                        temp.add(num[j]);
                        temp.add(num[k]);
                        res.add(temp);
                        k--;
                        j++;
                        while(k>j && num[k]==num[k+1]) k--;//avoid duplicate solutions

                        while(j<k && num[j]==num[j-1]) j++;//avoid duplicate solutions

                    }else if(num[j]+num[k]>-num[i]){
                        k--;
                    }else{
                        j++;
                    }
                }
            }
        }

        return res;
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
