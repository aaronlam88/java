package arrays_string;

public class StringAllUnique {

	/*
	 * Implement an algorithm to determine if a string has all unique
	 * characters. What if you cannot use additional data structures?
	 */

	/*
	 * ASCII or Unicode string? Assume ASCII
	 */
	public boolean isUniqueChars(String str) {
		int len = str.length();
		if (len > 256)
			return false;

		boolean[] char_set = new boolean[256];

		for (int i = 0; i < len; ++i) {
			int val = str.charAt(i);
			if (char_set[val]) {
				return false;
			}
			char_set[val] = true;
		}
		return true;
	}

	public static void main(String[] args) {
		StringAllUnique test = new StringAllUnique();
		String test1 = "abcdefghijklmnopqrstuvwxyz";
		String test2 = "abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz";

		if (test.isUniqueChars(test1) && !test.isUniqueChars(test2)) {
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}
	}
}
