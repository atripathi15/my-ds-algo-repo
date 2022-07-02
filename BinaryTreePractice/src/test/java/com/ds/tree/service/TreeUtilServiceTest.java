package com.ds.tree.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ds.tree.model.BTNode;
import com.ds.tree.util.TestUtils;

@ExtendWith(MockitoExtension.class)
@TestInstance(Lifecycle.PER_CLASS)
public class TreeUtilServiceTest {
	
	private TestUtils testUtils;
	
	private BTNode root1;
	
	private BTNode root2;
	
	private BTNode root3;
	
	private BTNode root4;
	
	private BTNode root5;
	
	private BTNode emptyTree;
	
	private BTNode oneNodeTree;
	
	@InjectMocks
	private TreeUtilService treeUtilSevice;
	
	@BeforeAll
	public void setUp() {
		testUtils = new TestUtils();
		root1 = testUtils.createBinaryTree1();
		root2 = testUtils.createBinaryTree2();
		root3 = testUtils.createChildSumTree();
		root4 = testUtils.createUnbalancedBinaryTree();
		root5 = testUtils.createCompleteBinaryTree();
		emptyTree = testUtils.createEmptyTree();
		oneNodeTree = testUtils.createOneNodeTree();
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
	public void getSizeTest() {
		int height1 = treeUtilSevice.getSize(root1);
		assertThat(height1).isEqualTo(5);
		
		int height2 = treeUtilSevice.getSize(root2);
		assertThat(height2).isEqualTo(8);
		
		int height3 = treeUtilSevice.getSize(emptyTree);
		assertThat(height3).isEqualTo(0);
		
		int height4 = treeUtilSevice.getSize(oneNodeTree);
		assertThat(height4).isEqualTo(1);		
	}
	
	@Test
	public void getMaximumTest() {
		int height1 = treeUtilSevice.getMaximum(root1);
		assertThat(height1).isEqualTo(50);
		
		int height2 = treeUtilSevice.getMaximum(root2);
		assertThat(height2).isEqualTo(80);
		
		int height3 = treeUtilSevice.getMaximum(emptyTree);
		assertThat(height3).isEqualTo(Integer.MIN_VALUE);
		
		int height4 = treeUtilSevice.getMaximum(oneNodeTree);
		assertThat(height4).isEqualTo(oneNodeTree.getKey());		
	}
	
	@Test
	public void getChildSumTest() {
		boolean result1 = treeUtilSevice.isChildSum(root1);
		assertThat(result1).isEqualTo(false);
		
		boolean result2 = treeUtilSevice.isChildSum(root2);
		assertThat(result2).isEqualTo(false);
		
		boolean result3 = treeUtilSevice.isChildSum(emptyTree);
		assertThat(result3).isEqualTo(true);
		
		boolean result4 = treeUtilSevice.isChildSum(oneNodeTree);
		assertThat(result4).isEqualTo(true);
		
		boolean result5 = treeUtilSevice.isChildSum(root3);
		assertThat(result5).isEqualTo(true);
	}
	
	@Test
	public void isBalancedTest() {
		int result1 = treeUtilSevice.isBalanced(root1);
		assertThat(result1).isEqualTo(3);
		
		int result2 = treeUtilSevice.isBalanced(root2);
		assertThat(result2).isEqualTo(4);
		
		int result3 = treeUtilSevice.isBalanced(emptyTree);
		assertThat(result3).isEqualTo(0);
		
		int result4 = treeUtilSevice.isBalanced(oneNodeTree);
		assertThat(result4).isEqualTo(1);
		
		int result5 = treeUtilSevice.isBalanced(root4);
		assertThat(result5).isEqualTo(-1);	
	}
	
	@Test
	public void getMaxWidthTest() {
		int result1 = treeUtilSevice.getMaxWidth(root1);
		assertThat(result1).isEqualTo(2);
		
		int result2 = treeUtilSevice.getMaxWidth(root2);
		assertThat(result2).isEqualTo(3);
		
		int result3 = treeUtilSevice.getMaxWidth(emptyTree);
		assertThat(result3).isEqualTo(0);
		
		int result4 = treeUtilSevice.getMaxWidth(oneNodeTree);
		assertThat(result4).isEqualTo(1);
	}

	@Test
	public void constructTreeTest() {
		int[] inOrder = { 40, 20, 60, 50, 70, 10, 80, 100, 30 };
		int[] preOrder = { 10, 20, 40, 50, 60, 70, 30, 80, 100 };
		BTNode root = treeUtilSevice.constructTree(preOrder, inOrder, 0, inOrder.length - 1);
		assertThat(root).isNotNull();
		assertThat(root.getKey()).isEqualTo(10);
		assertThat(root.getLeft().getKey()).isEqualTo(20);
		assertThat(root.getRight().getKey()).isEqualTo(30);
	}
	
	@Test
	public void serializeTreeTest() {
		List<Integer> serializedTreeList = new ArrayList<>();
		treeUtilSevice.serializeTree(root1, serializedTreeList);
		System.out.println(serializedTreeList);          
		assertThat(serializedTreeList.size()).isEqualTo(11);
		
		BTNode rootTree1 = treeUtilSevice.deSerializeTree(serializedTreeList);
		assertThat(rootTree1).isNotNull();
		assertThat(rootTree1.getKey()).isEqualTo(10);
		
		serializedTreeList.clear();
		treeUtilSevice.serializeTree(root2, serializedTreeList);
		System.out.println(serializedTreeList);
		assertThat(serializedTreeList.size()).isEqualTo(17);
	}
	
	@Test
	public void countNodeTest() {
		int treeCount1 = treeUtilSevice.countNode(root1);
		assertThat(treeCount1).isEqualTo(5);
		
		int treeCount2 = treeUtilSevice.countNode(root5);
		assertThat(treeCount2).isEqualTo(9);
		
	}
	
}
