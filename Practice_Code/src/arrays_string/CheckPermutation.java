package arrays_string;

import java.util.HashMap;

public class CheckPermutation {
	/*
	 * Check if 2 strings are permutation of each other
	 */

	public boolean isPermutation(String s, String t) {
		HashMap<Character, Integer> map = new HashMap<>();
		int len1 = s.length();
		int len2 = t.length();
		if (len1 != len2)
			return false;
		for (int i = 0; i < len1; ++i) {
			char c = s.charAt(i);
			map.put(c, map.getOrDefault(c, 0) + 1);
		}
		for (int i = 0; i < len2; ++i) {
			char c = t.charAt(i);
			if (!map.containsKey(c)) {
				return false;
			} else if (map.get(c) <= 0) {
				return false;
			} else {
				map.put(c, map.get(c) - 1);
			}
		}
		return true;
	}

	public static void main(String[] args) {
		CheckPermutation test = new CheckPermutation();
		String test1 = "abcdefghijklmnopqrstuvwxyz";
		String test2 = "zyxwvutsrqponmlkjihgfedcba";

		if (test.isPermutation(test1, test2)) {
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}
	}
}
