package com.mw.string.substring;

public class BMSubString {
	
	public static void subString(char[] s, char[] w)
	{
		int[] mov = new int[w.length];
		mov[0] = -1;
		int start = 0;
		for (int i = 0; i < w.length; i++)
		{
			if (w[i] != w[0])
			{
				if (start < 1) 
				{
					mov[i] = 0;
				}
				else
				{
					mov[i] = mov[i - 1] + 1;
					if (w[i] != w[i - start])
					{
						start = 0;
					}
				}
			}
			else
			{
				start = i;
			}
		}
		
		for (int i : mov)
		{
			System.out.print(i);
		}
		
		int substart = 0;
		int len = 0;
		int n = w.length - 1;
		int m = w.length - 1;
		for (; m >=0 && n < s.length; )
		{
			if (s[n] != w[m])
			{
				int bad = m - mov[m];
				n = n + bad;
				m = w.length - 1;
			}
			else
			{
				m--;
				if (m >= 0)
				{
					n--;
				}
				else
				{
					break;
				}
			}
		}
		
		if (m < 0)
			System.out.println("start = " + n);
	}
	
	public static void main(String[] args)
	{
		subString("ABC ABCDAB ABCDABCDABDE".toCharArray(), "ABCDABD".toCharArray());
	}
}
