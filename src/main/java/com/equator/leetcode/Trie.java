package com.equator.leetcode;

/**
 * @Author: Equator
 * @Date: 2020/1/29 8:54
 **/

public class Trie {
    class TrieNode {
        private int capacity = 26;
        private TrieNode[] trieNodes;
        private boolean isEnd;

        public TrieNode() {
            trieNodes = new TrieNode[capacity];
        }

        public boolean containKey(char ch) {
            return trieNodes[ch - 'a'] != null;
        }

        public TrieNode getNode(char ch) {
            return trieNodes[ch - 'a'];
        }

        public void setNode(char ch, TrieNode trieNode) {
            trieNodes[ch - 'a'] = trieNode;
        }

        public boolean isEnd() {
            return isEnd;
        }

        public void setEnd() {
            isEnd = true;
        }
    }

    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }


    public void insert(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            if (!node.containKey(ch)) {
                node.setNode(ch, new TrieNode());
            }
            node = node.getNode(ch);
        }
        node.setEnd();
    }


    public boolean search(String word) {
        TrieNode node = root;
        for (char ch : word.toCharArray()) {
            if (!node.containKey(ch)) {
                return false;
            }
            node = node.getNode(ch);
        }
        if (!node.isEnd()) {
            return false;
        }
        return true;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char ch : prefix.toCharArray()) {
            if (!node.containKey(ch)) {
                return false;
            }
            node = node.getNode(ch);
        }
        return true;
    }
}
