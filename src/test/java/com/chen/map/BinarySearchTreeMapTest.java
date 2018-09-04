package com.chen.map;

import com.chen.file.FileOperation;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * BinarySearchTreeMapTest
 *
 * @Author LeifChen
 * @Date 2018-09-04
 */
public class BinarySearchTreeMapTest {

    @Test
    public void test() {
        List<String> words = new ArrayList<>();
        if (FileOperation.readFile("pride-and-prejudice.txt", words)) {
            System.out.println("Total words: " + words.size());

            Map<String, Integer> map = new BinarySearchTreeMap<>();
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
    }
}