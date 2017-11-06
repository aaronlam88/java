
// Use split(). 
import java.util.regex.Pattern;

class split {
	split() {

		// Match lowercase words.
		Pattern pat = Pattern.compile("[ ,.!]");

		String strs[] = pat.split("De Anza.College,Cupertino!CA");

		for (int i = 0; i < strs.length; i++)
			System.out.println("Next token: " + strs[i]);

	}
}