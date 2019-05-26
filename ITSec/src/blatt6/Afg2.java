package blatt6;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;

public class Afg2 {
	public static void main(String[] args) {

		String inp = "";

		try {
			inp = new String(Files.readAllBytes(Paths.get("chiffretext.txt")), "UTF-8");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		Caesar:
//		char c;
//		for (int i = 1; i < 40; i++) {
//			for (int j = 0; j < inp.length(); j++) {
//				if (inp.charAt(j) + i > 'z') {
//					c = (char) ('a' + ((inp.charAt(j) + i) % 26));
//				} else {
//					c = (char)(inp.charAt(j) + i);
//				}
//				System.out.print(c);
//			}
//			System.out.println();
//		}

//		Substitution:

		HashMap<Character, Integer> anzahl = new HashMap<>();

		char c;

		for (int i = 0; i < inp.length(); i++) {
			c = inp.charAt(i);
			if (anzahl.get(c) == null) {
				anzahl.put(c, 0);
			}
			anzahl.put(c, anzahl.get(c) + 1);
		}

//		Wahrscheinlichkeit:
		for(char d : anzahl.keySet()) {
			System.out.println("Wahrscheinlichkeit: " + d + " : " + (double)d/inp.length());
		}
		
		System.out.println();
		
		for(int i = 0; i < inp.length(); i++){
			c = inp.charAt(i);
			switch (c) {
			case 'f':
				System.out.print('a');
				break;
//			case 'm':
//				System.out.print('t');
//				break;
//			case 'o':
//				System.out.print('h');
//				break;
//			case 'i':
//				System.out.print('e');
//				break;
			default:
				System.out.print(c);
			} 
			
			
		}
		
//		?????
//		f: a
//		m: t
//		o: h
//		i: e
//
	}
}
