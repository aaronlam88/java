package arrays_string;

public class StringCharReplace {

	public void replace(char[] str, int trueLen) {
		int len = str.length - 1;
		for (int i = len; i >= 0; --i) {
			if (str[--trueLen] == ' ') {
				str[i] = '0';
				str[--i] = '2';
				str[--i] = '%';
			} else {
				str[i] = str[trueLen];
			}
		}
	}

	public void printCharArray(char[] str) {
		System.out.print("\"");
		for (int i = 0; i < str.length; ++i) {
			System.out.print(str[i]);
		}
		System.out.println("\"");
	}

	public static void main(String[] args) {
		StringCharReplace test = new StringCharReplace();
		char[] arr = new char[5];
		arr[0] = 'h';
		arr[1] = ' ';
		arr[2] = 'e';
		test.printCharArray(arr);
		test.replace(arr, 3);
		test.printCharArray(arr);
	}
}
