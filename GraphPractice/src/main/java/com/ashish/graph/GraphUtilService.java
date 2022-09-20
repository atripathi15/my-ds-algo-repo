package com.ashish.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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

}
