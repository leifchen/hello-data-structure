package com.chen.tree;

/**
 * 基于Array的前缀树/字典树
 *
 * @Author LeifChen
 * @Date 2018-09-10
 */
public class Trie3 {

    private class Node {
        public boolean isWord;
        public Node[] next;

        public Node(boolean isWord) {
            this.isWord = isWord;
            next = new Node[26];
        }

        public Node() {
            this(false);
        }
    }

    private Node root;
    private int size;

    public Trie3() {
        root = new Node();
        size = 0;
    }

    /**
     * 返回Trie是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 返回Trie中存储的单词数量
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 添加新词word到Trie
     *
     * @param word
     */
    public void add(String word) {
        add(root, word, 0);
    }

    /**
     * 返回Trie是否包含单词word
     *
     * @param word
     * @return
     */
    public boolean contains(String word) {
        Node res = find(word);
        return res != null && res.isWord;
    }

    /**
     * 返回是否在Trie中存在以prefix为前缀的单词
     *
     * @param prefix
     * @return
     */
    public boolean isPrefix(String prefix) {
        Node res = find(prefix);
        return res != null;
    }

    /**
     * 向以node为根的Trie中添加word[index...end), 递归算法
     *
     * @param node
     * @param word
     * @param index
     */
    private void add(Node node, String word, int index) {
        if (index == word.length()) {
            if (!node.isWord) {
                node.isWord = true;
                size++;
            }
            return;
        }

        char c = word.charAt(index);
        if (node.next[c - 'a'] == null) {
            node.next[c - 'a'] = new Node();
        }
        add(node.next[c - 'a'], word, index + 1);
    }

    /**
     * 查询Trie是否包含单词word
     *
     * @param word
     * @return
     */
    private Node find(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next[c - 'a'] == null) {
                return null;
            }
            cur = cur.next[c - 'a'];
        }
        return cur;
    }
}
