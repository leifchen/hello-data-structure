package com.chen.hashtable;

import java.util.TreeMap;

/**
 * 哈希表
 *
 * @Author LeifChen
 * @Date 2018-10-10
 */
public class HashTable<K, V> {

    private static final int UPPER_TOL = 10;
    private static final int LOWER_TOL = 2;
    private final int[] capacity = {53, 97, 193, 389, 769, 1543, 3079, 6151, 12289, 24593,
            49157, 98317, 196613, 393241, 786433, 1572869, 3145739, 6291469,
            12582917, 25165843, 50331653, 100663319, 201326611, 402653189, 805306457, 1610612741};

    private TreeMap<K, V>[] hashTable;
    private int mod;
    private int size;
    private int capacityIndex = 0;

    public HashTable() {
        this.mod = capacity[capacityIndex];
        size = 0;
        hashTable = new TreeMap[mod];
        for (int i = 0; i < mod; i++) {
            hashTable[i] = new TreeMap<>();
        }
    }

    public int getSize() {
        return size;
    }

    public void add(K key, V value) {
        TreeMap<K, V> map = hashTable[hash(key)];
        if (map.containsKey(key)) {
            map.put(key, value);
        } else {
            map.put(key, value);
            size++;

            if (size >= UPPER_TOL * mod && capacityIndex + 1 < capacity.length) {
                capacityIndex++;
                resize(capacity[capacityIndex]);
            }
        }
    }

    public V remove(K key) {
        TreeMap<K, V> map = hashTable[hash(key)];
        V ret = null;
        if (map.containsKey(key)) {
            ret = map.remove(key);
            size--;

            if (size < LOWER_TOL * mod && capacityIndex - 1 >= 0) {
                capacityIndex--;
                resize(capacity[capacityIndex]);
            }
        }

        return ret;
    }

    public V get(K key) {
        return hashTable[hash(key)].get(key);
    }

    public void set(K key, V value) {
        TreeMap<K, V> map = hashTable[hash(key)];
        if (!map.containsKey(key)) {
            throw new IllegalArgumentException(key + " doesn't exist!");
        }
        map.put(key, value);
    }

    public boolean contains(K key) {
        return hashTable[hash(key)].containsKey(key);
    }

    /**
     * 计算哈希值
     *
     * @param key
     * @return
     */
    private int hash(K key) {
        return (key.hashCode() & 0x7fffffff % mod);
    }

    /**
     * 动态扩容
     *
     * @param newMod
     */
    private void resize(int newMod) {
        TreeMap<K, V>[] newHashTable = new TreeMap[newMod];
        for (int i = 0; i < newMod; i++) {
            newHashTable[i] = new TreeMap<>();
        }

        int oldMod = mod;
        this.mod = newMod;
        for (int i = 0; i < oldMod; i++) {
            TreeMap<K, V> map = hashTable[i];
            for (K key : map.keySet()) {
                newHashTable[hash(key)].put(key, map.get(key));
            }
        }

        this.hashTable = newHashTable;
    }
}
