package linkedList;

import java.util.LinkedList;

public class SumList {

	public static void main(String[] args) {
		LinkedList<Integer> add1 = new LinkedList<>();
		LinkedList<Integer> add2 = new LinkedList<>();
		
		add1.add(7);
		add1.add(1);
		add1.add(6);
		
		add2.add(5);
		add2.add(9);
		add2.add(2);
		
		LinkedList<Integer> sum = sum(add1, add2);
	}

	public static LinkedList<Integer> sum(LinkedList<Integer> add1, LinkedList<Integer> add2) {
		LinkedList<Integer> sum = new LinkedList<>();
		
		int carry = 0;
		
		for(Integer digit1 : add1) {
			
		}
		
		return sum;
	}

}
