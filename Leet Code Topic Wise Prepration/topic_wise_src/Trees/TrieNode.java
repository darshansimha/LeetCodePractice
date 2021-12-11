package Dec_06;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
	private Character content;
	private Map<Character, TrieNode> children;
	private boolean isValid;

	TrieNode(char c) {
		this.content = c;
		isValid = false;
		children = new HashMap<Character, TrieNode>();
	}

	@Override
	public String toString() {
		return "Char : " + content + " Children : " + children.keySet().toString();
	}

	public Character getContent() {
		return content;
	}

	public void setContent(Character content) {
		this.content = content;
	}

	public Map<Character, TrieNode> getChildren() {
		return children;
	}

	public void setChildren(Map<Character, TrieNode> children) {
		this.children = children;
	}

	public boolean isValid() {
		return isValid;
	}

	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}

}
