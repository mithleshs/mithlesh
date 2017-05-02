package part_00_array;

public class UnsortedArray {

	/*Time complexities:
		Search: O(n)
		Insert: O(1)
		Delete: O(n)*/
	public static void main(String[] args) {

		int capacity = 20;
		int temp[] = new int[capacity];
		int length = 5;
		temp[0] = 10;
		temp[1] = 2;
		temp[2] = 20;
		temp[3] = 21;
		temp[4] = 22;

		int seachPos = searchElement(temp, 22, length);
		// seachPos = insertElement(temp, 1, length, capacity);
		// removeElement(temp, 21, length);
		System.out.println(seachPos);
	}

	public static int searchElement(int numbs[], int searchFor, int length) {
		int index = -1;
		for (int i = 0; i < length; i++) {
			if (numbs[i] == searchFor) {
				return i;
			}
		}
		return index;
	}

	public static int insertElement(int numbs[], int value, int length,
			int capacity) {

		if (length < capacity) {
			numbs[length] = value;
			return length;
		}
		return -1;
	}

	public static void removeElement(int numbs[], int value, int length) {

		int searchFor = searchElement(numbs, value, length);

		if (searchFor >= 0) {
			for (int i = searchFor; i < length; i++) {
				numbs[i] = numbs[i + 1];
			}
		}
		System.out.println();
	}
}
