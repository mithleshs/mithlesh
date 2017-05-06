package part_00_array;

/*Program for array rotation
 Write a function rotate(ar[], d, n) that rotates arr[] of size n by d elements.
 */
public class RotateArray {

	public static void main(String[] args) {

		int[] temp = { 1, 2, 3, 4, 5, 6 };
		int rotation=3;
		
		int gcd=GCD(rotation, temp.length);
		System.out.println(gcd);
	}

	/*
	 * METHOD 1 (Use temp array)
	 * 
	 * Input arr[] = [1, 2, 3, 4, 5, 6, 7], d = 2, n =7 1) Store d elements in a
	 * temp array temp[] = [1, 2] 2) Shift rest of the arr[] arr[] = [3, 4, 5,
	 * 6, 7, 6, 7] 3) Store back the d elements arr[] = [3, 4, 5, 6, 7, 1, 2]
	 * Time complexity O(n) Auxiliary Space: O(d)
	 */

	/*
	 * Time complexity: O(n*d) Auxiliary Space: O(1)
	 */

	public static void rotateBy(int temp[], int rotationD) {

		while (rotationD > 0) {
			int first = temp[0];
			for (int i = 0; i < temp.length - 1; i++) {
				temp[i] = temp[i + 1];
			}
			temp[temp.length - 1] = first;
			rotationD--;
		}

	}

	public static int GCD(int a, int b) {
		if (b == 0)
			return a;
		else
			return GCD(b, a % b);
	}
}
