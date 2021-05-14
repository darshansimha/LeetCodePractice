package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseSchedule2 {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		int[] result = new int[numCourses];
		Map<Integer, List<Integer>> adj = new HashMap<>();
		Map<Integer, Integer> indegree = new HashMap<>();
		for (int i = 0; i < numCourses; i++) {
			adj.put(i, new ArrayList<Integer>());
		}

		for (int i = 0; i < prerequisites.length; i++) {
			adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
			indegree.put(prerequisites[i][1], indegree.getOrDefault(prerequisites[i][1], 0) + 1);
		}

		int[] visited = new int[numCourses];
		
		for(int i = 0; i < numCourses; i++) {
			if(!dfs(adj, i, visited)) {
				return result;
			}
		}
		return result;
	}
	public boolean dfs(Map<Integer, List<Integer>> adj, int curr, int[] visited) {
		if(visited[curr] == -1) {
			return false;
		}
		if(visited[curr] == 1) {
			return true;
		}
		visited[curr] = -1;
		for(int i : adj.get(curr)) {
			if(!dfs(adj, i, visited)) {
				return false;
			}
		}
		
		visited[curr] = 1;
		
		return true;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CourseSchedule2 c = new CourseSchedule2();
		System.out.println(c.findOrder(4, new int[][] {{ 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 }} ));
	}

}
