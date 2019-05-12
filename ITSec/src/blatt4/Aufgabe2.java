package blatt4;


import java.nio.file.Files;
import java.nio.file.Paths;

public class Aufgabe2 {
	public static void main(String[] args) {

		String s = "";

		try {

//			Zuerst die großen Buchstaben, danach Ä, Ö, Ü, die kleinen Buchstaben, ä, ö, ü, dann 0-9

			s = new String(Files.readAllBytes(Paths.get("text.txt")), "UTF-8");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// a)

		char c;
		int[] anzahl = new int[67];

		for (int i = 0; i < s.length(); i++) {
			c = s.charAt(i);
			anzahl[c % 67]++;
		}
		
		int anzahlzeichen = s.length();
		

//		 Anzahl:
//		int i = 0;
//		while ((char) ('A' + i) != '[') {
//			System.out.println((char) ('A' + i) + ": " + anzahl[('A' + i) % 67]);
//			i++;
//		}
//
//		System.out.println("Ä: " + anzahl['Ä' % 67]);
//		System.out.println("Ö: " + anzahl['Ö' % 67]);
//		System.out.println("Ü: " + anzahl['Ü' % 67]);
//
//		i = 0;
//		while ((char) ('a' + i) != '{') {
//			System.out.println((char) ('a' + i) + ": " + anzahl[('a' + i) % 67]);
//			i++;
//		}
//
//		System.out.println("ä: " + anzahl['ä' % 67]);
//		System.out.println("ö: " + anzahl['ö' % 67]);
//		System.out.println("ü: " + anzahl['ü' % 67]);
//
//		i = 0;
//		while ((char) ('0' + i) != ':') {
//			System.out.println((char) ('0' + i) + ": " + anzahl[('0' + i) % 67]);
//			i++;
//		}

//		 a) Informationsgehalt:
		int i = 0;
		while ((char) ('A' + i) != '[') {
			System.out.println((char) ('A' + i) + ": " + (double)(-(Math.log10((double)anzahl[('A' + i) % 67]/anzahlzeichen)/Math.log10(2.0))));
			i++;
		}

		System.out.println("Ä: " + (double)(-(Math.log10((double)anzahl[('Ä' + i) % 67]/anzahlzeichen)/Math.log10(2))));
		System.out.println("Ö: " + (double)(-(Math.log10((double)anzahl[('Ö' + i) % 67]/anzahlzeichen)/Math.log10(2))));
		System.out.println("Ü: " + (double)(-(Math.log10((double)anzahl[('Ü' + i) % 67]/anzahlzeichen)/Math.log10(2))));

		i = 0;
		while ((char) ('a' + i) != '{') {
			System.out.println((char) ('a' + i) + ": " + (double)(-(Math.log10((double)anzahl[('a' + i) % 67]/anzahlzeichen)/Math.log10(2))));
			i++;
		}

		System.out.println("ä: " + (double)(-(Math.log10((double)anzahl[('ä' + i) % 67]/anzahlzeichen)/Math.log10(2))));
		System.out.println("ö: " + (double)(-(Math.log10((double)anzahl[('ö' + i) % 67]/anzahlzeichen)/Math.log10(2))));
		System.out.println("ü: " + (double)(-(Math.log10((double)anzahl[('ü' + i) % 67]/anzahlzeichen)/Math.log10(2))));

		i = 0;
		while ((char) ('0' + i) != ':') {
			System.out.println((char) ('0' + i) + ": " + (double)(-(Math.log10((double)anzahl[('0' + i) % 67]/anzahlzeichen)/Math.log10(2))));
			i++;
		}

	}
}
