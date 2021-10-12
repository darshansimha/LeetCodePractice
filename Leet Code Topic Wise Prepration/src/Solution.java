import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Solution {

	static void workerAllocation(Integer[] arr) {
		if (arr == null || arr.length == 0 || arr.length < 2) {
			System.out.println("Wrong Input");
		}
		Arrays.sort(arr, Collections.reverseOrder());
		int pointer = 2;

		List<Integer> leftSum = new ArrayList<>();
		leftSum.add(arr[0]);
		List<Integer> rightSum = new ArrayList<>();
		rightSum.add(arr[1]);

		while (pointer < arr.length) {
			if (leftSum.get(leftSum.size() - 1) < rightSum.get(rightSum.size() - 1)) {
				leftSum.add(arr[pointer]);
			} else {
				rightSum.add(arr[pointer]);
			}
			pointer++;
		}
		System.out.println("Worker 1" + leftSum);
		System.out.println("Worker 2" + rightSum);
	}

	public static void main(String args[]) throws Exception {
		Solution.workerAllocation(new Integer[] { 10000, 1, 2, 3 });
	}

}
