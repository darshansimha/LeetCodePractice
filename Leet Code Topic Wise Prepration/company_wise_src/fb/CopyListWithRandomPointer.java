package Dec_11;

import java.util.HashMap;
import java.util.Map;

public class CopyListWithRandomPointer {
	class Node {
		int val;
		Node next;
		Node random;

		public Node(int val) {
			this.val = val;
			this.next = null;
			this.random = null;
		}
	}

	Map<Node, Node> map;

	public Node copyRandomList(Node head) {
		if(head == null) {
			return null;
		}
		map = new HashMap<>();
		return dfs(head);
	}

	private Node dfs(Node root) {
		if (map.containsKey(root)) {
			return map.get(root);
		}
		Node copy = new Node(root.val);
		map.put(root, copy);
		if (root.random != null) {
			copy.random = dfs(root.random);
		}
		if (root.next != null) {
			copy.next = dfs(root.next);
		}
		return copy;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
