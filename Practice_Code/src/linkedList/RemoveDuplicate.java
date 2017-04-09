package linkedList;

import java.util.HashSet;

public class RemoveDuplicate {

	public static void main(String[] args) {
		Node list = new Node(9);
		
		for(int i = 0; i < 10; ++i) {
			list.appendToTail(i);
		}
		
		list.printList();
		
		removeDuplicate(list);
		
		list.printList();
	}

	public static void removeDuplicate(Node list) {
		HashSet<Integer> set = new HashSet<>();
		
		Node n = list;
		while (n != null) {
			if(set.contains(n.data)) {
				list.deleteNode(n);
			} else {
				set.add(n.data);
			}
			n = n.next;
		}
	}
	
	public static void removeDuplicateNoSet(Node list) {
		for(Node n = list; n != null; n = n.next) {
			for(Node nn = n.next; nn != null; nn = nn.next) {
				if(nn.data == n.data) {
					list.deleteNode(nn);
				}
			}
		}
	}

}
