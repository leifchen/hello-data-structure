package com.chen.queue;

import org.junit.Test;

/**
 * LinkedListQueueTest
 *
 * @Author LeifChen
 * @Date 2018-08-29
 */
public class LinkedListQueueTest {

    @Test
    public void test() {
        Queue<Integer> queue = new LinkedListQueue<>();
        for (int i = 0; i < 9; i++) {
            queue.enqueue(i);
            System.out.println(queue);

            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}