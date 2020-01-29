package com.leetcode;

import java.util.*;

/**
 * @Author: Equator
 * @Date: 2020/1/29 11:16
 **/

public class Problem212 {
    class Trie {
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

    private char[][] board;
    private int[][] direction = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private int row, col;
    private boolean[][] traveled;
    Trie trie = new Trie();

    // 字典树
    public List<String> findWords(char[][] board, String[] words) {
        row = board.length;
        if (row == 0) {
            return null;
        }
        col = board[0].length;
        this.board = board;
        // 遍历标记
        traveled = new boolean[row][col];
        Set<String> ans = new HashSet<>();
        // 建立字典树
        for (String word : words) {
            trie.insert(word);
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                travel(ans, i, j, "");
            }
        }
        return new LinkedList<>(ans);
    }

    private void travel(Set<String> ans, int x, int y, String cur) {
        cur += board[x][y];
        // 剪枝，否则超时
        if (!trie.startsWith(cur)) {
            return;
        }
        if (trie.search(cur)) {
            ans.add(cur);
        }
        traveled[x][y] = true;
        for (int i = 0; i < direction.length; i++) {
            int nx = x + direction[i][0], ny = y + direction[i][1];
            if (0 <= nx && nx < row && 0 <= ny && ny < col && !traveled[nx][ny]) {
                travel(ans, nx, ny, cur);
            }
        }
        traveled[x][y] = false;
    }
}
