package arrays_string;

public class StringLengthRunCompress {
	public String LengthRunCompress(String str) {
		if (str.isEmpty()) {
			return str;
		}
		int len = str.length();
		char last = str.charAt(0);
		int count = 1;
		StringBuffer strReturn = new StringBuffer();
		strReturn.append(last);
		for (int i = 1; i < len; ++i) {
			char c = str.charAt(i);
			if (c == last) {
				++count;
			} else {
				strReturn.append(count);
				strReturn.append(c);
				count = 1;
				last = c;
			}
		}
		strReturn.append(count);
		if (strReturn.length() >= len) {
			return str;
		} else {
			return strReturn.toString();
		}
	}

	public static void main(String[] args) {
		StringLengthRunCompress test = new StringLengthRunCompress();

		test.runTest(test.LengthRunCompress("aaaaabbbbbbcdef"), "a5b6c1d1e1f1");

		test.runTest(test.LengthRunCompress("abcdefghijklmnopqr"), "abcdefghijklmnopqr");

		test.runTest(test.LengthRunCompress(""), "");

		test.runTest(test.LengthRunCompress(" "), " ");
	}

	public void runTest(String test, String check) {
		if (test.compareTo(check) == 0) {
			System.out.println("Pass");
		} else {
			System.out.println("Fail");
		}
	}
}
