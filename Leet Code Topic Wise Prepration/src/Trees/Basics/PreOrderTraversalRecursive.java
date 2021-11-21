package Trees.Basics;

import java.util.ArrayList;
import java.util.List;

import Common.TreeNode;

public class PreOrderTraversalRecursive {
    public List<Integer> preorderTraversal(TreeNode root) {
    	List<Integer> result = new ArrayList<Integer>();
    	preOrderTraversalHelper(root, result);
    	return result;
    }
    private void preOrderTraversalHelper(TreeNode root, List<Integer> result) {
    	if(root == null) {
    		return;
    	}
    	result.add(root.val);
    	preOrderTraversalHelper(root.left, result);
    	preOrderTraversalHelper(root.right, result);
    }
}
