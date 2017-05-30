package sorting;

/**
 * Logic (Worst-case and average complexity : О(n2))
 * 
 * @1. foundMinAt=0. scan from 0 to n-1 and find smallest index
 *     it will be foundMinAt swap arr[startFrom]=arr[foundMinAt]
 * @2. now start again from next unsorted position startFrom+1 and do
 *     above steps
 * 
 * */

public class SelectionSort {

	public static void main(String[] args) {

		int[] input = { 4, 2, 9, 6, 23, 12, 34, 0, 1 };

		int size = input.length;
		print(input);
		int startFrom = 0;
		while (size>0) {
			int foundMinAt = startFrom;
			for (int i = startFrom + 1; i < input.length; i++) {
				if (input[i] < input[foundMinAt]) {
					foundMinAt = i;
				}
				
			}
			if (foundMinAt != startFrom) {
				swapNumbers(startFrom, foundMinAt, input);
			}
			startFrom++;
			size--;
		}
		print(input);
	}

	public static void swapNumbers(int i, int j, int[] array) {
		int temp;
		temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}

	public static void print(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println(" ");
	}

}
