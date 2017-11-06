
// Use replaceAll(). 
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class replaceAll {
	replaceAll() {
		String str = "Jon Jonathan Frank Ken Todd";

		Pattern pat = Pattern.compile("Jon.*? ");
		Matcher mat = pat.matcher(str);

		System.out.println("Original sequence: " + str);

		str = mat.replaceAll("Eric ");

		System.out.println("Modified sequence: " + str);

	}
}
