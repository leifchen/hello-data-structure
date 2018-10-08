package com.chen.set;

import com.chen.file.FileOperation;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * SetTest
 *
 * @Author LeifChen
 * @Date 2018-09-04
 */
public class SetTest {

    @Test
    public void test() {
        String filename = "pride-and-prejudice.txt";

        Set<String> bstSet = new BinarySearchTreeSet<>();
        double time1 = testSet(bstSet, filename);
        System.out.println("Binary-Search-Tree Set: " + time1 + " s");

        System.out.println();

        Set<String> linkedListSet = new LinkedListSet<>();
        double time2 = testSet(linkedListSet, filename);
        System.out.println("LinkedList Set: " + time2 + " s");

        System.out.println();

        Set<String> avlSet = new AVLSet<>();
        double time3 = testSet(avlSet, filename);
        System.out.println("AVL Set: " + time3 + " s");
    }

    private static double testSet(Set<String> set, String filename) {
        long startTime = System.nanoTime();

        System.out.println(filename);
        List<String> words = new ArrayList<>();
        if (FileOperation.readFile(filename, words)) {
            System.out.println("Total words: " + words.size());

            for (String word : words) {
                set.add(word);
            }

            System.out.println("Total different words: " + set.getSize());
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }
}