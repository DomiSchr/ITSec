package blatt6;

import java.util.Arrays;

public class OneTimePad {

	/**
	 * Liefert den String in Binärform als Byte-Array zurück. Dabei wird jedes
	 * Symbol gemäß der erweiterten ASCII-Tabelle mit 8 Bit als ein Byte codiert.
	 * Diese Methode ist die "Umkehrfunktion" zu {@link #getStringForm(String)}.
	 */
	public static byte[] getBinaryForm(String s) {
//    	Evtl. Charset nachschauen!
		return s.getBytes();
	}

	/**
	 * Interpretiert das gegebene byte-Array als String. Dafür wird jedes Byte als
	 * Symbol gemäß der erweiterten ASCII Tabelle interpretiert. Diese Methode ist
	 * die "Umkehrfunktion" zu {@link #getBinaryForm(String)}.
	 */
	public static String getStringForm(byte[] c) {

		char arr[] = new char[c.length];

		for (int i = 0; i < c.length; i++) {
			arr[i] = (char) c[i];
		}
		return Arrays.toString(arr);
	}

	/**
	 * Produziert ein (pseudo-)zufälliges Array von bytes mit der gegebenen Länge.
	 */
	public static byte[] getRandomKey(int length) {
//		TODO: Nicht so toll!
		byte[] b = new byte[length];
		for (int i = 0; i < length; i++) {
			b[i] = (byte)((Math.random() * 128) * Math.pow(-1.0, Math.random() * 2));
		}
		return b;
	}

	/**
	 * Verschlüsselt die gegebene Nachricht msg mit dem gegebenen Schlüssel key
	 * gemäß dem Vorgehen von Vernams One-Time-Pad. Wirft eine
	 * IllegalArgumentException, falls eine der Eingaben null ist oder falls die
	 * Länge der Arrays nicht übereinstimmen.
	 */
	public static byte[] encode(byte[] msg, byte[] key) {
		// Bitte implementieren!
	}

	/**
	 * Entschlüsselt den gegebenen Chiffretext chiffre mit dem gegebenen Schlüssel
	 * key gemäß dem Vorgehen von Vernams One-Time-Pad. Wirft eine
	 * IllegalArgumentException, falls eine der Eingaben null ist oder falls die
	 * Länge der Arrays nicht übereinstimmen.
	 */
	public static byte[] decode(byte[] chiffre, byte[] key) {
		// Bitte implementieren!
	}

	/**
	 * Gibt eine binäre Repräsentation des gegebenen byte-Arrays zurück. Dabei
	 * wird jedes byte mit 8 Symbolen aus {0, 1} repräsentiert (auch die führenden
	 * 0-en!).
	 */
	public static String toBinaryString(byte[] buf) {

		StringBuffer bf = new StringBuffer();
		String tmp;
		for (int i = 0; i < buf.length; i++) {
			tmp = Integer.toBinaryString(buf[i]);

			if (buf[i] < 0) {
				for (int j = 32 - 8; j < tmp.length(); j++) {
					bf.append(tmp.charAt(j));
				}
			} else {
				for (int j = tmp.length(); j < 8; j++) {
					bf.append('0');
				}
				bf.append(tmp);
			}

		}

		return bf.toString();
	}

	public static void testBasics() {
		String klartext = "grüß die oma";
		byte[] m = getBinaryForm(klartext);
		System.out.println("Klartext                     : " + klartext);
		System.out.println("Klartext (binär)             : " + toBinaryString(m));
		byte[] k = getRandomKey(m.length);
		System.out.println("Schlüssel                    : " + toBinaryString(k));
		byte[] c = encode(m, k);
		System.out.println("Chiffretext (binär)          : " + toBinaryString(c));
		System.out.println("Chiffretext                  : " + getStringForm(c));
		byte[] decoded = decode(c, k);
		System.out.println("Decodierter Klartext (binär) : " + toBinaryString(decoded));
		System.out.println(getStringForm(decoded));
		System.out.println("Decodierter Klartext         : " + getStringForm(decoded));
	}

	public static void main(String[] args) {
//		testBasics();

		// Testen der Methoden:
		byte[] b = OneTimePad.getBinaryForm("Hallo");
		String s = OneTimePad.getStringForm(b);
		System.out.println(s);

		byte c[] = {34};
		System.out.println(OneTimePad.toBinaryString(c));

	}

}
