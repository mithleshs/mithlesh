package part_01_linkedList;

public class DoublyLinkedList {

	DNode head;
	int size = 0;

	public static void main(String[] args) {

		DoublyLinkedList list = new DoublyLinkedList();
		list.add(12);
		list.add(13);
		list.add(1);
		list.add(14);
		list.add(2);

		printList(list);
	}

	public void add(int data) {

		DNode node = new DNode(data);
		node.next = head;
		node.prev = null;
		if (head != null)
			head.prev = node;
		head=node;
		size++;
	}

	public static void printList(DoublyLinkedList list) {

		DNode tempHead = list.head;
		while (tempHead != null) {
			System.out.print(tempHead.data + " ");
			tempHead = tempHead.next;
		}
		System.out.println("");
	}
}
