package com.chen.linkedlist;

import org.junit.Before;
import org.junit.Test;

/**
 * LinkedListTest
 *
 * @Author LeifChen
 * @Date 2018-08-29
 */
public class LinkedListTest {

    LinkedList<Integer> linkedList = new LinkedList<>();

    @Before
    public void init() {

        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }
    }

    @Test
    public void add() {
        linkedList.addFirst(666);
        System.out.println(linkedList);

        linkedList.add(3, 333);
        System.out.println(linkedList);

        linkedList.addLast(999);
        System.out.println(linkedList);
    }

    @Test
    public void get() {
        System.out.println(linkedList.get(2));
        System.out.println(linkedList.getFirst());
        System.out.println(linkedList.getLast());
    }

    @Test
    public void set() {
        linkedList.set(2, 666);
        System.out.println(linkedList);
    }

    @Test
    public void contains() {
        System.out.println(linkedList.contains(3));
        System.out.println(linkedList.contains(5));
    }

    @Test
    public void remove() {
        System.out.println(linkedList.remove(2));
        System.out.println(linkedList);

        System.out.println(linkedList.removeFirst());
        System.out.println(linkedList);

        System.out.println(linkedList.removeLast());
        System.out.println(linkedList);
    }
}