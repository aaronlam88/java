
// Use replaceAll(). 
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class replace {
	replace() {
		String str = "Hello World";

		Pattern pat = Pattern.compile("World");
		Matcher mat = pat.matcher(str);

		System.out.println("Original sequence: " + str);

		str = mat.replaceAll("Planet");

		System.out.println("Modified sequence: " + str);

	}
}
