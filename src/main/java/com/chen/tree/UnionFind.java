package com.chen.tree;

/**
 * 并查集的接口
 *
 * @Author LeifChen
 * @Date 2018-09-11
 */
public interface UnionFind {

    /**
     * 返回并查集的大小
     *
     * @return
     */
    int getSize();

    /**
     * 查看元素p和元素q是否所属一个集合
     *
     * @param p
     * @param q
     * @return
     */
    boolean isConnected(int p, int q);

    /**
     * 合并
     *
     * @param p
     * @param q
     */
    void unionElements(int p, int q);
}
