package array;

import java.util.Arrays;

public class TwoSum2 {
    public int[] twoSum(int[] numbers, int target) {
    	int size = numbers.length;
        int left = 0;
        int right = size - 1;
        int currSum = 0;
        int[] result = new int[2];
        while(left < right) {
        	currSum = numbers[left] + numbers[right];
        	if(currSum == target) {
        		result[0] = left + 1;
        		result[1] = right + 1;
        		break;
        	} else if(currSum > target) {
        		right--;
        	} else {
        		left++;
        	}
        }
        
        return result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TwoSum2 t = new TwoSum2();
		System.out.println(Arrays.toString(t.twoSum(new int[] {2,7,11,15}, 9)));
	}

}
