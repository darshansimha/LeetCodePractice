package Graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseSchedule {
	
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		Map<Integer, List<Integer>> adj = new HashMap<>();
		for(int i = 0; i < numCourses; i++) {
			adj.put(i, new ArrayList<Integer>());
		}
		
		for(int i = 0; i < prerequisites.length; i++) {
			adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
		}
		
		int[] visited = new int[numCourses];
		
		for(int i = 0; i < numCourses; i++) {
			if(!dfs(adj, i, visited)) {
				return false;
			}
		}
		
		return true;
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

	}

}
