package arrays_string;

public class SubString {
	// Assume you have method isSubString which check if the one word is a
	// substring of another.
	// Give two strings, s1 and s2, write code to check if s2 is a rotation of
	// s1
	// using only one call to isSubString (e.g. "waterbottle" is a rotation of
	// "erbottlewat"

	// Solution:
	// s2 will always be a substring of s1s1
	public boolean isRotation(String s1, String s2) {
		int len = s1.length();

		if (len == s2.length() && len > 0) {
			String s1s1 = s1 + s1;
			return isSubString(s1s1, s2);
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "waterbottle";
		String s2 = "erbottlewat";
		SubString test = new SubString();
		System.out.println(test.isRotation(s1, s2));

	}

	public boolean isSubString(String s1, String s2) {
		int len1 = s1.length();
		int len2 = s2.length();

		if (len1 < len2) {
			return false;
		}

		for (int i = 0; (i + len2) <= len1; ++i) {
			String test = s1.substring(i, i + len2);
			if (test.equals(s2)) {
				return true;
			}
		}

		return false;
	}

}
