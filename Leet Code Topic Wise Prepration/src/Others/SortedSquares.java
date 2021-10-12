package Others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class SortedSquares {

	public int[] sortedSquares(int[] nums) {
		List<Integer> positive = new ArrayList<>();
		List<Integer> negative = new ArrayList<>();
		for (int i : nums) {
			if (i >= 0) {
				positive.add(i);
			} else {
				negative.add(i);
			}
		}
		if (positive.size() == 0) {
			negative = negative.stream().map(number -> number * number).collect(Collectors.toList());
			Collections.reverse(negative);
			return negative.stream().mapToInt(i -> i).toArray();
		}
		if (negative.size() == 0) {
			positive = positive.stream().map(number -> number * number).collect(Collectors.toList());
			return positive.stream().mapToInt(i -> i).toArray();
		}
		negative = negative.stream().map(number -> number * number).collect(Collectors.toList());
		Collections.reverse(negative);
		positive = positive.stream().map(number -> number * number).collect(Collectors.toList());

		for (int i : negative) {
			mergeTwoSortedArrays(positive, i, positive.size() - 1, 0);
		}
		return positive.stream().mapToInt(i -> i).toArray();
	}

	public void mergeTwoSortedArrays(List<Integer> a, int b, int high, int low) {
		int mid = (high + low) / 2;
		if (high == low) {
			a.add(low, b);
			return;
		}
		if (b == a.get(mid)) {
			a.add(mid, b);
			return;
		}
		if (b > a.get(mid) && b < a.get(mid + 1)) {
			a.add(mid + 1, b);
			return;
		}
		if (b > a.get(mid)) {
			mergeTwoSortedArrays(a, b, high, mid + 1);
		}
		if (b < a.get(mid)) {
			mergeTwoSortedArrays(a, b, mid - 1, low);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SortedSquares s = new SortedSquares();
		for (int i : s.sortedSquares(new int[] { -4, -1, 0, 3, 10 })) {
			System.out.print(i + ",");
		}
	}

}
