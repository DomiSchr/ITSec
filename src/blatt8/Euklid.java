package blatt8;

public class Euklid {
	public static int euklid(int a, int b) {
		if (b == 0) {
			return a;
		} else {
			return euklid(b, a % b);
		}
	}

	public static void main(String[] args) {
		System.out.println(euklid(15, 5));
	}
}
