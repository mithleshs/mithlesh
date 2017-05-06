package part_00_array;

/*Write a program to reverse an array or string
 We are given an array (or string), the task is to reverse the array.*/
public class ReversArray {

	public static void main(String[] args) {

		int[] temp = { 1, 2, 3 };
		recursiveWay(0, temp.length - 1, temp);
		System.out.println();
	}

	public static void method1(int temp[]) {

		int[] tempC = new int[temp.length];
		for (int i = 0; i < temp.length; i++) {
			tempC[i] = temp[temp.length - 1 - i];
		}
		System.out.println();
	}

	/*
	 * Iterative way: Time Complexity: O(n) 1) Initialize start and end indexes.
	 * start = 0, end = n-1 2) In a loop, swap arr[start] with arr[end] and
	 * change start and end as follows. start = start +1; end = end – 1
	 */
	public static void method2(int temp[]) {
		int start = 0;
		int end = temp.length - 1;
		while (start < end) {
			int t = temp[start];
			temp[start] = temp[end];
			temp[end] = t;
			start++;
			end--;
		}
		System.out.println();
	}

	/*
	 * Recursive Way: Time Complexity: O(n) 1) Initialize start and end indexes
	 * start = 0, end = n-1 2) Swap arr[start] with arr[end] 3) Recursively call
	 * reverse for rest of the array.
	 */

	public static void recursiveWay(int start, int end, int temp[]) {
		if (start >= end) {
			return;
		}

		int t = temp[start];
		temp[start] = temp[end];
		temp[end] = t;
		recursiveWay(start + 1, end - 1, temp);
	}
}
