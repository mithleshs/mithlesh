package sorting;

/**
 * Logic (Worst-case and average complexity : О(n2))
 * 
 * @1. currentPosToSort=foundMinAt=0. scan from 0 to n-1 and find smallest index
 *     it will be foundMinAt swap arr[currentPosToSort]=arr[foundMinAt]
 * @2. now start again from next unsorted position currentPosToSort+1 and do
 *     above steps
 * 
 * */

public class SelectionSort {

	public static void main(String[] args) {

		int[] input = { 4, 2, 9, 6, 23, 12, 34, 0, 1 };

		int size = input.length;
		print(input);
		int currentPosToSort = 0;
		int loopCount = 0;
		while (currentPosToSort < size - 1) {
			int foundMinAt = currentPosToSort;
			for (int i = currentPosToSort + 1; i < size; i++) {
				if (input[i] < input[foundMinAt]) {
					foundMinAt = i;
				}
				loopCount++;
			}
			if (foundMinAt != currentPosToSort) {
				swapNumbers(currentPosToSort, foundMinAt, input);
			}
			currentPosToSort++;
		}
		print(input);
		System.out.println(loopCount);
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
