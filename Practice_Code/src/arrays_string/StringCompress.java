package arrays_string;

public class StringCompress {

	/*
	 * Compress a string by char+char count "aabbc" -> "a2b2c1" if compress
	 * string is not shorter than original return the original string
	 */
	public String stringCompress(String str) {
		if (str == null) {
			return str;
		}
		int count = countCompression(str);
		int len = str.length();
		if (count >= len) {
			return str;
		}

		return charCountCompression(str);
	}

	private int countCompression(String str) {
		char last = str.charAt(0);
		int size = 0;
		int count = 1;
		int len = str.length();
		char c;
		for (int i = 1; i < len; ++i) {
			c = str.charAt(i);
			if (c == last) {
				++count;
			} else {
				last = c;
				size += 1 + String.valueOf(count).length();
				count = 1;
			}
		}
		size += 1 + String.valueOf(count).length();
		return size;
	}

	private String charCountCompression(String str) {
		StringBuffer strBuff = new StringBuffer();
		char last = str.charAt(0);
		int count = 1;
		int len = str.length();
		char c;

		for (int i = 1; i < len; ++i) {
			c = str.charAt(i);
			if (c == last) {
				++count;
			} else {
				strBuff.append(last);
				strBuff.append(count);
				last = c;
				count = 1;
			}
		}

		strBuff.append(last);
		strBuff.append(count);

		return strBuff.toString();
	}

	public static void main(String[] args) {
		StringCompress strCompress = new StringCompress();
		String str = "aaaaaaaabbbbbbbccikinjmmu";
		String compressedStr = strCompress.stringCompress(str);
		System.out.println(compressedStr);
	}

}
