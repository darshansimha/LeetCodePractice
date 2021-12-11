package Dec_07;

import java.util.HashSet;
import java.util.Set;

public class LowestCommonAncestorOfABinaryTreeWithParentPointer {
	class Node {
		public int val;
		public Node left;
		public Node right;
		public Node parent;
	};

	public Node lowestCommonAncestor(Node p, Node q) {
		if (p == null && q == null) {
			return null;
		}
		if (p != null && q == null) {
			return p;
		}
		if (q != null && p == null) {
			return q;
		}

		Set<Node> pParents = new HashSet<Node>();

		while (p != null) {
			pParents.add(p);
			p = p.parent;
		}

		while (q != null) {
			if (pParents.contains(q)) {
				return q;
			}
			q = q.parent;
		}
		
		return null;
	}
}
