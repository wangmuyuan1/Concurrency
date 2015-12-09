package com.mw.leetcode.p151to160;

public class ReverseWordsInString151
{
    public String reverseWords(String s)
    {
        String[] tmp = s.split("\\s");
        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= tmp.length; i++){
            if(tmp[tmp.length - i].equals("")){
                continue;
            }

            sb.append(tmp[tmp.length - i]);
            sb.append(" ");
        }

        return sb.toString().trim();
    }

    public static void main(String[] args)
    {
        ReverseWordsInString151 app = new ReverseWordsInString151();
        System.out.println(app.reverseWords("   a   b "));
    }
}
