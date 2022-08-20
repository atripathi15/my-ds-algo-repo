package com.ashish.trie.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TrieNode {	
	TrieNode[] child = new TrieNode[26];
	boolean isEnd;
}
