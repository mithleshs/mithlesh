package amazing;

/*How to Add Two Integer Numbers without using Plus + or ++ Arithmetic Operator in J
 */

public class AdditionWithoutArithmetic {

	public static void main(String[] args) {

		int a=100;
		int b=200;
		int sum=addIterative(a, b);
		System.out.println(sum);
	}

	public static int addIterative(int a, int b) {
		while (b != 0) {
			int carry = (a & b); // CARRY is AND of two bits

			a = a ^ b; // SUM of two bits is A XOR B

			b = carry << 1; // shifts carry to 1 bit to calculate sum
		}
		return a;
	}

}
