package Tree;

import Common.TreeNode;

public class CountCompleteTreeNodes {
	public int countNodes(TreeNode root) {
	    if (root == null) {
	        return 0;
	      }
	      
	      int leftHeight = leftHeight(root);
	      int rightHeight = rightHeight(root);
	      
	      if (leftHeight == rightHeight) {
	        int result = 2;
	        
	        for (int i = 1; i < leftHeight; i++) {
	          result *= 2;
	        }
	        return result - 1;
	      }
	      
	      return countNodes(root.left) + countNodes(root.right) + 1;
	}

	private int leftHeight(TreeNode root) {
		int height = 0;
		while (root != null) {
			height++;
			root = root.left;
		}
		return height;
	}

	private int rightHeight(TreeNode root) {
		int height = 0;
		while (root != null) {
			height++;
			root = root.right;
		}
		return height;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
