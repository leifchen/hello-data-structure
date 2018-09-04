package com.chen.set;

/**
 * 自定义集合Set的接口
 *
 * @Author LeifChen
 * @Date 2018-09-02
 */
public interface Set<E> {

    /**
     * 返回集合的大小
     *
     * @return
     */
    int getSize();

    /**
     * 返回集合是否为空
     *
     * @return
     */
    boolean isEmpty();

    /**
     * 添加新元素e
     *
     * @param e
     */
    void add(E e);

    /**
     * 移除元素e
     *
     * @param e
     */
    void remove(E e);

    /**
     * 返回是否包含元素e
     *
     * @param e
     * @return
     */
    boolean contains(E e);
}
