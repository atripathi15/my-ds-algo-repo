package com.ashish.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GraphTraversalService {

	/**
	 * Time Complexity O(V+E)
	 * @param adj : adjacency list of given graph
	 * @param s : source vertex
	 * @param V : no of vertices in graph
	 * @return BFSString
	 */
	public String BFS(List<ArrayList<Integer>> adj, int s, int V) {
		StringBuilder bfsString = new StringBuilder();
		boolean[] visited = new boolean[V + 1];
		LinkedList<Integer> queue = new LinkedList<>();
		queue.add(s);
		visited[s] = true;
		while (!queue.isEmpty()) {
			int u = queue.poll();
			System.out.print(u + " ");
			bfsString.append(u+" ");
			for (int v : adj.get(u)) {
				if (!visited[v]) {
					visited[v] = true;
					queue.add(v);
				}
			}
		}
		return bfsString.toString();
	}
	
	/** this method is used by disconnected graphs */
	public String BFS(List<ArrayList<Integer>> adj, int s, boolean[] visited) {
		StringBuilder bfsString = new StringBuilder();
		LinkedList<Integer> queue = new LinkedList<>();
		queue.add(s);
		visited[s] = true;
		while (!queue.isEmpty()) {
			int u = queue.poll();
			System.out.print(u + " ");
			bfsString.append(u+" ");
			for (int v : adj.get(u)) {
				if (!visited[v]) {
					visited[v] = true;
					queue.add(v);
				}
			}
		}
		return bfsString.toString();
	}
	
	public String BFSDisConnectedGraph(List<ArrayList<Integer>> adj, int V) {
		boolean[] visited = new boolean[V + 1];
		StringBuilder bfsString = new StringBuilder();
		for (int i = 0; i <= V; i++) {
			if (!visited[i]) {
				bfsString.append(BFS(adj, i, visited));
			}
		}
		return bfsString.toString();
	}
	
	/**
	 * Time Complexity O(V+E)
	 * @param adj : adjacency list of given graph
	 * @param s : source vertex
	 * @param V : no of vertices in graph
	 * @return BFSString
	 */
	public void DFS(List<ArrayList<Integer>> adj, int s, int V) {
		boolean[] visited = new boolean[V + 1];
		DFSRec(adj, s, visited);
	}
	
	public void DFSRec(List<ArrayList<Integer>> adj, int s, boolean[] visited) {
		visited[s]= true;
		System.out.print(s+" ");
		for(Integer u :adj.get(s)) {
			if(!visited[u]) {
				DFSRec(adj, u, visited);
			}
		}
	}
	
	public void DFSDisconnected(List<ArrayList<Integer>> adj, int V) {
		boolean[] visited = new boolean[V + 1];
		for (int i = 0; i <= V; i++) {
			if (!visited[i]) {
				DFSRec(adj, i, visited);
			}
		}
		
	}

}
