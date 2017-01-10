package part_02_stack.algo;

import java.util.Stack;

public class RecursionSortStack {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(30);
		stack.push(-5);
		stack.push(17);
		stack.push(13);
		stack.push(-3);

		sort(stack);
		System.out.println(stack);
	}

	public static void sort(Stack<Integer> stack) {
		if (!stack.isEmpty()) {
			int temp = stack.pop();
			sort(stack);
			insertSorted(stack, temp);
		}
	}

	public static void insertSorted(Stack<Integer> stack, int item) {
		if (stack.isEmpty() || item > stack.peek()) {
			stack.push(item);
			return;
		}
		int temp = stack.pop();
		insertSorted(stack, item);
		stack.push(temp);
	}

}
