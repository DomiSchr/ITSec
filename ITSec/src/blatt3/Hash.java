package blatt3;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Arrays;

public class Hash {

	public static String bruteForceCrack(int[] sha1Hash, char[] alphabet) {
		byte[] lastWord = { (byte) alphabet[0] };
		byte[] carr;
		int iarr[];
		do {
			int i;
			for (i = 0; i < lastWord.length; i++) {
				if (lastWord[i] != alphabet[alphabet.length - 1]) {
					for (int j = 0; j < alphabet.length; j++) {
						if (lastWord[i] == alphabet[j]) {
							lastWord[i] = (byte) alphabet[j + 1];
							break;
						}
					}
					break;
				} else {
					lastWord[i] = (byte) alphabet[0];
				}
			}

			if (i == lastWord.length) {
				carr = new byte[lastWord.length + 1];
				for (int j = 0; j < carr.length; j++) {
					carr[j] = (byte) alphabet[0];
				}

			} else {
				carr = lastWord;
			}
			lastWord = carr;

			iarr = Sha1.sha1(new BitBlock(carr));


		} while (!(sha1Hash[0] == iarr[0] && sha1Hash[1] == iarr[1] && sha1Hash[2] == iarr[2] && sha1Hash[3] == iarr[3] && sha1Hash[4] == iarr[4]));

		return Arrays.toString(carr);
	}

	public static void main(String[] args) {
		char[] alp = new char[26];
		for (int i = 0; i < alp.length; i++) {
			alp[i] = (char) ('a' + i);
		}

		char[] pw = { 'a', 'e', 'i', 'o', 'b' , 'q'};
		byte[] arr = new byte[pw.length];

		for (int i = 0; i < pw.length; i++) {
			arr[i] = (byte) pw[i];
		}
		

		String s = "d8daa4b16db733f969cd6eb48fc65b9c2a9bf7b";
		int[] hash = {0xd8daa4b1, 0x6db733f9, 0x69cd6eb4, 0x8fc65b9c, 0x2a9bf7b};

		long t = System.currentTimeMillis();
		System.out.println(bruteForceCrack(hash, alp));
		System.out.println(System.currentTimeMillis() - t);

	}
}
