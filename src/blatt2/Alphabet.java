package blatt2;

import java.util.Arrays;

public class Alphabet {

	public static void main(String[] args) {
		char alp[] = new char[26];

		for (int i = 0; i < 26; i++) {
			alp[i] = (char) ('a' + i);
		}

		char word[] = {};

		long t = System.currentTimeMillis();
		while (word.length < 7) {
			word = getNextWord(word, alp);
		}
		System.out.println((System.currentTimeMillis() - t));
	}

	public static char[] getNextWord(char[] lastWord, char[] alphabet) {

		if (lastWord.length == 0) {
			char[] arr = new char[1];
			arr[0] = alphabet[0];
			return arr;
		}

		int i;
		for (i = 0; i < lastWord.length; i++) {
			if (lastWord[i] != alphabet[alphabet.length - 1]) {
				for (int j = 0; j < alphabet.length; j++) {
					if (lastWord[i] == alphabet[j]) {
						lastWord[i] = alphabet[j + 1];
						break;
					}
				}
				break;
			} else {
				lastWord[i] = alphabet[0];
			}
		}

		if (i == lastWord.length) {
			char[] arr = new char[lastWord.length + 1];
			for (int j = 0; j < arr.length; j++) {
				arr[j] = alphabet[0];
			}
			return arr;
		} else {
			return lastWord;
		}
	}
}
