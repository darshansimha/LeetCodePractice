package array;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement2 {
	public int[] nextGreaterElements(int[] nums) {
		if (nums == null || nums.length == 0) {
			return null;
		}
		int len = nums.length;
		int[] result = new int[len];
		Arrays.fill(result, -1);
		Stack<Integer> stack = new Stack<Integer>();

		for (int i = 0; i < len * 2; i++) {
			int idx = i % len;
			while (!stack.isEmpty() && nums[idx] > nums[stack.peek()]) {
				int elem = stack.pop();
				result[elem] = nums[idx];
			}
			stack.push(idx);
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NextGreaterElement2 n = new NextGreaterElement2();
		System.out.println(n.nextGreaterElements(new int[] { 1, 2, 1 }));
	}

}
