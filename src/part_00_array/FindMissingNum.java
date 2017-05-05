package part_00_array;

/*Find the Missing Number
 You are given a list of n-1 integers and these integers are in the range of 1 to n. 
 There are no duplicates in list. One of the integers is missing in the list. 
 Write an efficient code to find the missing integer.
 */
public class FindMissingNum {

	public static void main(String[] args) {

		int temp[] = { 1, 2, 4, 6, 3, 7, 8 };

		int missingNumIs = method1(temp);
		System.out.println(missingNumIs);

	}

	/*
	 * METHOD 1(Use sum formula) Time : o(n) Algorithm:
	 * 
	 * 1. Get the sum of numbers total = n*(n+1)/2 2 Subtract all the numbers
	 * from sum and you will get the missing number.
	 * 
	 * In above formula we have to add +1 more because one element is missing so
	 * (n+1)*(n+2)/2;
	 */

	public static int method1(int temp[]) {
		int n = temp.length;
		int total = (n + 1) * (n + 2) / 2;

		for (int i = 0; i < n; i++) {
			total = total - temp[i];
		}
		return total;
	}

	/*
	 * METHOD 2(Use XOR) Time : o(n) but better than method1 because in above
	 * method it canbe integer overflow error may be occur
	 * 
	 * 1) XOR all the array elements, let the result of XOR be X1. 2) XOR all
	 * numbers from 1 to n, let XOR be X2. 3) XOR of X1 and X2 gives the missing
	 * number.
	 */
	public static int method2(int temp[]) {
		int n = temp.length;
		int x1 = temp[0]; // x1 will be result of XOR of all elements in given
							// array
		int x2 = 1; // x2 will be result of XOR of all elements from 1 to n+1
					// outside array because one element is missing so added +1

		for (int i = 1; i < n; i++) {
			x1 = x1 ^ temp[i];
		}

		for (int i = 2; i < n + 1; i++) {
			x2 = x2 ^ i;
		}

		return x1 ^ x2;
	}
}
