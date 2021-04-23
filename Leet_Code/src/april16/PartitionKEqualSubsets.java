package april16;

public class PartitionKEqualSubsets {

	public boolean canPartitionKSubsets(int[] nums, int k) {
		int sum = 0;
		int numberOfTruths = 0;

		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}

		if (sum % k != 0) {
			return false;
		}
		int target = sum / k;

		boolean[][] dpTable = new boolean[nums.length + 1][target + 1];

		dpTable = resetDpTable(dpTable);

		boolean chosen = false, notChosen = false;

		for (int i = 1; i <= nums.length; i++) {
			for (int j = 1; j <= target; j++) {

				if (j - nums[i - 1] < 0) {
					chosen = false;
				} else {
					chosen = dpTable[i - 1][j - nums[i - 1]];
				}
				// not selecting the element
				notChosen = dpTable[i - 1][j];

				dpTable[i][j] = chosen || notChosen;

				if (j == target && dpTable[i][j] == true) {
					numberOfTruths++;

					if (j - nums[i - 1] != 0) {
						nums[Math.abs(j - i)] = 0;
					}
					nums[i - 1] = 0;
					dpTable = resetDpTable(dpTable);
					i = 0;
					j = 0;
				}
			}
		}

		return numberOfTruths == k;
	}

	public boolean[][] resetDpTable(boolean[][] dpTable) {
		int row = dpTable.length;
		int cols = dpTable[0].length;
		dpTable = new boolean[row][cols];

		for (int i = 0; i <= cols; i++) {
			dpTable[i][0] = true;
		}

		return dpTable;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PartitionKEqualSubsets p = new PartitionKEqualSubsets();
		System.out.println(p.canPartitionKSubsets(new int[] { 1, 1, 1, 1, 1, 1, 1, 1, 1, 1 }, 5));
	}

}
