import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

// #PROBLEM
// You will be given a sequence of passages, and must filter out any passage whose text (sequence of whitespace-delimited words)
// is wholly contained as a sub-passage of one or more of the other passages.
// When comparing for containment, certain rules must be followed:
// 		1-The case of alphabetic characters should be ignored
// 		2-Leading and trailing whitespace should be ignored
// 		3-Any other block of contiguous whitespace should be treated as a single space
// 		4-Non-alphanumeric character should be ignored, white space should be retained
// 		5-Duplicates must also be filtered
// 		6-If two passages are considered equal with respect to the comparison rules listed above, 
// 			only the shortest should be retained. 
// 		7-If they are also the same length, the earlier one in the input sequence should be kept.
// The retained passages should be output in their original form (identical to the input passage), and in the same order.
//
// #TEST:
// Input: IBM cognitive computing|IBM "cognitive" computing is a revolution| ibm cognitive computing|'IBM Cognitive Computing' is a revolution? 
// Output: IBM "cognitive" computing is a revolution
// Input: IBM cognitive computing|IBM "cognitive" computing is a revolution|the cognitive computing is a revolution
// Output: IBM "cognitive" computing is a revolution|the cognitive computing is a revolution


// Get input for console
// Break input string into passages base on delimiter (String tokens[])
// Use LinkedHashMap map to store normalize (remove non-alphanumeric, toLowerCase) passage as key, 
// 		use both length of the passage and location (index of passage in tokens[]) as value (<Pair>)
// [Use LinkedHashMap to keep insertion order]
// When put <key, value> to map, if key existed, keep only the value with great length
// After builder the map, there should be no duplicate base on the rules, and only the longest passage survive.
// Iterate through the map, get the original passage from tokens[] by using the Pair.index, and build output string
// Print output to console

public class Main {
	static class Pair {
		int len;
		int index;

		public Pair(int l, int i) {
			len = l;
			index = i;
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String s;
		while ((s = in.readLine()) != null) {
			// Error checking, if user enter nothing, check of input again
			if (s.isEmpty())
				continue;
			
			// use linked hash map to keep insertion order
			LinkedHashMap<String, Pair> map = new LinkedHashMap<>();
			
			// Break single line in to passages
			String[] tokens = s.split("\\|");
			
			// loop through all the passages
			for (int i = 0; i < tokens.length; ++i) {
				// Normalize a passage
				String[] words = tokens[i].split(" +");
				StringBuilder sb = new StringBuilder();
				for (int j = 0; j < words.length; ++j) {
					sb.append(words[j].replaceAll("[^a-zA-Z0-9-]", "").toLowerCase());
					if (j < words.length - 1) {
						sb.append(" ");
					}
				}
				
				// Done normalization
				String line = sb.toString().trim();
				
				// Check to see if we should add the passage to the map
				// If map contains line, 
				//		only put in new line with length, index; if the new length is longer
				// Else
				// 		for all keys in map
				//			if key contains line, do not add line to map
				//			if line contain key, remove key, add line to map
				if (map.containsKey(line)) {
					if (map.get(line).len > line.length()) {
						map.put(line, new Pair(line.length(), i));
					}
				} else {
					boolean add = true;
					for (Iterator<Entry<String, Pair>> it = map.entrySet().iterator(); it.hasNext();) {
						Entry<String, Pair> entry = it.next();
						if (entry.getKey().contains(line)) {
							add = false;
							break;
						}
						if (line.contains(entry.getKey())) {
							it.remove();
						}
					}
					if (add) {
						map.put(line, new Pair(line.length(), i));
					}
				}
			}
			
			// Iterate map, get original passage from tokens[] using index to build result string
			StringBuilder sb = new StringBuilder();
			for (Pair pair : map.values()) {
				sb.append(tokens[pair.index] + "|");
			}
			
			// Error checking, remove extra character at the end of string.
			if (sb.length() - 1 > 0) {
				sb.deleteCharAt(sb.length() - 1);
			}
			
			// print result
			System.out.println(sb.toString());
		}
	}
}
