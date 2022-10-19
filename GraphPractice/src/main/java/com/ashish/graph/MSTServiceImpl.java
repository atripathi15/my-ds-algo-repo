package com.ashish.graph;

import org.springframework.stereotype.Service;

@Service
public class MSTServiceImpl {

	/**
	 * Time Complexity = O(V2)
	 * Can be optimized to O(ElogV) by using:
	 *  	minHeap for storing keys--extract min --O(logV)
	 *  	adjacency list instead of graph array --O(V+E) along with decrease key O(logV) = O(V+E)logV
	 * 
	 * @param graph
	 * @param V
	 * @return
	 */
	public int primMST(int[][] graph, int V) {
		int res = 0;
		int[] keys = new int[V];
		for (int i = 0; i < keys.length; i++) {
			keys[i] = Integer.MAX_VALUE;
		}
		keys[0] = 0;
		boolean[] mSet = new boolean[V];
		for (int count = 0; count < V; count++) {
			int u = -1;
			for (int j = 0; j < V; j++) {
				if (!mSet[j] && (u == -1 || keys[j] < keys[u])) {
					u = j;
				}
			}
			mSet[u] = true;
			res = res + keys[u];
			for (int v = 0; v < V; v++) {
				if (!mSet[v] && graph[u][v] != 0 && graph[u][v] < keys[v]) {
					keys[v] = graph[u][v];
				}
			}
		}
		return res;
	}

}
