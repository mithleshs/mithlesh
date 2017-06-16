package part_02_stack.algo;

import java.util.LinkedList;
import java.util.Queue;

public class StackWithTwoQueue {

	static Queue<Integer> queue1 = new LinkedList<Integer>();
	static Queue<Integer> queue2 = new LinkedList<Integer>();
	int size = 0;

	public static void main(String[] args) {

		StackWithTwoQueue stack = new StackWithTwoQueue();
		stack.push(1);
		stack.push(11);
		stack.push(111);
		System.out.println(stack);
		int data = stack.pop();

		System.out.println(data);
	}

	public void push(int data) {
		queue1.add(data);
		size++;
	}

	public int pop() {
		int data = 0;
		while (queue1.size() > 1) {
			queue2.add(queue1.remove());
		}
		data = queue1.remove();
		queue1 = queue2;
		size--;
		return data;
	}

}
