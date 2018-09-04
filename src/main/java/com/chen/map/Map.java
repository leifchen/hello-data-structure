package com.chen.map;

/**
 * 自定义映射Map的接口
 *
 * @Author LeifChen
 * @Date 2018-09-04
 */
public interface Map<K, V> {

    /**
     * 返回映射map的大小
     *
     * @return
     */
    int getSize();

    /**
     * 返回映射map是否为空
     *
     * @return
     */
    boolean isEmpty();

    /**
     * 添加键值对（key，value）
     *
     * @param key
     * @param value
     */
    void add(K key, V value);

    /**
     * 移除key对应的value
     *
     * @param key
     * @return
     */
    V remove(K key);

    /**
     * 返回映射map是否包含key
     *
     * @param key
     * @return
     */
    boolean contains(K key);

    /**
     * 获取映射map的键key对应的值value
     *
     * @param key
     * @return
     */
    V get(K key);

    /**
     * 设置映射map的键key对应的值为newValue
     *
     * @param key
     * @param newValue
     */
    void set(K key, V newValue);
}
