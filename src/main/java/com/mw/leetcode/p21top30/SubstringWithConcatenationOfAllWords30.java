package com.mw.leetcode.p21top30;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubstringWithConcatenationOfAllWords30
{
    public static List<Integer> findSubstring(String s, String[] words)
    {
        List<Integer> result = new ArrayList<>();
        if (words.length == 0)
        {
            return result;
        }

        //Construct dictionary.
        Map<String, Integer> dictionary = new HashMap<>(words.length);
        for (int i = 0; i < words.length; i++)
        {
            dictionary.put(words[i], dictionary.get(words[i]) == null ? 1 : dictionary.get(words[i]) + 1);
        }

        int len = words[0].length();

        for(int j=0; j<len; j++){ // loop word length * n times
            HashMap<String, Integer> currentMap = new HashMap<String, Integer>();
            int start = j;//start index of start
            int count = 0;//count totoal qualified words so far

            for(int i=j; i<=s.length()-len; i=i+len){
                String sub = s.substring(i, i+len);
                if(dictionary.containsKey(sub)){
                    //set frequency in current map
                    if(currentMap.containsKey(sub)){
                        currentMap.put(sub, currentMap.get(sub)+1);
                    } else {
                        currentMap.put(sub, 1);
                    }

                    count++;

                    // If not match, move one word forward.
                    while(currentMap.get(sub)>dictionary.get(sub)){
                        String left = s.substring(start, start+len);
                        currentMap.put(left, currentMap.get(left)-1);

                        count--;
                        start = start + len;
                    }

                    // If match, save and move one word forward.
                    if(count==words.length){
                        result.add(start); //add to result

                        //shift right and reset currentMap, count & start point
                        String left = s.substring(start, start+len);
                        currentMap.put(left, currentMap.get(left)-1);
                        count--;
                        start = start + len;
                    }
                }else{
                    currentMap.clear();
                    start = i+len;
                    count = 0;
                }
            }
        }

        return result;
    }

    public static void main(String[] args)
    {

        String s = "lingmindraboofooowingdingbarrwingmonkeypoundcake";
        String[] match = {"fooo", "barr", "wing", "ding", "wing"};
//        String s= "wordgoodgoodgoodbestword";
//        String[] match = {"word","good","best","good"};
        for (int i : findSubstring(s, match))
        {
            System.out.println(i);
        }
    }
}
