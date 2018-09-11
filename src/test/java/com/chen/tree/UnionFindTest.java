package com.chen.tree;

import org.junit.Test;

import java.util.Random;

/**
 * UnionFindTest
 *
 * @Author LeifChen
 * @Date 2018-09-11
 */
public class UnionFindTest {

    @Test
    public void test() {
        int size = 10000000;
        int m = 10000000;

        UnionFind uf1 = new UnionFind1(size);
        System.out.println("UnionFind1: " + testUnionFind(uf1, m) + " s");

        UnionFind uf2 = new UnionFind2(size);
        System.out.println("UnionFind2: " + testUnionFind(uf2, m) + " s");

        UnionFind uf3 = new UnionFind3(size);
        System.out.println("UnionFind3: " + testUnionFind(uf3, m) + " s");

        UnionFind uf4 = new UnionFind4(size);
        System.out.println("UnionFind4: " + testUnionFind(uf4, m) + " s");

        UnionFind uf5 = new UnionFind5(size);
        System.out.println("UnionFind5: " + testUnionFind(uf5, m) + " s");

        UnionFind uf6 = new UnionFind6(size);
        System.out.println("UnionFind6: " + testUnionFind(uf6, m) + " s");
    }

    private double testUnionFind(UnionFind uf, int m) {
        int size = uf.getSize();
        Random random = new Random();

        long startTime = System.nanoTime();

        for (int i = 0; i < m; i++) {
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.unionElements(a, b);
        }

        for (int i = 0; i < m; i++) {
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.isConnected(a, b);
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }
}