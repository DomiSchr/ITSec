package blatt6;

import java.nio.charset.Charset;
import java.util.Arrays;

public class OneTimePad {

	/**
	 * Liefert den String in Binärform als Byte-Array zurück. Dabei wird jedes
	 * Symbol gemäß der erweiterten ASCII-Tabelle mit 8 Bit als ein Byte codiert.
	 * Diese Methode ist die "Umkehrfunktion" zu {@link #getStringForm(String)}.
	 */
	public static byte[] getBinaryForm(String s) {
		return s.getBytes(Charset.forName("ISO-8859-1"));
	}

	/**
	 * Interpretiert das gegebene byte-Array als String. Dafür wird jedes Byte als
	 * Symbol gemäß der erweiterten ASCII Tabelle interpretiert. Diese Methode ist
	 * die "Umkehrfunktion" zu {@link #getBinaryForm(String)}.
	 */
	public static String getStringForm(byte[] c) {

		char arr[] = new char[c.length];

		for (int i = 0; i < c.length; i++) {
			if(c[i] < 0) {
//				Verstehen!
				arr[i] = (char)(c[i] & 0xFF);
			} else {
				arr[i] = (char) c[i];
			}
		}
		return Arrays.toString(arr);
	}

	/**
	 * Produziert ein (pseudo-)zufälliges Array von bytes mit der gegebenen Länge.
	 */
	public static byte[] getRandomKey(int length) {
		byte[] b = new byte[length];
		for (int i = 0; i < length; i++) {
			b[i] = (byte) (Math.random() * 255);
		}
		return b;
	}

	/**
	 * Verschlüsselt die gegebene Nachricht msg mit dem gegebenen Schlüssel key
	 * gemäß dem Vorgehen von Vernams One-Time-Pad. Wirft eine
	 * IllegalArgumentException, falls eine der Eingaben null ist oder falls die
	 * Länge der Arrays nicht übereinstimmen.
	 */
	public static byte[] encode(byte[] msg, byte[] key) throws IllegalArgumentException {
		if ((msg == null) || (key == null) || (msg.length != key.length)) {
			throw new IllegalArgumentException("Falsche Eingabe!");
		}

		byte[] b = new byte[msg.length];

		for (int i = 0; i < key.length; i++) {
			b[i] = (byte) (msg[i] ^ key[i]);
		}
		return b;
	}

	/**
	 * Entschlüsselt den gegebenen Chiffretext chiffre mit dem gegebenen Schlüssel
	 * key gemäß dem Vorgehen von Vernams One-Time-Pad. Wirft eine
	 * IllegalArgumentException, falls eine der Eingaben null ist oder falls die
	 * Länge der Arrays nicht übereinstimmen.
	 */
	public static byte[] decode(byte[] chiffre, byte[] key) throws IllegalArgumentException {
		if ((key == null) || (key == null) || (chiffre.length != key.length)) {
			throw new IllegalArgumentException("Falsche Eingabe!");
		}

		byte[] b = new byte[chiffre.length];

		for (int i = 0; i < key.length; i++) {
			b[i] = (byte) (chiffre[i] ^ key[i]);
		}
		return b;

	}

	/**
	 * Gibt eine binäre Repräsentation des gegebenen byte-Arrays zurück. Dabei wird
	 * jedes byte mit 8 Symbolen aus {0, 1} repräsentiert (auch die führenden
	 * 0-en!).
	 */
	public static String toBinaryString(byte[] buf) {

		StringBuffer bf = new StringBuffer();
		String tmp = "";
		for (int i = 0; i < buf.length; i++) {

//			Nochmal überlegen!!
			int x = buf[i];
			x &= 0xFF;
			tmp = Integer.toBinaryString(x);

			for (int j = tmp.length(); j < 8; j++) {
				bf.append('0');
			}

			bf.append(tmp);
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
		testBasics();

		// Testen der Methoden:
//		byte[] b = OneTimePad.getBinaryForm("Hallo");
//		String s = OneTimePad.getStringForm(b);
//		System.out.println(s);
//
//		byte c[] = OneTimePad.getBinaryForm("üß");
//		System.out.println(OneTimePad.toBinaryString(c));
//		System.out.println(OneTimePad.getStringForm(c));

	}

}
