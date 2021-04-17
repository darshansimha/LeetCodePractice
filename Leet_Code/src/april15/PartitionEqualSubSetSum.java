package april15;

public class PartitionEqualSubSetSum {
	public boolean canPartition(int[] nums) {
		int sum = 0;

		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}

		if (sum % 2 != 0) {
			return false;
		}
		int target = sum / 2;

		return this.subSetSumExists(nums, target);
	}

	public boolean subSetSumExists(int[] nums, int target) {
		boolean[][] dpTable = new boolean[nums.length + 1][target + 1];

		for (int i = 0; i <= nums.length; i++) {
			dpTable[i][0] = true;
		}
		boolean chosen = false, notChosen = false;

		for (int i = 1; i <= nums.length; i++) {
			for (int j = 1; j <= target; j++) {
				// selecting the element
				if (j - nums[i - 1] < 0) {
					chosen = false;
				} else {
					chosen = dpTable[i - 1][j - nums[i - 1]];
				}
				// not selecting the element
				notChosen = dpTable[i - 1][j];

				dpTable[i][j] = chosen || notChosen;
			}
		}
		return dpTable[dpTable.length - 1][target];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PartitionEqualSubSetSum p = new PartitionEqualSubSetSum();
		System.out.println(p.canPartition(new int[] { 1, 5, 5, 11 }));
	}

}
