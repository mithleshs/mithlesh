package part_00_array;

/*Given an array A[] and a number x, check for pair in A[] with sum as x

 METHOD 1 (Use Sorting)

 Algorithm:

 hasArrayTwoCandidates (A[], ar_size, sum)
 1) Sort the array in non-decreasing order.
 2) Initialize two index variables to find the candidate 
 elements in the sorted array.
 (a) Initialize first to the leftmost index: l = 0
 (b) Initialize second  the rightmost index:  r = ar_size-1
 3) Loop while l < r.
 (a) If (A[l] + A[r] == sum)  then return 1
 (b) Else if( A[l] + A[r] <  sum )  then r++
 (c) Else l--    
 4) No candidates in whole array - return 0*/

public class CheckForPair {

	public static void main(String[] args) {

		int temp[] = { -8, 4, 1, 10, 6, 45 };

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

		int isFound = checkForPairMethod1(temp, 5);
		if (isFound == 1) {
			System.out.println("Found ...");
		} else {
			System.out.println("Not Found ...");
		}

	}

	public static int checkForPairMethod1(int temp[], int findPairFor) {
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

/*	METHOD 2 (Use Hash Map)
	
	This method works in O(n) time if range of numbers is known.
	Let sum be the given sum and A[] be the array in which we need to find pair.

	1) Initialize Binary Hash Map M[] = {0, 0, ...}
	2) Do following for each element A[i] in A[]
	   (a)	If M[x - A[i]] is set then print the pair (A[i], x - A[i])
	   (b)	Set M[A[i]]*/
	
	static void checkForPairMethod2(int arr[], int sum) {
		// Declares and initializes the whole array as false
		boolean[] binmap = new boolean[10000];

		for (int i = 0; i < arr.length; ++i) {
			int temp = sum - arr[i];

			// checking for condition
			if (temp >= 0 && binmap[temp]) {
				System.out.println("Pair with given sum " + sum + " is ("
						+ arr[i] + ", " + temp + ")");
			}
			binmap[arr[i]] = true;
		}
	}

	public static void swapNumbers(int i, int j, int temp[]) {
		int tempC = temp[i];
		temp[i] = temp[j];
		temp[j] = tempC;
	}
}
