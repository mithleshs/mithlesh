package part_01_linkedList;


/**
 * @author Mithlesh Singh
 * @Methods
 * 
 * @1. add(e) or addFirst(e)
 * @2. addLast(e)
 * @3. addAfter(e)
 * @3. first()
 * @4. last()
 * @5. removeFirst()
 * @6. removeLast()
 * @7. size()
 * @8. getNodeAtPosition()
 * @9. removeAt()
 * @10. reverse()
 * @11. merge(list1,list2)
 * @12. removeNode(node)
 * @11. middleNode()
 * @12. isPalindrome()
 */

public class LinkedList {

	Node head;
	int size = 0;

	public int size() {
		return size;
	}

	public static void main(String[] args) {

	}

	public static void action_pairWiseSwap() {
		LinkedList linkedList1 = new LinkedList();
		linkedList1.add(7);
		linkedList1.add(5);
		linkedList1.add(4);
		linkedList1.add(3);
		linkedList1.add(2);
		linkedList1.add(1);

		printLinkedList(linkedList1);
		linkedList1.pairWiseSwap();
		printLinkedList(linkedList1);
	}

	public static void action_removeDuplicateFromSortedList() {
		LinkedList linkedList1 = new LinkedList();

		linkedList1.add(30);
		linkedList1.add(30);
		linkedList1.add(15);
		linkedList1.add(15);
		linkedList1.add(6);
		linkedList1.add(3);
		linkedList1.add(2);
		linkedList1.add(2);

		printLinkedList(linkedList1);
		linkedList1.removeDuplicateFromSortedList();
		printLinkedList(linkedList1);
	}

	// can also be solved using hashing # HashTable
	public static void action_interserctionNode() {
		LinkedList linkedList1 = new LinkedList();

		linkedList1.add(30);
		linkedList1.add(15);
		linkedList1.add(9);
		linkedList1.add(6);
		linkedList1.add(3);
		linkedList1.add(2);
		linkedList1.add(3);

		printLinkedList(linkedList1);

		LinkedList linkedList2 = new LinkedList();

		linkedList2.add(30);
		linkedList2.add(15);
		linkedList2.add(10);

		printLinkedList(linkedList2);

		System.out.println(" Intersection Point Node : "
				+ linkedList1.getCommonNode(linkedList1, linkedList2).data);
	}

	public static void action_merege() {
		LinkedList list1 = new LinkedList();
		list1.add(14);
		list1.add(2);
		list1.add(1);
		printLinkedList(list1);

		LinkedList list2 = new LinkedList();
		list2.add(13);
		list2.add(10);
		list2.add(5);
		printLinkedList(list2);

		list1.head = list1.merge(list1.head, list2.head);
		printLinkedList(list1);
	}

	// addFirst() or add()
	public Node add(int data) {
		Node newNode = new Node(data);
		newNode.next = head;
		head = newNode;
		size++;

		return newNode;
	}

	public void addLast(int data) {
		Node newNode = new Node(data);
		if (size == 0) {
			head = newNode;
		} else {
			Node tempHead = head;
			while (tempHead != null && tempHead.next != null) {
				tempHead = tempHead.next;
			}
			tempHead.next = newNode;
		}
		size++;
	}

	public void addAfter(Node node, int data) {
		Node newNode = new Node(data);
		newNode.next = node.next;
		node.next = newNode;
		size++;
	}

	public Node getNodeAtPosition(int pos) {

		if (pos == 0)
			return head;
		if (pos >= size)
			return null;

		Node tempHead = head;
		int count = 0;
		while (tempHead != null && count < pos) {
			tempHead = tempHead.next;
			count++;
		}
		return tempHead;
	}

	public Node first() {
		return head;
	}

	public Node last() {
		Node tempHead = head;
		while (tempHead != null && tempHead.next != null) {
			tempHead = tempHead.next;
		}
		return tempHead;
	}

	public Node removeFirst() {
		Node removedFirst = head;
		if (removedFirst != null) {
			head = removedFirst.next;
			size--;
		}
		return removedFirst;
	}

	public Node removeLast() {
		Node removed = head;
		Node removedTemp = head;
		while (removed != null && removed.next != null) {
			removedTemp = removed;
			removed = removed.next;
		}
		removedTemp.next = null;
		size--;
		return removed;
	}

	public Node removeAt(int pos) {

		Node removed = null;
		if (pos == 0) {
			head = head.next;
			removed = head;
			size--;
		}
		if (pos >= size) {

		} else {
			Node preNode = getNodeAtPosition(pos - 1);
			Node currentNode = getNodeAtPosition(pos);
			preNode.next = currentNode.next;
			removed = currentNode;
			size--;
		}
		return removed;
	}

	public void removeNode(Node node) {
		Node tempNext = node.next;
		node.next = tempNext.next;
		node.data = tempNext.data;
		tempNext = null;
		size--;
	}

