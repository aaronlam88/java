
// Use a character class. 
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class characterClass {
	characterClass() {
		// Match lowercase words.
		Pattern pat = Pattern.compile("[a-z]+");
		Matcher mat = pat.matcher("Hello World");

		while (mat.find())
			System.out.println("Match: " + mat.group());
	}
}
