package amazing;

public class CountSetOfBits {

	public static void main(String[] args) {

		int countBitsFor = 6;
		int output = 0;

		for (int i = 1; i <= countBitsFor; i++) {
			int bits = countBits(i);
			System.out.println("Number of Bits in " + i + " is : " + bits);
			output += bits;
		}

		System.out.println("Total Bits Count : " + output);

	}

	public static int countBits(int n) {
		if (n <= 0)
			return 0;

		return (n % 2 == 0 ? 0 : 1) + countBits(n / 2);
	}

}
