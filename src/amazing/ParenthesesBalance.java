package amazing;

import java.util.HashMap;
import java.util.Stack;

public class ParenthesesBalance {

	private final static HashMap<Character, Character> parenthesis = new HashMap<Character, Character>();
	
	static {
		parenthesis.put('(', ')');
		parenthesis.put('<', '>');
		parenthesis.put('{', '}');
		parenthesis.put('[', ']');
	}

	public static void main(String[] args) {

		String input = "[[()]]";

		System.out.println("Is Balanced : " + isBalanced(input));
	}

	static public boolean isBalanced(String str) {

		Stack<Character> stack = new Stack<Character>();

		for (Character c : str.toCharArray()) {
			if (parenthesis.containsKey(c)) {
				stack.push(c);
			} else {
				if ( stack.isEmpty() || parenthesis.get(stack.pop()) != c)
					return false;
			}
		}

		if (stack.isEmpty())
			return true;
		return false;

	}
}
