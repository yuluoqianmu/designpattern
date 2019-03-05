package com.buka.algorithm.statkqueue;

import java.util.*;

/**
 * 用队列实现栈
 */
public class MyStack {

    private Queue<Integer> queueA = null;
    private Queue<Integer> queueB = null;

    public MyStack() {
        queueA = new LinkedList<>();
        queueB = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        if (!queueA.isEmpty())
            queueA.offer(x);

        if (!queueB.isEmpty())
            queueB.offer(x);

        if (queueA.isEmpty() && queueB.isEmpty())
            queueA.offer(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if (!queueA.isEmpty()) {
            while (queueA.size() > 1) {
                queueB.offer(queueA.poll());
            }
            return queueA.poll();
        } else {
            while (queueB.size() > 1) {
                queueA.offer(queueB.poll());
            }
           return queueB.poll();
        }

    }

    /** Get the top element. */
    public int top() {
        int top = 0;
        if (!queueA.isEmpty()) {
            while (queueA.size() > 1) {
                queueB.offer(queueA.poll());
            }
            top = queueA.peek();
            queueB.offer(queueA.poll());
        } else {
            while (queueB.size() > 1) {
                queueA.offer(queueB.poll());
            }
            top = queueB.peek();
            queueA.offer(queueB.poll());
        }
        return top;

    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queueA.isEmpty() && queueB.isEmpty();

    }


}
