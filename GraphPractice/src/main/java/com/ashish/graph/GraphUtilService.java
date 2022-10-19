package com.ashish.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import org.springframework.stereotype.Service;

@Service
public class GraphUtilService {

	/**
	 * Time Complexity O(V+E)
	*/
	public int[] shortestPath(List<ArrayList<Integer>> adj, int V) {
		int[] dist = new int[V+1];
		boolean[] visited = new boolean[V + 1];
		LinkedList<Integer> queue = new LinkedList<>();
		for (int i = 0; i < dist.length; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		dist[0] = 0;
		queue.add(0);
		visited[0] = true;
		while (!queue.isEmpty()) {
			int u = queue.poll();
			for (int v : adj.get(u)) {
				if (!visited[v]) {
					dist[v] = dist[u] + 1;
					visited[v] = true;
					queue.add(v);
				}
			}
		}
		return dist;
	}
	
	/** Method to find cycle in undirected graph using DFS approach **/
	public boolean DFSRec(List<ArrayList<Integer>> adj, int s, boolean[] visited, int parent) {
		visited[s] = true;
		for (Integer u : adj.get(s)) {
			if (!visited[u]) {
				if (DFSRec(adj, u, visited, s))
					return true;
			} else if (u != parent) {
					return true;
			}
		}
		return false;
	}
	
	/** Method to find cycle in undirected graph using DFS approach **/
	public boolean DFSDisconnected(List<ArrayList<Integer>> adj, int V) {
		boolean[] visited = new boolean[V + 1];
		for (int i = 0; i < V; i++) {
			if (!visited[i]) {
				if(DFSRec(adj, i, visited,-1)) return true;
			}
		}
		return false;
		
	}
	
	/** Method to find cycle in directed graph using DFS approach **/
	public boolean DFSRecDirected(List<ArrayList<Integer>> adj, int s, boolean[] visited, boolean[] recStack) {
		visited[s] = true;
		recStack[s] = true;
		for (Integer u : adj.get(s)) {
			if (!visited[u]) {
				if (DFSRecDirected(adj, u, visited, recStack))
					return true;
			} else if (recStack[u]) {
				return true;
			}
		}
		recStack[s] = false;
		return false;
	}
	
	/** Method to find cycle in directed graph using DFS approach **/
	public boolean DFSDirected(List<ArrayList<Integer>> adj, int V) {
		boolean[] visited = new boolean[V + 1];
		boolean[] recStack = new boolean[V + 1];
		for (int i = 0; i < V; i++) {
			if (!visited[i]) {
				if(DFSRecDirected(adj, i, visited,recStack)) return true;
			}
		}
		return false;
		
	}
	
	/** Kahn's Algorithm - Based on BFS
	 *  Time Complexity - O(V+E)
	 */
	public void getTopologicalSorting(List<ArrayList<Integer>> adj, int V, int[] inDegree) {
		LinkedList<Integer> queue = new LinkedList<>();
		for (int i = 0; i < inDegree.length; i++) {
			if (inDegree[i] == 0) {
				queue.add(i);
			}
		}
		while (!queue.isEmpty()) {
			int s = queue.poll();
			System.out.print(s + " ");
			for (Integer u : adj.get(s)) {
				inDegree[u]--;
				if (inDegree[u] == 0) {
					queue.add(u);
				}
			}
		}
	}
	
	/** Method to find cycle in directed graph using BFS approach based on Kahn's algo **/
	public boolean DetectCycleDirected(List<ArrayList<Integer>> adj, int V, int[] inDegree) {
		LinkedList<Integer> queue = new LinkedList<>();
		int count = 0;
		for (int i = 0; i < inDegree.length; i++) {
			if (inDegree[i] == 0) {
				queue.add(i);
			}
		}
		while (!queue.isEmpty()) {
			int s = queue.poll();
			System.out.print(s + " ");
			for (Integer u : adj.get(s)) {
				inDegree[u]--;
				if (inDegree[u] == 0) {
					queue.add(u);					
				}
			}
			count++;
		}
		return (count!=V);		
	}
	
	/** Based on DFS
	 * Time Complexity - O(V+E)
	*/
	public void getTopologicalSortingDFS(List<ArrayList<Integer>> adj, int V) {
		boolean[] visited = new boolean[V + 1];
		Stack<Integer> stk = new Stack<>();
		for (int i = 0; i < V; i++) {
			if (!visited[i]) {
				DFSRecDirected(adj, i, visited, stk);
			}
		}
		while(!stk.isEmpty()) {
			System.out.print(stk.pop()+" ");
		}
	}
	
	public void DFSRecDirected(List<ArrayList<Integer>> adj, int s, boolean[] visited, Stack<Integer> stk) {
		visited[s] = true;
		for (Integer u : adj.get(s)) {
			if (!visited[u]) {
				DFSRecDirected(adj, u, visited, stk);
			}			
		}
		stk.add(s);
	}

}
