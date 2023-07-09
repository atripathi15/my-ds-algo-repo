package com.ashish.graph;

public class WeightedGraph {

	class Edge {
		int source;
		int dest;
		int weight;

		Edge(int s, int d, int w) {
			source = s;
			dest = d;
			weight = w;
		}
	};

	int V, E;
	private Edge[] edge;

	public WeightedGraph(int v, int e) {
		V = v;
		E = e;
		edge = new Edge[E];
		for (int i = 0; i < e; i++) {
			edge[i] = new Edge(0, 0, 0);
		}
	}

	void BellmanFord(WeightedGraph graph, int src) {
		int V = graph.V, E = graph.E;
		int dist[] = new int[V];

		for (int i = 0; i < V; ++i)
			dist[i] = Integer.MAX_VALUE;
		dist[src] = 0;

		for (int i = 1; i < V; ++i) {
			for (int j = 0; j < E; ++j) {
				int u = graph.edge[j].source;
				int v = graph.edge[j].dest;
				int weight = graph.edge[j].weight;
				if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v])
					dist[v] = dist[u] + weight;
			}
		}

		for (int j = 0; j < E; ++j) {
			int u = graph.edge[j].source;
			int v = graph.edge[j].dest;
			int weight = graph.edge[j].weight;
			if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
				System.out.println("Graph contains negative weight cycle");
				return;
			}
		}
		printArr(dist, V);
	}

	void printArr(int dist[], int V) {
		System.out.println("Vertex Distance from Source");
		for (int i = 0; i < V; ++i)
			System.out.println(i + "\t\t" + dist[i]);
	}

	public static void main(String[] args) {
		int V = 4;
		int E = 5;
		WeightedGraph wg = new WeightedGraph(V, E);
		wg.edge[0].source = 0;
		wg.edge[0].dest = 1;
		wg.edge[0].weight = 1;

		wg.edge[1].source = 0;
		wg.edge[1].dest = 2;
		wg.edge[1].weight = 4;

		wg.edge[2].source = 1;
		wg.edge[2].dest = 2;
		wg.edge[2].weight = -3;

		wg.edge[3].source = 1;
		wg.edge[3].dest = 3;
		wg.edge[3].weight = 2;

		wg.edge[4].source = 2;
		wg.edge[4].dest = 3;
		wg.edge[4].weight = 3;

		wg.BellmanFord(wg, 0);
	}

}
