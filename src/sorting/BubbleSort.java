package sorting;

/**
 * Logic (Worst-case and average complexity : О(n2))
 * 
 * @1. compare element with index 0 and 1 if arr[0]>arr[1] then swap else choose
 *     next two pair of elements
 * @2. now compare 1 and 2 if() arr[1]>arr[2] then swap ...repeat it till end
 * @3. now last element is sorted we dont have to include it again in second
 *     iteration
 * @4. now repat above step till size-1,size-2,size-3.....size-n.
 * */
public class BubbleSort {

	public static void main(String[] args) {

		int[] input = { 4, 2, 9, 6, 23, 12, 34, 0, 1 };

		int size = input.length;
		print(input);
		while (size > 1) {
			for (int i = 0; i < size - 1; i++) {
				int current = input[i];
				int next = input[i + 1];

				if (current > next) {
					swapNumbers(i, i + 1, input);
				}
			}
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
