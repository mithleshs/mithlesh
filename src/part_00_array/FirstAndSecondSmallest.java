package part_00_array;

/**
 * 1) Initialize both first and second smallest as INT_MAX first = second =
 * INT_MAX 2) Loop through all the elements. a) If the current element is
 * smaller than first, then update first and second. b) Else if the current
 * element is smaller than second then update second
 **/
public class FirstAndSecondSmallest {

	/*Time Complexity: O(n)*/
	
	public static void main(String[] args) {

		int temp[] = { 2, 0, -1, 5, 3, 8 };

		int smallest = 25;
		int secondSmallest = 25;

		for (int i = 1; i < temp.length; i++) {
			if (temp[i] < smallest) {
				secondSmallest = smallest;
				smallest = temp[i];
			}
			if (temp[i] < secondSmallest && temp[i] != smallest) {
				secondSmallest = temp[i];
			}
		}
		System.out.println("First smallest : " + smallest);
		System.out.println("Second smallest : " + secondSmallest);
	}

}
