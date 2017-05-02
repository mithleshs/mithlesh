package part_00_array;

public class SortedArray {

	public static void main(String[] args) {
		int capacity = 20;
		int temp[] = new int[capacity];
		int length = 8;
		temp[0] = 2;
		temp[1] = 3;
		temp[2] = 20;
		temp[3] = 21;
		temp[4] = 22;
		temp[5] = 30;
		temp[6] = 32;
		temp[7] = 33;

		int searchedPos=binarySearch(temp, 20, 0, length-1);
		System.out.println(searchedPos);
		
		insertElement(temp, 5, length);
	}

	public static int binarySearch(int temp[], int searchFor, int minPos,
			int maxPos) {

		if (maxPos < minPos) {
			return -1;
		}

		int center = (maxPos + minPos) / 2;

		if (searchFor == temp[center]) {
			return center;
		}

		if (searchFor > temp[center]) {
			minPos = center + 1;
		}

		if (searchFor < temp[center]) {
			maxPos = center - 1;
		}

		return binarySearch(temp, searchFor, minPos, maxPos);
	}
	
	public static void insertElement(int temp[], int value,int length){
		int i;
		for(i=length-1;(value<temp[i]&&i>=0);i--){
			temp[i+1]=temp[i];
		}
		temp[i+1]=value;
		System.out.println();
	}
}
