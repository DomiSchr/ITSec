package blatt9;

import java.math.BigInteger;

public class RSA {

	/**
	 * Bitte geeignete Attribute für die Klasse definieren. Jede Instanz von RSA
	 * soll sein eigenes Schluesselpaar besitzen.
	 */
	private BigInteger privKey[] = new BigInteger[2];
	private BigInteger pubKey[] = new BigInteger[2];

	/**
	 * Builds a new key-pair for RSA using the given two prime numbers.
	 */
	private RSA(BigInteger prime1, BigInteger prime2) {
		BigInteger n = prime1.multiply(prime2);
		BigInteger phi = prime1.subtract(BigInteger.ONE).multiply(prime2.subtract(BigInteger.ONE));

		BigInteger a[] = new BigInteger[3];
		BigInteger i = BigInteger.ZERO;
		
		while (a[0] != BigInteger.ONE && i.compareTo(phi.subtract(BigInteger.ONE)) == -1) {
			a = ggt(i, phi);
			i.add(BigInteger.ONE);
		}

		pubKey[0] = n;
		pubKey[1] = a[0];
		System.out.println("pubkey");

		a = ggt(a[0], phi);
		System.out.println("ggT");

		privKey[0] = n;
		privKey[1] = a[1];

	}

	private BigInteger[] ggt(BigInteger a, BigInteger b) {
		if (b == BigInteger.ZERO) {
			BigInteger arr[] = { a, BigInteger.ONE, BigInteger.ZERO };
			return arr;
		}
		BigInteger arr[] = ggt(b, a.mod(b));
		BigInteger at = arr[1];
		BigInteger bt = arr[2];
		arr[1] = bt;
		arr[2] = at.subtract(bt.multiply(a.divide(b)));
		return arr;

	}

	/**
	 * Builds a new key-pair for RSA the length of which is given by bitLength, i.e.
	 * bitLength determines the length of the module of the system. The key is
	 * chosen randomly using a pseudo-random number generator.
	 */
	public RSA(int bitLength) {
		// TODO Bitte implementieren
	}

	/**
	 * Encodes the given message using the public key and returns the corresponding
	 * cipher text.
	 */
	public BigInteger encode(BigInteger message) {
		return message.modPow(pubKey[1], pubKey[0]);
	}

	/**
	 * Decodes the given cipher text using the private key and returns the
	 * corresponding message.
	 */
	public BigInteger decode(BigInteger chiffre) {
		return chiffre.modPow(privKey[1], privKey[0]);
	}

	/**
	 * Returns a human-readable version of public and private key.
	 */
	public String toString() {
		return "Public Key: n: " + pubKey[0].toString() + ", a:" + pubKey[1].toString() + "\nPrivate Key: n:"
				+ privKey[0].toString() + ", b:" + privKey[1].toString();
	}

	public static void main(String[] args) {
		BigInteger a = BigInteger.valueOf(67);
		BigInteger b = BigInteger.valueOf(101);
		RSA r = new RSA(a, b);
		System.out.println((r.decode(r.encode(a))).toString());

	}

}
