package blatt9;

public class Afg2 {

//	0: n, 1: a/b
	int[] privKey = new int[2];
	int[] pubKey = new int[2];

//	a)
	void calcKeys(int p, int q) {
		int n = p * q;
		int phi = (p - 1) * (q - 1);

		int i = 0;
		int a = 0;
		while (a != 1 && i < phi - 1) {
			a = blatt8.Euklid.euklid(i, phi);
			i++;
		}
		pubKey[0] = n;
		pubKey[1] = a;
		
//	Funktioniert!
		int[] arr = blatt9.ErwEuklid.ErwEuklid(a, phi);
		
		privKey[0] = n;
		privKey[1] = arr[1];	

	}

//	b)
	long encrypt(long m) {
		return (long) (Math.pow(m, this.pubKey[1]) % this.pubKey[0]);
	}

//	c)
	long decrypt(long c) {
		return (long) (Math.pow(c, this.privKey[1]) % this.privKey[0]);
	}

	public static void main(String[] args) {
		Afg2 a = new Afg2();

		a.calcKeys(188711, 72173131);
		long l = a.encrypt(12816119204301L);
		System.out.println(a.decrypt(l));
	}

}
