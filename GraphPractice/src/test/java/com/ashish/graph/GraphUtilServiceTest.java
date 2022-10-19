package com.ashish.graph;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@TestInstance(Lifecycle.PER_CLASS)
public class GraphUtilServiceTest {
	
	@InjectMocks
	private GraphUtilService graphUtilService;
	
	@InjectMocks
	private AdjacencyListService adjacencyListService;
	
	@Test
	public void getShortestPathTest() {
		List<ArrayList<Integer>> adj = adjacencyListService.getInitializedAdjacencyList(4);
		adjacencyListService.addEdge(adj, 0, 1);
		adjacencyListService.addEdge(adj, 0, 2);
		adjacencyListService.addEdge(adj, 1, 0);
		adjacencyListService.addEdge(adj, 1, 2);
		adjacencyListService.addEdge(adj, 1, 3);
		adjacencyListService.addEdge(adj, 2, 0);
		adjacencyListService.addEdge(adj, 2, 1);
		adjacencyListService.addEdge(adj, 2, 3);
		adjacencyListService.addEdge(adj, 3, 1);
		adjacencyListService.addEdge(adj, 3, 2);
		
		int[] dist = graphUtilService.shortestPath(adj, 3);
		Arrays.stream(dist).forEach(value -> System.out.print(value+" "));
	}
	
	@Test
	public void isCycleUndirectedGraphTest() {
		
		List<ArrayList<Integer>> adj = adjacencyListService.getInitializedAdjacencyList(6);
		adjacencyListService.addEdge(adj, 0, 1);
		adjacencyListService.addEdge(adj, 1, 0);
		adjacencyListService.addEdge(adj, 1, 2);
		adjacencyListService.addEdge(adj, 1, 3);
		adjacencyListService.addEdge(adj, 2, 1);
		adjacencyListService.addEdge(adj, 2, 3);
		adjacencyListService.addEdge(adj, 2, 4);
		adjacencyListService.addEdge(adj, 3, 1);
		adjacencyListService.addEdge(adj, 3, 2);
		adjacencyListService.addEdge(adj, 4, 2);
		adjacencyListService.addEdge(adj, 4, 5);
		adjacencyListService.addEdge(adj, 5, 4);
		assertEquals(true, graphUtilService.DFSDisconnected(adj, 5));
		
		List<ArrayList<Integer>> adj2 = adjacencyListService.getInitializedAdjacencyList(4);
		adjacencyListService.addEdge(adj2, 0, 1);
		adjacencyListService.addEdge(adj2, 1, 0);
		adjacencyListService.addEdge(adj2, 1, 2);
		adjacencyListService.addEdge(adj2, 2, 1);
		adjacencyListService.addEdge(adj2, 2, 3);
		assertEquals(false, graphUtilService.DFSDisconnected(adj2, 3));
		
	}
	
	@Test
	public void isCycleDirectedGraphTest() {
		
		List<ArrayList<Integer>> adj = adjacencyListService.getInitializedAdjacencyList(6);
		adjacencyListService.addEdge(adj, 0, 1);
		adjacencyListService.addEdge(adj, 2, 1);
		adjacencyListService.addEdge(adj, 2, 3);
		adjacencyListService.addEdge(adj, 3, 4);
		adjacencyListService.addEdge(adj, 4, 5);
		adjacencyListService.addEdge(adj, 5, 3);
		assertEquals(true, graphUtilService.DFSDirected(adj, 5));
		
		List<ArrayList<Integer>> adj2 = adjacencyListService.getInitializedAdjacencyList(5);
		adjacencyListService.addEdge(adj2, 0, 1);
		adjacencyListService.addEdge(adj2, 2, 1);
		adjacencyListService.addEdge(adj2, 2, 3);
		adjacencyListService.addEdge(adj2, 3, 4);
		assertEquals(false, graphUtilService.DFSDirected(adj2, 4));
		
	}
	
	@Test
	public void topologicalSortTest() {
		List<ArrayList<Integer>> adj = adjacencyListService.getInitializedAdjacencyList(5);
		adjacencyListService.addEdge(adj, 0, 2);
		adjacencyListService.addEdge(adj, 0, 3);
		adjacencyListService.addEdge(adj, 1, 3);
		adjacencyListService.addEdge(adj, 1, 4);
		adjacencyListService.addEdge(adj, 2, 3);		
		int[] inDegree = adjacencyListService.getGraphIndegree(adj, 4);
		System.out.println("Topological Sort--BFS Approach");
		graphUtilService.getTopologicalSorting(adj, 5, inDegree);
		
		System.out.println("\nTopological Sort--DFS Approach");
		graphUtilService.getTopologicalSortingDFS(adj, 5);
		
		
	}
	
	

}
