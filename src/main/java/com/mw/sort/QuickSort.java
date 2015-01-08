package com.mw.sort;

public class QuickSort {
	
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
	
	public static int[] sort(int[] array, int start, int end)
	{
		if (end <= start)
		{
			return array;
		}
		
		int length = end - start + 1;
		int p = length / 2;
		int s = start;
		int pivot = array[start + p];
		
		swap(array, start + p, end);
		
		for (int i = start; i < end; i++)
		{
			if (array[i] < pivot)
			{
				swap(array, i, s);
				s++;
			}
		}
		
		swap(array, end, s);
		
		if (s - 1 > start)
		{
			sort(array, start, s - 1);
		}
		if (end > s + 1)
		{
			sort(array, s + 1, end);
		}
		
		return array;
	}
	
	private static final void swap(int[] array, int a, int b)
	{
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}
	
	public static void main(String[] args)
	{
		int[] array = {85, 86, 38, 7, 9, 26, 41, 46, 72, 15};
		sortAndPrint(array);
	}
}
