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

		int[] array = { 4, 2, 9, 6, 23, 12, 34, 0, 1 };

		int size = array.length;
		print(array);

		for (int i = 1; i < size; i++) {
			int j = i - 1;
			int minIndex = i;
			while (j >= 0) {
				if (array[minIndex] < array[j]) {
					swap(array, minIndex, j);
					minIndex = j;
				}
				j--;
			}
		}
		
		print(array);

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
