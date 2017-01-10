package part_02_stack.algo;

import java.util.Stack;

public class NextGreaterElement {

	static Stack<Integer> stack = new Stack<Integer>();

	public static void main(String[] args) {

		Integer[] input = { 4, 5, 2, 25 };
		printNGE(input);
	}

	public static void printNGE(Integer[] input) {

		stack.push(input[0]);

		for (int i = 1; i < input.length; i++) {

			int next = input[i];

			if (!stack.isEmpty()) {

				int element = stack.pop();

				while (element < next) {
					System.out.println(element + " ---> " + next);
					if (stack.isEmpty())
						break;
					element = stack.pop();
				}

				if (element > next) {
					stack.push(element);
				}
			}

			stack.push(next);
		}

		while (!stack.isEmpty()) {
			int element = stack.pop();
			int next = -1;
			System.out.println(element + " ---> " + next);
		}
	}

}
