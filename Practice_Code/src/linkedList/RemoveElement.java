package linkedList;

public class RemoveElement {

	public static void main(String[] args) {
		Node list = new Node(1);

		for (int i = 0; i < 10; ++i) {
			list.appendToTail(i);
		}
		
		int k = 1;
		list.printList();
		RemoveKthElement(list, k);
		list.printList();
	}

	private static void RemoveKthElement(Node list, int k) {
		Node start = list;
		Node end = start;
		
		int i;
		for(i = 0; i < k && end != null; ++i) {
			end = end.next;
		}
		if(i < k){
			System.out.println("not long enough");
			return;
		}
		
		System.out.println(end.data);
		System.out.println(start.data);
		
		while (end != null) {
			end = end.next;
			start = start.next;
		}
		list.deleteNode(start);
	}

}
