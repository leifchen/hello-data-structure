package com.chen.heap;

import org.junit.Test;

import java.util.Random;

/**
 * MinHeapTest
 *
 * @Author LeifChen
 * @Date 2018-09-05
 */
public class MinHeapTest {

    @Test
    public void test() {
        int n = 1000000;

        Random random = new Random();
        Integer[] testData = new Integer[n];
        for (int i = 0; i < n; i++) {
            testData[i] = random.nextInt(Integer.MAX_VALUE);
        }

        double time1 = testHeap(testData, false);
        System.out.println("Without heapify: " + time1 + " s");

        double time2 = testHeap(testData, true);
        System.out.println("With heapify: " + time2 + " s");
    }

    private double testHeap(Integer[] testData, boolean isHeapify) {
        long startTime = System.nanoTime();

        MinHeap<Integer> minHeap;
        if (isHeapify) {
            minHeap = new MinHeap<>(testData);
        } else {
            minHeap = new MinHeap<>();
            for (int num : testData)
                minHeap.add(num);
        }

        int[] arr = new int[testData.length];
        for (int i = 0; i < testData.length; i++) {
            arr[i] = minHeap.extractMin();
        }

        for (int i = 1; i < testData.length; i++) {
            if (arr[i - 1] > arr[i]) {
                throw new IllegalArgumentException("Error");
            }
        }
        System.out.println("Test MinHeap completed.");

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }
}