package Trees.Basics;

import java.util.ArrayList;
import java.util.List;

import Common.TreeNode;

public class InorderTraversalRecursion {
    public List<Integer> inorderTraversal(TreeNode root) {
    	List<Integer> result = new ArrayList<Integer>();
    	inorderTraversalHelper(root, result);
    	return result;
    }
    public void inorderTraversalHelper(TreeNode root, List<Integer> result) {
    	if(root == null) {
    		return;
    	}
    	inorderTraversalHelper(root.left, result);
    	result.add(root.val);
    	inorderTraversalHelper(root.right, result);
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
