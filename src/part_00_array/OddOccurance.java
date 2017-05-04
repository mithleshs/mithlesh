package part_00_array;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/*Find the Number Occurring Odd Number of Times
 Given an array of positive integers. 
 All numbers occur even number of times except one number which occurs odd number of times. 
 Find the number in O(n) time & constant space.*/
public class OddOccurance {

	public static void main(String[] args) {

		int[] temp = { 1, 2, 3, 2, 3, 1, 3 };

		int founded = method3(temp);

		if (founded != -1) {
			System.out.println("Founded : " + founded);
		} else {
			System.out.println("NONE");
		}

	}

	/*
	 * A Simple Solution is to run two nested loops. The outer loop picks all
	 * elements one by one and inner loop counts number of occurrences of the
	 * element picked by outer loop. Time complexity of this solution is O(n2).
	 */
	public static int method1(int temp[]) {

		for (int i = 0; i < temp.length; i++) {

			int count = 0;
			int founded = temp[i];
			for (int j = 0; j < temp.length; j++) {

				if (temp[j] == founded) {
					count++;
				}
			}

			if ((count % 2) != 0) {
				return founded;
			}
		}
		return -1;
	}

	/*
	 * A Better Solution is to use Hashing. Use array elements as key and their
	 * counts as value. Create an empty hash table. One by one traverse the
	 * given array elements and store counts. Time complexity of this solution
	 * is O(n). But it requires extra space for hashing.
	 */
	public static int method2(int temp[]) {

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < temp.length; i++) {
			if (map.containsKey(temp[i])) {
				map.put(temp[i], map.get(temp[i]) + 1);
			} else {
				map.put(temp[i], 1);
			}
		}

		Iterator<Entry<Integer, Integer>> it = map.entrySet().iterator();

		while (it.hasNext()) {
			Entry<Integer, Integer> entry = it.next();
			int key = entry.getKey();
			int count = entry.getValue();

			if ((count % 2) != 0) {
				return key;
			}

		}
		return -1;
	}

	/*
	 * The Best Solution is to do bitwise XOR of all the elements. XOR of all
	 * elements gives us odd occurring element. Please note that XOR of two
	 * elements is 0 if both elements are same and XOR of a number x with 0 is
	 * x.Time Complexity: O(n)
	 */
	public static int method3(int temp[]) {
		int res = 0;
		for (int i = 0; i < temp.length; i++) {
			res = res ^ temp[i];
		}
		return res;
	}
}
