package com.chen.tree;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * BinarySearchTreeTest
 *
 * @Author LeifChen
 * @Date 2018-08-30
 */
public class BinarySearchTreeTest {

    BinarySearchTree<Integer> bst = new BinarySearchTree<>();

    @Before
    public void init() {
        int[] nums = {5, 3, 1, 2, 4, 9, 7, 6, 8, 10, 8};
        for (int num : nums) {
            bst.add(num);
        }
    }

    @Test
    public void isEmpty() {
        assertEquals(10, bst.size());
        assertFalse(bst.isEmpty());
    }

    @Test
    public void contains() {
        assertTrue(bst.contains(2));
        assertFalse(bst.contains(11));
    }

    @Test
    public void order() {
        System.out.println(bst);
        System.out.println("preOrder: ");
        bst.preOrder();
        System.out.println("preOrderNR");
        bst.preOrderNR();
        System.out.println("inOrder: ");
        bst.inOrder();
        System.out.println("postOrder: ");
        bst.postOrder();
        System.out.println("levelOrder: ");
        bst.levelOrder();
    }

    @Test
    public void removeMin() {
        assertEquals(1, bst.removeMin().intValue());
        bst.inOrder();
    }

    @Test
    public void removeMax() {
        assertEquals(10, bst.removeMax().intValue());
        bst.inOrder();
    }

    @Test
    public void remove() {
        bst.remove(3);
        System.out.println(bst);
    }
}