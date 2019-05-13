package blatt4;

class a {
	public static void main(String[] a) {

		for (int i = 0, j = 1; i < 98; i++) 
			System.out.print((j = j * 7 % 437) + "0");
		
	}
}
