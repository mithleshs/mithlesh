package part_00_array;

/*Majority Element: A majority element in an array A[] of size n is an element that appears more than n/2 times
 *  (and hence there is at most one such element).
 */
public class MajorityElement {

	public static void main(String[] args) {

		int[] temp = { 3, 3, 4, 2, 4, 4, 2, 4, 4 };

		int founded = method3(temp);

		if (founded != -1) {
			System.out.println("Founded : " + founded);
		} else {
			System.out.println("NONE");
		}
	}

	/*
	 * METHOD 1 (Basic) The basic solution is to have two loops and keep track
	 * of maximum count for all different elements. If maximum count becomes
	 * greater than n/2 then break the loops and return the element having
	 * maximum count. If maximum count doesn’t become more than n/2 then
	 * majority element doesn’t exist.
	 * 
	 * Time Complexity: O(n*n). Auxiliary Space : O(1).
	 */

	public static int basicMethod1(int temp[]) {

		for (int i = 0; i < temp.length; i++) {

			int count = 1;
			int founded = temp[i];
			for (int j = 1; j < temp.length; j++) {

				if (temp[j] == founded) {
					count++;
				}

				if (count > temp.length / 2) {
					return founded;
				}
			}
		}
		return -1;
	}

	/*
	 * METHOD 2 (Using Binary Search Tree) Thanks to Sachin Midha for suggesting
	 * this solution. Node of the Binary Search Tree (used in this approach)
	 * will be as follows.
	 * 
	 * Time Complexity: If a binary search tree is used then time complexity
	 * will be O(n^2). If a self-balancing-binary-search tree is used then
	 * O(nlogn) Auxiliary Space: O(n)
	 */
	public static void method2() {
		// TODO : implement it using BST
	}

	/*
	 * METHOD 3 (Using Moore’s Voting Algorithm) Above algorithm loops through
	 * each element and maintains a count of a[maj_index], If next element is
	 * same then increments the count, if next element is not same then
	 * decrements the count, and if the count reaches 0 then changes the
	 * maj_index to the current element and sets count to 1. First Phase
	 * algorithm gives us a candidate element. In second phase we need to check
	 * if the candidate is really a majority element. Second phase is simple and
	 * can be easily done in O(n). We just need to check if count of the
	 * candidate element is greater than n/2.
	 */
	public static int method3(int temp[]) {

		// Phase -1

		int majIndex = 0;
		int count = 1;

		for (int i = 1; i < temp.length; i++) {
			if (temp[majIndex] == temp[i]) {
				count++;
			} else {
				count--;
			}

			if (count == 0) {
				majIndex = i;
				count = 1;
			}
		}

		// Phase -2

		count = 0;
		for (int i = 0; i < temp.length; i++) {
			if (temp[majIndex] == temp[i]) {
				count++;
			}

			if (count > temp.length / 2) {
				return temp[majIndex];
			}
		}
		return -1;

	}
}
