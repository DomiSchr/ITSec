package blatt8;

public class Euklid {
	public static int euklid(int a, int b) {
		if (a == b) {
			return a;
		}
		if (a < b) {
			return euklid(a, b - a);
		}
		return euklid(a - b, b);
	}

	public static void main(String[] args) {
		System.out.println(euklid(15, 5));
	}
}
