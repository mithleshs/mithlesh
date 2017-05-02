package part_00_array;

public class UnsortedArray {

	public static void main(String[] args) {

		int temp[] = new int[20];
		temp[0] = 10;
		temp[1] = 2;
		temp[2] = 20;
		temp[3] = 21;
		temp[4] = 22;

		int seachPos = search(temp, 22);
		System.out.println(seachPos);
	}

	public static int search(int numbs[], int value) {
		int index = -1;
		for (int i = 0; i < numbs.length; i++) {
			if (numbs[i] == value) {
				return i;
			}
		}
		return index;
	}

}
