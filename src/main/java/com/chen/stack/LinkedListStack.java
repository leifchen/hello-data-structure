package com.chen.stack;

import com.chen.linkedlist.LinkedList;

/**
 * 链表栈
 *
 * @Author LeifChen
 * @Date 2018-08-29
 */
public class LinkedListStack<E> implements Stack<E> {

    LinkedList<E> list;

    public LinkedListStack() {
        list = new LinkedList<>();
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void push(E e) {
        list.addFirst(e);
    }

    @Override
    public E pop() {
        return list.removeFirst();
    }

    @Override
    public E peek() {
        return list.getFirst();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack: \n");
        res.append(list);
        return res.toString();
    }
}
