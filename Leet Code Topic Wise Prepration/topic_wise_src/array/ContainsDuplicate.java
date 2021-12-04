package array;

//https://leetcode.com/problems/contains-duplicate/submissions/

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
	public boolean containsDuplicate(int[] nums) {
		Set<Integer> unique = new HashSet<Integer>();
		
		for(int i = 0; i < nums.length; i++) {
			if(unique.contains(nums[i])) {
				return true;
			}
			unique.add(nums[i]);
		}
		
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
