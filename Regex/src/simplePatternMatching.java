
// A simple pattern matching demo. 
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class simplePatternMatching {
	simplePatternMatching() {
		Pattern pat;
		Matcher mat;
		boolean found;

		pat = Pattern.compile("Hello World");
		mat = pat.matcher("Hello World");

		found = mat.matches(); // check for a match

		if (found)
			System.out.println("Matches");
		else
			System.out.println("No Match");

		System.out.println();

		mat = pat.matcher("Hello Planet"); // create a new matcher
		found = mat.matches(); // check for a match

		if (found)
			System.out.println("Matches");
		else
			System.out.println("No Match");
	}
}