package blatt4;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

public class Aufgabe2 {
	public static void main(String[] args) {

		String s = "";

		try {

			s = new String(Files.readAllBytes(Paths.get("text.txt")), "UTF-8");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
		for (char u : anzahl.keySet()) {
			System.out.println(u + ": " + anzahl.get(u));
		}

//		 a) Informationsgehalt:
		for (char u : anzahl.keySet()) {
			System.out.println(u + ": " + informationsgehalt(anzahl, u));
		}

//		b) Shannon-Entropie:
		double entr = 0;
		for (char u : anzahl.keySet()) {
			entr += (double)(anzahl.get(u) / anzahl.size()) * informationsgehalt(anzahl, u);
		}
		System.out.println("Shannon-Entropie: " + entr);

//		c) Min-Entropie:
		entr = informationsgehalt(anzahl, '0');

		for (char u : anzahl.keySet()) {
			if(informationsgehalt(anzahl, u) <  entr){
				entr = informationsgehalt(anzahl, u);
			}
		}
		
		System.out.println("Min-Entropie: " + entr);

	}

	public static double log2(double d) {
		return Math.log(d) / Math.log(2.0);
	}

	public static double informationsgehalt(HashMap<Character, Integer> h, char c) {
		return -(log2((double) h.get(c) / h.size()));
	}
}
