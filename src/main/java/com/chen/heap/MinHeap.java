package com.chen.heap;

import com.chen.array.Array;

/**
 * 最小堆
 *
 * @Author LeifChen
 * @Date 2018-09-05
 */
public class MinHeap<E extends Comparable<E>> {

    private Array<E> data;

    public MinHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public MinHeap() {
        data = new Array<>();
    }

    public MinHeap(E[] arr) {
        data = new Array<>(arr);
        for (int i = parent(arr.length - 1); i >= 0; i--) {
            siftDown(i);
        }
    }

    /**
     * 返回堆中的元素个数
     *
     * @return
     */
    public int size() {
        return data.getSize();
    }

    /**
     * 返回堆是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return data.isEmpty();
    }

    /**
     * 向堆中添加元素
     */
    public void add(E e) {
        data.addLast(e);
        siftUp(data.getSize() - 1);
    }

    /**
     * 查看堆中的最小元素
     *
     * @return
     */
    public E findMin() {
        if (data.getSize() == 0) {
            throw new IllegalArgumentException("Can not findMin when heap is empty.");
        }

        return data.get(0);
    }

    /**
     * 取出堆中的最小元素
     *
     * @return
     */
    public E extractMin() {
        E ret = findMin();
        data.swap(0, data.getSize() - 1);
        data.removeLast();
        siftDown(0);

        return ret;
    }

    /**
     * 取出堆中的最小元素，并且替换成元素e
     *
     * @param e
     * @return
     */
    public E replace(E e) {
        E ret = findMin();
        data.set(0, e);
        siftDown(0);

        return ret;
    }

    /**
     * 堆元素的上浮
     *
     * @param k
     */
    private void siftUp(int k) {
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) > 0) {
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    /**
     * 堆元素的下沉
     *
     * @param k
     */
    private void siftDown(int k) {
        while (leftChild(k) < data.getSize()) {
            // data[j] 是 leftChild 和 rightChild 中的最小值
            int j = leftChild(k);
            if (j + 1 < data.getSize() && data.get(j + 1).compareTo(data.get(j)) < 0) {
                j = rightChild(k);
            }

            if (data.get(k).compareTo(data.get(j)) <= 0) {
                break;
            }

            data.swap(k, j);
            k = j;
        }
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引所表示的元素的父亲节点的索引
     *
     * @param index
     * @return
     */
    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index-0 doesn't have parent.");
        }

        return (index - 1) / 2;
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
     *
     * @param index
     * @return
     */
    private int leftChild(int index) {
        return index * 2 + 1;
    }

    /**
     * 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
     *
     * @param index
     * @return
     */
    private int rightChild(int index) {
        return index * 2 + 2;
    }
}
