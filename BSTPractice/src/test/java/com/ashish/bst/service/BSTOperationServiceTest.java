package com.ashish.bst.service;

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

import com.ashish.bst.model.BSTNode;
import com.ashish.bst.service.BSTOperationService;
import com.ashish.bst.util.TestUtils;

@ExtendWith(MockitoExtension.class)
@TestInstance(Lifecycle.PER_CLASS)
public class BSTOperationServiceTest {

	TestUtils testUtils;

	private BSTNode root1;

	private BSTNode root2;

	private BSTNode emptyTree;

	private BSTNode oneNodeTree;

	@InjectMocks
	private BSTOperationService bstOperationService;

	@BeforeAll
	public void setUp() {
		testUtils = new TestUtils();
		root1 = testUtils.createBSTree1();

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
		BSTNode root = bstOperationService.insertRecursive(root1, 45);
		assertThat(root).isNotNull();
		assertThat(root.getRight().getRight().getLeft().getKey()).isEqualTo(45);
		
		root = bstOperationService.insertRecursive(null, 45);
		assertThat(root).isNotNull();
		assertThat(root.getKey()).isEqualTo(45);
		
		root = bstOperationService.insertRecursive(root1, 28);
		assertThat(root).isNotNull();
		assertThat(root.getLeft().getRight().getRight().getKey()).isEqualTo(28);
	}
	
	@Test
	public void insertBSTIterativeTest() {
		BSTNode root = bstOperationService.insertIterative(root1, 45);
		assertThat(root).isNotNull();
		assertThat(root.getRight().getRight().getLeft().getKey()).isEqualTo(45);
		
		root = bstOperationService.insertIterative(null, 45);
		assertThat(root).isNotNull();
		assertThat(root.getKey()).isEqualTo(45);
		
		root = bstOperationService.insertIterative(root1, 28);
		assertThat(root).isNotNull();
		assertThat(root.getLeft().getRight().getRight().getKey()).isEqualTo(28);
	}


}
