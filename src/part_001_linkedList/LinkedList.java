package part_001_linkedList;

public class LinkedList {

	Node head;

	static class Node {
		int data;
		Node next;

		Node(int data) {
			this.data = data;
		}
	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.head = new Node(2);
		list.head.next = new Node(3);
		list.head.next.next = new Node(4);

		list.printList();
		list.insertAtFront(1);
		list.printList();
		list.insertAfter(list.head.next, 5);
		list.printList();
		list.insertAtEnd(6);
		list.printList();
		list.deleteNode(list.head.next.next);
		list.printList();
		//list.deleteNodeAt(2);
		//list.printList();
		//list.size();
		//System.out.println("Recursive size is : " + list.getSize(list.head));
		//list.swapNodes(2, 1);
		//list.printList();
		System.out.println("Middle node is : "+list.middleNode().data);
	}

	public void printList() {

		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + "-->");
			temp = temp.next;
		}
		System.out.println("NULL");
	}

	public void insertAtFront(int data) {
		Node frontNode = new Node(data);
		frontNode.next = head;
		head = frontNode;
	}

	public void insertAfter(Node prevNode, int data) {
		Node node = new Node(data);
		node.next = prevNode.next;
		prevNode.next = node;
	}

	public void insertAtEnd(int data) {
		Node newNode = new Node(data);
		Node temp = head;

		while (temp != null && temp.next != null) {
			temp = temp.next;
		}

		temp.next = newNode;
	}

	public void deleteNode(Node node) {
		Node temp = head;
		Node prevNode = null;
		while (temp != null) {
			if (temp.data == node.data) {
				prevNode.next = node.next;
				node = null;
				return;
			}
			prevNode = temp;
			temp = temp.next;
		}
	}

	public void deleteNodeAt(int pos) {
		Node temp = head;
		Node prevNode = null;
		int count = 0;

		if (pos == 0) {
			head = head.next;
		}
		while (temp != null) {
			if (pos == count) {
				prevNode.next = temp.next;
				temp = null;
				return;
			}
			prevNode = temp;
			temp = temp.next;
			count++;
		}
	}

	public int size() {
		int size = 0;
		Node temp = head;
		while (temp != null) {
			temp = temp.next;
			size++;
		}
		System.out.println("Size is : " + size);
		return size;
	}

	public int getSize(Node node) {
		if (node != null) {
			return 1 + getSize(node.next);
		} else {
			return 0;
		}
	}

	public boolean contain(int data) {
		Node temp = head;
		if (head == null)
			return false;

		while (temp != null) {
			if (temp.data == data) {
				return true;
			}
			temp = temp.next;
		}
		return false;
	}

	public boolean contain(Node node, int data) {
		if (node == null)
			return false;
		if (node.data == data)
			return true;
		return contain(node.next, data);
	}

	public void swapNodes(int x, int y) {
		if (x == y)
			return;

		Node currentX = head;
		Node prevX = null;
		while (currentX != null) {
			if (currentX.data == x) {
				break;
			}
			prevX = currentX;
			currentX = currentX.next;
		}

		Node currentY = head;
		Node prevY = null;

		while (currentY != null) {
			if (currentY.data == y) {
				break;
			}
			prevY = currentY;
			currentY = currentY.next;
		}

		if (prevY != null) {
			prevY.next = currentX;
		} else {
			head = currentX;
		}

		if (prevX != null) {
			prevX.next = currentY;
		} else {
			head = currentY;
		}

		Node tempX = currentX.next;
		currentX.next = currentY.next;
		currentY.next = tempX;

	}
	
	public Node middleNode(){
		
		if(head==null)
			return head;
		Node fastPtr=head;
		Node slowPtr=head;
		while(fastPtr!=null&&fastPtr.next!=null){
			slowPtr=slowPtr.next;
			fastPtr=fastPtr.next.next;
		}
		
		return slowPtr;
	}
}
