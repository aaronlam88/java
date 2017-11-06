
// Use find() to find a subsequence. 
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class findASubsequence2 {
	findASubsequence2() {
		Pattern pat = Pattern.compile("(.*),(.*)");
		Matcher mat = pat.matcher("Hello,World");

		if (mat.find())
			System.out.println("subsequence found");
		else
			System.out.println("No Match");
	}
}