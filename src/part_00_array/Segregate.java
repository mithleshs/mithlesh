package part_00_array;

/**
 * Segregate 0s and 1s in an array You are given an array of 0s and 1s in random
 * order. Segregate 0s on left side and 1s on right side of the array. Traverse
 * array only once.
 **/

/**
 * Maintain two indexes. Initialize first index left as 0 and second index right
 * as n-1.
 * 
 * Do following while left < right a) Keep incrementing index left while there
 * are 0s at it b) Keep decrementing index right while there are 1s at it c) If
 * left < right then exchange arr[left] and arr[right]
 **/

public class Segregate {

	public static void main(String[] args) {

		int[] temp = { 0, 1, 0, 1, 0, 0, 1, 1, 1, 0 };
		int left = 0;
		int right = temp.length - 1;
		print(temp);

		while (left < right) {
			while (temp[left] == 0) {
				left++;
			}

			while (temp[right] == 1) {
				right--;
			}

			if (left < right) {
				temp[left] = 0;
				temp[right] = 1;
				left++;
				right--;
			}
		}

		print(temp);

	}

	public static void print(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println(" ");
	}

}
