package part_00_array;

/*Search an element in a sorted and rotated array
 An element in a sorted array can be found in O(log n) time via binary search. 
 But suppose we rotate an ascending order sorted array at some pivot unknown to you beforehand. 
 So for instance, 1 2 3 4 5 might become 3 4 5 1 2. 
 Devise a way to find an element in the rotated array in O(log n) time
 */
public class FindElementInRotatedSortedArray {

	public static void main(String[] args) {
		int arr[] = { 4, 5, 6, 7, 8, 9, 1, 2, 3 };

		int searchFor = pivotedBinarySearch(arr, 8);
		System.out.println(searchFor);
	}

	/*
	 * Input arr[] = {3, 4, 5, 1, 2} Element to Search = 1 1) Find out pivot
	 * point and divide the array in two sub-arrays. (pivot = 2) Index of 5 2)
	 * Now call binary search for one of the two sub-arrays. (a) If element is
	 * greater than 0th element then search in left array (b) Else Search in
	 * right array (1 will go in else as 1 < 0th element(3)) 3) If element is
	 * found in selected sub-array then return index Else return -1.
	 */

	public static int pivotedBinarySearch(int arr[], int key) {

		int pivotInd = findPivot(arr, 0, arr.length - 1);

		if (pivotInd == -1) {
			return binarySearch(arr, 0, arr.length - 1, key); // Then search by
																// normal binary
																// search
		}

		if (arr[pivotInd] == key) {
			return pivotInd;
		}

		if (key > arr[0]) {
			return binarySearch(arr, 0, pivotInd - 1, key);
		} else {
			return binarySearch(arr, pivotInd + 1, arr.length - 1, key);
		}
	}

	public static int binarySearch(int arr[], int low, int high, int key) {
		if (low > high) {
			return -1;
		}
		int mid = (low + high) / 2;
		if (arr[mid] == key) {
			return mid;
		}

		if (key > arr[mid]) {
			low = mid + 1;
		} else {
			high = mid - 1;
		}
		return binarySearch(arr, low, high, key);
	}

	public static int findPivot(int arr[], int low, int high) {

		if (low > high) {
			return -1;
		}

		if (high == low) {
			return low;
		}

		int mid = (low + high) / 2;

		if (mid < high && arr[mid] > arr[mid + 1]) {
			return mid;
		}

		if (mid > low && arr[mid] < arr[mid - 1]) {
			return mid - 1;
		}

		if (arr[low] >= arr[mid]) {
			return findPivot(arr, low, mid - 1);
		}

		return findPivot(arr, mid + 1, high);
	}

}
