package part_02_stack.algo;

import java.io.IOException;
import java.util.Stack;

public class InfixToSuffix {

	static Stack<Character> stack = new Stack<Character>();

	public static void main(String argv[]) throws IOException {
		String infix = "a+b*(c+d)";
		System.out.println("The expression in postfix is:" + toPostfix(infix));
	}

	private static String toPostfix(String infix) {
		char symbol;
		String postfix = "";

		for (int i = 0; i < infix.length(); ++i) {
			symbol = infix.charAt(i);
			if (Character.isLetter(symbol))
				postfix = postfix + symbol;
			else if (symbol == '(') {
				stack.push(symbol);
			} else if (symbol == ')')
			{
				while (stack.peek() != '(') {
					postfix = postfix + stack.pop();
				}
				stack.pop(); 
			} else
			{
				while (!stack.isEmpty() && !(stack.peek() == '(')
						&& prec(symbol) <= prec(stack.peek()))
					postfix = postfix + stack.pop();

				stack.push(symbol);
			}
		}
		while (!stack.isEmpty())
			postfix = postfix + stack.pop();
		return postfix;
	}

	static int prec(char x) {
		if (x == '+' || x == '-')
			return 1;
		if (x == '*' || x == '/' || x == '%')
			return 2;
		return 0;
	}

}
