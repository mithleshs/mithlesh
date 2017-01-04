package part_02_stack;

public class ArrayStack {

	int top = -1;
	int a[] = null;

	public ArrayStack(int size) {
		super();
		a = new int[size];
	}

	public boolean isFull() {
		return top == a.length - 1;
	}

	public boolean isEmpty() {
		return top == -1;
	}

	public void push(int data) {
		if (!isFull()) {
			a[top + 1] = data;
			top++;
			System.out.println("Pushed : "+data);
		}
	}

	public int pop() {
		int data = 0;
		if (!isEmpty()) {
			data = a[top];
			a[top] = 0;
			top--;
			System.out.println("Poped : "+data);
		}
		return data;
	}

	public int peek() {
		int data = 0;
		if (!isEmpty()) {
			data = a[top];
		}
		System.out.println("Top is : "+data);
		return data;
	}

	public void printStack() {

	}

	public int size() {
		return a.length;
	}
	
	public static void main(String[] args) {

		ArrayStack stack=new ArrayStack(10);
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
