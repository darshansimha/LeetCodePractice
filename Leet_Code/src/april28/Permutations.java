package april28;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
    	List<List<Integer>> result = new ArrayList();
    	if(nums == null || nums.length == 0) {
    		return result;
    	}
    	permuteRec(result, new ArrayList<Integer>(), nums, 0);
    	return result;
    }
    
    public void permuteRec(List<List<Integer>> result, List<Integer> current, int[] nums, int index) {
    	if(current.size() == nums.length) {
    		result.add(current);
    		return;
    	}
    	
    	
    	for(int i = index; i < nums.length; i++) {
    		current.add(nums[i]);
    		permuteRec(result, current, nums, index + 1);
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Permutations p = new Permutations();
		System.out.println(p.permute(new int[]{1,2,3}));
	}

}
