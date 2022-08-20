package com.ashish.trie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ashish.trie.model.TrieNode;

import lombok.Getter;

@Service
@Getter
public class TrieOperationsService {
	
	@Autowired
	TrieNode root;
	
	TrieOperationsService(){
		root = new TrieNode();
	}
	
	/**
	 * Time Complexity theta(n), where n is length of key
	*/
	public void insert(String key) {
		TrieNode current = root;
		for (int i = 0; i < key.length(); i++) {
			int index = key.charAt(i) - 'a';
			if (current.getChild()[index] == null) {
				current.getChild()[index] = new TrieNode();
			}
			current = current.getChild()[index];
		}
		current.setEnd(true);
	}
	
	/**
	 * Time Complexity O(n), where n is length of key
	*/
	public boolean search(String key) {
		TrieNode current = root;
		for (int i = 0; i < key.length(); i++) {
			int index = key.charAt(i) - 'a';
			if (current.getChild()[index] == null) {
				return false;
			}
			current = current.getChild()[index];
		}
		return current.isEnd();	
	}
	
	/**
	 * Time Complexity O(n), where n is length of key
	*/
	public TrieNode delete(TrieNode root, String key, int i) {
		if (root == null) {
			return null;
		}
		if (i == key.length()) {
			root.setEnd(false);
			if (empty(root))
				root = null;
			return root;
		}
		int index = key.charAt(i) - 'a';
		root.getChild()[index] = delete(root.getChild()[index], key, i + 1);
		if (empty(root) && !root.isEnd()) {
			root = null;
		}
		return root;
	}

	private boolean empty(TrieNode root) {
		for (int i = 0; i < 26; i++) {
			if (root.getChild()[i] != null)
				return false;
		}
		return true;
	}

}
