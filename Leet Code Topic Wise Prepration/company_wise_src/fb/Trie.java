package Dec_06;

import java.util.ArrayList;
import java.util.List;

public class Trie {
	private TrieNode root;

	Trie() {
		this.root = new TrieNode(' ');
	}

	public void addWord(String s) {
		TrieNode current = root;
		char curr = ' ';

		for (int i = 0; i < s.length(); i++) {
			curr = s.charAt(i);
			if (current.getChildren().get(curr) == null) {
				TrieNode temp = new TrieNode(curr);
				current.getChildren().put(curr, temp);
				current = temp;
			} else {
				current = current.getChildren().get(curr);
			}
		}
		current.setValid(true);
	}

	public boolean hasWord(String s) {
		TrieNode current = root;

		for (int i = 0; i < s.length(); i++) {
			current = current.getChildren().get(s.charAt(i));
			if (current == null) {
				return false;
			}
		}
		return current.isValid();
	}

	public List<String> searchWordsWithPrefix(String s) {
		TrieNode current = root;
		List<String> result = new ArrayList<String>();
		char curr = ' ';
		for (int i = 0; i < s.length(); i++) {
			curr = s.charAt(i);
			current = current.getChildren().get(curr);
			if (current == null) {
				return result;
			}
		}
		dfs(current, result, s);

		return result;
	}

	public boolean searchWordsWithPlaceholders(String s, TrieNode node) {
		TrieNode current = root;
		char curr = ' ';
		for (int i = 0; i < s.length(); i++) {
			curr = s.charAt(i);
			if (!node.getChildren().containsKey(curr)) {
				if (curr == '.') {
					for (char x : current.getChildren().keySet()) {
						TrieNode child = node.getChildren().get(x);
						if (searchWordsWithPlaceholders(s.substring(i + 1), child)) {
							return true;
						}
					}

				}
				return false;
			} else {
				node = node.getChildren().get(curr);
			}
		}

		return node.isValid();
	}

	private void dfs(TrieNode current, List<String> result, String partial) {
		if (current == null) {
			return;
		}
		if (current.isValid()) {
			result.add(partial);
		}
		List<TrieNode> children = new ArrayList<TrieNode>(current.getChildren().values());

		for (int i = 0; i < children.size(); i++) {
			dfs(children.get(i), result, partial + children.get(i).getContent());
		}
	}

	public static void main(String[] args) {
		Trie t = new Trie();

		t.addWord("bad");
		t.addWord("dad");
		t.addWord("mad");

		System.out.println(t.searchWordsWithPlaceholders("pad", t.root));
		System.out.println(t.searchWordsWithPlaceholders("bad", t.root));
		System.out.println(t.searchWordsWithPlaceholders(".ad", t.root));
		System.out.println(t.searchWordsWithPlaceholders("b..", t.root));
	}
}
