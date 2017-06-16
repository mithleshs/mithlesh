package part_02_stack.algo;

import java.io.IOException;
import java.util.Stack;

public class InfixToSuffix {

	static Stack<Character> stack = new Stack<Character>();

	public static void main(String argv[]) throws IOException {
		String infix = "a+b*(c+d)";
		System.out.println("The expression in postfix is:" + toPostfix(infix));
	}

	/**Algorithm
	1. Scan the infix expression from left to right.
	2. If the scanned character is an operand, output it.
	3. Else,
	…..3.1 If the precedence(scanned operator)> precedence(operator in the stack)(or the stack is empty) and stack top not is '(', push it.
	…..3.2 Else, Pop the operator from the stack until the precedence of the scanned operator is less-equal to the precedence of the operator residing on the top of the stack. 
	Push the scanned operator to the stack.
	4. If the scanned character is an ‘(‘, push it to the stack.
	5. If the scanned character is an ‘)’, pop and output from the stack until an ‘(‘ is encountered.
	6. Repeat steps 2-6 until infix expression is scanned.
	7. Pop and output from the stack until it is not empty.
	**/
	
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
				stack.pop(); // Because  parenthesis are not required in postfix
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
