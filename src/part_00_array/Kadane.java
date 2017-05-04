package part_00_array;

public class Kadane {

	public static void main(String[] args) {

		int[] temp = { -2, -3, 4, -1, -2, 1, 5, -3 };
	}

	public static void maxSubArraySum(int[] temp) {
		int max_so_far = 0;
		int max_ending_here = 0;
		for (int i = 0; i < temp.length; i++) {

			max_ending_here+=temp[i];
			if(max_ending_here>max_so_far){
				
			}
		}
	}

}
