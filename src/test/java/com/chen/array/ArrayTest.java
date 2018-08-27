package com.chen.array;

import org.junit.Before;
import org.junit.Test;

/**
 * ArrayTest
 *
 * @Author LeifChen
 * @Date 2018-08-27
 */
public class ArrayTest {

    Array<Integer> arr = new Array<>();

    @Before
    public void init() {
        for (int i = 0; i < 10; i++) {
            arr.addLast(i);
        }
        System.out.println(arr);
    }

    @Test
    public void add() {
        arr.add(1, 100);
        System.out.println(arr);

        arr.addFirst(99);
        System.out.println(arr);

        arr.addLast(100);
        System.out.println(arr);
    }

    @Test
    public void remove() {
        System.out.println(arr.remove(2));
        System.out.println(arr);

        arr.removeElement(4);
        arr.removeElement(5);
        arr.removeElement(6);
        arr.removeElement(7);
        arr.removeElement(8);
        System.out.println(arr);

        System.out.println(arr.removeFirst());
        System.out.println(arr);

        System.out.println(arr.removeLast());
        System.out.println(arr);
        System.out.println(arr.removeLast());
        System.out.println(arr);
        System.out.println(arr.removeLast());
        System.out.println(arr);
    }
}