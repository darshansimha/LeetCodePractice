package Dec_11;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {
	Map<Node, Node> map;

	class Node {
		public int val;
		public List<Node> neighbors;

		public Node() {
			val = 0;
			neighbors = new ArrayList<Node>();
		}

		public Node(int _val) {
			val = _val;
			neighbors = new ArrayList<Node>();
		}

		public Node(int _val, ArrayList<Node> _neighbors) {
			val = _val;
			neighbors = _neighbors;
		}
	}

	public Node cloneGraph(Node node) {
		if (node == null) {
			return null;
		}
		map = new HashMap<>();
		return dfs(node);
	}

	private Node dfs(Node root) {
		if (map.containsKey(root)) {
			return map.get(root);
		}
		Node copy = new Node(root.val);
		map.put(root, copy);
		for (Node neighbour : root.neighbors) {
			copy.neighbors.add(dfs(neighbour));
		}
		return copy;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
