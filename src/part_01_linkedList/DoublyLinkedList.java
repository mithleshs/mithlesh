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
		list.addToLast(21);
		
		printList(list);
	}

	public void addToLast(int data) {
		DNode node = new DNode(null, null, data);
		if (head != null) {
			DNode last = last();
			node.prev = last;
			last.next = node;
		} else {
			head = node;
		}
		size++;
	}

	public DNode last() {
		DNode tempHead = head;
		if (tempHead == null)
			return null;
		while (tempHead != null && tempHead.next != null) {
			tempHead = tempHead.next;
		}
		return tempHead;
	}

	public DNode add(int data) {
		DNode node = new DNode(head, null, data);
		if (head != null)
			head.prev = node;
		head = node;
		size++;

		return node;
	}

	public static void printList(DoublyLinkedList list) {
		DNode tempHead = list.head;
		System.out.print("NULL ->");
		while (tempHead != null) {
			System.out.print(tempHead.data + " ->");
			tempHead = tempHead.next;
		}
		System.out.print("NULL");
		System.out.println("");
	}
}
