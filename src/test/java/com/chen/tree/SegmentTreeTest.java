package com.chen.tree;

import org.junit.Test;

/**
 * SegmentTreeTest
 *
 * @Author LeifChen
 * @Date 2018-09-06
 */
public class SegmentTreeTest {

    @Test
    public void test() {
        Integer[] nums = {-2, 0, 3, -5, 2, -1};
        SegmentTree<Integer> segTree = new SegmentTree<>(nums,
                (a, b) -> a + b
        );
        System.out.println(segTree.getSize());
        System.out.println(segTree);


        System.out.println(segTree.query(0, 2));
        System.out.println(segTree.query(2, 5));
        System.out.println(segTree.query(0, 5));
    }

}