package com.ashish.graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

class Graph {
	private int V;
	private LinkedList<Integer> adj[];
	private int time;

	Graph(int v) {
		V = v;
		adj = new LinkedList[v];
		for (int i = 0; i < v; ++i)
			adj[i] = new LinkedList();
	}

	void addEdge(int v, int w) {
		adj[v].add(w);
	}

	void DFSUtil(int v, boolean visited[]) {

		visited[v] = true;
		System.out.print(v + " ");

		int n;

		Iterator<Integer> i = adj[v].iterator();
		while (i.hasNext()) {
			n = i.next();
			if (!visited[n])
				DFSUtil(n, visited);
		}
	}

	Graph getTranspose() {
		Graph g = new Graph(V);
		for (int v = 0; v < V; v++) {
			Iterator<Integer> i = adj[v].listIterator();
			while (i.hasNext())
				g.adj[i.next()].add(v);
		}
		return g;
	}

	void fillOrder(int v, boolean visited[], Stack stack) {
		visited[v] = true;

		Iterator<Integer> i = adj[v].iterator();
		while (i.hasNext()) {
			int n = i.next();
			if (!visited[n])
				fillOrder(n, visited, stack);
		}

		stack.push(new Integer(v));
	}

	void printSCCs() {
		Stack stack = new Stack();

		boolean visited[] = new boolean[V];
		for (int i = 0; i < V; i++)
			visited[i] = false;

		for (int i = 0; i < V; i++)
			if (!visited[i])
				fillOrder(i, visited, stack);

		Graph gr = getTranspose();

		for (int i = 0; i < V; i++)
			visited[i] = false;

		while (stack.empty() == false) {
			int v = (int) stack.pop();

			if (visited[v] == false) {
				gr.DFSUtil(v, visited);
				System.out.println();
			}
		}
	}

	void printTarjanSCCs() {
		int disc[] = new int[V];
		int low[] = new int[V];
		for (int i = 0; i < V; i++) {
			disc[i] = -1;
			low[i] = -1;
		}

		boolean stackMember[] = new boolean[V];
		Stack<Integer> st = new Stack<Integer>();

		for (int i = 0; i < V; i++) {
			if (disc[i] == -1)
				SCCUtil(i, low, disc, stackMember, st);
		}
	}

	void SCCUtil(int u, int low[], int disc[], boolean stackMember[], Stack<Integer> st) {
		disc[u] = time;
		low[u] = time;
		time += 1;
		stackMember[u] = true;
		st.push(u);

		int n;

		Iterator<Integer> i = adj[u].iterator();

		while (i.hasNext()) {
			n = i.next();

			if (disc[n] == -1) {
				SCCUtil(n, low, disc, stackMember, st);

				low[u] = Math.min(low[u], low[n]);
			} else if (stackMember[n] == true) {

				low[u] = Math.min(low[u], disc[n]);
			}
		}

		int w = -1;
		if (low[u] == disc[u]) {
			while (w != u) {
				w = (int) st.pop();
				System.out.print(w + " ");
				stackMember[w] = false;
			}
			System.out.println();
		}
	}

	public static void main(String args[]) {
		Graph g = new Graph(5);
		g.addEdge(1, 0);
		g.addEdge(0, 2);
		g.addEdge(2, 1);
		g.addEdge(0, 3);
		g.addEdge(3, 4);

		System.out.println("Following are strongly connected components " + "in given graph using KosaRaju's algo ");
		g.printSCCs();

		System.out.println("Following are strongly connected components " + "in given graph using Tarjan's algo ");
		g.printTarjanSCCs();
	}
}
