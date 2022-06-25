package com.ds.tree.service;

import static org.assertj.core.api.Assertions.assertThat;

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
public class TreeTraversalServiceTest {
	
	private TestUtils testUtils;
	
	private BTNode root1;
	
	private BTNode root2;
	
	@InjectMocks
	private TreeTraversalSevice treeTraversalSevice;
	
	@BeforeAll
	public void setUp() {
		testUtils = new TestUtils();
		root1 = testUtils.createBinaryTree1();
		root2 = testUtils.createBinaryTree2();
	}
	
	@BeforeEach 
	public void init() {
		System.out.println("in init method");
		
	}
	
	@AfterEach 
    public void teardown() {
		System.out.println("in teardown method");
		treeTraversalSevice.resetTraverstalString();
    }
	

	@Test
	public void inOrderTraversalTest() {
		String inOrder = treeTraversalSevice.inOrderTraversal(root1);
		assertThat(inOrder).isNotNull();
		assertThat(inOrder.trim()).isEqualTo("20 10 40 30 50");
		
		treeTraversalSevice.resetTraverstalString();
		String inOrder2 = treeTraversalSevice.inOrderTraversal(root2);
		assertThat(inOrder2).isNotNull();
		assertThat(inOrder2.trim()).isEqualTo("40 20 70 50 80 10 30 60");	
	}
	
	@Test
	public void preOrderTraversalTest() {
		String preOrder = treeTraversalSevice.preOrderTraversal(root1);
		assertThat(preOrder).isNotNull();
		assertThat(preOrder.trim()).isEqualTo("10 20 30 40 50");
		
		treeTraversalSevice.resetTraverstalString();
		String preOrder2 = treeTraversalSevice.preOrderTraversal(root2);
		assertThat(preOrder2).isNotNull();
		assertThat(preOrder2.trim()).isEqualTo("10 20 40 50 70 80 30 60");	
	}
	
	@Test
	public void postOrderTraversalTest() {
		String postOrder = treeTraversalSevice.postOrderTraversal(root1);
		assertThat(postOrder).isNotNull();
		assertThat(postOrder.trim()).isEqualTo("20 40 50 30 10");
		
		treeTraversalSevice.resetTraverstalString();
		String postOrder2 = treeTraversalSevice.postOrderTraversal(root2);
		assertThat(postOrder2).isNotNull();
		assertThat(postOrder2.trim()).isEqualTo("40 70 80 50 20 60 30 10");	
	}
	
	@Test
	public void levelOrderTraversalTest() {
		String levelOrder = treeTraversalSevice.levelOrderTraversal(root1);
		assertThat(levelOrder).isNotNull();
		assertThat(levelOrder.trim()).isEqualTo("10 20 30 40 50");

		treeTraversalSevice.resetTraverstalString();
		String postOrder2 = treeTraversalSevice.levelOrderTraversal(root2);
		assertThat(postOrder2).isNotNull();
		assertThat(postOrder2.trim()).isEqualTo("10 20 30 40 50 60 70 80");

	}
	
	@Test
	public void levelOrderTraversalLineByLine() {
		String levelOrderLineByLine1 = treeTraversalSevice.levelOrderTraversalLineByLine(root1);
		assertThat(levelOrderLineByLine1).isNotNull();
		System.out.println(levelOrderLineByLine1);
		assertThat(levelOrderLineByLine1.trim()).isEqualTo("10 \n20 30 \n40 50");

		treeTraversalSevice.resetTraverstalString();
		String levelOrderLineByLine2 = treeTraversalSevice.levelOrderTraversalLineByLine(root2);
		assertThat(levelOrderLineByLine2).isNotNull();
		System.out.println(levelOrderLineByLine2);
		assertThat(levelOrderLineByLine2.trim()).isEqualTo("10 \n20 30 \n40 50 60 \n70 80");

	}
	
	@Test
	public void printDestTest() {
		String result1 = treeTraversalSevice.printDist(root1,1);
		assertThat(result1).isNotNull();
		System.out.println(result1);
		assertThat(result1.trim()).isEqualTo("20 30");

		treeTraversalSevice.resetTraverstalString();
		String result2 = treeTraversalSevice.printDist(root2,2);
		assertThat(result2).isNotNull();
		System.out.println(result2);
		assertThat(result2.trim()).isEqualTo("40 50 60");
	}

}
