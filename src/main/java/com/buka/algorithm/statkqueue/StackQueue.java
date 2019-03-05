package com.buka.algorithm.statkqueue;

import java.util.Stack;

/**
 *  用栈实现队列
 */
public class StackQueue {

    private Stack<Integer> stackA = new Stack<>();

    private Stack<Integer> stackB = new Stack<>();

    /**
     * 入队操作
     */
    public void enQueue(int item) {
        stackA.push(item);
    }

    /**
     * 出队操作
     *
     */
    public Integer deQueue() {
        if (stackB.isEmpty()) {
            if (stackA.isEmpty()) {

                return null;
            }

            transfer();
        }
        return stackB.pop();
    }

    /**
     * 转换
     */
    public void transfer () {
        while (!stackA.isEmpty()) {
            stackB.push(stackA.pop());
        }
    }


    public static void main(String[] args) {

        StackQueue stackQueue = new StackQueue();
        stackQueue.enQueue(1);
        stackQueue.enQueue(2);
        stackQueue.enQueue(3);
        stackQueue.enQueue(4);
        System.out.println(stackQueue.deQueue());
        System.out.println(stackQueue.deQueue());
        stackQueue.enQueue(5);
        System.out.println(stackQueue.deQueue());
        System.out.println(stackQueue.deQueue());
        System.out.println(stackQueue.deQueue());
        System.out.println(stackQueue.deQueue());

    }


}
