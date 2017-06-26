package amazing;

import java.util.ArrayList;
import java.util.List;

public class PairWithGivenProduct {

	static List<Integer> tmpList = new ArrayList<Integer>();

	public static void main(String[] args) {

		int arr[] = { 10, 20, 9, 40 };
		int x = 400;
	}

	/**
	 * Efficient Solution ( O(n) ): We can improve time complexity to O(n) using
	 * hashing. Below are steps.
	 * 
	 * Create an empty hash table Traverse array elments and do following for
	 * every element arr[i]. If arr[i] is 0 and x is also 0, return true, else
	 * ignore arr[i]. If x % arr[i] is 0 and x/arr[i] exists in table, return
	 * true. Insert arr[i] into the hash table. Return false
	 **/

	static boolean isProduct(int arr[], int x) {
		int n = arr.length;
		for (int i = 0; i < n; i++) {
			if (arr[i] == 0 && x == 0)
				return true;
			if (x % arr[i] == 0) {
				if (tmpList.contains(x / arr[i])) {
					return true;
				}
				tmpList.add(x / arr[i]);
			}
		}
		return false;
	}

}
