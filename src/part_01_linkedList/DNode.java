package part_01_linkedList;

public class DNode {

	DNode next;
	DNode prev;
	int data;

	public DNode(DNode next, DNode prev, int data) {
		super();
		this.next = next;
		this.prev = prev;
		this.data = data;
	}

	public DNode(int data) {
		super();
		this.data = data;
	}

	public DNode getNext() {
		return next;
	}

	public void setNext(DNode next) {
		this.next = next;
	}

	public DNode getPrev() {
		return prev;
	}

	public void setPrev(DNode prev) {
		this.prev = prev;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

}
