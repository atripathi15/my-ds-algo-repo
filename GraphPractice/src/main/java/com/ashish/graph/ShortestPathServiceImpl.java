package com.ashish.graph;

import org.springframework.stereotype.Service;

@Service
public class ShortestPathServiceImpl {

	/**
	 * Time Complexity theta(V2)
	 * @param graph
	 * @param src
	 * @return
	 */
	public int[] dijkstraShortestPath(int[][] graph, int src) {
		int V = graph.length;
		int[] dist = new int[V];
		for (int i = 0; i < V; i++) {
			dist[i] = Integer.MAX_VALUE;
		}
		dist[src] = 0;
		boolean[] fSet = new boolean[V]; // finalized set of vertices

		for (int count = 0; count < V - 1; count++) {
			int u = -1;
			for (int j = 0; j < V; j++) {
				if (!fSet[j] && (u == -1 || dist[j] < dist[u])) {
					u = j;
				}
			}
			fSet[u] = true;
			for (int v = 0; v < V; v++) {
				if (!fSet[v] && graph[u][v] != 0) {
					if (dist[v] > dist[u] + graph[u][v]) {
						dist[v] = dist[u] + graph[u][v];
					}
				}
			}
		}
		return dist;
	}

}
