package part_02_stack.algo;

import java.util.Stack;

/*Algorithm
 We can use below algorithm to sort stack elements:

 sortStack(stack S)
 if stack is not empty:
 temp = pop(S);  
 sortStack(S); 
 sortedInsert(S, temp);
 Below algorithm is to insert element is sorted order:

 sortedInsert(Stack S, element)
 if stack is empty OR element > top element
 push(S, elem)
 else
 temp = pop(S)
 sortedInsert(S, element)
 push(S, temp)*/

public class SortStack {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(1);
		stack.push(0);
		stack.push(-4);
		stack.push(42);
		stack.push(-3);
		sortStack(stack);
		System.out.println(stack);
	}

	public static void sortStack(Stack<Integer> stack) {

		if (!stack.isEmpty()) {
			int item = stack.pop();
			sortStack(stack);
			sortedInsert(stack, item);
		}
	}

	public static void sortedInsert(Stack<Integer> stack, int item) {
		if (stack.isEmpty() || item >= stack.peek()) {
			stack.push(item);
		} else {
			int temp = stack.pop();
			sortedInsert(stack, item);
			stack.push(temp);
		}
	}
}
