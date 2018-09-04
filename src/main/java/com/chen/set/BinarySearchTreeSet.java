package com.chen.set;

import com.chen.tree.BinarySearchTree;

/**
 * 基于二分搜索树的集合Set实现
 *
 * @Author LeifChen
 * @Date 2018-09-02
 */
public class BinarySearchTreeSet<E extends Comparable<E>> implements Set<E> {

    private BinarySearchTree<E> bst;

    public BinarySearchTreeSet() {
        bst = new BinarySearchTree<>();
    }

    @Override
    public int getSize() {
        return bst.size();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }

    @Override
    public void add(E e) {
        bst.add(e);
    }

    @Override
    public void remove(E e) {
        bst.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }
}
