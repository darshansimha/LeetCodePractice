package april19;

public class MirrorABinaryTree {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode() {
		}

		TreeNode(int val) {
			this.val = val;
		}

		TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
	}

	public TreeNode invertTree(TreeNode root) {
		invertTreeRec(root);
		return root;
	}
	
	public void invertTreeRec(TreeNode node) {
		
		if(node == null) {
			return;
		}
		
		TreeNode temp = node.left;
		
		node.left = node.right;
		
		node.right = temp;
		
		invertTreeRec(node.left);
		invertTreeRec(node.right);
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
