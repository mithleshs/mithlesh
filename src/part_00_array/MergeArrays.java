package part_00_array;

public class MergeArrays {

	public static void main(String[] args) {

		int mPlusN[] = { 2, 8, -1, -1, -1, 13, -1, 15, 20 };
		int N[] = { 5, 7, 9, 25 };
		int n = N.length;
		int m = mPlusN.length - n;

		moveToEnd(mPlusN);
		mergeSortedArrays(mPlusN, N, m, n);
		System.out.println("");
	}

	public static void moveToEnd(int mPlusN[]) {
		int i = mPlusN.length - 1;
		int negaPos = mPlusN.length - 1;

		for (i = mPlusN.length - 1; i >= 0; i--) {

			if (mPlusN[i] != -1) {
				mPlusN[negaPos] = mPlusN[i];
				negaPos--;
			}
		}
	}

	public static void mergeSortedArrays(int mPlusN[], int N[], int m, int n) {

		// TODO Need to work on
		int nPos = 0;
		int mPlusNpos = m - 1;
		int assignInPos = 0;
		for (int i = 0; i < mPlusN.length; i++) {

			if (assignInPos != n) {
				int valueOfM = mPlusN[mPlusNpos];
				int valueOfN = N[nPos];

				if (valueOfM <= valueOfN) {
					mPlusN[assignInPos] = valueOfM;
					assignInPos++;
					mPlusNpos++;
				} else {
					while (valueOfM >= valueOfN) {
						mPlusN[assignInPos] = valueOfN;
						assignInPos++;
						nPos++;
						valueOfN = N[nPos];
					}
				}
			}
		}
	}
}
