package com.ashish.bst.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ashish.bst.model.BSTNode;
import com.ashish.bst.util.TestUtils;

@ExtendWith(MockitoExtension.class)
@TestInstance(Lifecycle.PER_CLASS)
public class BSTOperationServiceTest {

	TestUtils testUtils;

	private BSTNode root1;
	
	private BSTNode root2;

	@InjectMocks
	private BSTOperationService bstOperationService;

	@BeforeAll
	public void setUp() {
		testUtils = new TestUtils();
		root1 = testUtils.createBSTree1();
		root2 = testUtils.createBSTree2();
	}

	@BeforeEach
	public void init() {
		System.out.println("in init method");

	}

	@AfterEach
	public void teardown() {
		System.out.println("in teardown method");
	}

	@Test
	public void searchBSTRecursiveTest() {
		boolean found = bstOperationService.searchBSTRecursive(root1, 38);
		assertThat(found).isEqualTo(true);

		found = bstOperationService.searchBSTRecursive(root1, 45);
		assertThat(found).isEqualTo(false);

		found = bstOperationService.searchBSTRecursive(null, 20);
		assertThat(found).isEqualTo(false);
	}

	@Test
	public void searchBSTIterativeTest() {
		boolean found = bstOperationService.searchBSTIterative(root1, 38);
		assertThat(found).isEqualTo(true);

		found = bstOperationService.searchBSTIterative(root1, 45);
		assertThat(found).isEqualTo(false);

		found = bstOperationService.searchBSTIterative(null, 20);
		assertThat(found).isEqualTo(false);
	}
	
	@Test
	public void insertBSTRecursiveTest() {
		BSTNode root = bstOperationService.insertRecursive(testUtils.createBSTree1(), 45);
		assertThat(root).isNotNull();
		assertThat(root.getRight().getRight().getLeft().getKey()).isEqualTo(45);
		
		root = bstOperationService.insertRecursive(null, 45);
		assertThat(root).isNotNull();
		assertThat(root.getKey()).isEqualTo(45);
		
		root = bstOperationService.insertRecursive(testUtils.createBSTree1(), 28);
		assertThat(root).isNotNull();
		assertThat(root.getLeft().getRight().getRight().getKey()).isEqualTo(28);
	}
	
	@Test
	public void insertBSTIterativeTest() {
		BSTNode root = bstOperationService.insertIterative(testUtils.createBSTree1(), 45);
		assertThat(root).isNotNull();
		assertThat(root.getRight().getRight().getLeft().getKey()).isEqualTo(45);
		
		root = bstOperationService.insertIterative(null, 45);
		assertThat(root).isNotNull();
		assertThat(root.getKey()).isEqualTo(45);
		
		root = bstOperationService.insertIterative(testUtils.createBSTree1(), 28);
		assertThat(root).isNotNull();
		assertThat(root.getLeft().getRight().getRight().getKey()).isEqualTo(28);
	}
	
	@Test
	public void deleteBSTTest() {
		//Node to be deleted is a leaf node i.e. has no child. Can be simply removed
		BSTNode result1 = bstOperationService.delete(testUtils.createBSTree1(), 25);
		assertThat(result1).isNotNull();
		assertThat(result1.getLeft().getRight()).isNull();
		
		//Node to be deleted has one child. Replace the node with child
		BSTNode result2 = bstOperationService.delete(testUtils.createBSTree1(), 35);
		assertThat(result2).isNotNull();
		assertThat(result2.getRight().getLeft().getKey()).isEqualTo(38);
		
		//Node to be deleted has both child. In this case find inorder successor and replace with that node
		BSTNode result3 = bstOperationService.delete(testUtils.createBSTree1(), 40); 
		assertThat(result3).isNotNull();
		assertThat(result3.getRight().getKey()).isEqualTo(50);
		
		//NOde to be deleted does not exists
		BSTNode result4 = bstOperationService.delete(testUtils.createBSTree1(), 45);
		assertThat(result4).isNotNull();
	}
	
	@Test
	public void getFloorTest() {
		BSTNode result1 = bstOperationService.getFloor(root1, 18);
		assertThat(result1).isNotNull();
		assertThat(result1.getKey()).isEqualTo(10);
		
		result1 = bstOperationService.getFloor(root1, 39);
		assertThat(result1).isNotNull();
		assertThat(result1.getKey()).isEqualTo(38);
		
		result1 = bstOperationService.getFloor(root1, 40);
		assertThat(result1).isNotNull();
		assertThat(result1.getKey()).isEqualTo(40);
	}
	
	@Test
	public void getCeilTest() {
		BSTNode result1 = bstOperationService.getCeil(root1, 18);
		assertThat(result1).isNotNull();
		assertThat(result1.getKey()).isEqualTo(20);
		
		result1 = bstOperationService.getCeil(root1, 39);
		assertThat(result1).isNotNull();
		assertThat(result1.getKey()).isEqualTo(40);
		
		result1 = bstOperationService.getCeil(root1, 25);
		assertThat(result1).isNotNull();
		assertThat(result1.getKey()).isEqualTo(25);
	}
	
	@Test
	public void verticalSumTest() {
		Map<Integer, Integer> map = new TreeMap<>();
		bstOperationService.verticalSumR(root1, 0, map);
		//System.out.println("vertical sum :" + map);
		for (Map.Entry<Integer, Integer> e : map.entrySet()) {
			System.out.print(e.getValue() + " ");
		}
		System.out.println();
		assertThat(map).isNotEmpty();
		assertThat(map.get(0)).isEqualTo(90);		
	}
	
	@Test
	public void verticalTraversalTest() {
		Map<Integer, List<Integer>> map = new TreeMap<>();
		bstOperationService.verticalTraversal(root1, map);
		//System.out.println("vertical Traversal :" + map);
		for (Map.Entry<Integer, List<Integer>> e : map.entrySet()) {
			System.out.print(e.getValue() + " ");
		}
		System.out.println();
		assertThat(map).isNotEmpty();
		assertThat(map.size()).isEqualTo(5);		
	}
	
	@Test
	public void getTopViewTest() {
		Map<Integer, List<Integer>> map = new TreeMap<>();
		bstOperationService.getTopView(root1, map);
		System.out.println("Top View :" + map);
		for (Map.Entry<Integer, List<Integer>> e : map.entrySet()) {
			System.out.print(e.getValue() + " ");
		}
		System.out.println();
		assertThat(map).isNotEmpty();
		assertThat(map.size()).isEqualTo(5);		
	}
	
	@Test
	public void getTopBottomTest() {
		Map<Integer, List<Integer>> map = new TreeMap<>();
		bstOperationService.getBottomView(root1, map);
		System.out.println("Bottom View :" + map);
		for (Map.Entry<Integer, List<Integer>> e : map.entrySet()) {
			System.out.print(e.getValue() + " ");
		}
		System.out.println();
		assertThat(map).isNotEmpty();
		assertThat(map.size()).isEqualTo(5);		
	}


}
