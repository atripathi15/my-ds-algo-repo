package com.ashish.graph;

import java.util.ArrayList;
import java.util.List;

public class AdjacencyListService {

	public List<ArrayList<Integer>> getInitializedAdjacencyList(int vertices) {
		List<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>(vertices);
		for (int i = 0; i < vertices; i++) {
			adj.add(new ArrayList<Integer>());
		}
		return adj;
	}

	public void addEdge(List<ArrayList<Integer>> adj, int u, int v) {
		adj.get(u).add(v);
		//required for undirected graph
		//adj.get(v).add(u);
	}

	public void printGraph(List<ArrayList<Integer>> adj) {
		for (int i = 0; i < adj.size(); i++) {
			for (int j = 0; j < adj.get(i).size(); j++) {
				System.out.print(adj.get(i).get(j) + " ");
			}
			System.out.println();
		}
	}

}
