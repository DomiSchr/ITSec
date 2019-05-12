package blatt4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Aufgabe2 {
	public static void main(String[] args) {

		BufferedReader reader;
		String s;

		try {
			reader = new BufferedReader(new FileReader("text.txt"));

			s = reader.readLine();
			System.out.println(s);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// a)

	}
}
