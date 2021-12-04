package Trees;

import Common.TreeNode;

public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        return maxDepthHelper(root, 0);
    }
    public int maxDepthHelper(TreeNode root, int current) {
    	if(root == null) {
    		return current;
    	} else {
    		return Math.max(maxDepthHelper(root.left, 1 + current), maxDepthHelper(root.right, 1 + current));
    	}
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
