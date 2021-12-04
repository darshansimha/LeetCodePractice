package Trees;

public class ConstructBinarySearchTreefromPreorderTraversal {
	class CustomTreeNode extends TreeNode {
		CustomTreeNode(int n) {
			super(n);
		}

		public void add(int n) {
			if (n < val) {
				if (left == null) {
					left = new TreeNode(n);
				} else {
					((CustomTreeNode) left).add(n);
				}
			} else {
				if (right == null) {
					right = new TreeNode(n); 
				} else {
					((CustomTreeNode) right).add(n);
				}
			}
		}
	}

	public TreeNode bstFromPreorder(int[] preorder) {
		int len = preorder.length;
		if (len == 0) {
			return null;
		}
		if (len == 1) {
			return new TreeNode(preorder[0]);
		}
		CustomTreeNode root = new CustomTreeNode(preorder[0]);
		for(int i = 1; i < preorder.length; i++) {
			root.add(preorder[i]);
		}
		return root;
	}

}
