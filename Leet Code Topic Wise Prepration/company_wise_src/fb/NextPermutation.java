package Dec_07;

public class NextPermutation {

	public void nextPermutation(int[] nums) {
		if (nums == null || nums.length == 0 || nums.length == 1) {
			return;
		}
		int len = nums.length;
		int pointer = nums.length - 2;
		int index = -1;
		while (pointer >= 0) {
			if (nums[pointer] < nums[pointer + 1]) {
				index = pointer;
				break;
			}
			pointer--;
		}
		if (index == -1) {
			reverse(nums, 0);
		} else {
			int nextGreaterElementIndex = index + 1;
			pointer = index;
			while (nextGreaterElementIndex < len) {
				if (nums[pointer] < nums[nextGreaterElementIndex]) {
					nextGreaterElementIndex++;
				} else {
					nextGreaterElementIndex--;
					break;
				}
			}
			if (nextGreaterElementIndex == len) {
				nextGreaterElementIndex -= 1;
			}
			int temp = nums[index];
			nums[index] = nums[nextGreaterElementIndex];
			nums[nextGreaterElementIndex] = temp;
			reverse(nums, index + 1);
		}
	}

	private void reverse(int[] nums, int start) {
		int temp = 0;
		int len = nums.length;
		int left = start;
		int right = len - 1;
		while (right > left) {
			temp = nums[left];
			nums[left] = nums[right];
			nums[right] = temp;
			left++;
			right--;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NextPermutation n = new NextPermutation();
		n.nextPermutation(new int[] { 1, 2, 3 });
	}

}
