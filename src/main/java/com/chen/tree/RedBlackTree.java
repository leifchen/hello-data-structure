package com.chen.tree;

/**
 * 红黑树
 *
 * @Author LeifChen
 * @Date 2018-10-09
 */
public class RedBlackTree<K extends Comparable<K>, V> {

    private static final boolean RED = true;
    private static final boolean BLACK = false;

    private class Node {
        public K key;
        public V value;
        public Node left, right;
        public boolean color;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
            color = RED;
        }
    }

    private Node root;
    private int size;

    public RedBlackTree() {
        root = null;
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(K key, V value) {
        root = add(root, key, value);
        root.color = BLACK;
    }

    public boolean contains(K key) {
        return getNode(root, key) != null;
    }

    public V get(K key) {
        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }

    public void set(K key, V newValue) {
        Node node = getNode(root, key);
        if (node == null) {
            throw new IllegalArgumentException(key + "doesn't exist!");
        }

        node.value = newValue;
    }

    /**
     * 向以node为根的红黑树中插入新元素(key,value)，递归算法
     *
     * @param node
     * @param key
     * @param value
     * @return 返回插入新节点后红黑树的根
     */
    private Node add(Node node, K key, V value) {
        if (node == null) {
            size++;
            return new Node(key, value);
        }

        if (key.compareTo(node.key) < 0) {
            node.left = add(node.left, key, value);
        } else if (key.compareTo(node.key) > 0) {
            node.right = add(node.right, key, value);
        } else { // key.compareTo(node.key) == 0
            node.value = value;
        }

        if (isRed(node.right) && !isRed(node.left)) {
            node = leftRotate(node);
        }

        if (isRed(node.left) && isRed(node.left.left)) {
            node = rightRotate(node);
        }

        if (isRed(node.left) && isRed(node.right)) {
            flipColors(node);
        }

        return node;
    }

    /**
     * 对节点node进行左旋转操作，返回旋转后新的根节点x
     *   node                     x
     *   / \                     / \
     * t1   x     向左旋转     node t3
     *     / \   - - - -- ->  / \
     *    t2  t3             t1 t2
     *
     * @param node
     * @return
     */
    private Node leftRotate(Node node) {
        Node x = node.right;

        // 左旋转
        node.right = x.left;
        x.left = node;

        x.color = node.color;
        node.color = RED;

        return x;
    }

    /**
     * 对节点node进行右旋转操作，返回旋转后新的根节点x
     *    node                  x
     *    / \                  / \
     *   x   t3   向右旋转    t1 node
     *  / \     - - - -- ->     / \
     * t1 t2                   t2 t3
     *
     * @param node
     * @return
     */
    private Node rightRotate(Node node) {
        Node x = node.left;

        // 右旋转
        node.left = x.right;
        x.right = node;

        x.color = node.color;
        node.color = RED;

        return x;
    }

    /**
     * 颜色翻转
     *
     * @param node
     */
    private void flipColors(Node node) {
        node.color = RED;
        node.left.color = BLACK;
        node.right.color = BLACK;
    }

    /**
     * 返回节点node的颜色
     *
     * @param node
     * @return
     */
    private boolean isRed(Node node) {
        if (node == null) {
            return BLACK;
        }

        return node.color;
    }

    /**
     * 返回以node为根节点的红黑树中，key所在的节点
     *
     * @param node
     * @param key
     * @return
     */
    private Node getNode(Node node, K key) {
        if (node == null) {
            return null;
        }

        if (key.compareTo(node.key) == 0) {
            return node;
        } else if (key.compareTo(node.key) < 0) {
            return getNode(node.left, key);
        } else {
            return getNode(node.right, key);
        }
    }
}
