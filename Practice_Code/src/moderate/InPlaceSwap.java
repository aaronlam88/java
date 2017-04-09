package moderate;

public class InPlaceSwap {

	public void inplaceSwap(int a, int b) {
		System.out.println(a + "|" + b);
		a = a ^ b;
		b = a ^ b;
		a = a ^ b;
		System.out.println(a + "|" + b);
	}

	public static void main(String[] args) {
		int a = 5, b = 7;

		InPlaceSwap test = new InPlaceSwap();
		test.inplaceSwap(a, b);
	}

}
