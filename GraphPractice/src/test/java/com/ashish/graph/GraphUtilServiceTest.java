package com.ashish.graph;

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

}
