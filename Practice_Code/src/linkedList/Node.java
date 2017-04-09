package linkedList;

public class Node {
	Node next = null;
	int data;

	public Node(int d) {
		data = d;
	}
	
	void appendToTail (int d) {
		Node end = new Node(d);
		Node n = this;
		while(n.next != null) {
			n = n.next;
		}
		n.next = end;
	}
	
	Node deleteNode (Node head, int d) {
		Node n = head;
		
		if(n.data == d) {		
			return head.next; 
		}
		
		while(n.next != null) {
			if(n.next.data == d) {
				n.next = n.next.next;
				return head;
			}
			n = n.next;
		}
		return head;
	}
	
	void printList() {
		Node n = this;
		while(n != null) {
			System.out.format("%d ", n.data);
			n = n.next;
		}
		System.out.println();
	}
	
	void deleteNode(Node node) {
		if(node == null) {
			return;
		}
		
		Node next = node.next;
		if(next == null) {
			node = null; 
		} else {
			node.data = next.data;
			node.next = next.next;
			//free next
			next = null;
		}
	}
}
