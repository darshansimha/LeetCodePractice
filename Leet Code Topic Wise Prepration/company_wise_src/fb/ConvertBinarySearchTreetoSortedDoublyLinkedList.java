package Dec_06;

public class ConvertBinarySearchTreetoSortedDoublyLinkedList {
	Node first = null;
	Node last = null;

	class Node {
		public int val;
		public Node left;
		public Node right;

		public Node() {
		}

		public Node(int _val) {
			val = _val;
		}

		public Node(int _val, Node _left, Node _right) {
			val = _val;
			left = _left;
			right = _right;
		}
	};

	public Node treeToDoublyList(Node root) {
		if (root == null) {
			return root;
		}
		//Since the problem mentions that it is a BST and we need a sorted DLL
		//i.e. we need to do an inorder traversal to navigate in a sorted fashion
		inOrderTraversal(root);
		//This takes care of the edge cases where we need to link the first's successor as last	
		last.right = first;
		//And last's predecessor as the first so that there is a circle
		first.left = last;
		
		return first;
	}
	
	private void inOrderTraversal(Node root){
		if(root == null) {
			return;
		}
		//Travel as much to the left as possible
		inOrderTraversal(root.left);
		//We check if this is the first node we start to process
		//i.e. the leftmost node
		//We choose to use last as an indicator instead of first is because first will only be populated once and 
		//Then we only look at the last node
		if(last == null) {
			//Initialize first
			first = root;
		} else {
			// We need to take the last element's successor as the current node we are processing
			last.right = root;
			//We also need to say that the current node's predecessor is the last node
			root.left = last;
		}
		//We populate the last node for the next node we process
		last = root;
		
		inOrderTraversal(root.right);
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
