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
public class TreeHeightServiceTest {
	
    private TestUtils testUtils;
	
	private BTNode root1;
	
	private BTNode root2;
	
	private BTNode emptyTree;
	
	private BTNode oneNodeTree;
	
	@InjectMocks
	private TreeHeightSevice treeHeightSevice;
	
	@BeforeAll
	public void setUp() {
		testUtils = new TestUtils();
		root1 = testUtils.createBinaryTree1();
		root2 = testUtils.createBinaryTree2();
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
	public void getBTHeightTest() {
		int height1 = treeHeightSevice.getBTHeight(root1);
		assertThat(height1).isEqualTo(3);
		
		int height2 = treeHeightSevice.getBTHeight(root2);
		assertThat(height2).isEqualTo(4);
		
		int height3 = treeHeightSevice.getBTHeight(emptyTree);
		assertThat(height3).isEqualTo(0);
		
		int height4 = treeHeightSevice.getBTHeight(oneNodeTree);
		assertThat(height4).isEqualTo(1);
		
	}

}
