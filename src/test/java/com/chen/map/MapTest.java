package com.chen.map;

import com.chen.file.FileOperation;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * MapTest
 *
 * @Author LeifChen
 * @Date 2018-09-04
 */
public class MapTest {

    @Test
    public void test() {
        String filename = "pride-and-prejudice.txt";

        Map<String, Integer> binarySearchTreeMap = new BinarySearchTreeMap<>();
        double time1 = testSet(binarySearchTreeMap, filename);
        System.out.println("Binary-Search-Tree Map: " + time1 + " s");

        System.out.println();

        Map<String, Integer> linkedListMap = new LinkedListMap<>();
        double time2 = testSet(linkedListMap, filename);
        System.out.println("LinkedList Map: " + time2 + " s");
    }

    private static double testSet(Map<String, Integer> map, String filename) {
        long startTime = System.nanoTime();

        System.out.println(filename);
        List<String> words = new ArrayList<>();
        if (FileOperation.readFile(filename, words)) {
            System.out.println("Total words: " + words.size());

            for (String word : words) {
                if (map.contains(word)) {
                    map.set(word, map.get(word) + 1);
                } else {
                    map.add(word, 1);
                }
            }

            System.out.println("Total different words: " + map.getSize());
            System.out.println("Frequency of pride: " + map.get("pride"));
            System.out.println("Frequency of prejudice: " + map.get("prejudice"));
        }

        long endTime = System.nanoTime();

        return (endTime - startTime) / 1000000000.0;
    }
}