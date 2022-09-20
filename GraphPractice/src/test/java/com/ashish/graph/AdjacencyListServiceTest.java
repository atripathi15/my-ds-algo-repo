package com.ashish.graph;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@TestInstance(Lifecycle.PER_CLASS)
public class AdjacencyListServiceTest {
	
	@InjectMocks
	private AdjacencyListService adjacencyListService;
	
	@InjectMocks
	private GraphTraversalService graphTraversalService;
	
	@Test
	public void creatAdjacencyList() {
		List<ArrayList<Integer>> adj = adjacencyListService.getInitializedAdjacencyList(4);
		adjacencyListService.addEdge(adj, 0, 1);
		adjacencyListService.addEdge(adj, 0, 2);
		adjacencyListService.addEdge(adj, 1, 0);
		adjacencyListService.addEdge(adj, 1, 2);
		adjacencyListService.addEdge(adj, 2, 0);
		adjacencyListService.addEdge(adj, 2, 1);
		adjacencyListService.addEdge(adj, 2, 3);
		adjacencyListService.addEdge(adj, 3, 2);
		//adjacencyListService.printGraph(adj);
		
		String bfs = graphTraversalService.BFS(adj, 0, 3);
		assertEquals("0 1 2 3", bfs.trim());
		System.out.println();
		
		List<ArrayList<Integer>> adj2 = adjacencyListService.getInitializedAdjacencyList(6+1);
		adjacencyListService.addEdge(adj2, 0, 1);
		adjacencyListService.addEdge(adj2, 0, 2);
		adjacencyListService.addEdge(adj2, 1, 0);
		adjacencyListService.addEdge(adj2, 1, 3);
		adjacencyListService.addEdge(adj2, 2, 0);
		adjacencyListService.addEdge(adj2, 2, 3);
		adjacencyListService.addEdge(adj2, 3, 1);
		//adjacencyListService.addEdge(adj2, 3, 3);
		adjacencyListService.addEdge(adj2, 4, 5);
		adjacencyListService.addEdge(adj2, 4, 6);
		adjacencyListService.addEdge(adj2, 4, 5);
		adjacencyListService.addEdge(adj2, 5, 4);
		adjacencyListService.addEdge(adj2, 5, 6);
		adjacencyListService.addEdge(adj2, 6, 4);
		adjacencyListService.addEdge(adj2, 6, 5);
		//adjacencyListService.printGraph(adj2);
		
		String bfs2 = graphTraversalService.BFSDisConnectedGraph(adj2, 6);
		assertEquals("0 1 2 3 4 5 6", bfs2.trim());
		
		List<ArrayList<Integer>> adj3 = adjacencyListService.getInitializedAdjacencyList(6+1);
		adjacencyListService.addEdge(adj3, 0, 1);
		adjacencyListService.addEdge(adj3, 0, 4);
		adjacencyListService.addEdge(adj3, 1, 0);
		adjacencyListService.addEdge(adj3, 1, 2);
		adjacencyListService.addEdge(adj3, 2, 1);
		adjacencyListService.addEdge(adj3, 2, 3);
		adjacencyListService.addEdge(adj3, 3, 2);
		adjacencyListService.addEdge(adj3, 4, 0);
		adjacencyListService.addEdge(adj3, 4, 5);
		adjacencyListService.addEdge(adj3, 4, 6);
		adjacencyListService.addEdge(adj3, 5, 4);
		adjacencyListService.addEdge(adj3, 5, 6);
		adjacencyListService.addEdge(adj3, 6, 4);
		adjacencyListService.addEdge(adj3, 6, 5);
		System.out.println("\nAdjacency List");
		adjacencyListService.printGraph(adj3);
		System.out.println("DFS: ");
		graphTraversalService.DFS(adj3, 0, 6);
		
		List<ArrayList<Integer>> adj4 = adjacencyListService.getInitializedAdjacencyList(6+1);
		adjacencyListService.addEdge(adj4, 0, 1);
		adjacencyListService.addEdge(adj4, 0, 2);
		adjacencyListService.addEdge(adj4, 1, 0);
		adjacencyListService.addEdge(adj4, 1, 3);
		adjacencyListService.addEdge(adj4, 1, 4);
		adjacencyListService.addEdge(adj4, 2, 0);
		adjacencyListService.addEdge(adj4, 2, 3);
		adjacencyListService.addEdge(adj4, 3, 1);
		adjacencyListService.addEdge(adj4, 3, 2);
		adjacencyListService.addEdge(adj4, 4, 1);
		adjacencyListService.addEdge(adj4, 4, 5);
		adjacencyListService.addEdge(adj4, 5, 4);		
		System.out.println("\nAdjacency List");
		adjacencyListService.printGraph(adj4);
		System.out.println("DFS: ");
		graphTraversalService.DFS(adj4, 0, 5);
		
		System.out.println("\nDFS Disconnected: ");
		graphTraversalService.DFSDisconnected(adj2, 6);
	}
	

}
