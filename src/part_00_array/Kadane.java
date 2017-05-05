package part_00_array;

/*Largest Sum Contiguous Subarray
 Write an efficient C program to find the sum of contiguous subarray within a one-dimensional array of numbers which has the largest sum.
 */
public class Kadane {

	public static void main(String[] args) {

		int[] temp = { -2, -3, 4, -1, -2, 1, 5, -3 };

		int maxSubArrSum = maxSubArraySum(temp);
		System.out.println(maxSubArrSum);
	}

	/*
	 * Kadane’s Algorithm:
	 * 
	 * Initialize: max_so_far = 0 max_ending_here = 0
	 * 
	 * Loop for each element of the array (a) max_ending_here = max_ending_here
	 * + a[i] (b) if(max_ending_here < 0) max_ending_here = 0 (c) if(max_so_far
	 * < max_ending_here) max_so_far = max_ending_here return max_so_far
	 */

	public static int maxSubArraySum(int[] temp) {
		int max_so_far = 0;
		int max_ending_here = 0;
		int startIn=0;
		int endIn=0;
		int s=0;
		for (int i = 0; i < temp.length; i++) {

			max_ending_here += temp[i];
			if (max_ending_here > max_so_far) {
				max_so_far = max_ending_here;
				startIn=s;
				endIn=i;
			}

			if (max_ending_here < 0) {
				max_ending_here = 0;
				s=i+1;
			}
		}
		
		System.out.println("SUBARRAY is from "+startIn+" to "+endIn);
		return max_so_far;
	}

}
