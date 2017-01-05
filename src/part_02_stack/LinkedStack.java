package part_02_stack;

import part_01_linkedList.LinkedList;

public class LinkedStack {

	LinkedList list = new LinkedList();

	public void push(int data) {
		list.add(data);
		System.out.println("Pushed : " + data);
	}

	public int pop() {
		int data = 0;
		if (!isEmpty()) {
			data = list.removeFirst().getData();
			System.out.println("Poped : " + data);
		}
		return data;
	}

	public int peek() {
		int data = list.head.getData();
		System.out.println("Top : " + data);
		return data;
	}

	public int getSize() {
		return list.getSize();
	}

	public boolean isEmpty() {
		return list.head == null;
	}

	public static void main(String[] args) {

		LinkedStack stack = new LinkedStack();
		
		stack.push(12);
		stack.push(10);
		stack.push(14);
		stack.push(18);
		stack.push(20);

		stack.pop();
		stack.pop();
		stack.pop();
		stack.pop();

		stack.peek();
	}

}
