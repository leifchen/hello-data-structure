package com.chen.queue;

/**
 * 自定义队列的接口
 *
 * @Author LeifChen
 * @Date 2018-08-27
 */
public interface Queue<E> {
    /**
     * 获取队列的长度
     *
     * @return
     */
    int getSize();

    /**
     * 返回是否空队列
     *
     * @return
     */
    boolean isEmpty();

    /**
     * 从队尾添加一个元素e
     *
     * @param e
     */
    void enqueue(E e);

    /**
     * 从队首取出一个元素
     *
     * @return
     */
    E dequeue();

    /**
     * 返回队首元素
     *
     * @return
     */
    E getFront();
}
