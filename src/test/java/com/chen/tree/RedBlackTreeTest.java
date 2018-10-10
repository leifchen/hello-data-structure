package com.chen.tree;

import com.chen.hashtable.HashTable;
import com.chen.map.BinarySearchTreeMap;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * RedBlackTreeTest
 *
 * @Author LeifChen
 * @Date 2018-10-09
 */
public class RedBlackTreeTest {

    @Test
    public void test() {
        int n = 1000000;

        Random random = new Random();
        List<Integer> testData = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            testData.add(random.nextInt(Integer.MAX_VALUE));
        }

        // Test BST
        long startTIme = System.nanoTime();

        BinarySearchTreeMap<Integer, Integer> bst = new BinarySearchTreeMap<>();
        for (Integer x : testData) {
            bst.add(x, null);
        }

        long endTime = System.nanoTime();

        double time = (endTime - startTIme) / 1000000000.0;
        System.out.println("BST: " + time + " s");

        // Test AVT
        startTIme = System.nanoTime();

        AVLTree<Integer, Integer> avl = new AVLTree<>();
        for (Integer x : testData) {
            avl.add(x, null);
        }

        endTime = System.nanoTime();

        time = (endTime - startTIme) / 1000000000.0;
        System.out.println("AVT: " + time + " s");

        // Test RBT
        startTIme = System.nanoTime();

        RedBlackTree<Integer, Integer> rbt = new RedBlackTree<>();
        for (Integer x : testData) {
            rbt.add(x, null);
        }

        endTime = System.nanoTime();

        time = (endTime - startTIme) / 1000000000.0;
        System.out.println("RBT: " + time + " s");

        // Test HashTable
        startTIme = System.nanoTime();

        HashTable<Integer, Integer> ht = new HashTable<>();
        for (Integer x : testData) {
            ht.add(x, null);
        }

        endTime = System.nanoTime();

        time = (endTime - startTIme) / 1000000000.0;
        System.out.println("HashTable: " + time + " s");
    }
}