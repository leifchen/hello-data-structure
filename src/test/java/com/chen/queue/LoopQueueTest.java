package com.chen.queue;

import org.junit.Test;

/**
 * LoopQueueTest
 *
 * @Author LeifChen
 * @Date 2018-08-28
 */
public class LoopQueueTest {

    @Test
    public void test() {
        Queue<Integer> queue = new LoopQueue<>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            System.out.println(queue);

            if (i % 3 == 2) {
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}