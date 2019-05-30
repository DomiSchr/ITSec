package blatt7;

public class Blatt7 {
	public static boolean isEquivalent(int x, int y, int m) {
		if (m < 0) {
			return false;
		}

		int t = y % m;

		t = t < 0 ? t + Math.abs(m) : t;

		if (t == x) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(isEquivalent(11, -19, 15));
	}
}
