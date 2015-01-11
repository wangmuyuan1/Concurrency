package com.mw.string;

public class FindPalindromicString {

	public static void palindromic(String s)
	{
		boolean[][] m = new boolean[s.length()][s.length()];
		
		for (int i = 0; i < s.length(); i++)
		{
			m[i][i] = true;
		}
		
		for (int i = 0; i < s.length() - 1; i++)
		{
			if (s.charAt(i) == s.charAt(i + 1)) {
				m[i][i + 1] = true;
			}
		}
		
		int longestBegin = 0;
		int maxLen = 0;
		for (int len = 3; len <= s.length(); len++) {
		    for (int i = 0; i < s.length()-len+1; i++) {
		      int j = i+len-1;
		      if (s.charAt(i) == s.charAt(j) && m[i+1][j-1]) {
		        m[i][j] = true;
		        longestBegin = i;
		        maxLen = len;
		      }
		    }
		  }
		
		System.out.println("longestBegin = " + longestBegin + " maxLen = " + maxLen);
	}
	
	public static void main(String[] args)
	{
		palindromic("cabad");
	}
}
