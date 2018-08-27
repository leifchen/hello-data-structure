package com.chen.stack;

/**
 * 自定义栈的接口
 *
 * @Author LeifChen
 * @Date 2018-08-27
 */
public interface Stack<E> {

    /**
     * 获取栈的容量
     *
     * @return
     */
    int getSize();

    /**
     * 返回是否空栈
     *
     * @return
     */
    boolean isEmpty();

    /**
     * 入栈一个元素
     *
     * @param e
     */
    void push(E e);

    /**
     * 出栈一个元素
     *
     * @return
     */
    E pop();

    /**
     * 返回栈顶元素
     *
     * @return
     */
    E peek();
}
