
import java.math.BigInteger;

public class RSA {

	/**
	 * Bitte geeignete Attribute für die Klasse definieren. Jede Instanz von RSA
	 * soll sein eigenes Schluesselpaar besitzen.
	 */
	private BigInteger n;
	private BigInteger a;
	private BigInteger b;

	/**
	 * Builds a new key-pair for RSA using the given two prime numbers.
	 */
	private RSA(BigInteger prime1, BigInteger prime2) {
		// TODO Bitte implementieren
		n = prime1.multiply(prime2);
		BigInteger phi = prime1.subtract(BigInteger.ONE).multiply(prime2.subtract(BigInteger.ONE));
		
		for(int )
		
		
	}
	
	private BigInteger ggt(BigInteger a, BigInteger b) {
		if(b.equals(0)) {
			return a;
		}
		return ggt(b, a.mod(b));
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
		// TODO Bitte implementieren
	}

	/**
	 * Decodes the given cipher text using the private key and returns the
	 * corresponding message.
	 */
	public BigInteger decode(BigInteger chiffre) {
		// TODO Bitte implementieren
	}

	/**
	 * Returns a human-readable version of public and private key.
	 */
	public String toString() {
		return "Public Key: n: " + n.toString() + ", a:" + a.toString() + "\nPrivate Key: n:" + n.toString() + ", b:"
				+ b.toString();
	}

	public static void main(String[] args) {
		// TODO Bitte geeignete Tests implementieren
	}

}
