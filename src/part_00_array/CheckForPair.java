package part_00_array;

/*Given an array A[] and a number x, check for pair in A[] with sum as x
 */

public class CheckForPair {

	public static void main(String[] args) {

		int temp[] = { -8, 4, 1, 10, 6, 45 };

		int isFound = checkForPairMethod1(temp, 5);
		if (isFound == 1) {
			System.out.println("Found ...");
		} else {
			System.out.println("Not Found ...");
		}
	}

	/*
	 * METHOD 1 (Use Sorting)
	 * 
	 * Algorithm:
	 * 
	 * hasArrayTwoCandidates (A[], ar_size, sum) 1) Sort the array in
	 * non-decreasing order. 2) Initialize two index variables to find the
	 * candidate elements in the sorted array. (a) Initialize first to the
	 * leftmost index: l = 0 (b) Initialize second the rightmost index: r =
	 * ar_size-1 3) Loop while l < r. (a) If (A[l] + A[r] == sum) then return 1
	 * (b) Else if( A[l] + A[r] < sum ) then r++ (c) Else l-- 4) No candidates
	 * in whole array - return 0
	 */
	public static int checkForPairMethod1(int temp[], int findPairFor) {

		// Sort it by using Bubble sort
		int size = temp.length;

		while (size > 1) {
			for (int i = 0; i < size - 1; i++) {
				int current = temp[i];
				int next = temp[i + 1];

				if (current > next) {
					swapNumbers(i, i + 1, temp);
				}
			}
			size--;
		}

		int leftIn = 0;
		int rightIn = temp.length - 1;

		while (leftIn < rightIn) {
			int sum = temp[leftIn] + temp[rightIn];
			if (sum == findPairFor) {
				return 1;
			} else if (sum > findPairFor) {
				rightIn--;
			} else {
				leftIn++;
			}
		}
		return 0;
	}

	public static void swapNumbers(int i, int j, int temp[]) {
		int tempC = temp[i];
		temp[i] = temp[j];
		temp[j] = tempC;
	}
}
