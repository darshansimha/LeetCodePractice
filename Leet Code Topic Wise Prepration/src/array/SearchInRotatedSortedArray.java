package array;

//https://leetcode.com/problems/search-in-rotated-sorted-array
public class SearchInRotatedSortedArray {
	public int search(int[] nums, int target) {
		int size = nums.length;
		int pivot = findPivot(nums, 0, size - 1);
		if (pivot < 0) {
			return binarySearch(nums, 0, size - 1, target);
		} else {
			return Math.max(binarySearch(nums, 0, pivot - 1, target), binarySearch(nums, pivot, size - 1, target));
		}
	}

	private int findPivot(int[] nums, int low, int high) {
		int mid = low + (high - low) / 2;
		// Boundary conditions as to not breach the boundary on the left and right side
		if (mid >= nums.length || mid < 0 || low > high) {
			return -1;
		}
		// Breaking pattern where nums[mid] is greater than the next element
		if (mid + 1 < nums.length - 1 && nums[mid] > nums[mid + 1]) {
			return mid + 1;
		}
		// Breaking pattern where nums[mid] is less than the previous element
		if (mid - 1 >= 0 && nums[mid] < nums[mid - 1]) {
			return mid;
		}
		return Math.max(findPivot(nums, low, mid - 1), findPivot(nums, mid + 1, high));
	}

	private int binarySearch(int[] nums, int low, int high, int target) {
		int mid = low + (high - low) / 2;
		int size = nums.length;
		if (mid >= size || mid < 0 || low > high) {
			return -1;
		}
		if (nums[mid] == target) {
			return mid;
		}
		if (target > nums[mid]) {
			return binarySearch(nums, mid + 1, high, target);
		} else {
			return binarySearch(nums, low, mid - 1, target);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SearchInRotatedSortedArray s = new SearchInRotatedSortedArray();
		System.out.println(s.search(new int[] { 4, 5, 6, 7, 0, 1, 2 }, 0));
	}

}
