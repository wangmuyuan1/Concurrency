package com.mw.string.substring;

public class BruteSubString {

	public static void searchSubStr(char[] s, char[] w)
	{
		//o[n - m]
		for (int i = 0; i < s.length - w.length; i++)
		{
			if (s[i] == w[0])
			{
				//o[m]
				for (int j = 0; j < w.length; j++)
				{
					if (s[i + j] != w[j])
					{
						break;
					}
					if (j == w.length - 1)
					{
						System.out.println("it is the sub string start = " + i);
						return;
					}
				}
			}
		}
		
		System.out.println("not found");
	}
	
	public static void main(String[] args)
	{
		searchSubStr("abc1234abc".toCharArray(), "234".toCharArray());
	}
}
