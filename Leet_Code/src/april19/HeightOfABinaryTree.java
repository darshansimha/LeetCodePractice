package april19;

public class HeightOfABinaryTree {
	class Node {
		int data;
		Node left, right;

		Node(int item) {
			data = item;
			left = right = null;
		}
	}

	int height(Node root) {
		if(root == null) {
			return 0;
		}
		return findHeightRec(root);

	}

	public int findHeightRec(Node root) {
		if (root == null) {
			return 0;
		} else {
			return Math.max(1 + findHeightRec(root.left), 1 + findHeightRec(root.right));
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
