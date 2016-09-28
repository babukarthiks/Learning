package com.learning.algos.trees;
public class WordDictionary {
    class TrieNode {
        boolean isKey;
        TrieNode[] children;
        public TrieNode() {
            children = new TrieNode[26];
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }
    TrieNode root = new TrieNode();
    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode copy = root;
        for (char c : word.toCharArray()) {
            if (copy.children[c - 'a'] == null) {
                copy.children[c - 'a'] = new TrieNode();
            }
            copy = copy.children[c - 'a'];
        }
        copy.isKey = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return dfs(word, 0, root);
    }

    private boolean dfs(String word, int depth, TrieNode node) {
        if (depth == word.length()) {
            return node.isKey;
        }
        char c = word.charAt(depth);
        if (c != '.') {
            return node.children[c - 'a'] != null && dfs(word, depth + 1, node.children[c - 'a']);
        } else {
            for (TrieNode child : node.children) {
                if (child != null) {
                    if (dfs(word, depth + 1, child)) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
    
    public static void main(String[] args) {
        WordDictionary dic = new WordDictionary();
        dic.addWord("karthik");
        System.out.println("afaa");
    }
}