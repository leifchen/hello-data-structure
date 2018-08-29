package com.chen.stack;

import org.junit.Assert;
import org.junit.Test;

/**
 * LinkedListStackTest
 *
 * @Author LeifChen
 * @Date 2018-08-29
 */
public class LinkedListStackTest {

    @Test
    public void test() {
        Stack<Integer> stack = new LinkedListStack<>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }

        Assert.assertEquals(new Integer(4), stack.pop());
        System.out.println(stack);
    }
}