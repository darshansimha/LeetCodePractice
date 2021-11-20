package array;

//https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

public class FindMinimumInRotatedSortedArray {
	public int findMin(int[] nums) {
		if (nums.length == 1) {
			return nums[0];
		}
		if (nums.length == 2) {
			return nums[0] < nums[1] ? nums[0] : nums[1];
		}
		int minIndex = findPivot(nums, 0, nums.length - 1);
		return nums[minIndex >= 0 ? minIndex : 0];
	}

	private int findPivot(int[] nums, int low, int high) {
		int mid = low + (high - low) / 2;
		//Boundary conditions as to not breach the boundary on the left and right side
		if (mid >= nums.length || mid < 0 || low > high) {
			return -1;
		}
		//Breaking pattern where nums[mid] is greater than the next element
		if (mid + 1 < nums.length -1 && nums[mid] > nums[mid + 1]) {
			return mid + 1;
		}
		//Breaking pattern where nums[mid] is less than the previous element
		if(mid - 1 >=0 && nums[mid] < nums[mid - 1]) {
			return mid;
		}
		return Math.max(findPivot(nums, low, mid - 1), findPivot(nums, mid + 1, high));
	}

	public static void main(String[] args) {
		FindMinimumInRotatedSortedArray f = new FindMinimumInRotatedSortedArray();
		System.out.println(f.findMin(new int[] { 5, 1, 2, 3, 4 }));
	}

}
