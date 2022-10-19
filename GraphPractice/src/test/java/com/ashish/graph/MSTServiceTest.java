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
public class MSTServiceTest {
	@InjectMocks
	private MSTServiceImpl mstService;
	
	@Test
	public void getPrimMST() {
		int[][] graph= new int[4][4];
		graph[0][0]=0;
		graph[0][1]=5;
		graph[0][2]=8;
		graph[0][3]=0;
		
		graph[1][0]=5;
		graph[1][1]=0;
		graph[1][2]=10;
		graph[1][3]=15;
		
		graph[2][0]=8;
		graph[2][1]=10;
		graph[2][2]=0;
		graph[2][3]=20;
		
		graph[3][0]=0;
		graph[3][1]=15;
		graph[3][2]=20;
		graph[3][3]=0;
		
		int result = mstService.primMST(graph, 4);
		assertEquals(28, result);
	}			

}
