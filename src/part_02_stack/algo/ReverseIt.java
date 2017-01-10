package part_02_stack.algo;

import java.util.Stack;

public class ReverseIt {

	public static void main(String[] args) {

		String input = "My name is Mithlesh Singh";
		System.out.println("Original : " + input);
		StringBuilder output = new StringBuilder();
		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < input.length(); i++) {
			stack.push(input.charAt(i));
		}

		while (!stack.isEmpty()) {
			output.append(stack.pop());
		}

		System.out.println("Reverse : " + output.toString());
	}

}
