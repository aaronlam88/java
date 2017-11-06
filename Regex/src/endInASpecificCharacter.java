
// Match words that end in a specific character
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class endInASpecificCharacter {
	endInASpecificCharacter() {
		Pattern pat = Pattern.compile("\\w+o");
		Matcher mat = pat.matcher("Hello World");

		while (mat.find())
			System.out.println("Match: " + mat.group());
	}
}
