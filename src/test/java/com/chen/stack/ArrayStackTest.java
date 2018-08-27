package com.chen.stack;

import org.junit.Assert;
import org.junit.Test;

/**
 * ArrayStackTest
 *
 * @Author LeifChen
 * @Date 2018-08-27
 */
public class ArrayStackTest {

    @Test
    public void test() {
        Stack<Integer> stack = new ArrayStack<>();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }

        Assert.assertEquals(new Integer(4), stack.pop());
        System.out.println(stack);
    }
}