	public void swapNodes(int x, int y) {

		// Nothing to do if x and y are same
		if (x == y)
			return;

		// Search for x (keep track of prevX and CurrX)
		Node prevX = null, currX = head;
		while (currX != null && currX.data != x) {
			prevX = currX;
			currX = currX.next;
		}

		// Search for y (keep track of prevY and currY)
		Node prevY = null, currY = head;
		while (currY != null && currY.data != y) {
			prevY = currY;
			currY = currY.next;
		}

		// If either x or y is not present, nothing to do
		if (currX == null || currY == null)
			return;

		// If x is not head of linked list
		if (prevX != null)
			prevX.next = currY;
		else
			// make y the new head
			head = currY;

		// If y is not head of linked list
		if (prevY != null)
			prevY.next = currX;
		else
			// make x the new head
			head = currX;

		// Swap next pointers
		Node temp = currX.next;
		currX.next = currY.next;
		currY.next = temp;
	}

	public static void printLinkedList(LinkedList linkedList) {
		Node tempHead = linkedList.head;
		while (tempHead != null) {
			System.out.print(tempHead.data + " ");
			tempHead = tempHead.next;
		}
		System.out.println("");
	}

	public void reversePrint(Node head) {
		if (head == null)
			return;

		reversePrint(head.next);
		System.out.print(head.data + " ");
	}

	public void reverse(Node currentNode, Node prevNode) {
		/* If last node mark it head */
		if (currentNode.next == null) {
			head = currentNode;
			currentNode.next = prevNode;
			return;
		}

		/* Save curr->next node for recursive call */
		Node next1 = currentNode.next;
		currentNode.next = prevNode;
		reverse(next1, currentNode);
	}

	public Node merge(Node nodeA, Node nodeB) {

		Node newNode = null;
		if (nodeA == null)
			return nodeB;
		else if (nodeB == null)
			return nodeA;
		else if (nodeA.data >= nodeB.data) {
			newNode = nodeB;
			newNode.next = merge(nodeB.next, nodeA);
		} else {
			newNode = nodeA;
			newNode.next = merge(nodeA.next, nodeB);
		}
		return newNode;
	}

	public Node middleNode() {
		int fastCount = 0;
		Node tempHead = head;
		Node currentNode = head;
		while (tempHead != null && fastCount <= size) {
			fastCount = fastCount + 2;
			currentNode = tempHead;
			tempHead = tempHead.next;

		}
		System.out.println("Middle Node : " + currentNode.data);
		return currentNode;
	}

	public boolean isPalindrome() {

		/***
		 * ABCDABC is palindrome Can implement by two ways 1. By using stack 2.
		 * Find the middle and reverse the second half and compare each node of
		 * first and second half
		 */

		return true;
	}

	public int getSize() {
		Node tempHead = head;
		int count = 0;
		while (tempHead != null) {
			count++;
			tempHead = tempHead.next;
		}
		return count;
	}

	public Node getCommonNode(LinkedList list1, LinkedList list2) {
		Node commonNode = null;
		int listSize1 = list1.getSize();
		int listSize2 = list2.getSize();
		if (listSize1 > listSize2) {
			commonNode = getIntersectionNode(list1.head, list2.head, listSize1
					- listSize2);
		} else {
			commonNode = getIntersectionNode(list2.head, list1.head, listSize2
					- listSize1);
		}
		return commonNode;
	}

	public Node getIntersectionNode(Node head1, Node head2, int commonPos) {
		Node commonNode = null;
		for (int i = 0; i < commonPos; i++) {
			if (head1 == null) {
				return null;
			}
			head1 = head1.next;
		}

		while (head1 != null && head2 != null) {
			if (head1.data == head2.data) {
				return head1;
			} else {
				head1 = head1.next;
				head2 = head2.next;
			}
		}
		return commonNode;
	}

	public void removeDuplicateFromSortedList() {
		Node currentNode = head;
		Node nextTemp = null;
		if (head == null)
			return;
		while (currentNode.next != null) {

			if (currentNode.data == currentNode.next.data) {
				nextTemp = currentNode.next.next;
				currentNode.next = null;
				currentNode.next = nextTemp;
				size--;
			} else {
				currentNode = currentNode.next;
			}
		}

	}

	public void pairWiseSwap() {
		Node temp = head;
		/* Traverse only till there are atleast 2 nodes left */
		while (temp != null && temp.next != null) {
			/* Swap the data */
			int k = temp.data;
			temp.data = temp.next.data;
			temp.next.data = k;
			temp = temp.next.next;
		}
	}

	public Node getNodeAt(int pos) {
		if (pos >= size)
			return null;
		Node tempNode = head;
		Node currentNode = head;
		int count = 0;
		while (tempNode != null && count <= pos) {
			currentNode = tempNode;
			tempNode = tempNode.next;
			count++;
		}
		return currentNode;
	}

	public void moveLastToFirst() {
		if (size <= 1)
			return;
		Node tailNode = last();
		Node secondlastNode = getNodeAt(size - 2);
		tailNode.next = head;
		secondlastNode.next = null;
		head = tailNode;
	}
	
	public void meregeSort()
	{
		//TODO : Need to implement later
	}
}
