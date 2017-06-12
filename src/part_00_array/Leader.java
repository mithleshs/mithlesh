package part_00_array;

/**
 * Write a program to print all the LEADERS in the array. An element is leader
 * if it is greater than all the elements to its right side. And the rightmost
 * element is always a leader. For example int the array {16, 17, 4, 3, 5, 2},
 * leaders are 17, 5 and 2.
 **/
public class Leader {

	public static void main(String[] args) {

		int[] temp = { 16, 17, 4, 3, 5, 2 };// leaders are 17, 5 and 2.
		findLeaders2(temp);
	}

	/* Time Complexity: O(n2) */
	public static void findLeaders1(int[] temp) {
		for (int i = 0; i < temp.length; i++) {
			int checkFor = temp[i];
			boolean isLeader = true;
			for (int j = i + 1; j < temp.length; j++) {
				if (checkFor < temp[j]) {
					isLeader = false;
					break;
				}
			}
			if (isLeader) {
				System.out.println("Leader is :" + checkFor);
			}
		}
	}

	/* Time Complexity: O(n) */
	public static void findLeaders2(int[] temp) {
		int maxFormRight = 0;
		for (int i = temp.length - 1; i >= 0; i--) {
			if (temp[i] > maxFormRight) {
				maxFormRight = temp[i];
				System.out.println("Leader is :" + maxFormRight);
			}
		}
	}

}
