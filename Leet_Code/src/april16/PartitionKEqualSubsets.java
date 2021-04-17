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
		
		
    	return numberOfTruths == k;
    }
    public void resetDpTable(boolean[][] dpTable) {
    	int row = dpTable.length;
    	int cols = dpTable[0].length;
    	dpTable = new boolean[row][cols];
    	
		for (int i = 0; i <= cols; i++) {
			dpTable[i][0] = true;
		}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
