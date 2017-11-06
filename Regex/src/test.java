import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class test {
	public static void main(String args[]) {
		new test();
	}

	test() {
		Pattern pat = Pattern.compile("\\w+ *= *new *\\w+;");
		Matcher mat = pat.matcher("Primitives p = new Primitives();");
		while (mat.find())
			System.out.println("Match: " + mat.group());
		pat = Pattern.compile("[ ]");
		String strs[] = pat.split("Primitives p = new Primitives();");
		for (int i = 0; i < strs.length; i++)
			System.out.println("Next token: " + strs[i]);
		System.out.println("\nDone");
	}

}
