package blatt4;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

public class Aufgabe2 {
	public static void main(String[] args) {

		String s = "";

		try {

//			Zuerst die großen Buchstaben, danach Ö, Ä, Ü, die kleinen Buchstaben, ö, ä, ü, dann 0-9

			s = new String(Files.readAllBytes(Paths.get("text.txt")), "UTF-8");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// a)

		char c;
		HashMap<Character, Integer> anzahl = new HashMap<>();

		for (int i = 0; i < s.length(); i++) {
			c = s.charAt(i);
			if (anzahl.get(c) == null) {
				anzahl.put(c, 0);
			}
			anzahl.put(c, anzahl.get(c) + 1);
		}

		anzahl.remove(' ');
		anzahl.remove('\t');
		anzahl.remove('\n');

//		 Anzahl:
		int i = 0;
		for (char u : anzahl.keySet()) {
			System.out.println(u + " :" + anzahl.get(u));
		}

//		 a) Informationsgehalt:
		i = 0;
		for (char u : anzahl.keySet()) {
			System.out.println(
					u + ":" + (double)();

		}

	}
}
