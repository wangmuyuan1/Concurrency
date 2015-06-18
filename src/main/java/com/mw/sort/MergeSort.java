package com.mw.sort;

public class MergeSort {
	
	public static void sortAndPrint(int[] array)
	{
		System.out.println("Before: ");
		for (int value : array)
		{
			System.out.print(value + " ");
		}
		
		int[] result = sort(array, 0, array.length - 1);
		
		System.out.println("\nAfter: ");
		for (int value : result)
		{
			System.out.print(value + " ");
		}
	}
	
	private static int[] sort(int[] array, int start, int end)
	{
		int length = end - start + 1;
		int[] result = new int[length];
		int[] left = new int[length / 2];
		int[] right = new int[length - length / 2];
		
		if (start != end)
		{
			left = sort(array, start, start + length / 2 - 1);
			right = sort(array, start + length / 2, end);
		}
		else
		{
			result[0] = array[start];
			return result;
		}
		
		int li = 0;
		int ri = 0;
		int count = 0;
		while (li < left.length && ri < right.length)
		{
			if (left[li] <= right[ri])
			{
				result[count] = left[li];
				li++;
			}
			else
			{
				result[count] = right[ri];
				ri++;
			}
			count++;
		}
		
		if (li < left.length)
		{
			System.arraycopy(left, li, result, count, left.length - li);
		}
		else
		{
			System.arraycopy(right, ri, result, count, right.length - ri);
		}
		
		return result;
	}
	
	public static void main(String[] args)
	{
		int[] array = {85, 86, 38, 7, 9, 26, 41, 46, 72, 15};
		sortAndPrint(array);
	}
}
