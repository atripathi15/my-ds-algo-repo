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
import com.ds.tree.model.Distance;
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
	
	@Test
	public void getBTDiameterNaiveTest() {
		int diameter1 = treeHeightSevice.getBTDiameterNaive(root1);
		assertThat(diameter1).isEqualTo(4);
		
		int diameter2 = treeHeightSevice.getBTDiameterNaive(root2);
		assertThat(diameter2).isEqualTo(6);
		
		int diameter3 = treeHeightSevice.getBTDiameterNaive(emptyTree);
		assertThat(diameter3).isEqualTo(0);
		
		int diameter4 = treeHeightSevice.getBTDiameterNaive(oneNodeTree);
		assertThat(diameter4).isEqualTo(1);		
	}
	
	@Test
	public void getHeightForDiameterTest() {
		int height1 = treeHeightSevice.getHeightForDiameter(root1);
		assertThat(height1).isEqualTo(3);
		int diameter1 = treeHeightSevice.getResult();
		assertThat(diameter1).isEqualTo(4);
		
		treeHeightSevice.setResult(0);
		int height2 = treeHeightSevice.getHeightForDiameter(root2);
		assertThat(height2).isEqualTo(4);
		int diameter2 = treeHeightSevice.getResult();
		assertThat(diameter2).isEqualTo(6);
		
		treeHeightSevice.setResult(0);
		int height3 = treeHeightSevice.getHeightForDiameter(emptyTree);
		assertThat(height3).isEqualTo(0);
		int diameter3 = treeHeightSevice.getResult();
		assertThat(diameter3).isEqualTo(0);
		
		treeHeightSevice.setResult(0);
		int height4 = treeHeightSevice.getHeightForDiameter(oneNodeTree);
		assertThat(height4).isEqualTo(1);
		int diameter4 = treeHeightSevice.getResult();
		assertThat(diameter4).isEqualTo(1);		
	}
	
	@Test
	public void burnTimeTest() {
		int height1 = treeHeightSevice.burnTime(root1, 50, new Distance(-1));
		assertThat(height1).isEqualTo(3);
		int burnTime1 = treeHeightSevice.getBurnTime();
		assertThat(burnTime1).isEqualTo(3);
		treeHeightSevice.setBurnTime(0);

		int height2 = treeHeightSevice.burnTime(root2, 70, new Distance(-1));
		assertThat(height2).isEqualTo(4);
		int burnTime2 = treeHeightSevice.getBurnTime();
		assertThat(burnTime2).isEqualTo(5);

	}

}
