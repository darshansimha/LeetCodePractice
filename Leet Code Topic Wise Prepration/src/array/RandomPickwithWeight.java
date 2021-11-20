package array;

import java.util.ArrayList;
import java.util.List;

public class RandomPickwithWeight {
	List<Integer> preFixSum;

	public RandomPickwithWeight(int[] w) {
		int sum = 0;
		preFixSum = new ArrayList<Integer>();
		for (int i : w) {
			sum += i;
			preFixSum.add(sum);
		}
	}

	public int pickIndex() {
		int totalSum = preFixSum.get(preFixSum.size() - 1);
		double randomElement = totalSum * Math.random();
		int low = 0;
		int high = preFixSum.size();
		while (low < high) {
			int mid = low + (high - low) / 2;
			if (randomElement > preFixSum.get(mid)) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}

		return low;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RandomPickwithWeight r = new RandomPickwithWeight(new int[] { 10, 7, 8, 10 });
		for (int i = 0; i < 35; i++)
			System.out.println(r.pickIndex());
	}

}
