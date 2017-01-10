package part_02_stack.algo;

import java.util.Stack;

public class RecursionStackReverse {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);

		reverse(stack);
		System.out.println(stack);
	}

	public static void reverse(Stack<Integer> stack) {

		if (!stack.isEmpty()) {
			int temp = stack.pop();
			reverse(stack);
			insertAtBottom(stack, temp);
		}
	}

	public static void insertAtBottom(Stack<Integer> stack, int item) {

		if (stack.isEmpty()) {
			stack.push(item);
		} else {
			int temp = stack.pop();
			insertAtBottom(stack, item);

			stack.push(temp);
		}
	}

}
