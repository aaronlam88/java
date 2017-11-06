
// match against exact length
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class exactLength {
	exactLength() {
		Pattern pat = Pattern.compile("(\\w{1,5}):(\\w{1,6})");
		Matcher mat = pat.matcher("Hello:Planet");

		while (mat.find())
			System.out.println("Match: " + mat.group());
	}
}