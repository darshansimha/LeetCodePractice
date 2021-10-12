package Others;

public class SearchInRotatedSortedArray {
	public int search(int[] nums, int target) {
		if (nums == null || nums.length == 0) {
			return -1;
		}
		if (nums.length == 1) {
			if (nums[0] == target) {
				return 0;
			} else {
				return -1;
			}
		}
		int rotatedIndex = findRotatedIndex(nums, 0, nums.length - 1);
		int left = binarySearch(nums, target, 0, rotatedIndex);
		int right = binarySearch(nums, target, rotatedIndex + 1, nums.length - 1);

		if (left != -1) {
			return left;
		} else {
			return right;
		}
	}

	public int findRotatedIndex(int[] nums, int low, int high) {
		if (low < 0 || high >= nums.length || low > high) {
			return -1;
		}
		int mid = (high + low) / 2;
		if (mid + 1 == nums.length) {
			return -1;
		}
		if (nums[mid + 1] < nums[mid]) {
			return mid;
		}
		int left = findRotatedIndex(nums, low, mid - 1);
		int right = findRotatedIndex(nums, mid + 1, high);
		if (left != -1) {
			return left;
		} else {
			return right;
		}
	}

	public int binarySearch(int[] nums, int target, int low, int high) {
		if (low < 0 || high >= nums.length || low > high) {
			return -1;
		}
		int mid = (high + low) / 2;
		if (nums[mid] == target) {
			return mid;
		}
		if (target < nums[mid]) {
			return binarySearch(nums, target, low, mid - 1);
		} else {
			return binarySearch(nums, target, mid + 1, high);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SearchInRotatedSortedArray s = new SearchInRotatedSortedArray();

		System.out.println(s.search(new int[] { 1, 3 }, 0));
	}

}
