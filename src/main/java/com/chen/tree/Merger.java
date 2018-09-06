package com.chen.tree;

/**
 * Merger
 *
 * @Author LeifChen
 * @Date 2018-09-06
 */
public interface Merger<E> {

    /**
     * 具体业务逻辑实现方法
     *
     * @param a
     * @param b
     * @return
     */
    E merge(E a, E b);
}
