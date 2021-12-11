package Dec_05;

import java.util.Arrays;
import java.util.List;

public class LeftMostColumnWithAtleastAOne {
	int result;

	// Dummy class just for the Intellisense to work
	class BinaryMatrix {
		public int get(int row, int col) {
			return 0;
		}

		public List<Integer> dimensions() {
			return Arrays.asList(0, 1);

		}
	}

	public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
		List<Integer> dimensions = binaryMatrix.dimensions();
		int n = dimensions.get(0);
		int m = dimensions.get(1);
		result = m;

		for (int i = 0; i < n; i++) {
			binarySearch(0, m - 1, binaryMatrix, i, m, n);
		}
		return result == m ? -1 : result;
	}

	private void binarySearch(int low, int high, BinaryMatrix binaryMatrix, int index, int m, int n) {
		if (low < 0 || low >= n || high <= 0 || high >= m || low > high) {
			return;
		}
		int mid = (high + low) / 2;

		// This means that we need to go right to find our potential one
		if (binaryMatrix.get(index, mid) == 0) {
			if (mid >= result) {
				// We do this because inside our matrix we already found something that is
				// More towards the left than our current computation
				// So going further right would be a waste of time
				return;
			}
			binarySearch(mid + 1, high, binaryMatrix, index, m, n);

		}
		// Otherwise we need to move left to further optimize our result;
		else {
			result = Math.min(result, mid);
			binarySearch(low, mid - 1, binaryMatrix, index, m, n);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
