package com.mw.string.substring;

public class KMPSubString {

	public static void subString(char[] s, char[] w)
	{
		int[] mov = new int[w.length];
		int la = -1;
		int k = 1;
		mov[0] = -1;
		// O(m)
		for (int i = 1; i < w.length; i++)
		{
			mov[i] = 0;
			if (w[i] == w[0])
			{
				la = i;
			}
			else if (la > 0)
			{
				mov[i] = mov[i - 1] + 1;
				if (w[i] == w[k])
				{
					la++;
					k++;
				}
				else
				{
					la = -1;
					k = 1;
				}
			}
		}
		
		for (int i : mov)
		{
			System.out.print(i);
		}
		
		
		int start = 0;
		int len = 0;
		// O(n)
		for (int i = 0, j = 0, m = 0; i < s.length && j < w.length;)
		{
			if (s[i + j] == w[j])
			{
				start = i;
				len++;
				j++;
				m++;
			}
			else
			{
				start = 0;
				len = 0;
				i = i + (m - mov[m]);
				j = 0;
				m = 0;
			}
		}
		
		System.out.println("start = " + start + ", length = " + len);
	}
	
	public static void main(String[] args)
	{
		subString("ABC ABCDAB ABCDABCDABDE".toCharArray(), "ABCDABD".toCharArray());
	}
}
