package sorting;

/**
 * Logic (Worst-case and average complexity : О(n2))
 * 
 * @1. start with first element and compare it with previous element if
 *     arr[prev] > arr[current] then swap
 * @2. increment current pointer by 1 and repeat above
 * */

public class InsertionSort {

	public static void main(String[] args) {

		int[] input = { 4, 2, 9, 6, 23, 12, 34, 0, 1 };

		int size = input.length;
		print(input);

		for (int k = 1; k < size; k++) {
			for (int m = k; m > 0; m--) {
				if (input[m] < input[m - 1]) {
					swapNumbers(m, m - 1, input);
				}
			}
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
