package com.ashish.trie;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ashish.trie.model.TrieNode;
import com.ashish.trie.service.TrieOperationsService;

@ExtendWith(MockitoExtension.class)
@TestInstance(Lifecycle.PER_CLASS)
public class TrieOperationsServiceTest {
	
	@InjectMocks
	private TrieOperationsService trieOperationService;

	@BeforeAll
	public void setUp() {
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
	public void trieInsertSearchTest() {
		trieOperationService.insert("bad");
		trieOperationService.insert("bat");
		trieOperationService.insert("geek");
		trieOperationService.insert("geeks");
		trieOperationService.insert("cat");
		trieOperationService.insert("cut");
		trieOperationService.insert("zoo");
		TrieNode root = trieOperationService.getRoot();
		assertNotNull(root);
		
		assertEquals(true, trieOperationService.search("geek"));
		assertEquals(true, trieOperationService.search("cat"));
		assertEquals(true, trieOperationService.search("zoo"));
		assertEquals(false, trieOperationService.search("geeka"));
		assertEquals(false, trieOperationService.search("baddy"));
		
		trieOperationService.delete(root, "zoo", 0);
		assertEquals(false, trieOperationService.search("zoo"));
		trieOperationService.delete(root, "geek", 0);
		assertEquals(false, trieOperationService.search("geek"));
		trieOperationService.delete(root, "bad", 0);
		assertEquals(false, trieOperationService.search("bad"));
	}

}
