package april11;

import java.util.Arrays;

public class ThreeSumTarget {
    public int threeSumClosest(int[] nums, int target) {
        int result = Integer.MIN_VALUE;
        Arrays.sort(nums);
        int minDifference = Integer.MAX_VALUE;
        int currSum = 0;
        int low = 0;
        int high = 0;
        for(int i = 0; i < nums.length; i++) {
        	low = i+1;
        	high = nums.length - 1;
        	while(high > low) {
        		currSum = nums[i] + nums[low] + nums[high];
        		if(currSum > target) {
        			high--;
        		} else if(currSum == target) {
        			return target;
        		} else {
        			low++;
        		}
        		if(Math.abs(target - currSum) < minDifference) {
        			minDifference = Math.abs(target - currSum);
        			result = currSum;
        		}
        	}
        }
        return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ThreeSumTarget t = new ThreeSumTarget();
		System.out.println(t.threeSumClosest(new int[] {-1, 0, 1, 1, 55}, 3));
	}

}
