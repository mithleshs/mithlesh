package part_02_stack.algo;

import java.util.Stack;

public class ParenthesesBalance {

	static Stack<Character> stack = new Stack<Character>();

	public static void main(String[] args) {

		String input = "[[()]]";

		System.out.println("Is Balanced : "+isBalanced(input));
	}

	public static boolean isBalanced(String input) {

		for (int i = 0; i < input.length(); i++) {
			char current = input.charAt(i);

			if (current == '(' || current == '[' || current == '{') {
				stack.push(current);
			} else if (current == ')' || current == ']' || current == '}') {
				if (!stack.isEmpty()) {
					char topChar = stack.peek();
					if ((topChar == '(' && current == ')')
							|| (topChar == '[' && current == ']')
							|| (topChar == '{' && current == '}')) {
						stack.pop();
					} else
						return false;
				} else
					return false;
			}
		}

		if (stack.isEmpty())
			return true;
		else
			return false;
	}

}
