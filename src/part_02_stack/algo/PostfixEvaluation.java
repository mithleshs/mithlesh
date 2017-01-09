package part_02_stack.algo;

import java.util.Stack;

public class PostfixEvaluation {

	static Stack<Integer> stack = new Stack<Integer>();

	public static void main(String[] args) {
		String input="231*+9-";
		for(int i=0;i<input.length();i++){
			char current=input.charAt(i);
			if(Character.isDigit(current)){
				stack.push(new Integer(String.valueOf(current)));
			}else{
				int a = 0,b = 0;
				if(!stack.isEmpty()){
					b=stack.pop();
				}
				if(!stack.isEmpty()){
					a=stack.pop();
				}
				cal(a, b, current);
			}
		}
		
		System.out.println("Final answer is : "+stack.peek());
	}

	public static void cal(int a, int b, char operator) {
		int result = 0;
		if (operator == '+') {
			result = a + b;
		} else if (operator == '-') {
			result = a - b;
		} else if (operator == '*') {
			result = a * b;
		} else {
			result = a / b;
		}
		
		stack.push(result);
	}

}
