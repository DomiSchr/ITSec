package blatt9;

import java.util.Arrays;

public class ErwEuklid {

	static int[] ErwEuklid(int a, int b) {
		if (b == 0) {
			int[] arr = { a, 1, 0 };
			return arr;
		} else {
			int[] arr = ErwEuklid(b, a % b);
			int at = arr[1];
			int bt = arr[2];
			arr[1] = bt;
			arr[2] = at - (bt * (a / b));

			return arr;
		}

	}

	public static void main(String[] args) {
		
		
		int phi = (188711 - 1) * (72173131 - 1);
		System.out.println(Arrays.toString(ErwEuklid(5, 13)));
	}
}
