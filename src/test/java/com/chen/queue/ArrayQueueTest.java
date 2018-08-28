package com.chen.queue;

import org.junit.Test;

/**
 * ArrayQueueTest
 *
 * @Author LeifChen
 * @Date 2018-08-27
 */
public class ArrayQueueTest {

    @Test
    public void test() {
        Queue<Integer> queue = new ArrayQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);

            if (i % 3 == 2) {
                System.out.println("Dequeue: " + queue.dequeue());
                System.out.println(queue);
            }
        }
    }
}