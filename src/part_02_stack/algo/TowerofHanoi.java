package part_02_stack.algo;

import java.util.Stack;

/**
 * Iterative Algorithm:
 * 
 * @1. Calculate the total number of moves required i.e. "pow(2, n) - 1" here n
 *     is number of disks.
 * @2. If number of disks (i.e. n) is even then interchange destination pole and
 *     auxiliary pole.
 * @3. for i = 1 to total number of moves: if i%3 == 1: legal movement of top
 *     disk between source pole and destination pole if i%3 == 2: legal movement
 *     top disk between source pole and auxiliary pole if i%3 == 0: legal
 *     movement top disk between auxiliary pole and destination pole
 */
public class TowerofHanoi {

	static Stack<Integer> source = new Stack<Integer>();
	static Stack<Integer> dest = new Stack<Integer>();
	static Stack<Integer> temp = new Stack<Integer>();
	int diskSize = 0;
	static int numOfMove = 0;

	public TowerofHanoi(int diskSize) {
		this.diskSize = diskSize;
		numOfMove = (int) (Math.pow(2, diskSize) - 1);
		for (int i = diskSize; i > 0; i--) {
			source.push(i);
		}
	}

	public static void main(String[] args) {

		new TowerofHanoi(3);
		for (int i = 1; i <= numOfMove; i++) {
			if (i % 3 == 1) {
				moveDisksBetweenTwoPoles(source, dest);
			} else if (i % 3 == 2) {
				moveDisksBetweenTwoPoles(source, temp);
			} else if (i % 3 == 0) {
				moveDisksBetweenTwoPoles(dest, temp);
			}
		}

		System.out.println(dest);
	}

	public static void moveDisksBetweenTwoPoles(Stack<Integer> stack1,
			Stack<Integer> stack2) {

		Integer pol1Value = stack1.size() > 0 ? stack1.peek() : null;
		Integer pol2Value = stack2.size() > 0 ? stack2.peek() : null;

		if (pol1Value == null) {
			stack1.push(stack2.pop());
		} else if (pol2Value == null) {
			stack2.push(stack1.pop());
		} else if (pol1Value > pol2Value) {
			stack1.push(stack2.pop());
		} else {
			stack2.push(stack1.pop());
		}
	}

}
