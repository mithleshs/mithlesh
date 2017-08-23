package amazing;

/*given a stream of natural numbers , 

 and a array J contains integers in increasing orders 
 operations performed J = [2,3,4] 
 1 2 3 4 5 6 7 8 9 10…………..27....100...1111 
 first operation 

 J[0] = 2 => remove every 2nd integer 

 now the stream is 
 1 3 5 7 … 27 
 J[1] = 3 
 remove every 3rd 
 stream is now 
 1 3 7 … 
 3rd 
 given a natural number n , find if it will survive given J, or at what index it will 
 die.
 */
public class WillItDie {

	public static void main(String[] args) {

		int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		int[] j = { 2, 3, 4 };
		int n = 9;

		willItDie(nums, j, n);
	}

	public static void willItDie(int[] nums, int[] j, int n) {
		// Find the index of n
		int nIndex = findIndex(nums, n);
		if (nIndex == -1) {
			System.out.println(true);
			return;
		}

		int jIterator = 0;
		while (jIterator < j.length) {

			int currentItNum = j[jIterator];
			if (nIndex % currentItNum == 0) {
				System.out.println("Yes, It will die at " + nIndex);
				return;
			} else {
				nIndex -= (nIndex / currentItNum);
			}
			jIterator++;
		}

		if (jIterator >= j.length) {
			System.out.println("No It Won't Die!!");
		} else
			System.out.println("Yes, It will die at " + nIndex);
	}

	private static int findIndex(int[] nums, int n) {
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == n)
				return i + 1;
		}
		return -1;
	}

}
