package Matrix;

import java.util.List;

public class LeftmostColumnWithAtleastAOne {
	interface BinaryMatrix {
		public static int get(int row, int col) {
			return col;
		}

		public static List<Integer> dimensions() {
			return null;
		}
	};

	public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
		if (binaryMatrix == null) {
			return -1;
		}
		List<Integer> sizes = BinaryMatrix.dimensions();
		int rows = sizes.get(0);
		int cols = sizes.get(1);
		int result = Integer.MAX_VALUE;
		int r = 0;
		int c = cols - 1;

		while (r < rows && c >= 0) {
			if (BinaryMatrix.get(r, c) == 1) {
				result = Math.min(result, c);
				c--;
			} else {
				r++;
			}
		}
		return (result == Integer.MAX_VALUE) ? -1 : result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
