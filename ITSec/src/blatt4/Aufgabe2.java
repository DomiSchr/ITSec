package blatt4;


import java.nio.file.Files;
import java.nio.file.Paths;

public class Aufgabe2 {
	public static void main(String[] args) {

		String s = "";

		try {

//			Zuerst die gro�en Buchstaben, danach �, �, �, die kleinen Buchstaben, �, �, �, dann 0-9

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
//		System.out.println("�: " + anzahl['�' % 67]);
//		System.out.println("�: " + anzahl['�' % 67]);
//		System.out.println("�: " + anzahl['�' % 67]);
//
//		i = 0;
//		while ((char) ('a' + i) != '{') {
//			System.out.println((char) ('a' + i) + ": " + anzahl[('a' + i) % 67]);
//			i++;
//		}
//
//		System.out.println("�: " + anzahl['�' % 67]);
//		System.out.println("�: " + anzahl['�' % 67]);
//		System.out.println("�: " + anzahl['�' % 67]);
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

		System.out.println("�: " + (double)(-(Math.log10((double)anzahl[('�' + i) % 67]/anzahlzeichen)/Math.log10(2))));
		System.out.println("�: " + (double)(-(Math.log10((double)anzahl[('�' + i) % 67]/anzahlzeichen)/Math.log10(2))));
		System.out.println("�: " + (double)(-(Math.log10((double)anzahl[('�' + i) % 67]/anzahlzeichen)/Math.log10(2))));

		i = 0;
		while ((char) ('a' + i) != '{') {
			System.out.println((char) ('a' + i) + ": " + (double)(-(Math.log10((double)anzahl[('a' + i) % 67]/anzahlzeichen)/Math.log10(2))));
			i++;
		}

		System.out.println("�: " + (double)(-(Math.log10((double)anzahl[('�' + i) % 67]/anzahlzeichen)/Math.log10(2))));
		System.out.println("�: " + (double)(-(Math.log10((double)anzahl[('�' + i) % 67]/anzahlzeichen)/Math.log10(2))));
		System.out.println("�: " + (double)(-(Math.log10((double)anzahl[('�' + i) % 67]/anzahlzeichen)/Math.log10(2))));

		i = 0;
		while ((char) ('0' + i) != ':') {
			System.out.println((char) ('0' + i) + ": " + (double)(-(Math.log10((double)anzahl[('0' + i) % 67]/anzahlzeichen)/Math.log10(2))));
			i++;
		}

	}
}
