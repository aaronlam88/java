
// Use delimiters with wildcard
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class wildcard {
	wildcard() {
		Pattern pat = Pattern.compile("@(.*)%");
		Matcher mat = pat.matcher("@Hello World%");
		while (mat.find())
			System.out.println("Match: " + mat.group());
	}
}