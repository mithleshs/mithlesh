package part_01_linkedList;

public class CircularSinglyLinkedList {

	Node head;
	Node tail;
	int size = 0;

	public static void main(String[] args) {

		CircularSinglyLinkedList csLL = new CircularSinglyLinkedList();
		csLL.add(12);
		csLL.add(13);
		csLL.add(14);
		csLL.add(15);

		printList(csLL);
	}

	public Node add(int data) {
		Node node = new Node(data);

		if (size == 0) {
			head = node;
			tail = node;
		} else {
			node.next = head;
			tail.next = node;
		}
		head = node;
		size++;

		return node;
	}

	public static void printList(CircularSinglyLinkedList list) {
		int count = 0;
		Node tempHead = list.head;
		while (count < list.size && tempHead != null) {
			System.out.print(tempHead.data + " ");
			tempHead = tempHead.next;
			count++;
		}
		System.out.println("");
	}

}
