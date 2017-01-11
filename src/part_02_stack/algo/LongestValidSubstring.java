package part_02_stack.algo;

import java.util.Stack;

public class LongestValidSubstring {

	static Stack<Character> stack = new Stack<Character>();

	public static void main(String[] args) {

		String input = "()(()))))";
		int count = 0;
		for (int i = 0; i < input.length(); i++) {

			char current=input.charAt(i);
			if(current=='(' ){
				stack.push(current);
				count++;
			}
			else if(current==')' && !stack.isEmpty() && stack.peek()=='('){
				count++;;
				stack.pop();
			}
			
		}
		
		while(!stack.isEmpty()){
			count--;;
			stack.pop();
		}
		System.out.println(count);
	}

}
