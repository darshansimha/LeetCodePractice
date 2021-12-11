package Dec_10;

import java.util.Stack;

public class SimplifyPath {

	public String simplifyPath(String path) {
		String[] folders = path.split("/");
		Stack<String> stack = new Stack<String>();
		StringBuilder result = new StringBuilder();
		int len = folders.length;
		int i = 0;
		while (i < len) {
			if (!folders[i].equals(".") && !folders[i].equals(" ") && !folders[i].equals("")
					&& !folders[i].equals("..")) {
				stack.push(folders[i]);
			} else if (folders[i].equals("..")) {
				if (!stack.isEmpty()) {
					stack.pop();
				}
			}
			i++;
		}
		for (String s : stack) {
			result.append("/");
			result.append(s);
		}

		return result.length() > 0 ? result.toString() : "/";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SimplifyPath s = new SimplifyPath();
		System.out.println(s.simplifyPath("/a/../../b/../c//.//"));
	}

}
