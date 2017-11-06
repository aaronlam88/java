package filterPassage;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;

public class Filter {

	public static void main(String[] args) {
		HashSet<String> remove = buildSet("check.txt");
		LinkedList<String> result = removeDuplicate("input.txt", remove);
		writeToFile("output.txt", result);

	}

	private static void writeToFile(String outFile, LinkedList<String> result) {
		try {
			FileWriter fw = new FileWriter(new File(outFile));
			BufferedWriter bw = new BufferedWriter(fw);
			if(result.isEmpty()) {
				bw.close();
				return;
			}
			Iterator<String> it = result.iterator();
			bw.write(it.next());
			while (it.hasNext()) {
				bw.newLine();
				bw.write(it.next());
			}
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static LinkedList<String> removeDuplicate(String inFile, HashSet<String> remove) {
		LinkedList<String> list = new LinkedList<>();

		try {
			FileReader fr = new FileReader(new File(inFile));
			BufferedReader br = new BufferedReader(fr);
			String line;
			while ((line = br.readLine()) != null) {
				String[] tokens = line.split("\\W+");
				StringBuilder sb = new StringBuilder();
				for (String str : tokens) {
					sb.append(str + " ");
				}

				if (!remove.contains(sb.toString())) {
					list.add(line);
				}
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return list;
	}

	private static HashSet<String> buildSet(String checkFile) {
		HashSet<String> set = new HashSet<>();

		try {
			FileReader fr = new FileReader(new File(checkFile));
			BufferedReader br = new BufferedReader(fr);
			String line;
			while ((line = br.readLine()) != null) {
				String[] tokens = line.split("\\W+");
				StringBuilder sb = new StringBuilder();
				for (String str : tokens) {
					sb.append(str + " ");
				}
				set.add(sb.toString());
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return set;
	}

}
