package com.chen.tree;

import com.chen.file.FileOperation;
import com.chen.set.BinarySearchTreeSet;
import com.chen.set.Set;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * TrieTest
 *
 * @Author LeifChen
 * @Date 2018-09-10
 */
public class TrieTest {

    @Test
    public void test() {
        String filename = "pride-and-prejudice.txt";

        List<String> words = new ArrayList<>();
        if (FileOperation.readFile(filename, words)) {
            long startTime = System.nanoTime();
            Set<String> set = new BinarySearchTreeSet<>();
            for (String word : words) {
                set.add(word);
            }

            for (String word : words) {
                set.contains(word);
            }

            long endTime = System.nanoTime();

            double time = (endTime - startTime) / 1000000000.0;

            System.out.println("Total different words: " + set.getSize());
            System.out.println("BinarySearchTree: " + time + " s");

            System.out.println();

            startTime = System.nanoTime();
            Trie trie = new Trie();
            for (String word : words) {
                trie.add(word);
            }

            for (String word : words) {
                trie.contains(word);
            }
            endTime = System.nanoTime();
            time = (endTime - startTime) / 1000000000.0;
            System.out.println("Total different words: " + trie.getSize());
            System.out.println("TreeMap Trie: " + time + " s");

            System.out.println();

            startTime = System.nanoTime();
            Trie2 trie2 = new Trie2();
            for (String word : words) {
                trie2.add(word);
            }

            for (String word : words) {
                trie2.contains(word);
            }
            endTime = System.nanoTime();
            time = (endTime - startTime) / 1000000000.0;
            System.out.println("Total different words: " + trie2.getSize());
            System.out.println("HashMap Trie: " + time + " s");

            System.out.println();

            startTime = System.nanoTime();
            Trie3 trie3 = new Trie3();
            for (String word : words) {
                trie3.add(word);
            }

            for (String word : words) {
                trie3.contains(word);
            }
            endTime = System.nanoTime();
            time = (endTime - startTime) / 1000000000.0;
            System.out.println("Total different words: " + trie3.getSize());
            System.out.println("Array(Map) Trie: " + time + " s");
        }
    }
}