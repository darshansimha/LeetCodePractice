package String;

import java.util.Stack;

public class SimplifyFilePath {
	public String simplifyPath(String path) {
		if (path == null || path.length() == 0) {
			return "/";
		}
		StringBuilder sb = new StringBuilder();

		Stack<String> stack = new Stack<String>();

		String[] components = path.split("/");

		for (String s : components) {
			if (s.equals(".") || s.isEmpty()) {
				continue;
			} else if (s.equals("..")) {
				if (!stack.isEmpty()) {
					stack.pop();
				}
			} else {
				stack.add(s);
			}

		}
		for (String dir : stack) {
			sb.append("/");
			sb.append(dir);
		}
		return sb.toString().equals("") ? "/" : sb.toString();

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
